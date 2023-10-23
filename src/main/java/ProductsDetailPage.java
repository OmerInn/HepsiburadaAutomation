import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductsDetailPage extends BasePage{

    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    By addToCartButton = By.xpath("//button[@id='addToCart']");


    By addProductPhoneDetailPage = By.xpath("//div[@class='col lg-4 visible']/a[.='Tüm Özellikler']");
    By isOnProductTshirtDetailPage = By.xpath("(//a[@id='productReviews'])[1]");


    By closeProductButtonLocator = By.xpath("//div[@class='checkoutui-Modal-muJqBya3N8yo8EA2G9s5']/h1[1]/a[1]");
    public boolean isOnProductPhoneDetailPage(){
        newTab();
        return isDisplayed(addProductPhoneDetailPage);
    }
    public boolean isOnProductTshirtDetailPage(){
        newTab();
        return isDisplayed(isOnProductTshirtDetailPage);
    }
    public void addToCard() {
        waitForElementToBeVisible(addToCartButton).click();
    }
    public void closeToProduct(){
      waitForElementToBeVisible(closeProductButtonLocator).click();
    }
}