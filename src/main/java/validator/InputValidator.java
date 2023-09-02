package validator;

import domain.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEX = "^[0-9]+$";

    public void validateIsDigit(String number) {
        if (Pattern.matches(number, REGEX)) {
            System.out.println(Pattern.matches(number, REGEX));
            throw new IllegalArgumentException(ErrorMessage.WRONG_FEATURE_NUMBER.toString());
        }
    }
}
