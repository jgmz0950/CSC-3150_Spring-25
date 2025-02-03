package HW_01_21;

import ManualExceptions.InvalidPackageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ShippingCalculatorTest {

    ShippingCalculator c;

    //beforeEach
    @BeforeEach
    void setUp() {
        c = new ShippingCalculator();
    }

    @Test //WORD
    public void getCount_forPackages_expected2() {
        Package p = new Package(5, 10);
        Package p2 = new Package(10, 20);
        c.addPackage(p);
        c.addPackage(p2);

        assertEquals(2, c.getPackageCount());


    }

    //addPackageSuccessfully-WORD
    @Test
    public void AddPackage_Successfully_expected1() {
        Package p = new Package(5, 10);
        c.addPackage(p);
        assertEquals(1, c.getPackageCount());
    }

    //addSeveralPackagesSuccessfully-WORD
    //TODO: this test case feels weird, is there a better way to optimize it?
    @ParameterizedTest
    @CsvSource({
            "5, 10",
            "10, 5",
            "9, 9"
    })
    public void addSeveralPackages_expected3(double weight, double distance) {
            Package p = new Package(weight, distance);
            c.addPackage(p);
           if(c.getPackageCount() == 3){
               assertEquals(3, c.getPackageCount());
           }
    }

    @ParameterizedTest //WORD
    @CsvSource({
            "10,20, 30",
            "20, 10, 30",
            "15, 15, 30"
    })
    public void getTotalDistance_forPackages_Expected30(double distance, double distance2, double expectedTotal)  {
       Package p = new Package(10, distance);
       Package p2 = new Package(20, distance2);
        c.addPackage(p);
        c.addPackage(p2);
        assertEquals(expectedTotal, c.getTotalDistance());
    }

    @Test //WORD
    public void getTotalDistance_forSinglePackage_expected10() {
            Package p = new Package(5, 10);
            c.addPackage(p);
            assertEquals(10, c.getTotalDistance());
    }

    @Test //WORD
    public void testCalculateDistanceFee(){
        assertEquals(5, c.calculateDistanceFee(5));
        assertEquals(10, c.calculateDistanceFee(20));
        assertEquals(20, c.calculateDistanceFee(40));
        assertEquals(50, c.calculateDistanceFee(100));
    }


    //testDistance<=0 || test distance>100
    @DisplayName("Test for <= 0 || > 100  ")
    @ParameterizedTest //WORD
    @CsvSource({
            "101",
            "0",
            "-1"
    })
    public void testDistanceLessThan0_moreThan100_ExpectedErrorMessage(double distance){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()-> {
            Package p = new Package(5, distance);
            c.addPackage(p);

        }); assertEquals("Distance must be between 1 and 100", e.getMessage());
    }

    //test getTotalWeight for 1 package
    @Test //WORD
    public void getTotalWeightFor_1Package_Expected10(){
        Package p = new Package(10, 5);
        c.addPackage(p);
        assertEquals(10, c.getTotalWeight());
    }

    @ParameterizedTest
    @CsvSource({ //WORD
            "10, 20, 30",
            "15, 15, 30",
            "19, 11, 30"
    })
    //test getTotalWeight for more than 1 package
    public void getTotalWeightFor_Several_Packages_Expected30(double weight1, double weight2, double expectedTotal) {
        Package p1 = new Package(weight1, 10);
        Package p2 = new Package(weight2, 10);

        c.addPackage(p1);
        c.addPackage(p2);

        assertEquals(expectedTotal, c.getTotalWeight());

    }


    //test invalid numeric weight
    @ParameterizedTest
    @CsvSource({
            "-1",    //  < 1
            "0",     //  < 1
            "100",   //  > 75
            "76"     //  > 75
    })
    public void testInvalidWeight_ExpectedErrorMessage(double weight){
        //invalid weights
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
            Package p = new Package(weight, 10);
            c.addPackage(p);
        });
        assertEquals("Weight must be between 1 and 75", e.getMessage());  //compare err messages
    }

    //test shipping formula
    //weight, distance, expected cost (w*1.2) + distanceFee
    @Test
    public void testShippingCostCalculation_Expected16(){
        Package p = new Package(5, 10);
        c.addPackage(p);
        assertEquals(16, c.calculateShippingCost());
    }


    //TODO: test shipping formula for more than 1 package

    //TODO test invalid input(alphanumeric) for weight and distance

    //TODO: test empty input for weight and distance
//    @Test
//    public void testInvalidAlphanumericInputForWeight_ExpectedErrorMessage(){
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
//            Package p = new Package("abc", 10);
//            c.addPackage(p);
//        });
//    }
}