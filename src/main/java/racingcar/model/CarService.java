package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    // 스트림 API로 추후 리팩터링 고려하기
    public Cars createCar(String inputCarNames){
        if(inputCarNames.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 포함할 수 없습니다.");
        }
        String[] carArray = inputCarNames.split(",",-1);
        for(int i=0; i<carArray.length; i++){
            if(carArray[i].isBlank()){
                throw new IllegalArgumentException("잘못된 구분자(,)위치는 허용되지 않습니다.");
            }
        }
        if(carArray.length<2){
            throw new IllegalArgumentException("자동차는 2대 이상 입력해야 합니다.");
        }
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carArray.length; i++){
            carList.add(new Car(carArray[i]));
        }
        return new Cars(carList);
    }
}
