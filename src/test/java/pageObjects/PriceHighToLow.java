package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PriceHighToLow extends BasePage{

	 public PriceHighToLow(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

	    @FindBy(xpath = "//li[contains(@class,'product-base')]")
	    List<WebElement> products;
	    
	    @FindBy(xpath="//div[@class='sort-sortBy']")
	    WebElement sortBy;
	    
	    @FindBy(xpath="//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div/ul/li[5]/label")
	    WebElement priceHighToLow;
	    
	    public void clickSortBy() {
	    	sortBy.click();
	    	
	    }
	    public void priceHighToLow() {
	    	priceHighToLow.click();
	    }

	    public void getPriceFromProductPage() throws InterruptedException {

	        int count = 0;

	        for (int i = 0; i < products.size(); i++) {

	            products = driver.findElements(By.xpath("//li[contains(@class,'product-base')]"));
	            WebElement product = products.get(i);

	            if (product.getText().contains("AD")) {
	                continue;
	            }

	            // Scroll + Click (safer)
	            Actions act = new Actions(driver);
	            act.moveToElement(product).click().perform();

	            Thread.sleep(3000);

	            // Handle new tab (IMPORTANT for Myntra)
	            for (String windowHandle : driver.getWindowHandles()) {
	                driver.switchTo().window(windowHandle);
	            }

	            // Get price
	            String priceText = driver.findElement(
	                    By.xpath("//span[@class='pdp-price']"))
	                    .getText();
	            String cleanPrice = priceText.replaceAll("[^0-9]", "");
	            int price = Integer.parseInt(cleanPrice);

	            System.out.println("Price: " + price);

	            count++;

	            driver.close(); // close product tab

	            // Switch back to main window
	            for (String windowHandle : driver.getWindowHandles()) {
	                driver.switchTo().window(windowHandle);
	            }

	            Thread.sleep(2000);

	            if (count == 5) {
	                break;
	            }
	        }
	    }
}
