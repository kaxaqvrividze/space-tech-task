package step;

import api.client.UserClient;
import api.client.UserClientImp;
import api.model.request.CreateUserRequest;
import api.model.request.UpdateUserRequest;
import api.model.response.CreateUserResponse;
import api.model.response.GetUserResponse;
import api.model.response.UpdateUserResponse;
import api.util.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class UserStepsDefinitions {

    private final UserClient userClient = new UserClientImp();
    private CreateUserResponse createUserResponse;
    private UpdateUserResponse updateUserResponse;
    private GetUserResponse getUserResponse;
    private int deletedStatusCode;

    @Given("I create a user with name {string} and job {string}")
    public void createUserWithNameAndJob(String name, String job) {
        CreateUserRequest request = new CreateUserRequest(name, job);
        createUserResponse = userClient.createUser(request);
    }

    @Then("the user ID and creation date should not be null")
    public void verifyUserIdAndCreationDateNotNull() {
        Assert.assertNotNull(createUserResponse.getId(), "User ID should not be null");
        Assert.assertNotNull(createUserResponse.getCreatedAt(), "Created At should not be null");
    }

    @Then("the user should be created with name {string} and job {string}")
    public void verifyCreatedUserData(String name, String job) {
        Assert.assertEquals(createUserResponse.getName(), name);
        Assert.assertEquals(createUserResponse.getJob(), job);
    }

    @Given("I request to get the user with ID {int}")
    public void getUserById(int userId) {
        getUserResponse = userClient.getUser(userId);
    }

    @Then("the user with ID {int} should be returned with email {string}")
    public void verifyUserEmailById(int id, String email) {
        Assert.assertEquals(getUserResponse.getData().getEmail(), email);
        Assert.assertEquals(getUserResponse.getData().getId(), id);
    }

    @Then("the user's first name should be {string} and last name should be {string}")
    public void verifyUserFullName(String firstName, String lastName) {
        Assert.assertEquals(getUserResponse.getData().getFirst_name(), firstName);
        Assert.assertEquals(getUserResponse.getData().getLast_name(), lastName);
    }

    @Then("the support URL should contain {string}")
    public void verifySupportUrlContains(String url) {
        Assert.assertTrue(getUserResponse.getSupport().getUrl().contains(url));
    }

    @Given("I update the user with ID {int} to have name {string} and job {string}")
    public void updateUserWithId(int userId, String name, String job) {
        UpdateUserRequest request = new UpdateUserRequest(name, job);
        updateUserResponse = userClient.updateUser(userId, request);
    }

    @Then("the user should be updated with name {string} and job {string}")
    public void verifyUpdatedUser(String name, String job) {
        Assert.assertEquals(updateUserResponse.getName(), name);
        Assert.assertEquals(updateUserResponse.getJob(), job);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        Assert.assertEquals(TestContext.getStatusCode(), statusCode, "Status code should match");
    }

    @Then("the update date should not be null")
    public void verifyUpdateDateNotNull() {
        Assert.assertNotNull(updateUserResponse.getUpdatedAt(), "Updated date should not be null");
    }

    @Given("I delete the user with ID {int}")
    public void deleteUserById(int userId) {
        deletedStatusCode = userClient.deleteUser(userId).getStatusCode();
    }

    @Then("the user should be deleted successfully")
    public void verifyUserDeleted() {
        Assert.assertEquals(deletedStatusCode, 204);
    }

    @Then("the user should not have an id")
    public void verifyUserIdIsEmpty() {
        Assert.assertTrue(createUserResponse.getId().isEmpty(), "User ID should be empty");
    }

    @Given("I request to get the non-existent user with ID {int}")
    public void getNonExistentUser(int userId) {
        getUserResponse = userClient.getUser(userId);
    }

    @Then("no support data should be available")
    public void verifyNoSupportData() {
        Assert.assertNull(getUserResponse.getSupport());
    }

    @Given("I update the user with ID {int} with empty name and job")
    public void updateUserWithEmptyFields(int userId) {
        UpdateUserRequest request = new UpdateUserRequest("", "");
        updateUserResponse = userClient.updateUser(userId, request);
    }

    @Then("the user's name and job should not be empty")
    public void verifyUserNameAndJobNotEmpty() {
        Assert.assertNotEquals(updateUserResponse.getName(), "");
        Assert.assertNotEquals(updateUserResponse.getJob(), "");
    }

    @Given("I delete the non-existent user with ID {int}")
    public void deleteNonExistentUser(int userId) {
        deletedStatusCode = userClient.deleteUser(userId).getStatusCode();
    }
}
