package HW01_16;

public class CalculatorV2 {
    //POJO- plain old Java object
    private int x;
    private int y;

    private String operation;

    //constructor
    public CalculatorV2(int x, int y, String operation) {
        this.x = x;
        this.y = y;
    }

    public String getOperation() {
        return operation;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
