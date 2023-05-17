package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

import java.io.File;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Get lists users
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsersValidParamPage(page);
    }
    @When("Send get lists users")
    public void sendGetListsUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    //Post create new user
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.postCreateUser(json);
    }
    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    //put update user
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(ReqresAPI.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.putUpdateUser(id,json);
    }
    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //Delete user
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }


}
