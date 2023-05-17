package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String BASE_URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String REQ_BODY_DIR = DIR+"/src/test/resources/JSON/ReqBody/";
    public static String JSON_SCHEMA_DIR = "/src/test/resources/JSON/JSONSchema/";
    public static String GET_LIST_USERS = BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USER = BASE_URL+"/api/users/{id}";
    public static String GET_INVALID_SINGLE_USER = BASE_URL+"/api/users/{firstName}";
    //public static String DELETE_INVALID_USER = BASE_URL+"/api/users/{id}";

    @Step("Get lists user with valid parameter page")
    public void getListUsersValidParamPage(int page) {
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                    .pathParam("id",id);
    }
    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given()
                    .pathParam("id",id);
    }
    @Step("Get invalid single user")
    public void getInvalidSingleUser(String firstName) {
        SerenityRest.given()
                    .pathParam("firstName",firstName);
    }
    @Step("Delete invalid user")
    public void deleteInvalidUser(String id) {
        SerenityRest.given()
                    .pathParam("id",id);
    }

}
