public class InputValidator {

    private static final int FIRST_MAIN_NUMBER = 1;
    private static final int LAST_MAIN_NUMBER = 3;

    public void validateMainListNumber(Integer number){
        if (number < FIRST_MAIN_NUMBER || number > LAST_MAIN_NUMBER){
            throw new IllegalArgumentException(String.format(ErrorMessage.INPUT_MAIN_NUMBER_ERROR.toString()
                    , FIRST_MAIN_NUMBER, LAST_MAIN_NUMBER));
        }
    }
}
