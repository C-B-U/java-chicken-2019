package domain;

public enum MenuType {
    CHICKEN("치킨"),
    DRINK("음료");

    final String type;

    MenuType(String type) {
        this.type = type;
    }
}
