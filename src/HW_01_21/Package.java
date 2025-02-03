package HW_01_21;

import HW_01_21.Validation.Utility;

public class Package {
    //set packages
    private double weight;
    private double distance;

    public Package(double weight, double distance) {
        //validate using utility class ensuring valid objects
        Utility.validatePackage(weight, distance);
        this.weight = weight;
        this.distance = distance;
    }
    public double getWeight() {
        return weight;
    }
    public double getDistance() {
        return distance;
    }
    @Override
    public String toString() {
        return "Package [weight=" + weight + ", distance=" + distance + "]";
    }

}


