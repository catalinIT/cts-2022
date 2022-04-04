package ro.ase.acs.cts.g1098.clean.stage6.models;


//stage 5
// SOLID - Single Responsibility
// outsource the implementation of the account discount computation
//

import ro.ase.acs.cts.g1098.clean.stage6.exceptions.MissingMarketingStrategyException;
import ro.ase.acs.cts.g1098.clean.stage6.interfaces.MarketingStrategyInterface;
import ro.ase.acs.cts.g1098.clean.stage6.marketing.AccountMarketingStrategy;
import ro.ase.acs.cts.g1098.clean.stage6.marketing.SummerMarketingStrategy;

public class Product {
	
	SummerMarketingStrategy accountDiscountStrategy = null;

	public float getPriceDiscount(float initialPrice, ProductType productType) {
		return initialPrice * productType.getDiscount();
	}

	public void setAccountDiscountStrategy(SummerMarketingStrategy accountDiscountStrategy) {

		this.accountDiscountStrategy = accountDiscountStrategy;
	}

	public float getPriceWithDiscount(float initialPrice, ProductType productType) {
		return initialPrice - this.getPriceDiscount(initialPrice, productType);
	}
	
	public float computeFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears)
	  {	
	    float finalPrice = 0;
	    float accountDiscount = 0;
	    
	    if(productType != ProductType.NEW) {
			if(accountDiscountStrategy == null) {
				throw new MissingMarketingStrategyException();
			}
	    	accountDiscount = accountDiscountStrategy.getAccountDiscount(accountAgeInYears);
	    }
	   
	    finalPrice = (this.getPriceDiscount(initialPrice, productType)) * (1 - accountDiscount);
	    
	    return finalPrice;
	  }
}