package racingcar.controller;

import racingcar.model.CarService;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;
    public Application(OutputView outputView, InputView inputView, CarService carService){
        this.outputView = outputView;
        this.inputView = inputView;
        this.carService = carService;
    }

    public void run(){
        outputView.requestCarNames();
        Cars cars = carService.createCar(inputView.readCarNames());
        outputView.requestTryNumber();
        int tryCount = inputView.readTryCount();
        //최종 결과 출력
    }

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        CarService carService = new CarService();

        Application app = new Application(outputView, inputView, carService);
        app.run();
    }
}
