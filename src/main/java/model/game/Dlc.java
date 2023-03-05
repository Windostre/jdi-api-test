package model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dlc {
    private String description;
    private String dlcName;
    private boolean isDlcFree;
    private int price;
    private int rating;
    public SimilarDlc similarDlc;
}
