package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private static final int MINIMUM_CAR_COUNT = 2;
    private static final String DELIMITER = ",";

    public Cars createCar(String inputCarNames){
        validateNoBlankInCarNames(inputCarNames);
        String[] carArray = inputCarNames.split(DELIMITER,-1);
        validateDelimiterPosition(carArray);
        validateMinimumCarCount(carArray);

        List<Car> carList = Arrays.stream(carArray)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    private void validateNoBlankInCarNames(String inputCarNames){
        if(inputCarNames.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 포함할 수 없습니다.");
        }
    }

    private void validateDelimiterPosition(String[] carArray){
        boolean hasBlankEntry = Arrays.stream(carArray)
                .anyMatch(String::isBlank);

        if(hasBlankEntry){
            throw new IllegalArgumentException("잘못된 구분자(,)위치는 허용되지 않습니다.");
        }

    }

    private void validateMinimumCarCount(String[] carArray){
        if(carArray.length < MINIMUM_CAR_COUNT){
            throw new IllegalArgumentException("자동차는 2대 이상 입력해야 합니다.");
        }
    }
}
