package model;

import java.util.HashMap;
import java.util.Map;

public class CurrencyModel {
    private Map<String, Currency> currencies = new HashMap<>();

    public CurrencyModel() {
        // Hardcoded currencies for demonstration
        currencies.put("USD", new Currency("USD", "US Dollar", 1.0));
        currencies.put("EUR", new Currency("EUR", "Euro", 0.92));
        currencies.put("JPY", new Currency("JPY", "Japanese Yen", 144.55));
        currencies.put("GBP", new Currency("GBP", "British Pound", 0.79));
        currencies.put("NPR", new Currency("NPR", "Nepalese Rupee", 132.00));
        currencies.put("INR", new Currency("INR", "Indian Rupee", 83.10));
        currencies.put("AUD", new Currency("AUD", "Australian Dollar", 1.56));
        currencies.put("AED", new Currency("AED", "UAE Dirham", 3.67));
        currencies.put("CAD", new Currency("CAD", "Canadian Dollar", 1.35));

    }
    public Map<String, Currency> getCurrencies() {
        return currencies;
    }
    public double convert(String from, String to, double amount) {
        Currency source = currencies.get(from);
        Currency target = currencies.get(to);
        if (source == null || target == null) {
            throw new IllegalArgumentException("Invalid currency code selected.");
        }
        // Covert to USD first and then to target currency
        double amountInUSD = amount / source.getRateToUSD();
        return amountInUSD * target.getRateToUSD();
    }
}