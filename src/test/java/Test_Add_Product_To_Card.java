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
    public void search_a_Product(){
        driver.get("https://www.hepsiburada.com/");
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.click(homePage.searchBox().searchRatherClick);
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation,Duration.ofSeconds(5));
        productsPage = new ProductsPage(driver);
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation,Duration.ofSeconds(5)).sendKeys("Cep telefonu");
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation, Duration.ofSeconds(5)).sendKeys(Keys.ENTER);
        Assertions.assertTrue(productsPage.isOnPhoneProductPage() ,
                "Not on products page!");
    }
    @Test
    @Order(2)
    public void select_phone_a_product(){
        productsDetailPage = new ProductsDetailPage(driver);
        productsPage.selectProduct(2);
        Assertions.assertTrue(productsDetailPage.isOnProductPhoneDetailPage(),"Not on product detail page!");
    }
    @Test
    @Order(3)
    public void add_phone_product_to_cart(){
        productsDetailPage.addToCard();
        Assertions.assertTrue(homePage.addProductToCart(),
                "Product could not be added to basket");
        productsDetailPage.closeToProduct();
    }
    @Test
    @Order(4)
    public void go_to_cart(){
        homePage.goToCard();
        Assertions.assertTrue(homePage.cartPage().isProductAdded(Duration.ofSeconds(10)) ,
                "Product was not added to cart!");
    }
    @Test
    @Order(5)
    public void go_to_tshirt(){
        homePage.click(homePage.searchBox().hepsiBuradaLogo);
        homePage.waitForElementToBeVisible(homePage.searchBox().searchRatherClick,Duration.ofSeconds(5)).click();
        homePage.click(homePage.searchBox().searchRatherClick);
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation,Duration.ofSeconds(5));
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation,Duration.ofSeconds(5)).sendKeys("Tshirt");
        homePage.waitForElementToBeVisible(homePage.searchBox().searchLocation, Duration.ofSeconds(5)).sendKeys(Keys.ENTER);
    }
    @Test
    @Order(6)
    public void select_tshirt_a_product(){
        productsPage.selectTshirtProduct(2);
        Assertions.assertTrue(productsDetailPage.isOnProductTshirtDetailPage(),"Not on product detail page!");
        productsDetailPage.addToCard();
        productsDetailPage.closeToProduct();
        homePage.goToCard();
    }
    @Test
    @Order(7)
    public void go_to_myAccount(){
        homePage.accountPage().goToMyAccount();
        homePage.accountPage().loginInfo();
        Assertions.assertTrue(homePage.accountPage().isOnAccountPageDisplay(),"Not on account page!");
    }

}
