package racingcar.controller;

import racingcar.model.InputNameHandler;
import racingcar.model.firstcollection.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
    private final Input input;
    private final Output output;

    public RacingGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        Cars cars = new Cars(InputNameHandler.createNames(input.inputCarNames()));
        int trials = input.inputTrials();
        race(cars, trials);
        output.printWinner(cars.getWinner());
    }

    private void race(Cars cars, int trials) {
        for (int round = 0; round < trials; round++) {
            cars.move();
            output.printCurrentPosition(cars.getCars());
        }
    }
}