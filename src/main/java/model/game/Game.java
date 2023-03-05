package model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private String company;
    private String description;
    private ArrayList<Dlc> dlcs;
    private int gameId;
    private String genre;
    private boolean isFree;
    private int price;
    private Date publish_date;
    private int rating;
    private boolean requiredAge;
    private Requirements requirements;
    private ArrayList<String> tags;
    private String title;
}
