package snake_n_ladder_design;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Dice {

    private final int diceCount;
    private final int min = 1, max = 6;

    public int rollDice() {

        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(min, max + 1);
            diceUsed++;
        }
        return totalSum;
    }

}
