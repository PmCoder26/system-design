package snake_n_ladder_design;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {

    private final String id;
    private int currentPosition;

}
