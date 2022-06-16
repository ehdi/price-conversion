package in.ehdi.service;

import in.ehdi.model.ConversionEnum;
import in.ehdi.model.CurrencyEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConversionService {

    /**
     * @param conversion : flow of conversion based on ConversionEnum
     * @return
     */
    public List<Double> conversionRateList(ConversionEnum conversion){
       try {
           List<Double> priceList = new ArrayList<>();
           for (Map.Entry<Integer, CurrencyEnum> x : conversionOrderMapCollection().get(conversion).entrySet()) {
               priceList.add(currencyRateMap().get(x.getValue()));
           }
           return priceList;
       } catch (NullPointerException e){
           return Collections.emptyList();
       }
    }

    /**
     * @return list of existence currency and exchange rate
     */
    private Map<CurrencyEnum, Double> currencyRateMap() {
        Map<CurrencyEnum, Double> currencyList  = new EnumMap<>(CurrencyEnum.class);
        currencyList.put(CurrencyEnum.GBP, 0.5);
        currencyList.put(CurrencyEnum.USD, 1.9);
        currencyList.put(CurrencyEnum.CAD, 0.3);
        currencyList.put(CurrencyEnum.ADE, 0.26);
        return currencyList;
    }

    /**
     * Ordered conversion list by using TreeMap
     * @return ordered conversion map
     */
    private Map<ConversionEnum, TreeMap<Integer, CurrencyEnum>> conversionOrderMapCollection() {

        Map<ConversionEnum, TreeMap<Integer, CurrencyEnum>> conversionMap = new EnumMap<>(ConversionEnum.class);

        TreeMap<Integer, CurrencyEnum> conversionFromEurToUSD = new TreeMap<>();
        conversionFromEurToUSD.put(1, CurrencyEnum.GBP);
        conversionFromEurToUSD.put(2, CurrencyEnum.USD);

        conversionMap.put(ConversionEnum.EUR2USD, conversionFromEurToUSD);

        TreeMap<Integer, CurrencyEnum> conversionFromCadToUSD = new TreeMap<>();
        conversionFromCadToUSD.put(1, CurrencyEnum.CAD);
        conversionFromCadToUSD.put(2, CurrencyEnum.USD);

        conversionMap.put(ConversionEnum.EUR2CAD2USD, conversionFromCadToUSD);

        TreeMap<Integer, CurrencyEnum> conversionFromAedToEur = new TreeMap<>();
        conversionFromAedToEur.put(1, CurrencyEnum.ADE);
        conversionFromAedToEur.put(2, CurrencyEnum.USD);

        conversionMap.put(ConversionEnum.EUR2AED2USD, conversionFromAedToEur);

        return conversionMap;
    }

}
