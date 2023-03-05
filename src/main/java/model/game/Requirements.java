package model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requirements {
    private int hardDrive;
    private String osName;
    private int ramGb;
    private String videoCard;
}
