package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Negative Case 1
    @Given("Delete user with invalid id {}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteInvalidUser(id);
    }
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int responseCode) {
        SerenityRest.then().statusCode(responseCode);
    }
}
