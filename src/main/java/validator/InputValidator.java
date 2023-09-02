package validator;

import domain.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGIX = "^[\\d]*$";
    public void validateIsDigit(String number) {
        if (!Pattern.matches(number, REGIX)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FEATURE_NUMBER.toString());
        }
    }
}
