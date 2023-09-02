package view;

import domain.FeatureMessage;
import domain.ProcessMessage;

public class OutputView {
    public void printMainScreen() {
        System.out.println(ProcessMessage.MAIN_SCREEN);
        System.out.println(FeatureMessage.getMessage());
    }
}
