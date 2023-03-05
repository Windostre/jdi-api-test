package user;

import helper.Utils;
import jdi.UserController;
import model.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.epam.http.requests.ServiceInit.init;

public class RegisterTests {

    private static UserController userController;
    private final Utils utils = new Utils();
    private User user;

    @BeforeClass
    public static void initService() {
        userController = init(UserController.class);
    }

    @Before
    public void initTestData() {
        user = utils.generateRandomUser();
    }

    @Test
    public void registerUserSuccessReturnStatus201ok() {
        User actualUser = userController.registerNewUser(user)
                .hasStatusCode(201)
                .hasMessage("User created")
                .as("register_data", User.class);

        Assert.assertTrue(String.valueOf(actualUser.getId()).matches("\\d+"));

    }
}
