package page;

import log.Log4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    By pageLoad = By.xpath("//a[contains(@href, 'gittigidiyor')]");
    public WebElement pageLoad(){
        boolean checkPage = driver.findElement(pageLoad).isEnabled();
        // System.out.println(checkPage);
        //Assert.assertEquals(pageLoad,true);
        /*if(checkPage == true){
            System.out.println("Sayfa yüklendi");
        }*/
        return driver.findElement(pageLoad);
    }

    By searchInputClick = By.xpath("//input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']");
    By searchInputKey = By.xpath("//input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']");
    By searcButtonClick = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']");

    public void Search(String search){
        driver.findElement(searchInputClick).click();
        driver.findElement(searchInputKey).sendKeys(search);
        driver.findElement(searcButtonClick).click();
    }

    By imageClick = By.xpath("//img[starts-with(@class, 'wis-clsbtn')]");

    public void imageClick(){
        driver.findElement(imageClick).click();
    }

    By confidentialityAgreementClick = By.xpath("//span[@class='gg-icon gg-icon-close icon-close']");

    public void confidentialityAgreementClick(){
        driver.findElement(confidentialityAgreementClick).click();
    }

    public void addCart(){
        WebElement hoverCart= driver.findElement(By.xpath("//div[starts-with(@class, 'cell-border-css')][1]"));
        Actions hoverCartAct = new Actions(driver);
        hoverCartAct.moveToElement(hoverCart).perform();
        //Thread.sleep(1000);


        WebElement clickCart = driver.findElement(By.xpath("(//button[@class='gg-ui-button gg-ui-btn-primary'])[1]"));
        Actions clickCartAct = new Actions(driver);
        clickCartAct.moveToElement(clickCart).click().build().perform();
    }

    public void checkCartPrice() throws InterruptedException {
        //-------------SEPETTEKİ FİYAT BİLGİSİNİ ALIYORUZ
        Thread.sleep(2000);
        String cartPriceControl = driver.findElement(By.xpath("//span[@class='product-new-price']")).getText();

        //------------ÜRÜN FİYAT BİLGİSİNİ ALIYORUZ
        Thread.sleep(2000);
        String price = driver.findElement(By.xpath("(//p[@class='extra-price'])[1]")).getText();

        //ÜRÜN İLE SEPETTEKİ FİYATI KARŞILAŞTIRIYORUZ
        Thread.sleep(2000);
        if(cartPriceControl.equals(price)){
            Log4j.info("Sepetteki ürün fiyatı ile aldığını ürün fiyatı aynı başarılı bir şekilde alışveriş yapabilirsiniz.");
            System.out.println("Sepetteki ürün fiyatı ile aldığını ürün fiyatı aynı başarılı bir şekilde alışveriş yapabilirsiniz.");
        }
        else{
            System.out.println("Sepetinizi kontrol ediniz");
        }
    }
    public void pageScrollDown(){
        //Sayfada aşağı doğru inme
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pageNumber=driver.findElement(By.xpath("//a[@class='current' and contains(text(),'1')]"));
        js.executeScript("arguments[0].scrollIntoView();",pageNumber);
    }

    public void pageTwoClick(){
        //2 numaralı sayfaya yönlendirme
        WebElement pageNumberTwoClick = driver.findElement(By.xpath("//a[contains(text(),'2')]"));
        pageNumberTwoClick.click();
    }

    public void checkPageNumber(){
        //Sayfa sayısı kontrol
        WebElement checkPageNumber = driver.findElement(By.xpath("//a[@class='current' and contains(text(),'2')]"));
        Assert.assertEquals(checkPageNumber.isEnabled(),true);
        if (checkPageNumber.isEnabled() == true){
            Log4j.info("2.Numaralı sayfadasınız");
            System.out.println("2.Numaralı sayfadasınız");
        }
        else {
            System.out.println("Sayfa sayınız yanlış");
        }
    }

    public void cartProductPiece(){
        //-------------------SEPETTEKİ ÜRÜN sayısı
        WebElement checkCartPiece = driver.findElement(By.xpath("//p[@class='product-specs-quantity' and contains(text(),'1')]"));
        Assert.assertEquals(checkCartPiece.isEnabled(),true);
        if (checkCartPiece.isEnabled() == true){
            Log4j.info("Sepetteki ürün adedi 2 tanedir");
            System.out.println("Sepetteki ürün adedi 2 tanedir");
        }
        else{
            System.out.println("Ürün sayısı eksik");
        }
    }

    public void mouseHoverCart(){
        //Fare ile Sepete Üstüne Gelme
        WebElement mouseHoverCart=driver.findElement(By.xpath("//a[@class='dIB']"));
        Actions mouseAct = new Actions(driver);
        mouseAct.moveToElement(mouseHoverCart).perform();
    }

    public void cartProductDelete(){
        //Sepetteki Ürünü Silme
        WebElement cartDelete =driver.findElement(By.xpath("//a[@href='javascript:;']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",cartDelete);
    }
    public void checkCartEmpty(){
        WebElement checkCartControl = driver.findElement(By.xpath("//p[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]"));
        Assert.assertEquals(checkCartControl.isEnabled(),true);
        if (checkCartControl.isEnabled() == true){
            Log4j.info("Sepette ürün yok");
            System.out.println("Sepette Ürün Yok");
        }
        else{
            System.out.println("Sepette Ürün Bulunmaktadır");
        }
    }
}
