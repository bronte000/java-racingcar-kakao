package stringaddcalculator;

import org.junit.jupiter.api.Test;
import stringaddcalculator.controller.Calculator;
import stringaddcalculator.model.PositiveNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void sum() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(
                List.of(
                        new PositiveNumber(1),
                        new PositiveNumber(2),
                        new PositiveNumber(3)))
        ).isEqualTo(new PositiveNumber(6));
    }

    @Test
    void 쉼표_구분자를_가진_문자열_입력의_경우_올바르게_더한다() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum("1,2,3"))
                .isEqualTo(new PositiveNumber(6));
    }

    @Test
    void 커스텀_구분자를_가진_문자열_입력의_경우_올바르게_더한다() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum("//m\n1m2,3"))
                .isEqualTo(new PositiveNumber(6));
    }
}
