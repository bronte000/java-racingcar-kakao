package stringaddcalculator.model;

import java.util.Objects;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        validate(number);
        this.number = number;
    }

    public PositiveNumber(String number) {
        this(Integer.parseInt(number));
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
    }

    public PositiveNumber add(PositiveNumber targetPositiveNumber) {
        return new PositiveNumber(this.number + targetPositiveNumber.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positiveNumber1 = (PositiveNumber) o;
        return number == positiveNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
