public class OutputView {

    public void printChoicesProgram(){
        System.out.println(ProgressMessage.MAIN_MESSAGE);
        System.out.println(ProgressMessage.SELECT_NUMBER);
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
}
