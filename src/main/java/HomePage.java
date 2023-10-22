import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{


    SearchBox searchBox;
    CartPage cartPage;
    AccountPage accountPage;

    By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    By cartCountLocator = By.id("cartItemCount");
    By cartContainerLocator = By.id("shoppingCart");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
        cartPage = new CartPage(driver);
        accountPage= new AccountPage(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }
    public CartPage cartPage() {
        return this.cartPage;
    }
    public AccountPage accountPage() {
        return this.accountPage;
    }



    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }

    public  boolean addProductToCart() {
        String cartCountBefore = driver.findElement(cartCountLocator).getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(cartCountLocator, cartCountBefore)));

        String cartCountAfter = driver.findElement(cartCountLocator).getText();

        int oldCount = Integer.parseInt(cartCountBefore);
        int newCount = Integer.parseInt(cartCountAfter);

        return newCount > oldCount;
    }

    public void goToCard() {
        click(cartContainerLocator);
    }

}
