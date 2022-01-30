import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Stack;

public class HomePage extends BasePage{

    SearchBar searchBar;
    By basketCountLoc = By.xpath("//span[@class='gekhq4-7 jYBgHc']");  //Sepete Ekle Count Kontrol
    By goBasketLoc = By.xpath("//a[@class='gg-ui-btn-default padding-none']"); //Sepete Git
    By basketHoverLoc = By.xpath("//a[@class='header-cart-hidden-link']");
    By foundProductLoc = By.xpath("//div[@class='m96g9g-1 gKNIBK']"); // Bilgisayar Kelimesi için Sonuçlar Bulundu
    By acceptCookiesLoc = By.xpath("//a[@class='tyj39b-5 lfsBU']");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBar = new SearchBar(driver);
    }

    public SearchBar searchBar() {
        return this.searchBar;
    }

    public boolean isOnProductPage(){
        return isVisible(foundProductLoc);
    }


    public void goToCart() throws InterruptedException {
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(basketHoverLoc)).perform();
        click(goBasketLoc);
    }

    private int getBasketCount () throws InterruptedException {
        Thread.sleep(2000);
        String countB = find(basketCountLoc).getText();
        System.out.println("Basket total is " + countB);
        return Integer.parseInt(countB);
    }

    public void acceptCookies(){
        if (isVisible(acceptCookiesLoc)){
            click(acceptCookiesLoc);
        }
    }
}
