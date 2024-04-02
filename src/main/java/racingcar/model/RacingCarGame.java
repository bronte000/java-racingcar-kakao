package racingcar.model;

import racingcar.model.Car;
import racingcar.model.RacingCarDice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<Car> cars;
    private final RacingCarDice dice;

    public RacingCarGame(List<Car> cars, RacingCarDice dice) {
        this.cars = cars;
        this.dice = dice;
    }

    public RacingCarGame(String[] inputs, RacingCarDice dice) {
        this(Arrays.stream(inputs)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList()), dice);
    }

    public RacingCarGame(String input, RacingCarDice dice) {
        this(input.split(","), dice);
    }

    public void processOneTurn() {
        for (Car car : cars) {
            int diceResult = dice.throwOnce();
            car.moveWithDiceNum(diceResult);
        }
    }

    public List<Car> decideWinner() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(it -> it.getPosition() == max)
                .collect(Collectors.toList());
    }

    public String makeGameBoard() {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .reduce("", (car1, car2) -> car1 + car2 + "\n");
    }
}
