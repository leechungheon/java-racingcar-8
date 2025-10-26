package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    // 스트림 API로 추후 리팩터링 고려하기
    public Cars createCar(String inputCarNames){
        validateNoBlankInCarNames(inputCarNames);
        String[] carArray = inputCarNames.split(",",-1);
        validateDelimiterPosition(carArray);
        checkAtLeastTwoCars(carArray);
        List<Car> carList = new ArrayList<>();
        for (String car : carArray) {
            carList.add(new Car(car));
        }
        return new Cars(carList);
    }

    public void validateNoBlankInCarNames(String inputCarNames){
        if(inputCarNames.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 포함할 수 없습니다.");
        }
    }

    public void validateDelimiterPosition(String[] carArray){
        for(int i=0; i<carArray.length; i++){
            if(carArray[i].isBlank()){
                throw new IllegalArgumentException("잘못된 구분자(,)위치는 허용되지 않습니다.");
            }
        }
    }

    public void checkAtLeastTwoCars(String[] carArray){
        if(carArray.length<2){
            throw new IllegalArgumentException("자동차는 2대 이상 입력해야 합니다.");
        }
    }
}
