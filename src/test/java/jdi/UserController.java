package jdi;

import com.epam.http.annotations.*;
import com.epam.http.requests.RestMethod;

import static io.restassured.http.ContentType.JSON;

@ServiceDomain("85.192.34.140:8080/api")
public class UserController {
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
}
