package view;

import constant.OutputMessage;
import constant.PaymentType;
import domain.*;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MainOptions inputMainOption() {
        System.out.println(OutputMessage.OPTION_SELECT);
        int input = scanner.nextInt();
        System.out.println();
        return MainOptions.getMainOptions(input);
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        int tableNumber = scanner.nextInt();
        System.out.println();
        return tableNumber;
    }

    public static Menu inputMenu() {
        System.out.println(OutputMessage.MENU);
        int input = scanner.nextInt();
        System.out.println();
        return MenuRepository.findMenuByNumber(input);
    }

    public static int inputQuantity() {
        System.out.println(OutputMessage.QUANTITY);
        int quantity = scanner.nextInt();
        System.out.println();
        return quantity;
    }

    public static PaymentType inputPayment() {
        int payment = scanner.nextInt();
        System.out.println();
        return PaymentType.getPaymentType(payment);
    }
}
