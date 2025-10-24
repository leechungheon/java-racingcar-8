package racingcar; // CarService가 model 패키지에 있다고 가정

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.CarService;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarServiceTest {
    private final CarService carService = new CarService();

    // --- 정상 동작 테스트 ---

    @DisplayName("쉼표로 구분된 이름 문자열로부터 Car 객체 리스트를 성공적으로 생성한다.")
    @Test
    void createCars_정상_생성() {
        // given: 입력 문자열
        String inputNames = "pobi,woni,jun";

        // when: CarService를 통해 Car 객체 리스트 생성
        Cars cars = carService.createCar(inputNames);

        // then: 리스트의 크기와 각 Car 객체의 이름이 정확한지 검증
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    // --- 예외 처리 테스트 ---

    @DisplayName("이름 길이가 5자를 초과하거나 빈 문자열일 경우 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest(name = "{index}: 입력값 \"{0}\" 테스트")
    @ValueSource(strings = {
            "pobi,javaji",     // 6자 초과 이름
            "pobi,woni,",      // 후행 쉼표로 인한 빈 문자열
            ",pobi,woni",      // 선행 쉼표로 인한 빈 문자열
            "pobi,,woni",      // 연속 쉼표로 인한 빈 문자열
            "pobi,      ",     // 공백만 있는 이름
            "abcdef,woni",     // 6자 초과 이름
            "  ,woni",         // 공백만 있는 이름
            "pobi"             // 이름이 한 개
    })
    void createCars_예외_유효성_검사(String invalidInput) {
        // then: CarService의 createCars 메서드 호출 시 예외 발생 검증
        assertThatThrownBy(() -> carService.createCar(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}