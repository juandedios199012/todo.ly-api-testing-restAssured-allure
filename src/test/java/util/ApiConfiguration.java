package util;

public class ApiConfiguration {

    public static final String CREATE_PROJECT=GetProperties.getInstance().getHost()+"/api/projects.json";
    public static final String CREATE_ITEM_PROJECT=GetProperties.getInstance().getHost()+"/api/items.json";
    public static final String UPDATE_ITEM_PROJECT=GetProperties.getInstance().getHost()+"/api/items/%s.json";
    public static final String READ_ITEM_PROJECT=GetProperties.getInstance().getHost()+"/api/items/%s.json";
    public static final String DELETE_ITEM_PROJECT=GetProperties.getInstance().getHost()+"/api/items/%s.json";



}
