public class PosController {
    private static final int INIT_NUMBER = 0;
    private final PosService posService;

    public PosController() {
        this.posService = new PosService();
    }

    public void startProgram(){
        int number = INIT_NUMBER;
        while (Main.isNotProgramExit(number)){
            number = posService.selectMain();
            executeFunction(number);
        }
    }

    private void executeFunction(int number){
        posService.registerOrder(number);
        posService.makePayment(number);
    }
}
