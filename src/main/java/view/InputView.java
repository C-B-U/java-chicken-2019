package view;


import camp.nextstep.edu.missionutils.Console;
import domain.PosFeature;
import validator.InputValidator;

public class InputView {
    private static final InputValidator inputValidator = new InputValidator();
    private static final OutputView outputView = new OutputView();

    public PosFeature inputWantedFeature() {
        String number = Console.readLine();
        try {
            inputValidator.validateIsDigit(number);
            return PosFeature.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedFeature();
        }
    }
}
