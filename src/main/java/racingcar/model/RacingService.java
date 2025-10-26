package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    public void runOneTurn(Cars cars){
        for(int i=0; i< cars.getTotalCarsNumber(); i++) {
            move(cars.getCars().get(i));
        }
    }
    public void move(Car car){
        if(Randoms.pickNumberInRange(0, 9)>=4){
            car.increaseDistance();
        }
    }
}
