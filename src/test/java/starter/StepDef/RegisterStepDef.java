package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("User register with valid email and password")
    public void userRegisterWithValidEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterUserValid.json");
        reqresAPI.registerUser(json);
    }
    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserValidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("User register with valid email and blank password")
    public void userRegisterWithValidEmailAndBlankPassword() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterUserInvalid.json");
        reqresAPI.registerUser(json);
    }
    @And("Validate json schema failed register user with valid email and blank password")
    public void validateJsonSchemaFailedRegisterUserWithValidEmailAndBlankPassword() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserInvalidJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
