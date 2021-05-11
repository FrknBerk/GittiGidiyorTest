package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScroll extends BasePage{
    public HomePageScroll(WebDriver driver) {
        super(driver);
    }

    By scroll = By.xpath("//a[@class='current' and contains(text(),'1')]");

    public void pageScrollDown(){
        jsScrollIntoView(scroll);
    }
}
