public class OutputView {

    public void printMainProgram(){
        System.out.println(ProgressMessage.MAIN_MESSAGE);

    }

    public void printSelectMainNumber(){
        System.out.println(ProgressMessage.SELECT_NUMBER);
    }

    public void printMainFunction(){
        System.out.println(Main.showMainFunction());
    }

    public void printTableList(TableList tableList){
        System.out.println(ProgressMessage.TABLE_LIST);
        System.out.println(tableList);
    }

    public void printSelectTableNumber(){
        System.out.println(ProgressMessage.SELECT_TABLE);
    }

    public void printMenuList(){
        System.out.println(Menu.showMenu());
    }

    public void printSelectMenu(){
        System.out.println(ProgressMessage.SELECT_MENU);
    }

    public void printMenuQuantity(){
        System.out.println(ProgressMessage.INPUT_MENU_QUANTITY);
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
}
