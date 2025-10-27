package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        RacingCarController controller = config.racingCarController();
        controller.run();
    }
}