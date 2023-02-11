package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListResourcesStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resources with valid parameter")
    public void getListUsersWithValidParameterPage() {

        reqresAPI.getListResources("unknown");
    }

    @When("Send request get list resources")
    public void sendRequestGetListResources() {
        SerenityRest.when()
                .get(ReqresAPI.LIST_RESOURCES);
    }

    @And("Validate list resources json schema")
    public void validateListResourcesJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListResourcesJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Get list resources with invalid parameter {string}")
    public void getListResourcesWithInvalidParameter(String input) {

        reqresAPI.getListResources(input);
    }
}
