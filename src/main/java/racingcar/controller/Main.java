package racingcar.controller;

import racingcar.controller.RacingCarGame;
import racingcar.view.Input;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(Input.getRacingCars());
        int count = Input.getGameCount();

        ResultView.printGameProcessTitle();
        ResultView.printGameBoard(racingCarGame.makeGameBoard());
        for (int i = 0; i < count; i++) {
            racingCarGame.processOneTurn();
            ResultView.printGameBoard(racingCarGame.makeGameBoard());
        }
        ResultView.printGameWinner(racingCarGame.decideWinner());
    }
}
