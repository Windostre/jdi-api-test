package user;

import helper.Utils;
import jdi.UserController;
import model.user.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.epam.http.requests.ServiceInit.init;

public class RegisterTests {

    private UserController userController;
    private final Utils utils = new Utils();
    private User user;

    @Before
    public void initService() {
        userController = init(UserController.class);
        user = utils.generateRandomUser();
    }

    @Test
    public void registerUserSuccessReturnStatus200ok() {
        userController.registerNewUser(user);

    }
}
