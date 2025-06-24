package api.client;

import api.model.request.CreateUserRequest;
import api.model.request.UpdateUserRequest;
import api.model.response.CreateUserResponse;
import api.model.response.GetUserResponse;
import api.model.response.UpdateUserResponse;
import io.restassured.response.Response;

public interface  UserClient {

    CreateUserResponse createUser(CreateUserRequest user);
    GetUserResponse getUser(int id);
    UpdateUserResponse updateUser(int id, UpdateUserRequest user);
    Response deleteUser(int id);


}
