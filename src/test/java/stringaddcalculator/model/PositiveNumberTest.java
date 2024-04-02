package stringaddcalculator.model;

import org.junit.jupiter.api.Test;
import stringaddcalculator.model.PositiveNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @Test
    void add() {
        PositiveNumber n1 = new PositiveNumber(1);
        PositiveNumber n2 = new PositiveNumber(2);
        assertThat(n1.add(n2)).isEqualTo(new PositiveNumber(3));
    }

    @Test
    void construct_fail() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construct_fail2() {
        assertThatThrownBy(() -> new PositiveNumber("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
