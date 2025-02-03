package HW_01_30;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    static BankAccount ba;

    @BeforeAll
    //setup
    static void setUp() {
        ba = new BankAccount("Jonathan", 5.0, 10.00);

    }

    //TODO: #5 make getInterestdue as stream testing.
    @ParameterizedTest
    @CsvSource({
            "999, 9.99", //balance, expected Interest
            "1000, 20.00",
            "1001, 20.02",
            "4999, 99.98",
            "5000, 150.00",
            "5001, 150.03"
    })
    @DisplayName("Test expected interest using BVA")
    void getInterestDue(double balance, double expectedInterest) {
        //Arrange
        ba = new BankAccount("Jonathan", balance, 0.0);
        //Act
        double interest = ba.getInterestDue();
        assertEquals(expectedInterest, interest);
        //Assert
    }

    @ParameterizedTest
    @CsvSource({
            "-0.99",
            "0.00"
    })
    @DisplayName("Test for deposit being 0 or < 0")
    void deposit_negativeAmount_or_0_throwsException(double amount) {
        //ba = new BankAccount("Jonathan", 0.0, 0.0);
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () -> ba.deposit(amount));
        assertEquals("Deposit amount must be greater than zero.", err.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "-0.99",
            "0.00"
    })
    @DisplayName("Test withdrawl() error message to be thrown when 0 or < 0 is requested")
    void testWithdraw_negativeAmount_or_0_throwsException(double amount) {
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () -> ba.withdraw(amount));
        assertEquals("Withdrawal amount must be greater than zero.", err.getMessage());
    }

    @Test
    @DisplayName("Test withdrawl() error message to be thrown when exceeding withdrawl limit.")
    void testWithdraw_ExceedWithdrawLimit_throwsException() {
        //limit $10.00
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () -> ba.withdraw(11.00));
        assertEquals("Exceeded withdrawal limit.", err.getMessage());

    }
    @Test
    @DisplayName("test withdrawl() error message to be thrown if request > balance")
    void testWithdraw_InsufficientFunds_throwsException() {
        //initial balance $5
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () -> ba.withdraw(6));
        assertEquals("Insufficient funds.", err.getMessage());
    }
}