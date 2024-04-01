package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.controller.RacingCarGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 우승자를_반환한다() {
        Car winner = new Car("Mark", 3);
        RacingCarGame racingCarGame = new RacingCarGame(List.of(
                winner,
                new Car("Daisy", 1),
                new Car("Rosie", 1)
        ));

        List<Car> winners = racingCarGame.decideWinner();
        assertThat(winners).containsExactly(winner);
    }
}
