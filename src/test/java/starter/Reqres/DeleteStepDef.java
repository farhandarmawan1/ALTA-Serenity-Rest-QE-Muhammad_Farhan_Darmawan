package starter.Reqres;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class DeleteStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with invalid parameter id {int}")
    public void deleteUserWithInvalidParameterIdId(int id) {
        reqresAPI.deleteUser(id);
    }
}
