package view;

import domain.PosFeature;
import domain.ProcessMessage;

public class OutputView {

    public void printMainScreen() {
        System.out.println(ProcessMessage.MAIN_SCREEN);
        System.out.println(PosFeature.getFeatureName());
        printSelectFeature();
    }

    private void printSelectFeature() {
        System.out.println(ProcessMessage.SELECT_FEATURE);
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
