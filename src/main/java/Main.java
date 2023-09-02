public enum Main {
    REGISTER_ORDER(1, "주문등록"),
    MAKE_PAYMENT(2, "결제하기"),
    PROGRAM_EXIT(3, "프로그램 종료");

    private final int number;
    private final String function;

    Main(int number, String function) {
        this.number = number;
        this.function = function;
    }

    public static void validateMainListNumber(Integer number){
        if (number < REGISTER_ORDER.number || number > PROGRAM_EXIT.number){
            throw new IllegalArgumentException(String.format(ErrorMessage.INPUT_MAIN_NUMBER_ERROR.toString()
                    , REGISTER_ORDER.number, PROGRAM_EXIT.number));
        }
    }

    public int getNumber() {
        return number;
    }

    public static String showMainFunction(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Main main : Main.values()){
            stringBuilder.append(String.format("%d - %s", main.number, main.function));
        }
        return stringBuilder.toString();
    }


}
