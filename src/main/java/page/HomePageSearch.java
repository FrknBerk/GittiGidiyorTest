package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageSearch extends BasePage{
    public HomePageSearch(WebDriver driver) {
        super(driver);
    }

    By searchInputClick = By.xpath("//input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']");
    By searchInputKey = By.xpath("//input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']");
    By searcButtonClick = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']");

    public void search(String search) throws InterruptedException {
        click(searchInputClick);
        Thread.sleep(2000);
        writeText(searchInputKey,search);
        Thread.sleep(2000);
        click(searcButtonClick);
        Thread.sleep(2000);
    }
}
