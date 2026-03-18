package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.InitialPrice;
import pageObjects.PriceHighToLow;
import testBase.BaseTest;

public class TC_003PriceHighToLow extends BaseTest{
	
	@Test
    public void verifyPriceFromProductPage() throws InterruptedException {

        // Step 1: Search product
        HomePage hp = new HomePage(driver);
        hp.searchForProductsSet("Tshirt men");

        
        
        // Step 2: Call your method
        PriceHighToLow ip = new PriceHighToLow(driver);
        ip.clickSortBy();
        ip.priceHighToLow();
       // Thread.sleep(6000);
       ip.getPriceFromProductPage();
    }

}
