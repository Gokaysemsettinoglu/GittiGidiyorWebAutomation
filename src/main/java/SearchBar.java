import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBar extends BasePage{

    By searchBarLoc = By.xpath("//input[@type='text']");  //SearchBar Locator
    By searcButtonLoc = By.xpath("//button[@type='submit']"); //Sbutton Locator

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBarLoc,text);
        click(searcButtonLoc);
    }
}
