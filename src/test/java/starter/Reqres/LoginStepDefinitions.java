package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    @Given("User login with valid email and password")
    public void userLoginWithValidEmailAndPassword() {
        File json = new File(Constant.JSON_REQ_BODY + "/LoginReqBody.json");
        reqresAPI.setLoginUser(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when()
                .post(ReqresAPI.LOGIN_USER);
    }

    @And("Validate json schema success login user")
    public void validateJsonSchemaSuccessLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginSuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
        
    }

    @Given("User login with valid email and empty password")
    public void userLoginWithValidEmailAndEmptyPassword() {
        File json = new File(Constant.JSON_REQ_BODY + "/EmptyPasswordLog.json");
        reqresAPI.setLoginUser(json);
        
    }

    @And("Validate json schema failed login user")
    public void validateJsonSchemaFailedLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginFailedJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @And("Response body name should be {string}")
    public void responseBodyNameShouldBe(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }

    @Given("User login with empty email and valid password")
    public void userLoginWithEmptyEmailAndValidPassword() {
        File json = new File(Constant.JSON_REQ_BODY + "/EmptyEmailLog.json");
        reqresAPI.setLoginUser(json);

    }
}
