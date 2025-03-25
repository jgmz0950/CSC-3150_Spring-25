package HW_02_14;

public class LoyaltyServiceImpl implements LoyaltyService {

    @Override
    public int getLoyaltyYears(int customerId) {
        return customerId % 10;
    }
}
