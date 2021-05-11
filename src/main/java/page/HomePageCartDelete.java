package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageCartDelete extends  BasePage{
    public HomePageCartDelete(WebDriver driver) {
        super(driver);
    }
    By cartDelete = By.xpath("//a[@class='header-cart-delete-button'  and @href='javascript:;']");
    public void cartProductDelete(){
        jsClick(cartDelete);
    }
}
