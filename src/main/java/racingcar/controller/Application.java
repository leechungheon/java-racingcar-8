package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarService;
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
        List<Car> carList = carService.createCar(inputView.readCarNames());
        outputView.requestTryNumber();
        inputView.readTryNumber();
    }

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        CarService carService = new CarService();

        Application app = new Application(outputView, inputView, carService);
        app.run();
    }
}
