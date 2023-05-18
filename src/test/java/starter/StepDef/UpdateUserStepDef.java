package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Put update user with valid id {int} and invalid json")
    public void putUpdateUserWithValidIdAndInvalidJson(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"/UpdateInvalid.json");
        reqresAPI.putUpdateUser(id,json);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Response body name was {string}, job was {string}, and age was {int}")
    public void responseBodyNameWasJobWasAndAddressWas(String name, String job, int age) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name)).body(ReqresResponses.JOB,equalTo(job)).body(ReqresResponses.AGE,equalTo(age));
    }

    //Negative Case 2
    @Given("Put update user with empty name and job with id {int}")
    public void putUpdateUserWithEmptyNameAndJobWithId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"/UpdateInvalid2.json");
        reqresAPI.putUpdateUser(id,json);
    }

}
