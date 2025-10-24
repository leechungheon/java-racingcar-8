package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingService {
    // depth 4 이므로 리팩터링 필요!
    public void startRacing(Cars cars, int tryCount){
        String hypen = "-";
        System.out.println("실행 결과");
        while(tryCount!=0){
            for(int i=0; i< cars.getTotalCarsNumber(); i++){
                move(cars.getCars().get(i));
                System.out.println(cars.getCars().get(i).getName()+" : "+hypen.repeat(cars.getCars().get(i).getDistance()));
            }
            tryCount--;
            System.out.println();
        }
        System.out.print("최종 우승자 : ");
        List<Car> winners = cars.getMaximumDistanceCars();
        for(int i=0; i< winners.size(); i++){
            if(i==0){
                System.out.print(winners.get(0).getName());
            }else{
                System.out.print(", "+winners.get(i).getName());
            }
        }
    }
    public void move(Car car){
        if(Randoms.pickNumberInRange(0, 9)>=4){
            car.increaseDistance();
        }
    }
}
