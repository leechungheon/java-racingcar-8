package racingcar.controller;

import racingcar.config.AppConfig;
import racingcar.model.CarService;
import racingcar.model.Cars;
import racingcar.model.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;
    private final RacingService racingService;
    public Application(OutputView outputView, InputView inputView, CarService carService, RacingService racingService){
        this.outputView = outputView;
        this.inputView = inputView;
        this.carService = carService;
        this.racingService = racingService;
    }

    public void run(){
        // 입력
        outputView.requestCarNames();
        Cars cars = carService.createCar(inputView.readCarNames());
        outputView.requestTryNumber();
        int tryCount = inputView.readTryCount();

        // 실행
        startRacing(cars,tryCount);

        // 출력
        outputView.printWinnerMessage(cars.getMaximumDistanceCars());
    }

    private void startRacing(Cars cars, int tryCount){
        // 최종 결과 출력
        outputView.printExecutionMessage();
        while(tryCount!=0){
            racingService.runOneTurn(cars);
            outputView.printOneTurn(cars);
            tryCount--;
        }
    }

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        Application app = config.application();
        app.run();
    }
}
