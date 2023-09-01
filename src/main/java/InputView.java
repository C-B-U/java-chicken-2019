import java.util.Scanner;

public class InputView {

    InputValidator inputValidator = new InputValidator();
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
            inputValidator.validateMainListNumber(number);
            return number;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }
}
