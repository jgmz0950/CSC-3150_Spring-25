package OtherCalculator;

public class Calculator {
    private int x;
    private int y;
    private int result = 0;

    //contructor
    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //overloaded constructor (option if top constructor is not covered)
    public Calculator( String strX, String strY ) {
        setAndConvertX(strX);
        setAndConvertY(strY);

    }

    public void setAndConvertY(String strY) throws NumberFormatException {
        try {
            this.y = Integer.parseInt(strY);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Y is not a number");
        }
    }

    public void setAndConvertX(String strX) throws NumberFormatException {
        try{
            this.x = Integer.parseInt(strX);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("X is not a number");
        }
    }

    public void addNumber() {
        this.result = this.y + this.x;
    }

    public void subtractNumber() {
        this.result = this.y - this.x;
    }

    public void multiplyNumber() {
        this.result = this.y * this.x;
    }

    public void divideNumber() {
        if(this.y == 0){
            throw new ArithmeticException("Division by zero");
        } else {
            this.result = this.x / this.y;
        }
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getResult(){
        return this.result;
    }

}

