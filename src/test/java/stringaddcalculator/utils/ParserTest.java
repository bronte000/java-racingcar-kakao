package stringaddcalculator.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringaddcalculator.utils.Parser;
import stringaddcalculator.model.PositiveNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    @Test
    void 커스텀_구분자가_존재하는_경우_커스텀_구분자로_자른다() {
        String hasDelimiter = "//a\n1a2a3";

        assertThat(Parser.parseNumbers(hasDelimiter))
                .isEqualTo(List.of(
                        new PositiveNumber(1),
                        new PositiveNumber(2),
                        new PositiveNumber(3)
                ));
    }

    @Test
    void 기본_구분자가_존재하는_경우_기본_구분자로_자른다() {
        String hasNormalDelimiter = "1,2";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(
                        new PositiveNumber(1),
                        new PositiveNumber(2)
                ));
    }

    @Test
    void 기본_구분자가_섞여_존재하는_경우_올바르게_자른다() {
        String hasNormalDelimiter = "1,2;3";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(
                        new PositiveNumber(1),
                        new PositiveNumber(2),
                        new PositiveNumber(3)
                ));
    }

    @Test
    void 기본_구분자와_커스텀_구분자가_섞여_존재하는_경우_올바르게_자른다() {
        String hasNormalDelimiter = "//b\n1b2,3;4";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(
                        new PositiveNumber(1),
                        new PositiveNumber(2),
                        new PositiveNumber(3),
                        new PositiveNumber(4)
                ));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 문자열이_비었거나_널일_경우_0을_반환한다(String input) {
        assertThat(Parser.parseNumbers(input))
                .isEqualTo(List.of(new PositiveNumber(0)));
    }

    @Test
    void 구분할_숫자가_없는_경우_구분_없이_반환한다() {
        String hasNormalDelimiter = "9";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(new PositiveNumber(9)));
    }
}
