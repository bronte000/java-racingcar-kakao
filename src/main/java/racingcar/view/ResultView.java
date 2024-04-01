package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printGameProcessTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printGameBoard(String gameBoard) {
        System.out.println(gameBoard);
    }
    public static void printGameWinner(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
