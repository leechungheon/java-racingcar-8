package racingcar.model;

public class Car {
    private final String name;
    private int distance=0;

    public Car(String name){
        validateNames(name);
        this.name = name;
    }

    public void validateNames(String name){
        if(name.length() > 5 || name.isBlank()){
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상, 5글자 이하가 되어야 합니다.");
        }
    }
}
