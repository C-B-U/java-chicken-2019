import java.util.Arrays;

public enum Menu {

    MENU1("치킨", 1, "후라이드", 16000),
    MENU2("치킨", 2, "양념치킨", 16000),
    MENU3("치킨", 3, "반반치킨", 16000),
    MENU4("치킨", 4, "통구이", 16000),
    MENU5("치킨", 5, "간장치킨", 17000),
    MENU6("치킨", 6, "순살치킨", 17000),
    MENU21("음료", 21, "콜라", 1000),
    MENU22("음료", 22, "사이다", 1000);


    private final String type;
    private final int number;
    private final String name;
    private final int price;

    Menu(String type, int number, String name, int price) {
        this.type = type;
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public static String showMenu(){
        StringBuilder menuString = new StringBuilder();
        for (Menu menu : values()) {
            menuString.append(String.format("[%s] %d - %s : %d원\n", menu.type, menu.number, menu.name, menu.price));
        }
        menuString.append("\n");
        return menuString.toString();
    }

    public static Menu getMenu(Integer number){
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.number == number)
                .findFirst()
                .orElse(null);
    }

    public static void validateMenuNumber(Integer number) {
        if (Arrays.stream(Menu.values()).noneMatch(menu -> menu.number == number)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_MENU_NUMBER_ERROR.toString());
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

