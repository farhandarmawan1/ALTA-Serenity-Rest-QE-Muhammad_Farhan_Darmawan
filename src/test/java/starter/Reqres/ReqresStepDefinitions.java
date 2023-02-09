package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {

        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {

        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {

        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }

    //scenario 2
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(ReqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }

    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(ReqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
    reqresAPI.setPutUpdateUser(id, jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int intNoContent) {
       SerenityRest.then().statusCode(intNoContent);
    }

}