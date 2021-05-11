package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver =driver;
        //wait = new WebDriverWait(driver,15);
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
    public void click(By elementBy){
        waitForLoad(driver);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text){
        waitForLoad(driver);
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy){
        waitForLoad(driver);
        return driver.findElement(elementBy).getText();
    }

    public void jsScrollIntoView(By elementBy){
        waitForLoad(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(elementBy);
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void jsClick(By elementBy){
        waitForLoad(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(elementBy);
        js.executeScript("arguments[0].click();",element);
    }

    public void assertEquals(By elementBy){
        waitForLoad(driver);
        Assert.assertEquals(driver.findElement(elementBy).isEnabled(), true);
    }

    public void actionsPerform(By elementBy){
        WebElement element = driver.findElement(elementBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void actionsClick(By elementBy){
        WebElement element = driver.findElement(elementBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

}
