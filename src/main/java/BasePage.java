import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;

public class BasePage{

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {

        find(locator).click();
    }

    public void type(By locator, String text) {  // Locator ile Bulup Text gönderimi yapıyor

        find(locator).sendKeys(text);
    }

    public boolean isVisible(By locator) {
        return find(locator).isDisplayed();
    }

    public void productInfo(String productInfo, String productPrice) throws IOException {
        File file = new File("C:\\Users\\MSI Alpha\\IdeaProjects\\GittiGidiyorWebAutomation\\TxtFile\\ProductInfo.txt");
        FileWriter fw = new FileWriter(file);

        BufferedWriter writer = new BufferedWriter(fw);
        writer.write("Product Info is: " + productInfo);
        writer.newLine();
        writer.write("Product price is: " + productPrice);
        writer.close();
    }

}
