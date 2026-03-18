package pageObjects;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

}