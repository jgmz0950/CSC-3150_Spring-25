package Class_02_04;

public class DBOfATMUsers_Tester implements IDBOfATMUsers {
//    @Override
//    public PinUser getPinUser(int pinNumber) {
//        return null;
//    }

    @Override
    public PinUser getPinUser(String pin) {
        //PinUser(String pin, String firstName, String lastName, double balance) {
        double balance = Double.parseDouble(pin);
        System.out.printf("Got balance=%s", balance);
        PinUser pinUser = new PinUser(pin, "Herman", "Munster", balance);
        return pinUser;
    }
}