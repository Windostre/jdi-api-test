package jdi;

import com.epam.http.annotations.ContentType;
import com.epam.http.annotations.POST;
import com.epam.http.annotations.ServiceDomain;
import com.epam.http.requests.RestMethod;
import io.restassured.http.Header;
import model.user.User;

import java.util.HashMap;
import java.util.Map;

@ServiceDomain("http://85.192.34.140:8080/api")
public class AuthController {

    private String jwt;

    @POST("/login")
    @ContentType(io.restassured.http.ContentType.JSON)
    private static RestMethod auth;

    public Header getAuthHeader() {
        return new Header("Authorization", "Bearer " + jwt);
    }

    public String login(User user) {
        Map<String, String> credentials = new HashMap<String, String>() {{
                put("username", user.getLogin());
                put("password", user.getPass());
            }};
        jwt = auth.body(credentials).call().getRaResponse().then().extract().body().jsonPath().get("token");
        return jwt;
    }
}
