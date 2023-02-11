package starter.Reqres;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class UpdateUserStepdefs {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with empty request body")
    public void putUpdateUserWithEmptyRequestBody() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBodyEmpty.json");
        reqresAPI.setPutUpdateUser(2, jsonReq);
    }

    @Given("Update user valid json with invalid parameter id {int}")
    public void updateUserValidJsonWithInvalidParameterIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBody.json");
        reqresAPI.setPutUpdateUser(id, jsonReq);
    }
}
