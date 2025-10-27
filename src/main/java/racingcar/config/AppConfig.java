package racingcar.config;

import racingcar.Application;
import racingcar.model.CarService;
import racingcar.model.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public CarService carService() {
        return new CarService();
    }

    public RacingService racingService() {
        return new RacingService();
    }

    public Application application() {
        return new Application(
                outputView(),
                inputView(),
                carService(),
                racingService()
        );
    }
}