package factoryRequest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import util.GetProperties;

import static io.restassured.RestAssured.given;

public class RequestPUT implements IRequest{
    @Override
    public Response send(RequestInfo info) {
        Response response =given()
                .filter(new AllureRestAssured())
                .auth()
                .preemptive()
                .basic(GetProperties.getInstance().getUser(),
                        GetProperties.getInstance().getPwd())
                .body(info.getBody())
                .log().all()
        .when()
                .put(info.getUrl());

        response.then().log().all();
        return response;
    }
}
