package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private final OutputView outputView;
    private final InputView inputView;
    public Application(OutputView outputView, InputView inputView){
        this.outputView = outputView;
        this.inputView = inputView;
    }
    public void run(){
        outputView.requestCarNames();
        inputView.readCarNames();
        outputView.requestTryNumber();
        inputView.readTryNumber();
    }
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        Application app = new Application(outputView, inputView);
        app.run();
    }
}
