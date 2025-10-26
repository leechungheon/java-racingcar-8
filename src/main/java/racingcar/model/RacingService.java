package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    private static final int MINIMUM_MOVE_CRITERIA = 4;

    public void runOneTurn(Cars cars){
        cars.getCars().forEach(this::move);
    }

    public void move(Car car){
        if(Randoms.pickNumberInRange(0, 9) >= MINIMUM_MOVE_CRITERIA){
            car.increaseDistance();
        }
    }
}
