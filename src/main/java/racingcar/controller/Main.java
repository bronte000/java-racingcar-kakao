package racingcar.controller;

import racingcar.model.RacingCarDice;
import racingcar.model.RacingCarGame;
import racingcar.view.Input;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        RacingCarDice dice = new RacingCarDice();
        RacingCarGame racingCarGame = new RacingCarGame(Input.getRacingCars(), dice);
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
