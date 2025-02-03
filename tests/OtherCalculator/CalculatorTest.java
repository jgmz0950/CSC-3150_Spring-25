package OtherCalculator;
import HW01_14.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    @org.junit.jupiter.api.Test
    void setX() {
    }

    @org.junit.jupiter.api.Test
    void setY() {
    }

    @Test
    void calculatorAdd_10_and_5_expect15(){
        Calculator c = new Calculator(10,2);
        int expected = 12;
        c.addNumber();
        //expected and result
        assertEquals(expected, c.getResult());
    }

    @Test
    void calculatorSubstract_7from2_expect3_(){
        Calculator c = new Calculator(20,6);
        int expected = 14;
        c.addNumber();
        //expected and result
        assertEquals(expected, c.getResult());
    }

    @Test
    void calculatorMultiply_10_and_5_expect50(){
        //Arrange
        Calculator c = new Calculator(10,5);
        int expected = 50;
        //Act
        c.multiplyNumber();
        //Expected
        assertEquals(50, c.getResult());

    }
    @Test
    void calculatorDivide_10_and_5_expect_2(){
        Calculator c = new Calculator(10,5);
        int expected = 2;
        c.divideNumber();
        assertEquals(expected, c.getResult());
    }
    @Test
    void calculatorDivide_10_and_8_expectException(){
        Calculator c = new Calculator(10,8);
        //lambda expression, a call back, when this happens, run this code.
        assertThrows(ArithmeticException.class, () -> c.divideNumber());

        assertEquals(8, c.getResult());
    }
}