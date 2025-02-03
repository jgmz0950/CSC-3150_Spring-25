package HW_01_21;

import ManualExceptions.InvalidPackageException;

import java.util.ArrayList;

public class ShippingCalculator {

    private double totalDistance = 0;
    private double totalWeight = 0;
    private ArrayList<Package> packages;
    private double weightFee = 1.2;

    //constructor
    public ShippingCalculator() {
        packages = new ArrayList<>();
    }

    //addPackage-tests done
    public void addPackage(Package p)  { //manual exception
            packages.add(p);
            totalWeight += p.getWeight();//add to total weight
            totalDistance += p.getDistance();//add to total distance
    }

    //distanceFee calculation-tests done
    public double calculateDistanceFee(double distance) {
        if (distance < 10) {
            return 5;
        } else if (distance < 25) {
            return 10;
        } else if (distance < 50) {
            return 20;
        } else if (distance <= 100) {
            return 50;
        } else {
            //throw error
            return 0;
        }
    }

    //calculate shipping cost-TODO
    public double calculateShippingCost(){
        double shippingCost = 0;
        //iterate through each object
        for(Package p : packages){
            //calculate fee for distance and weight
            double distanceFee = calculateDistanceFee(p.getDistance());
            //pemdas
            shippingCost += (p.getWeight() * weightFee) + distanceFee;

            }
            return shippingCost;
        }

    //getPackageCount- tests done
    public int getPackageCount(){
        //count arrayList size
        return packages.size();
    }

    public double getTotalDistance(){ //tests done
        return totalDistance;
    }

    public double getTotalWeight(){// tests done
        return totalWeight;
    }


}
