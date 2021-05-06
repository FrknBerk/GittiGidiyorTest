package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    String UserName ="Your Name";
    String Password="Your Password";

    By hover =By.xpath("//div[@class='gekhq4-5 grTfZj']");
    By clickBy = By.xpath("//a[@class='qjixn8-0 sc-1bydi5r-0 kNKwwK']");

    public void LoginButton() throws InterruptedException {
        WebElement element = driver.findElement(hover);
        Actions hoverAct = new Actions(driver);
        hoverAct.moveToElement(element).perform();

        Thread.sleep(1000);

        WebElement click = driver.findElement(By.xpath("//a[@class='qjixn8-0 sc-1bydi5r-0 kNKwwK']"));
        Actions clickAct = new Actions(driver);
        clickAct.moveToElement(click).click().build().perform();

        driver.findElement(By.id("L-UserNameField")).sendKeys(UserName);
        driver.findElement(By.id("L-PasswordField")).sendKeys(Password);

        driver.findElement(By.xpath("//input[@id='gg-login-enter']")).click();
        LoginControl();
        Thread.sleep(3000);

    }
    public void LoginControl(){
        boolean loginControl = driver.findElement(By.xpath("//span[contains(text(),'furkanbrkakdas')]")).isEnabled();
        if (loginControl == true){
            Assert.assertEquals(loginControl,true);
            System.out.println("Giriş Başarılı");
        }
        else{
            System.out.println("Giriş Başarısız");
        }
    }
}
