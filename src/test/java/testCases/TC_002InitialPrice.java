package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.InitialPrice;
import testBase.BaseTest;

public class TC_002InitialPrice extends BaseTest {

    @Test
    public void verifyPriceFromProductPage() throws InterruptedException {

        // Step 1: Search product
        HomePage hp = new HomePage(driver);
        hp.searchForProductsSet("Tshirt men");

        // Step 2: Call your method
        InitialPrice ip = new InitialPrice(driver);
        ip.getPriceFromProductPage();
    }
}