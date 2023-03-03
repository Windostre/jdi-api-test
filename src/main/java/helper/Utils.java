package helper;

import com.github.javafaker.Faker;
import model.user.User;

/**
 * Вспомогательльные методы, генерации данных
 */
public class Utils {
    private final Faker faker = new Faker();
    public User generateRandomUser() {
        String login = faker.internet().emailAddress();
        String password = faker.internet().password(3,6);
        return new User(login, password);
    }
}
