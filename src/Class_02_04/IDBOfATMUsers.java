package Class_02_04;

import java.util.HashMap;

public interface IDBOfATMUsers {
    PinUser getPinUser(int pinNumber);

    PinUser getPinUser(String pin);
}
