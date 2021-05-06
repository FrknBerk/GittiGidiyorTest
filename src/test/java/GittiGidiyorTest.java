import log.Log4j;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import page.HomePage;
import page.LoginPage;

public class GittiGidiyorTest {
    WebDriver driver;



    @Test
    void GittiGidiyor() throws InterruptedException {
        boolean pageLoad = driver.findElement(By.xpath("//a[contains(@href, 'gittigidiyor')]")).isEnabled();
        Assert.assertEquals(pageLoad,true);
        if (pageLoad == true){
            Log4j.info("Sayfa Yüklendi");
            System.out.println("Sayfa Yüklendi");
        }
        else{
            System.out.println("Sayfa yüklenmedi");
        }
        String search = "Bilgisayar";

        HomePage page = new HomePage(driver);
        page.pageLoad();

        Thread.sleep(1000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginButton();
        page.Search(search);
        Thread.sleep(2000);
        page.imageClick();
        page.confidentialityAgreementClick();
        page.pageScrollDown();
        page.pageTwoClick();
        page.checkPageNumber();
        page.addCart();
        page.checkCartPrice();
        Thread.sleep(2000);
        page.addCart();
        page.cartProductPiece();
        page.mouseHoverCart();;
        page.cartProductDelete();
        page.mouseHoverCart();
        page.checkCartEmpty();

    }

}
