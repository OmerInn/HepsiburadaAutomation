import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
        WebDriver driver;
        public BasePage(WebDriver driver){this.driver=driver;}

    public WebElement find(By locator){
       return driver.findElement(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void sendKeys(By locator, CharSequence... keysToSend) {
        find(locator).sendKeys(keysToSend);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void newTab(){driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));}
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public WebElement waitForElementToBeVisible(By locator,Duration timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
