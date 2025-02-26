package ro.ase.acs.cts.g1098.clean.stage5;


//stage 5
// SOLID - Single Responsibility
// outsource the implementation of the account discount computation

public class Product {
	
	AccountMarketingStrategy accountDiscountStrategy = null;

	public float getPriceDiscount(float initialPrice, ProductType productType) {
		return initialPrice * productType.getDiscount();
	}

	public float getPriceWithDiscount(float initialPrice, ProductType productType) {
		return initialPrice - this.getPriceDiscount(initialPrice, productType);
	}
	
	public float computeFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears)
	  {	
	    float finalPrice = 0;
	    float accountDiscount = 0;
	    
	    if(productType != ProductType.NEW) {
	    	accountDiscount = accountDiscountStrategy.getAccountDiscount(accountAgeInYears);
	    }
	   
	    finalPrice = (this.getPriceDiscount(initialPrice, productType)) * (1 - accountDiscount);
	    
	    return finalPrice;
	  }
}