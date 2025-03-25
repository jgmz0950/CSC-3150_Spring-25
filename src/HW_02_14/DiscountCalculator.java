package HW_02_14;

public class DiscountCalculator {
    private LoyaltyService loyaltyService;

    public DiscountCalculator(LoyaltyService loyaltyService)
    {
        this.loyaltyService = loyaltyService; // remove new keyword and inject dependency
    }

    public double calculateDiscount(int customerId) {
        int years = loyaltyService.getLoyaltyYears(customerId);

        if (years < 1) return 0.0;
        else if (years <= 3) return 5.0;
        else if (years <= 5) return 10.0;
        else return 15.0;
    }
}

