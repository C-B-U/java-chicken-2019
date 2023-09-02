package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum PosFeature {
    ORDER_REGISTER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    PROGRAM_QUIT(3, "프로그램 종료");

    private static final String NEW_LINE = "\n";
    private static final String LINK = "-";
    private final int featureNumber;
    private final String featureName;

    PosFeature(int featureNumber, String featureName) {
        this.featureNumber = featureNumber;
        this.featureName = featureName;
    }

    public static String getFeatureName() {
        return Arrays.stream(values())
                .map(feature -> feature.featureNumber + LINK + feature.featureName)
                .collect(Collectors.joining(NEW_LINE));
    }

    public static PosFeature convert(String number) {
        return Arrays.stream(values())
                .filter(feature -> feature.featureNumber == Integer.parseInt(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WRONG_FEATURE_NUMBER.toString()));
    }
}
