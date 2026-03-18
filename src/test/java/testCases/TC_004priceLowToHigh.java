package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PriceLowToHigh;
import testBase.BaseTest;

public class TC_004priceLowToHigh extends BaseTest{
	
	@Test
    public void verifyPriceFromProductPage() throws InterruptedException {

        // Step 1: Search product
        HomePage hp = new HomePage(driver);
        hp.searchForProductsSet("Tshirt men");

        
        
        // Step 2: Call your method
        PriceLowToHigh ip = new PriceLowToHigh(driver);
        ip.clickSortBy();
        ip.priceLowToHigh();
        Thread.sleep(2000);
       ip.getPriceFromProductPage();
    }

}
