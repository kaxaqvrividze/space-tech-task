package api.client;
import api.model.request.CreateUserRequest;
import api.model.request.UpdateUserRequest;
import api.model.response.CreateUserResponse;
import api.model.response.GetUserResponse;
import api.model.response.UpdateUserResponse;
import api.util.TestContext;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static api.util.Config.API_KEY;
import static api.util.Config.BASE_URI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class UserClientImp  implements UserClient {

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.requestSpecification = RestAssured
                .given()
                .header("x-api-key", API_KEY);
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest user) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users");

        TestContext.setStatusCode(response.getStatusCode());

        return response
                .then()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Server", notNullValue())
                .extract()
                .as(CreateUserResponse.class);
    }


    @Override
    public UpdateUserResponse updateUser(int id,UpdateUserRequest user) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put("/users/" + id);
        response.prettyPrint();
        TestContext.setStatusCode(response.getStatusCode());
        return response.then().extract().as(UpdateUserResponse.class);

    }

    @Override
    public GetUserResponse getUser(int userId) {
        Response response  =  given()
                .when()
                .get("/users/" + userId);
        TestContext.setStatusCode(response.getStatusCode());

        return response.then()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Server", notNullValue())
                .extract()
                .as(GetUserResponse.class);
    }

    @Override
    public Response deleteUser(int id) {
         Response response = given()
                .when()
                .delete("/users/" + id);
        TestContext.setStatusCode(response.getStatusCode());
        return response;
    }


}
