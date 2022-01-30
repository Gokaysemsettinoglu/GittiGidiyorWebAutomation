import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class ProductsPage extends BasePage {


    By foundNameLoc = new By.ByCssSelector("h2.sc-1ku3a4v-0"); // Name Locatorları
    By foundProdLoc = new By.ByCssSelector("div.sc-533kbx-0");
    By foundProdPriceLoc = By.xpath("//span[@class='sc-1tdlrg-0 yf6n83-0 jPaJyh elANpG sc-1n2i5kn-3 lcRLro']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectOnProduct(int i) throws InterruptedException, IOException {
        Thread.sleep(2000);
        String productInfo = getAllProductsInf().get(i).getText();
        String productPrice = getAllProductsPrice().get(i).getText();
        System.out.println("Product info is: " + productInfo);
        System.out.println("Product price is: " + productPrice);
        productInfo(productInfo,productPrice);
        getAllProducts().get(i).click();
    }

    private List<WebElement> getAllProductsInf() {
        return findAll(foundNameLoc);
    }
    private List<WebElement> getAllProductsPrice() {
        return findAll(foundProdPriceLoc);
    }
    private List<WebElement> getAllProducts() {
        return findAll(foundProdLoc);
    }



}
