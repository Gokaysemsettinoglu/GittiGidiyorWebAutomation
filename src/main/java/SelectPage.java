import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPage extends BasePage{

    By foundPageNumLoc = By.xpath("//li[3][@class='sc-12aj18f-2 jwZJjs']"); // 2.Page e Geçiş Loc

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void selectOnPage() {
        wait = new WebDriverWait(driver, 10);
        WebElement pageNum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[3][@class='sc-12aj18f-2 jwZJjs']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",pageNum);
        click(foundPageNumLoc);

    }

    public boolean isOnSelectPage() {
        return isVisible(foundPageNumLoc);
    }
}
