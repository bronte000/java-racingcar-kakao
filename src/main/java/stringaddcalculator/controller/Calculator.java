package stringaddcalculator.controller;

import stringaddcalculator.utils.Parser;
import stringaddcalculator.model.PositiveNumber;

import java.util.List;

public class Calculator {

    public PositiveNumber sum(List<PositiveNumber> positiveNumbers) {
        return positiveNumbers.stream()
                .reduce(new PositiveNumber(0), PositiveNumber::add);
    }

    public PositiveNumber sum(String input) {
        List<PositiveNumber> positiveNumbers = Parser.parseNumbers(input);
        return sum(positiveNumbers);
    }
}
