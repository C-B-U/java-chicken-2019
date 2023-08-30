package domain;

import constant.ExceptionMessage;
import constant.PrintElement;

import java.util.Arrays;

public enum MainOptions {

    ORDER_REGISTRATION(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    TERMINATION(3, "프로그램 종료");

    private final int choice;
    private final String title;

    MainOptions(int choice, String title) {
        this.choice = choice;
        this.title = title;
    }

    public static MainOptions getMainOptions(int input) {
        return Arrays.stream(MainOptions.values())
                .filter(option -> input == option.choice)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INCORRECT_MAIN_OPTION.toString()));
    }

    public boolean isTermination() {
        return this == TERMINATION;
    }

    public static String printValues() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(MainOptions.values())
                .forEach((value) ->
                        stringBuilder.append(value.choice)
                                .append(PrintElement.HYPHEN)
                                .append(value.title)
                                .append(PrintElement.NEW_LINE)
                );
        return stringBuilder.toString();
    }
}
