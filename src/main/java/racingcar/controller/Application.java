package racingcar.controller;

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
        outputView.requestCarNames();
        Cars cars = carService.createCar(inputView.readCarNames());
        outputView.requestTryNumber();
        int tryCount = inputView.readTryCount();
        //최종 결과 출력
        racingService.startRacing(cars,tryCount);
    }

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        CarService carService = new CarService();
        RacingService racingService = new RacingService();

        Application app = new Application(outputView, inputView, carService, racingService);
        app.run();
    }
}
