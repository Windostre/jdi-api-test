package user;

import com.jdiai.tools.map.MapArray;
import helper.Utils;
import io.restassured.response.ValidatableResponse;
import jdi.AuthController;
import jdi.UserController;
import model.user.ChangeUserPass;
import model.user.User;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.epam.http.requests.ServiceInit.init;

public class RegisterTests {

    private static UserController userController;
    private final Utils utils = new Utils();
    private User randomUser;

    @BeforeClass
    public static void initService() {
        userController = init(UserController.class);
        init(AuthController.class);
    }

    @Before
    public void initTestData() {
        randomUser = utils.generateRandomUser();
    }

    @Test
    public void registerUserSuccess() {
        User actualUser = userController.registerNewUser(randomUser)
                .hasStatusCode(201)
                .hasMessage("User created")
                .as("register_data", User.class);

        Assert.assertTrue(String.valueOf(actualUser.getId()).matches("\\d+"));

    }

    @Test
    public void updateUserPassSuccess() {
        ChangeUserPass changeUserPass = new ChangeUserPass(utils.generatePassword());
        userController.registerNewUser(randomUser);
        userController.auth(randomUser)
                .updatePassword(changeUserPass)
                .hasStatusCode(200) //TODO разобраться, почему 404
                .hasMessage("User password successfully changed");


    }
}
