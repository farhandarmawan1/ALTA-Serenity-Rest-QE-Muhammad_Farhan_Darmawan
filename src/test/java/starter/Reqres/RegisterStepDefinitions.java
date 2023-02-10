package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class RegisterStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Register user with valid json input")
    public void registerUserWithValidJsonInput() {
        File json = new File(Constant.JSON_REQ_BODY + "/LoginReqBody.json");
        reqresAPI.setLoginUser(json);
    }



    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER_USER);

    }

    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterValidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Register user with valid username and blank password")
    public void registerUserWithValidUsernameAndBlankPassword() {
            File json = new File(Constant.JSON_REQ_BODY + "/BlankPassword.json");
            reqresAPI.setLoginUser(json);
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
