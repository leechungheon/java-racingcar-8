package racingcar.DomainTest; // CarService가 model 패키지에 있다고 가정

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

class CarsTest {
    private Car createMockCar(String name){
        return new Car(name);
    }
    @DisplayName("이름이 중복된 Car 리스트로 Cars 생성 시 예외를 발생시킨다.")
    @Test
    void cars_정상_생성_및_크기_확인(){
        // given: 중복된 입력 문자열
        List<Car> carList = Arrays.asList(
                createMockCar("pobi"),
                createMockCar("woni"),
                createMockCar("jun")
        );

        // when: Cars 객체 생성
        Cars cars = new Cars(carList);

        // then: 내부 리스트 크기와 이름이 정확한지 확인
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("woni");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("jun");
    }
    @DisplayName("이름이 중복된 Car 리스트로 Cars 생성 시 예외를 발생시킨다.")
    @Test
    void validateDuplicateNames_중복된_이름_예외(){
        // given: 중복된 입력 문자열
        List<Car> carList = Arrays.asList(
                createMockCar("pobi"),
                createMockCar("pobi"),
                createMockCar("woni")
        );

        // when && then: 객체 생성 && 중복인지 확인 후 예외처리
        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름은 허용되지 않습니다.");
    }
}
