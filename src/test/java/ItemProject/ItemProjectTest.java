package ItemProject;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class ItemProjectTest {
    Response response;
    JSONObject body= new JSONObject();
    RequestInfo requestInfo = new RequestInfo();

    public int getProjectID(){
        body.put("Content","ProjectDiplomado10");
        requestInfo.setUrl(ApiConfiguration.CREATE_PROJECT);
        requestInfo.setBody(body.toString());

        response= FactoryRequest.make("post").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
        return response.then().extract().path("Id");
    }

    @Test
    @DisplayName("Verify Create Project Item")
    @Description("Verify Create Project Item ")
    public void verifyCreateItemProject(){

        body.put("Content","ItemDiplomado10");
        body.put("ProjectId",getProjectID());
        requestInfo.setUrl(ApiConfiguration.CREATE_ITEM_PROJECT);
        requestInfo.setBody(body.toString());

        response= FactoryRequest.make("post").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
    }

    public int getItemProjectId(){

        body.put("Content","ItemDiplomado10");
        body.put("ProjectId",getProjectID());
        requestInfo.setUrl(ApiConfiguration.CREATE_ITEM_PROJECT);
        requestInfo.setBody(body.toString());

        response= FactoryRequest.make("post").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
        return response.then().extract().path("Id");
    }

    @Test
    @DisplayName("Verify Update Project Item")
    @Description("Verify Update Project Item")
    public void verifyUpdateItemProject(){

        body.put("Content","ItemDiplomado10UPDATE");
        requestInfo.setUrl(String.format(ApiConfiguration.UPDATE_ITEM_PROJECT,getItemProjectId()));
        requestInfo.setBody(body.toString());
        response= FactoryRequest.make("put").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
    }

    @Test
    @DisplayName("Verify Read Project Item")
    @Description("Verify Read Project Item")
    public void verifyReadItemProject(){

        requestInfo.setUrl(String.format(ApiConfiguration.READ_ITEM_PROJECT,getItemProjectId()));
        requestInfo.setBody(body.toString());
        response= FactoryRequest.make("get").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
    }

    @Test
    @DisplayName("Verify Delete Project Item")
    @Description("Verify Delete Project Item")
    public void verifyDeleteItemProject(){
        requestInfo.setUrl(String.format(ApiConfiguration.DELETE_ITEM_PROJECT,getItemProjectId()));
        requestInfo.setBody(body.toString());
        response= FactoryRequest.make("delete").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
    }
}
