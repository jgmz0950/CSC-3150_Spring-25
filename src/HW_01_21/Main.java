package HW_01_21;

import ManualExceptions.InvalidPackageException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calculator = new ShippingCalculator();

        //handle exceptions in main

        // Loop for adding packages
        while (true) {
            System.out.println("Enter weight of Package: ");
            double weight = sc.nextDouble();

            System.out.println("Enter distance: ");
            double distance = sc.nextDouble();

            try{
                // create new package and add to calculator
                Package p = new Package(weight, distance);
                calculator.addPackage(p);

                // Show package details
                System.out.println("Package added: " + p);

                //display total weight and distance
                System.out.println("Total weight: " + calculator.getTotalWeight());
                System.out.println("Total distance: " + calculator.getTotalDistance());
            }
            catch (IllegalArgumentException e){
                //System.out.println("Error: " + e.getMessage());
                System.err.println("Error: " + e.getMessage());
                System.out.println("Please try again.");

                continue;
            }

            // Ask if the user wants to add another package
            System.out.println("Would you like to add another package? Y / N");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("N")) {
                break; // Exit if user doesn't want to add another
            }

        }

        // After loop ends, calculate total cost
        System.out.println("\nTotal number of packages: " + calculator.getPackageCount());
        System.out.println("Total shipping cost: $" + calculator.calculateShippingCost());
    }
}
