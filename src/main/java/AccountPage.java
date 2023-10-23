import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AccountPage extends BasePage{


    By myAccountBtn = By.xpath("//div[@class='sf-HeaderButton-hHjSLPf7EekM6_UdP7S0 sf-Account-tZRYzA4pgR9Y64aiy7H6 sf-HeaderButton-AmsLhUw8vmU320Fmk_V1']");

    By myAccountLogInBtn = By.xpath("//a[.='Giriş yap']");
    By userLogin = By.id("txtUserName");
    By userPassword = By.xpath("//input[@id='txtPassword']");
    By loginBtn = By.id("btnLogin");
    By displayAccount = By.cssSelector("[fill='#FF6000']");


    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public void goToMyAccount(){
        waitForElementToBeVisible(myAccountBtn).click();
        waitForElementToBeVisible(myAccountLogInBtn).click();
        newTab();
    }
    public void loginInfo(){
        waitForElementToBeVisible(userLogin).sendKeys("asdasdasd123@gmail.com");
        waitForElementToBeVisible(loginBtn).click();
        waitForElementToBeVisible(userPassword).click();
        waitForElementToBeVisible(userPassword).sendKeys("canakkale1717");

    }
    public boolean isOnAccountPageDisplay(){
        return isDisplayed(displayAccount);
    }


}
