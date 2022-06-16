package in.ehdi.service;

import in.ehdi.model.ConversionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculationServiceTest {

    private static final Double EUR_BASE_PRICE = 1_000.0;
    private CalculationService service;

    @BeforeEach
    void init(){
        service = new CalculationService();
    }

    @Test
    @DisplayName("Convert Euro price to Canadian price then to United States price")
    void shouldConvertCadToUsd() {
        var actualPrice = service.hotelPriceToUser(EUR_BASE_PRICE, ConversionEnum.EUR2CAD2USD);
        var expectedPrice = 570.75;
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("Convert Euro price to British Pound then to United States price")
    void shouldConvertEuroToUsd() {
        var actualPrice = service.hotelPriceToUser(EUR_BASE_PRICE, ConversionEnum.EUR2USD);
        var expectedPrice = 950.75;
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("Convert Euro price to United Arab Emirates dirham price then to United States price")
    void shouldConvertAedToEuro() {
        var actualPrice = service.hotelPriceToUser(EUR_BASE_PRICE, ConversionEnum.EUR2AED2USD);
        var expectedPrice = 494.75;
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("Return base price without conversion")
    void shouldReturnBasePricePlusFee() {
        var actualPrice = service.hotelPriceToUser(EUR_BASE_PRICE, ConversionEnum.NOTFOUND);
        var expectedPrice = 1_000.75;
        assertEquals(expectedPrice, actualPrice);
    }

}
