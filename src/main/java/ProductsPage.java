import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

By phoneSheetLocator =new By.ByCssSelector(".treeCategoryContent-MyO6mtk47l73JXmpol8O");
By productPhoneList =  By.xpath("(//h3[@type='comfort'])");

By tshirtSheetLocator =new By.ByCssSelector("//div[@class='treeCategoryContent-XPVj5InCxOWIJtyTC35Z treeCategoryContent-MyO6mtk47l73JXmpol8O']");
By productTshirtList = By.xpath("//h3[@type='cozy']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPhoneProductPage(){
        return isDisplayed(phoneSheetLocator);
    }

    private List<WebElement> getAllPhoneProduct(){
        return findAll(productPhoneList);
    }
    public void selectProduct(int i) {

        if (i >= 0) {
            List<WebElement> productPhoneList = getAllPhoneProduct();

            if (i < productPhoneList.size()) {
                productPhoneList.get(i).click();
            } else {
                System.out.println("Belirtilen indeksle bir ürün bulunamadı.");
            }
        } else {
            System.out.println("Geçersiz bir indeks kullanıldı.");
        }
    }

    public boolean isOnTshirtProductPage(){
        return isDisplayed(tshirtSheetLocator);
    }
    private  List<WebElement> getAllTshirtProduct(){
     return findAll(productTshirtList);
    }
    public void selectTshirtProduct(int i){
        if (i >= 0) {
            List<WebElement> productPhoneList = getAllTshirtProduct();

            if (i < productPhoneList.size()) {
                productPhoneList.get(i).click();
            } else {
                System.out.println("Belirtilen indeksle bir ürün bulunamadı.");
            }
        } else {
            System.out.println("Geçersiz bir indeks kullanıldı.");
        }
    }

}
