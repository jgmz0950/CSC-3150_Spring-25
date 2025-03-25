package HW_02_14;

public class DriveDiscountCalc {
        public static void main(String[] args) {
            //#1
            LoyaltyService lService = new LoyaltyServiceImpl();
            // Create an instance of DiscountCalculator
            DiscountCalculator calculator = new DiscountCalculator(lService);

            // Test with different customer IDs
            int[] testCustomerIds = {1, 2, 3, 10, 15, 20};

            System.out.println("CustomerID | Loyalty Years | Discount");
            System.out.println("-------------------------------------");
            for (int customerId : testCustomerIds) {
                double discount = calculator.calculateDiscount(customerId);
                System.out.printf("%10d | %13d | %.1f%%\n",
                        customerId,
                       // new LoyaltyService().getLoyaltyYears(customerId), // Retrieve loyalty years for display
                        lService.getLoyaltyYears(customerId),
                        discount);
            }
        }
    }

