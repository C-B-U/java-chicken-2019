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

    public Integer readTableNumber(TableList tableList){
        Integer input;
        do {
            input = inputTableNumber(tableList);
        }while (input == null);
        return input;
    }

    private Integer inputTableNumber(TableList tableList) {
        outputView.printSelectTableNumber();
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        try {
            tableList.validateTableNumber(number);
            return number;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }
}
