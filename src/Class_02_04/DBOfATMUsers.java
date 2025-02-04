package Class_02_04;

import java.util.HashMap;
import java.util.Random;

public class DBOfATMUsers {
    public PinUser getThisUserRecord( String pin ){
        HashMap<String, PinUser> DBOfATMUsers = getAllUserData();
        if ( DBOfATMUsers.containsKey(pin) ){
            return DBOfATMUsers.get(pin);
        } else {
            return null;
        }
    }
    public HashMap<String, PinUser> getAllUserData() {
        HashMap<String, PinUser> DBOfUsers = new HashMap<>();

        // Array of characters from The Munsters and The Addams Family
        String[][] users = {
                {"Herman", "Munster"},
                {"Lily", "Munster"},
                {"Eddie", "Munster"},
                {"Grandpa", "Munster"},
                {"Marilyn", "Munster"},
                {"Gomez", "Addams"},
                {"Morticia", "Addams"},
                {"Wednesday", "Addams"},
                {"Pugsley", "Addams"},
                {"Uncle", "Fester"}
        };

        int pin = 1000; // Start PIN from 1000

        for (String[] user : users) {
            double balance = Math.random() * 1000; // Random balance up to $1000
            DBOfUsers.put(String.valueOf(pin), new PinUser(String.valueOf(pin), user[0], user[1], balance));
            pin++; // Increment PIN for next user
        }

        return DBOfUsers;
    }

}