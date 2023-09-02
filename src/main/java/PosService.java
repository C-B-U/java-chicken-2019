public class PosService {
    private final InputView inputView;
    private final OutputView outputView;
    private final TableList tableList;
    private final TableStatus tableStatus;

    public PosService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.tableList = new TableList();
        this.tableStatus = new TableStatus(tableList);
    }

    public int selectMain(){
        outputView.printMainProgram();
        outputView.printMainFunction();
        return inputView.readMainNumber();
    }

    public void registerOrder(int number){
        if (Main.isRegisterOrder(number)){
            outputView.printTableList(tableStatus);
            Table table = inputView.readTableNumber(tableList);
            outputView.printMenuList();
            Menu menu = inputView.readMenuNumber();
            OrderList orderList = table.getOrderList();
            int quantity = inputView.readMenuQuantity(orderList, menu);
            orderList.saveOrder(menu, quantity);
            tableStatus.changeTableOrderStatus(table);
        }
    }

    public void makePayment(int number){
        if (Main.isMakePayment(number)){
            outputView.printTableList(tableStatus);
            Table table = inputView.readTableNumber(tableList);
            outputView.printOrderHistory(table.getOrderList());
            int paymentNumber = inputView.readPaymentNumber(table.getNumber());
            outputView.printPaymentAmount();
            Payment payment = new Payment(table.getOrderList());
            payment.applyDiscount(paymentNumber);
            outputView.printPaymentPrice(payment);
            tableStatus.changeTablePaymentStatus(table);
        }
    }
}
