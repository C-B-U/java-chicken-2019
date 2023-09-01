public class Table {

    private final int number;
    private boolean isOrdering = false;

    public Table(int number) {
        this.number = number;
    }

    private void isOrdering(boolean isOrdering){
        this.isOrdering = isOrdering;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOrdering() {
        return isOrdering;
    }
}
