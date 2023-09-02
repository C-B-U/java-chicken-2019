public class PosService {
    private final InputView inputView;
    private final OutputView outputView;
    private final TableList tableList;

    public PosService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.tableList = new TableList();
    }

    public int selectMain(){
        outputView.printMainProgram();
        outputView.printMainFunction();
        return inputView.readMainNumber();
    }

    public void registerOrder(int number){
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

    public void makePayment(int number){
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
