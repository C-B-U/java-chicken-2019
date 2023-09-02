package validator;

import constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {



    public static void validateNumber(String userInput) {
        String NUMBER_REGEXP = "^\\d*$";

        if (!Pattern.matches(NUMBER_REGEXP, userInput)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_NUMBER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
