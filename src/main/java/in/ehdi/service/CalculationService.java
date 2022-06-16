package in.ehdi.service;

import in.ehdi.model.ConversionEnum;

public class CalculationService {

    private static final Double PRICE_FEE = 0.75;

    public Double hotelPriceToUser(Double eurPrice, ConversionEnum conversionEnum) {
        var baseFare = eurPrice; // it is redundant variable, just for readability
        var conversionService = new ConversionService();
        for (Double conversionRate : conversionService.conversionRateList(conversionEnum)) {
            baseFare = conversionRate * baseFare;
        }
        var finalPrice =  baseFare + PRICE_FEE; // it is redundant variable, just for readability
        return finalPrice;
    }

}
