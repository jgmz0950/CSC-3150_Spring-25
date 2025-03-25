package CLASS_02_11;

import java.util.InputMismatchException;

public class ATM_Manager {
    //    DBOfATMUsers dbOfATMUsers;
    PinUser pinUser;
    String userPin;
    ATMUsersInterface atmUsersInterface;
    public ATM_Manager(String userPin, ATMUsersInterface atmUsersInterface ) {
//        this.dbOfATMUsers = new DBOfATMUsers();
        this.atmUsersInterface = atmUsersInterface;
        this.pinUser = atmUsersInterface.getThisUserRecord( userPin);
        if ( pinUser == null) {
            throw new InputMismatchException("Transaction Denied pin is null");
        }
    }
    public PinUser withDrawRequest(double withAmount ){
        double newBalance = 0.0;
        System.out.printf("\n Balance=%s withAmount:%s", this.pinUser.balance, withAmount);
        if ( withAmount > this.pinUser.balance){
            throw new InputMismatchException("Insufficient Funds");
        } else if (withAmount > this.pinUser.balance *.8 ){
            throw new InputMismatchException("Funds Not Within Treshold");
        } else {
            newBalance = this.pinUser.balance - withAmount;
            this.pinUser.setMsg("Withdraw Approved New Balance: " + newBalance);
        }
        return pinUser;
    }
}