package ro.ase.acs.cts.g1098.clean.stage6.marketing;

import ro.ase.acs.cts.g1098.clean.stage6.interfaces.MarketingStrategyInterface;

public class SummerMarketingStrategy implements MarketingStrategyInterface {
    @Override
    public float getAccountDiscount(int accountAgeInYears) {
        return 0;
    }
}
