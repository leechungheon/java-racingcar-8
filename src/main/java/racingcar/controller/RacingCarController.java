package racingcar.controller;

import racingcar.model.CarService;
import racingcar.model.Cars;
import racingcar.model.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;
    private final RacingService racingService;

    public RacingCarController(OutputView outputView, InputView inputView, CarService carService, RacingService racingService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.carService = carService;
        this.racingService = racingService;
    }

    public void run() {
        // 1. 입력
        outputView.requestCarNames();
        Cars cars = carService.createCar(inputView.readCarNames());

        outputView.requestTryNumber();
        int tryCount = inputView.readTryCount();

        // 2. 실행
        startRacing(cars, tryCount);

        // 3. 출력
        outputView.printWinnerMessage(cars.getMaximumDistanceCars());
    }
    private void startRacing(Cars cars, int tryCount) {
        outputView.printExecutionMessage();

        while (tryCount > 0) {
            racingService.runOneTurn(cars);
            outputView.printOneTurn(cars);
            tryCount--;
        }
    }
}