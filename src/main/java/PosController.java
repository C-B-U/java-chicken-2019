public class PosController {
    private final PosService posService;

    public PosController() {
        this.posService = new PosService();
    }

    public void startProgram(){
        int number = 0;
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
