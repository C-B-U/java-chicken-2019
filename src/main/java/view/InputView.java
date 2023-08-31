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
        return MainOptions.getMainOptions(input);
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static Menu inputMenu() {
        System.out.println(OutputMessage.MENU);
        int input = scanner.nextInt();
        return MenuRepository.findMenuByNumber(input);
    }

    public static int inputQuantity() {
        System.out.println(OutputMessage.QUANTITY);
        return scanner.nextInt();
    }

    public static PaymentType inputPayment() {
        return PaymentType.getPaymentType(scanner.nextInt());
    }
}
