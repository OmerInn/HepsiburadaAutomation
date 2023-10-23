import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class Test_Add_Product_To_Card extends BaseTest{

    HomePage homePage;
    ProductsPage productsPage;
    ProductsDetailPage productsDetailPage;


    @Test
    @Order(1)
    public void searchForPhoneProduct(){
        driver.get("https://www.hepsiburada.com/");
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.click(homePage.searchBox().searchRatherClick);
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation);
        productsPage = new ProductsPage(driver);
        homePage.sendKeysAndWaitForElementToBeVisible(homePage.searchBox().searchLocation,"Cep Telefonu");
        homePage.sendKeysAndWaitForElementToBeVisible(homePage.searchBox().searchLocation,Keys.ENTER);
        Assertions.assertTrue(productsPage.isOnPhoneProductPage() ,
                "Not on products page!");
    }
    @Test
    @Order(2)
    public void selectPhoneProduct(){
        productsDetailPage = new ProductsDetailPage(driver);
        productsPage.selectProduct(2);
        Assertions.assertTrue(productsDetailPage.isOnProductPhoneDetailPage(),"Not on product detail page!");
    }
    @Test
    @Order(3)
    public void addPhoneToBasket(){
        productsDetailPage.addToCard();
        Assertions.assertTrue(homePage.addProductToCart(),
                "Product could not be added to basket");
        productsDetailPage.closeToProduct();
    }
    @Test
    @Order(4)
    public void goToCard(){
        homePage.goToCard();
        Assertions.assertTrue(homePage.cartPage().isProductAdded() ,
                "Product was not added to cart!");
    }
    @Test
    @Order(5)
    public void searchForTshirtProduct(){
        homePage.click(homePage.searchBox().hepsiBuradaLogo);
        homePage.clickAndWaitForElementToBeVisible(homePage.searchBox().searchRatherClick);
        homePage.click(homePage.searchBox().searchRatherClick);
        homePage.sendKeysAndWaitForElementToBeVisible(homePage.searchBox().searchLocation,"Tshirt");
        homePage.sendKeysAndWaitForElementToBeVisible(homePage.searchBox().searchLocation,Keys.ENTER);
    }
    @Test
    @Order(6)
    public void selectTshirtProduct(){
        productsPage.selectTshirtProduct(2);
        Assertions.assertTrue(productsDetailPage.isOnProductTshirtDetailPage(),"Not on product detail page!");
        productsDetailPage.addToCard();
        productsDetailPage.closeToProduct();
        homePage.goToCard();
    }
    @Test
    @Order(7)
    public void goToMyAccount(){
        homePage.accountPage().goToMyAccount();
        homePage.accountPage().loginInfo();
        Assertions.assertTrue(homePage.accountPage().isOnAccountPageDisplay(),"Not on account page!");
    }

}
