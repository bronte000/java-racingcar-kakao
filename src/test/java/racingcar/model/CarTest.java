package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"Mark", "Daisy", "Rosie"})
    void 다섯_글자_이하의_이름이_주어지면_해당_이름으로_인스턴스를_생성한다(String name) {
        Car car = new Car(name);

        assertThat(car.getName().length()).isEqualTo(name.length());
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 다섯_글자_초과의_이름이_주어지면_에러를_반환한다() {
        assertThatThrownBy(() -> new Car("Programmer"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차를_이동시키면_위치가_1_커진다() {
        Car car = new Car("Move");

        int previousPosition = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(previousPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 주사위_눈이_4이상이면_차를_이동시킨다(int diceNum) {
        Car car = new Car("Mark");

        int previousPosition = car.getPosition();
        car.moveWithDiceNum(diceNum);
        assertThat(car.getPosition()).isEqualTo(previousPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 주사위_눈이_4미만이면_차를_이동시키지_않는다(int diceNum) {
        Car car = new Car("Mark");

        int previousPosition = car.getPosition();
        car.moveWithDiceNum(diceNum);
        assertThat(car.getPosition()).isEqualTo(previousPosition);
    }
}
