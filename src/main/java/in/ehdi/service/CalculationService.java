package in.ehdi.service;

import in.ehdi.model.ConversionEnum;

public class CalculationService {

    private static final Double PRICE_FEE = 0.75;

    public Double hotelPriceToUser(Double price, ConversionEnum conversionEnum) {
        ConversionService conversionService = new ConversionService();
        for (Double conversionRate : conversionService.conversionRateList(conversionEnum)) {
            price = conversionRate * price;
        }
        return price + PRICE_FEE;
    }

}
