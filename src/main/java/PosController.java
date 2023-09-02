public class PosController {

    private final InputView inputView;
    private final OutputView outputView;
    private final TableList tableList;

    public PosController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.tableList = new TableList();
    }

    public void startProgram(){
        int number = 0;
        while (Main.isNotProgramExit(number)){
            outputView.printMainProgram();
            outputView.printMainFunction();
            number = inputView.readMainNumber();
            executeFunction(number);
        }
    }

    private void executeFunction(int number){
        registerOrder(number);
        makePayment(number);
    }
    private void registerOrder(int number){
        if (Main.isRegisterOrder(number)){
            outputView.printTableList(tableList);
            Table table = inputView.readTableNumber(tableList);
            outputView.printMenuList();
            Menu menu = inputView.readMenuNumber();
            OrderList orderList = table.getOrderList();
            int quantity = inputView.readMenuQuantity(orderList, menu);
            orderList.saveOrder(menu, quantity);
            tableList.changeTableOrderStatus(table);
        }
    }

    private void makePayment(int number){
        if (Main.isMakePayment(number)){
            outputView.printTableList(tableList);
            Table table = inputView.readTableNumber(tableList);
            outputView.printOrderHistory(table.getOrderList());
            int paymentNumber = inputView.readPaymentNumber(table.getNumber());
            outputView.printPaymentAmount();
            Payment payment = new Payment(table.getOrderList());
            payment.applyDiscount(paymentNumber);
            outputView.printPaymentPrice(payment);
            tableList.changeTablePaymentStatus(table);
        }
    }
}
