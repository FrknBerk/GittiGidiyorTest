package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageAddCart extends  BasePage{
    public HomePageAddCart(WebDriver driver) {
        super(driver);
    }
    By hoverCart = By.xpath("//div[starts-with(@class, 'cell-border-css')][1]");

    public void addCart(){
        actionsPerform(hoverCart);
    }

    By clickCart = By.xpath("(//button[@class='gg-ui-button gg-ui-btn-primary'])[1]");

    public void cartClick(){
        actionsClick(clickCart);
    }
}
