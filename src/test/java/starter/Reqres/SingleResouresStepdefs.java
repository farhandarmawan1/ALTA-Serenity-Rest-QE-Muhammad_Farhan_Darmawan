package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class SingleResouresStepdefs {

    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Get single resources with valid parameter")
    public void getSingleResourcesWithValidParameter() {
        reqresAPI.setSingleResources(2);
    }

    @When("Send request get single resources")
    public void sendRequestGetSingleResources() {
        SerenityRest.when()
                .get(ReqresAPI.SINGLE_RESOURCES);
    }

    @And("Validate single resources json schema")
    public void validateSingleResourcesJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/SingleResourcesJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2
    @Given("Get single resources with invalid parameter id {int}")
    public void getSingleResourcesWithInvalidParameterIdId(int id) {
        reqresAPI.setSingleResources(id);
    }
}
