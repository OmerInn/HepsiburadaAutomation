import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{

    private final By productNameLocator=  By.className("item_list_1NnvG");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductAdded(Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        List<WebElement> productsInCart = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productNameLocator));
        return !productsInCart.isEmpty();
    }



}
