package jdi;

import com.epam.http.annotations.*;
import com.epam.http.requests.RestMethod;
import model.user.ChangeUserPass;
import model.user.User;

import static com.epam.http.requests.RequestDataFactory.headers;
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

    public JDIAssertedResponse updatePassword(ChangeUserPass changeUserPass) {
        return new JDIAssertedResponse(updateUserPassword.call(
                headers().add(getAuthHeader())
                        .setBody(changeUserPass))
        );
    }
    public JDIAssertedResponse registerNewUser(User user) {
        return new JDIAssertedResponse(registerUser.body(user).call());
    }
}
