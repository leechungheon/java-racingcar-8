package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;
    public Cars(List<Car> cars){
        validateDuplicateNames(cars);
        this.cars=cars;
    }
    private void validateDuplicateNames(List<Car> cars){
        if(cars.size() != getUniqueNames(cars).size()){
            throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
        }
    }
    private Set<String> getUniqueNames(List<Car> cars){
        Set<String> uniqueNames = new HashSet<>();
        for(Car car : cars){
            uniqueNames.add(car.getName());
        }
        return uniqueNames;
    }
    public List<Car> getCars(){
        return this.cars;
    }
    public int getTotalCarsNumber(){
        return cars.size();
    }
    public List<Car> getMaximumDistanceCars(){
        if (this.cars.isEmpty()) {
            return new ArrayList<>();
        }

        int maxDistance = findMaximumDistance();

        return filterCarsByDistance(maxDistance);
    }
    private int findMaximumDistance() {
        int maxDistance = 0;

        for (Car car : this.cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    private List<Car> filterCarsByDistance(int distance) {
        List<Car> winners = new ArrayList<>();

        for (Car car : this.cars) {
            if (car.getDistance() == distance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
