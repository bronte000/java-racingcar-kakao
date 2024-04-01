package stringaddcalculator.utils;

import stringaddcalculator.model.PositiveNumber;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Parser {

    public static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static List<PositiveNumber> parseNumbers(String input) {
        if (input == null || input.isEmpty()) {
            return List.of(new PositiveNumber(0));
        }

        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String customRegex = matcher.group(1);
            return convertToIntegers(matcher.group(2), customRegex);
        }
        return convertToIntegers(input);
    }

    private static List<PositiveNumber> convertToIntegers(String input, String customRegex) {
        return stream(input.split("[,;" + customRegex + "]"))
                .map(Integer::parseInt)
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    private static List<PositiveNumber> convertToIntegers(String input) {
        return stream(input.split("[,;]"))
                .map(Integer::parseInt)
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }
}
