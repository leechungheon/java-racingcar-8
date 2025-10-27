package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.model.CarService;
import racingcar.model.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }

    public CarService carService() {
        return new CarService();
    }

    public RacingService racingService() {
        return new RacingService();
    }

    public RacingCarController racingCarController() {
        return new RacingCarController(
                outputView(),
                inputView(),
                carService(),
                racingService()
        );
    }
}