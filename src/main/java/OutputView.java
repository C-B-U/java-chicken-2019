public class OutputView {

    public void printMainProgram() {
        System.out.println(ProgressMessage.MAIN_MESSAGE);
    }

    public void printSelectMainNumber() {
        System.out.println(ProgressMessage.SELECT_NUMBER);
    }

    public void printMainFunction() {
        System.out.println(FunctionScreen.showMainFunction());
    }

    public void printTableStatus(TableStatus tableStatus) {
        System.out.println(ProgressMessage.TABLE_LIST);
        System.out.println(tableStatus);
    }

    public void printSelectTableNumber() {
        System.out.println(ProgressMessage.SELECT_TABLE);
    }

    public void printMenuList() {
        System.out.println(Menu.showMenu());
    }

    public void printSelectMenu() {
        System.out.println(ProgressMessage.SELECT_MENU);
    }

    public void printMenuQuantity() {
        System.out.println(ProgressMessage.INPUT_MENU_QUANTITY);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printOrderHistory(OrderList orderList) {
        System.out.println(orderList);
    }

    public void printProgressPayment(int tableNum) {
        System.out.printf(ProgressMessage.PAYMENT_PROGRESS + "%n", tableNum);
    }

    public void printPaymentMethod() {
        System.out.println(PaymentMethod.showPaymentMethod());
    }

    public void printPaymentAmount() {
        System.out.println(ProgressMessage.PAYMENT_AMOUNT);
    }

    public void printPaymentPrice(Payment payment) {
        System.out.println(payment);
        printEnter();
    }

    public void printEnter() {
        System.out.println();
    }
}
