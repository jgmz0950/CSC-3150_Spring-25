package HW_02_14;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiscountCalculatorTest {
    public static LoyaltyService loyaltyService;
    public static DiscountCalculator dc;

    @BeforeAll
    static void setUp(){
        loyaltyService = mock(LoyaltyService.class);
        dc = new DiscountCalculator(loyaltyService);
    }

//    @ParameterizedTest
//    @CsvSource({ //BVA
//            "0, 0.0", //customerId, expected discount
//            "2, 5.0",
//            "3, 5.0",
//            "4, 10.0",
//            "5, 10.0",
//            "6, 15.0" //
//
//    })
//    public void testDiscountForSeveralLoyaltyYears(int id, double expectedDiscount) {
//        //calc disc
//        double currentDiscount = dc.calculateDiscount(id);
//        assertEquals(expectedDiscount, currentDiscount);
//    }
    @Test
    public void testDiscountBoundaryValues(){
        when(loyaltyService.getLoyaltyYears(0)).thenReturn(0);
        double discount = dc.calculateDiscount(0);
        assertEquals(0, discount, 0);
    }


}