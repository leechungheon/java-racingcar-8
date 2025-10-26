package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private final String SCORE_VISUALIZATION_CHAR = "-";
    public void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
    }

    public void requestTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printExecutionMessage(){
        System.out.println("\n실행 결과");
    }

    public void printOneTurn(Cars cars){
        cars.getCars().forEach(car->
            System.out.println(car.getName() + " : " + SCORE_VISUALIZATION_CHAR.repeat(car.getDistance()))
        );
        System.out.println();
    }

    public void printWinnerMessage(List<Car> winners){
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : "+ winnerNames);
    }
}
