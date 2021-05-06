package base;

import log.Log4j;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setup(){
        setProperty();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
        driver.get("https://www.gittigidiyor.com/");
        Log4j.startLog("GittiGidiyorTest");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        Log4j.endLog("GittiGidiyorTest");
        driver.quit();
    }


    public static void setProperty(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\FurkanBerk\\Selenium\\ChromeDriver\\chromedriver.exe");
    }
}
