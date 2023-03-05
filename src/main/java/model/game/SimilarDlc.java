package model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimilarDlc {
    private String dlcNameFromAnotherGame;
    private boolean free;

}
