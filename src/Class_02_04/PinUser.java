package Class_02_04;

public class PinUser {
    String pin;
    String firstName;
    String lastName;
    double balance;
    String msg = "";

    public PinUser(String pin, String firstName, String lastName, double balance) {
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    PinUser() {

    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}