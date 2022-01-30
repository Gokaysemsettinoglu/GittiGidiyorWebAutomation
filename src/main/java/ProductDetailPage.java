import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class ProductDetailPage extends BasePage {

    By buyButtonLoc = By.xpath("//button[@id='buy-now']");
    By addToBasketLoc = By.xpath("//button[@id='add-to-basket']"); 
    By selectCountLoc = By.xpath("//select[@class='amount']");
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {

        return isVisible(buyButtonLoc);
    }

    public void addCart(){
        click(addToBasketLoc);
    }
    public void addProductBasket(){
        Select selectCount = new Select(driver.findElement(selectCountLoc));
        selectCount.selectByIndex(1);
    }
    private int getBasketCount () throws InterruptedException {
        Thread.sleep(2000);
        String countB = find(selectCountLoc).getText();
        return Integer.parseInt(countB);
    }
    public boolean basketCountControl() throws InterruptedException {
        return getBasketCount() > 1;
    }

}
