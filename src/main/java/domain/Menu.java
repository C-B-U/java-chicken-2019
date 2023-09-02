package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    FRIED_CHICKEN(MenuType.CHICKEN, 1, "후라이드", 16000),
    SEASONED_CHICKEN(MenuType.CHICKEN, 2, "양념치킨", 16000),
    HALF_AND_HALF_CHICKEN(MenuType.CHICKEN, 3, "반반치킨", 16000),
    BARBECUE(MenuType.CHICKEN, 4, "통구이", 16000),
    SOY_SAUCE_CHICKEN(MenuType.CHICKEN, 5, "간장치킨", 17000),
    BONELESS_CHICKEN(MenuType.CHICKEN, 6, "순살치킨", 17000),
    COLA(MenuType.DRINK, 7, "콜라", 1000),
    CIDER(MenuType.DRINK, 8, "사이다", 1000);

    private static final String NEW_LINE = "\n";
    private static final String LINK = " - ";
    private static final String COLON = " : ";
    private static final String WON_UNIT = "원";
    final MenuType menuType;
    final String menuName;
    final int menuNumber;
    final int menuPrice;

    Menu(MenuType menuType, int menuNumber, String menuName, int menuPrice) {
        this.menuType = menuType;
        this.menuNumber = menuNumber;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public static String getMenuBoard() {
        return Arrays.stream(values())
                .map(Menu::toString)
                .collect(Collectors.joining(NEW_LINE));
    }

    public static Menu convert(String number) {
        return Arrays.stream(values())
                .filter(menuNumber -> menuNumber.menuNumber == Integer.parseInt(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WRONG_MENU_NUMBER.toString()));
    }

    @Override
    public String toString() {
        return "[" + menuType.type + "] " + menuNumber + LINK + menuName
                + COLON + menuPrice + WON_UNIT;
    }
}