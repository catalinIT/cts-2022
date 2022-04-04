package ro.ase.acs.cts.g1098.clean.stage6.main;

import ro.ase.acs.cts.g1098.clean.stage6.interfaces.MarketingStrategyInterface;
import ro.ase.acs.cts.g1098.clean.stage6.marketing.AccountMarketingStrategy;
import ro.ase.acs.cts.g1098.clean.stage6.marketing.SummerMarketingStrategy;
import ro.ase.acs.cts.g1098.clean.stage6.models.Product;
import ro.ase.acs.cts.g1098.clean.stage6.models.ProductType;

public class Main {
    public static void main(String[] args) {

        Product product = new Product();
        SummerMarketingStrategy marketingStrategy = new SummerMarketingStrategy();

        product.setAccountDiscountStrategy(marketingStrategy);
        float finalPrice = product.computeFinalPrice(ProductType.NEW, 1000, 10);
        System.out.println("FInal price is " + finalPrice);

    }
}
