package MockDatabase.Models.Database;

import java.util.ArrayList;
import java.util.List;

import MockDatabase.Models.Currency;

/**
 * Created by Zoltan on 1/13/2017.
 */

public class CurrencyData {

    public static List<Currency> currencies;

    public static void setupCurrencies(){
        currencies = new ArrayList<>();
        currencies.add(new Currency(0, "USD", "1.064", "-0.13", false));
        currencies.add(new Currency(1, "GBD", "0.872", "-0.19", false));
        currencies.add(new Currency(2, "RON", "4.4962", "+0.05", true));
    }
}
