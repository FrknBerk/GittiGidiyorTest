package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    String userName = "Your Name";
    String password = "Your Password";

    By hover = By.xpath("//div[@class='gekhq4-5 grTfZj']");
    By clickBy = By.xpath("//a[@class='qjixn8-0 sc-1bydi5r-0 kNKwwK']");
    By usernameWrite = By.id("L-UserNameField");
    By passwordWrite = By.id("L-PasswordField");
    By buttonClick = By.xpath("//input[@id='gg-login-enter']");
    By loginControl = By.xpath("//span[contains(text(),'furkanbrkakdas')]");


    public void LoginButton() throws InterruptedException {
        actionsPerform(hover);
        Thread.sleep(1000);
        actionsClick(clickBy);
        writeText(usernameWrite,userName);
        writeText(passwordWrite,password);
        click(buttonClick);
    }

    public void LoginControl(){
        assertEquals(loginControl);
        if (driver.findElement(loginControl).isEnabled() == true){
            System.out.println("Giriş başarılı");
        }
        else{
            System.out.println("Oturumunuzu kontrol ediniz");
        }
    }

}
