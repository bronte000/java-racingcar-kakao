package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 우승자를_반환한다() {
        Car winner = new Car("Mark", 3);
        RacingCarDice dice = new RacingCarDice();
        RacingCarGame racingCarGame = new RacingCarGame(List.of(
                winner,
                new Car("Daisy", 1),
                new Car("Rosie", 1)
        ), dice);

        List<Car> winners = racingCarGame.decideWinner();
        assertThat(winners).containsExactly(winner);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 주사위_수가_3_이하면_차를_움직이지_않는다(int diceNum) {
        RacingCarDice dice = new RacingCarDice() {
            @Override
            public int throwOnce() {
                return diceNum;
            }
        };

        List<Car> cars = List.of(
                new Car("Mark", 1),
                new Car("Daisy", 1),
                new Car("Rosie", 1)
        );
        RacingCarGame racingCarGame = new RacingCarGame(cars, dice);
        racingCarGame.processOneTurn();

        assertThat(cars).allMatch(car -> car.getPosition() == 1);
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 주사위_수가_4_이상이면_차를_움직인다(int diceNum) {
        RacingCarDice dice = new RacingCarDice() {
            @Override
            public int throwOnce() {
                return diceNum;
            }
        };

        List<Car> cars = List.of(
                new Car("Mark", 1),
                new Car("Daisy", 1),
                new Car("Rosie", 1)
        );
        RacingCarGame racingCarGame = new RacingCarGame(cars, dice);
        racingCarGame.processOneTurn();

        assertThat(cars).allMatch(car -> car.getPosition() == 2);
    }
}
