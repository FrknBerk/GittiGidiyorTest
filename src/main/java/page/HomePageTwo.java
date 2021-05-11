package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTwo extends BasePage{
    public HomePageTwo(WebDriver driver) {
        super(driver);
    }

    By pageClick = By.xpath("//a[contains(text(),'2')]");

    public void pageTwoClick(){
        click(pageClick);
    }
}
