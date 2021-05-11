package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageImage extends BasePage{
    public HomePageImage(WebDriver driver) {
        super(driver);
    }

    By imageClick = By.xpath("//img[starts-with(@class, 'wis-clsbtn')]");

    public void imageClick(){
        click(imageClick);
    }
}
