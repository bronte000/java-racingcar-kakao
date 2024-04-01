package racingcar.model;

import java.util.Random;

public class RacingCarDice {

    private static final Random random = new Random();
    private static final int DICE_SIZE = 10;

    public static int throwOnce() {
        return random.nextInt(DICE_SIZE);
    }
}
