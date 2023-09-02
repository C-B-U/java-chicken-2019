import java.util.Scanner;

public class InputView {

    OutputView outputView = new OutputView();

    public Integer readMainNumber(){
        Integer input;
        do {
            input = inputMainNumber();
        }while (input == null);
        return input;
    }

    public Integer inputMainNumber(){
        outputView.printSelectMainNumber();
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        try {
            Main.validateMainListNumber(number);
            return number;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    public Table readTableNumber(TableList tableList){
        Table table;
        do {
            table = inputTableNumber(tableList);
        }while (table == null);
        return table;
    }

    private Table inputTableNumber(TableList tableList) {
        outputView.printSelectTableNumber();
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        try {
            tableList.validateTableNumber(number);
            return tableList.getTable(number);
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    public Menu readMenuNumber(){
       Menu menu;
       do{
           menu = inputMenuNumber();
       }while (menu == null);
       return menu;
    }

    private Menu inputMenuNumber() {
        outputView.printSelectMenu();
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        try {
            Menu.validateMenuNumber(number);
            return Menu.getMenu(number);
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    public Integer readMenuQuantity(OrderList orderList, Menu menu){
        Integer quantity;
        do {
            quantity = inputMenuQuantity(orderList, menu);
        }while (quantity == null);
        return quantity;
    }

    private Integer inputMenuQuantity(OrderList orderList, Menu menu) {
        outputView.printMenuQuantity();
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        try {
            orderList.validateMenuQuantity(menu, quantity);
            return quantity;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    public Integer readPaymentNumber(int tableNum){
        Integer number;
        do {
            number = inputPaymentNumber(tableNum);
        }while (number == null);
        return number;
    }

    private Integer inputPaymentNumber(int tableNum) {
        outputView.printProgressPayment(tableNum);
        outputView.printPaymentMethod();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        try {
            PaymentMethod.validatePaymentNumber(number);
            return number;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }


}
