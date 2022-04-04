package ro.ase.acs.cts.g1098.clean;

public class Product {
    static final int MAX_ACCOUNT_AGE = 10;
    static final float MAX_ACCOUNT_DISCOUNT = 0.15f;



    public float computeFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears)
    {
        float finalPrice = 0;
        float accountDiscount = 0;



        if(productType != ProductType.NEW) {
            accountDiscount =
                    (accountAgeInYears > MAX_ACCOUNT_AGE) ? MAX_ACCOUNT_DISCOUNT : (float)accountAgeInYears/100;
        }

        finalPrice = (initialPrice - (ProductType.DISCOUNT.getDiscount() * initialPrice)) -
                accountDiscount * (initialPrice - (ProductType.DISCOUNT.getDiscount() * initialPrice));

        switch(productType) {
            case NEW:
                finalPrice = initialPrice;
                break;
            case DISCOUNT:

                break;
            case SALES:
                finalPrice = (initialPrice - (ProductType.SALES.getDiscount() * initialPrice)) -
                        accountDiscount * (initialPrice - (ProductType.SALES.getDiscount() * initialPrice));
                break;
            case FINAL_SALES:
                finalPrice = (initialPrice - (ProductType.FINAL_SALES.getDiscount() * initialPrice)) -
                        accountDiscount * (initialPrice - (ProductType.FINAL_SALES.getDiscount() * initialPrice));
                break;
            default:
                throw new UnsupportedOperationException();
        }

        return finalPrice;
    }
}
