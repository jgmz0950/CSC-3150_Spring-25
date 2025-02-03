package HW_01_21.Validation;

public class Utility {

    //validation class ensures reusable code, centralized validation ensures  objects have valid properties
    public static void validatePackage(double weight, double distance){

        if(distance <= 0 || distance > 100){
            throw new IllegalArgumentException("Distance must be between 1 and 100");
        }

        if(weight <= 0 || weight > 75){
            throw new IllegalArgumentException("Weight must be between 1 and 75");
        }


    }



}
