package Class_02_04;

public class DriveATMMachine {
    public static void main(String[] args) {
        String pin = getPinFromUser();
        ATM_Manager atm = new ATM_Manager( pin );
        String msg = atm.checkPinInfo();
        System.out.printf("\n Msg:%s", msg );
        double withAmount = getWithAmount();
        PinUser pinUser = atm.withDrawRequest(  withAmount );
        System.out.printf("\n User:%s Amount=%s msg=%s", pinUser.lastName, pinUser.balance, pinUser.getMsg());
    }
    private static String getPinFromUser() {
        return "1002";
    }
    private static double getWithAmount(){
        return 222.00;
    }
}