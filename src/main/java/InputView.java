import java.util.Scanner;

public class InputView {

    OutputView outputView = new OutputView();

    public Integer readNumber(){
        Integer input;
        do {
            input = inputSelectNumber();
        }while (input == null);
        return input;
    }

    public Integer inputSelectNumber(){
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
}
