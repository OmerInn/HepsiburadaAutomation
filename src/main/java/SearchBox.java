import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    By searchLocation =By.xpath("(//input[@placeholder='Ürün, kategori veya marka ara'])[1]");

    By searchRatherClick =By.cssSelector(".searchBoxOld-M1esqHPyWSuRUjMCALPK");

    By hepsiBuradaLogo = By.cssSelector("[width='191']");


}
