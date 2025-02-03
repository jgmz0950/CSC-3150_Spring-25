package Class_01_23;

public class Calculator {
    private int x;
    private int y;
    private int result = 0;
    Calculator(int x, int y) {
        this.x = x;
        this.y = y;
        result = 0;
    }
    Calculator( String strX, String strY ) throws InvalidNumberFormatException {
        setAndConvertX( strX );
        setAndConvertY( strY );
    }
    public void setAndConvertX( String strX ) throws InvalidNumberFormatException {
        try {
            this.x = Integer.parseInt(strX);
        } catch ( NumberFormatException e ) {
            throw new InvalidNumberFormatException ("Invalid number format on input.");
        }
    }
    public int getResult() {
        return result;
    }
    public void setAndConvertY( String strY ) throws InvalidNumberFormatException {
        try {
            this.y = Integer.parseInt(strY);
        } catch ( NumberFormatException e ) {
            throw new InvalidNumberFormatException ("Invalid number format on input.");
        }
    }
    //    public int addNumbers(String a, String b) throws Drive_CalculatorCorrected.InvalidNumberFormatException {
//        try {
//            int numA = Integer.parseInt(a);
//            int numB = Integer.parseInt(b);
//            return numA + numB;
//        } catch (NumberFormatException e) {
//            throw new Drive_CalculatorCorrected.InvalidNumberFormatException("Invalid number format for addition.");
//        }
//    }
    public int getX() {
        return x;
    }
    public void addNumbers() {
        result = x + y;
    }
    public void subtractNumbers() {
        result = x - y;
    }
    public void multiplyNumbers() {
        result = x * y;
    }
    public  void divideNumbers() throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        result = x/y;
    }
}