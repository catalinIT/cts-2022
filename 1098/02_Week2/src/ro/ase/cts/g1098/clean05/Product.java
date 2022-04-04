package ro.ase.cts.g1098.clean05;


public class Product {

    AccountMarketingStrategy accountMarketingStrategy = null;



    public float computeFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears)
    {
        float finalPrice = 0;
        float accountDiscount = 0;



        if(productType != ProductType.NEW) {
            accountDiscount = accountMarketingStrategy.getAccountDiscount(accountAgeInYears);
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
