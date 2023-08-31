package view;

import constant.OutputMessage;
import constant.PaymentType;
import domain.*;
import validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainOptions inputMainOption() {
        System.out.println(OutputMessage.OPTION_SELECT);
        String input = scanner.nextLine();
        InputValidator.validateNumber(input);
        System.out.println();
        return MainOptions.getMainOptions(Integer.parseInt(input));
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String tableNumber = scanner.nextLine();
        InputValidator.validateNumber(tableNumber);
        System.out.println();
        return Integer.parseInt(tableNumber);
    }

    public static Menu inputMenu() {
        System.out.println(OutputMessage.MENU);
        String input = scanner.nextLine();
        InputValidator.validateNumber(input);
        System.out.println();
        return MenuRepository.findMenuByNumber(Integer.parseInt(input));
    }

    public static int inputQuantity() {
        System.out.println(OutputMessage.QUANTITY);
        String input = scanner.nextLine();
        InputValidator.validateNumber(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    public static PaymentType inputPayment() {
        String input = scanner.nextLine();
        InputValidator.validateNumber(input);
        System.out.println();
        return PaymentType.getPaymentType(Integer.parseInt(input));
    }
}
