package domain;

public class MenuQuantity {
    private static final int MAXIMUM_QUANTITY = 99;
    private int quantity;

    public MenuQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    private void validateQuantity(int quantity) {
        if(quantity > MAXIMUM_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_QUANTITY.toString());
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
