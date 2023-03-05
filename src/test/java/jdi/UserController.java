package jdi;

import com.epam.http.annotations.*;
import com.epam.http.requests.RestMethod;
import model.user.User;

import static io.restassured.http.ContentType.JSON;

@ServiceDomain("http://85.192.34.140:8080/api")
public class UserController extends AuthenticationController {
    @POST("/register")
    @ContentType(JSON)
    private RestMethod registerUser;

    @GET("/user")
    @ContentType(JSON)
    private RestMethod getUserInfo;

    @PUT
    @ContentType(JSON)
    private RestMethod updateUserPassword;

    @DELETE
    @ContentType(JSON)
    private RestMethod deleteUser;

    public JDIAssertedResponse registerNewUser(User user) {
        return new JDIAssertedResponse(registerUser.body(user).call());
    }
}
