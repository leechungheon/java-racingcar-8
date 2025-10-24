package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;
    public Cars(List<Car> cars){
        validateDuplicateNames(cars);
        this.cars=cars;
    }
    public void validateDuplicateNames(List<Car> cars){
        if(cars.size() != getUniqueNames(cars).size()){
            throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
        }
    }
    public Set<String> getUniqueNames(List<Car> cars){
        Set<String> uniqueNames = new HashSet<>();
        for(Car car : cars){
            uniqueNames.add(car.getName());
        }
        return uniqueNames;
    }
    public List<Car> getCars(){
        return this.cars;
    }
}
