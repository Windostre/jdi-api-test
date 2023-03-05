package model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.game.Game;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String login;
    private String pass;
    private String id;
    private List<Game> games;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User(String login) {
        this.login = login;
    }

}
