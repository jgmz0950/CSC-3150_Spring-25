package Class_02_04;


import java.util.InputMismatchException;
import java.util.Random;

public class ATM_Manager {
    DBOfATMUsers dbOfATMUsers;
    PinUser pinUser;
    String userPin;
    IDBOfATMUsers idbOfATMUsers;
    public ATM_Manager( String userPin, IDBOfATMUsers idbOfATMUsers ) {
        //this.dbOfATMUsers = new DBOfATMUsers();
        this.idbOfATMUsers = idbOfATMUsers;
        this.userPin = userPin;
        this.pinUser = dbOfATMUsers.getThisUserRecord( userPin);
        if ( pinUser == null) {
            throw new InputMismatchException("Transaction Denied pin is null");
        }
    }
    public String  checkPinInfo(){
        this.pinUser = dbOfATMUsers.getThisUserRecord( userPin );
        String msg = "";
        double balance = pinUser.balance;
        msg = "Balance: " + balance;
        return msg;
    }
    public PinUser withDrawRequest( double withAmount ){
        double newBalance;
        if ( pinUser == null){
            throw new InputMismatchException("Transaction Denied");
        } else {
            if ( withAmount > pinUser.balance){
                throw new InputMismatchException("Insufficient Funds");
            } else if (withAmount > pinUser.balance *.8 ){
                throw new InputMismatchException("Funds Not Within Treshold");
            } else {
                newBalance = pinUser.balance - withAmount;
                pinUser.setMsg("Withdraw Approved New Balance: " + newBalance);
            }
            return pinUser;
        }
    }
}