package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String REGISTER_USER = Constant.BASE_URL+"/api/register";
    public static String LOGIN_USER = Constant.BASE_URL + "/api/login";
    public static  String SINGLE_RESOURCES = Constant.BASE_URL+"/api/unknown/{id}";
    public static  String LIST_RESOURCES = Constant.BASE_URL+"/api/{input}";

    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json) {
         SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void setPutUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Delete User")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Register user")
    public  void setRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Login user")
    public  void setLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get list resources")
    public void getListResources(String input) {
        SerenityRest.given()
                .pathParam("input", input);
    }
    @Step("Get single resources")
    public void setSingleResources (int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
