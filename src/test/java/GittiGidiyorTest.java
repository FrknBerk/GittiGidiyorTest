import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GittiGidiyorTest {
    WebDriver driver;
    String UserName ="Your Name";
    String Password="Your Password";
    String search ="Bilgisayar";

    @BeforeClass
    void Setup(){
        String chromePath = "C:\\\\Users\\\\FurkanBerk\\\\Selenium\\\\ChromeDriver\\\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gittigidiyor.com/");
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }

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
        //LoginClick();
        Search();
        PictureClick();
        GizlilikSözClick();
        PageScrollDown();
        PageTwoClick();
        Thread.sleep(2000);
        CheckPageNumber();
        Thread.sleep(2000);
        AddCart();
        CheckCartPrice();
        Thread.sleep(2000);
        AddCart();
        Thread.sleep(2000);
        CartProductPiece();
        MouseHoverCart();
        CartProductDelete();
        MouseHoverCart();
        CheckCartEmpty();

    }
    public void LoginClick() throws InterruptedException {

        // ----------LOGİN
        WebElement hover= driver.findElement(By.xpath("//div[@class='gekhq4-5 grTfZj']"));
        Actions hoverAct = new Actions(driver);
        hoverAct.moveToElement(hover).perform();
        Thread.sleep(1000);

        WebElement click = driver.findElement(By.xpath("//a[@class='qjixn8-0 sc-1bydi5r-0 kNKwwK']"));
        Actions clickAct = new Actions(driver);
        clickAct.moveToElement(click).click().build().perform();

        driver.findElement(By.id("L-UserNameField")).sendKeys(UserName);
        driver.findElement(By.id("L-PasswordField")).sendKeys(Password);

        driver.findElement(By.xpath("//input[@id='gg-login-enter']")).click();

        Thread.sleep(3000);

        //----------------LOGİN CONTROL
        boolean loginControl = driver.findElement(By.xpath("//span[contains(text(),'furkanbrkakdas')]")).isEnabled();
        Assert.assertEquals(loginControl,true);
        System.out.println(loginControl);
        if (loginControl == true){
            Log4j.info("Giriş Başarılı");
            System.out.println("Giriş başarılı");
        }
        else{
            System.out.println("Giriş Yapılmadı");
        }
    }
    public void Search() throws InterruptedException {
        // -------------SEARCH-------------------------
        driver.findElement(By.xpath("//input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']")).click();
        driver.findElement(By.xpath("//input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']")).sendKeys(search);
        driver.findElement(By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']")).click();
        Thread.sleep(2000);
    }
    public void PictureClick() throws InterruptedException {
        //------------FOTOĞRAFI KALDIRIYORUZ
        driver.findElement(By.xpath("//img[@class='wis-clsbtn-86912']")).click();
        Thread.sleep(2000);
    }
    public void GizlilikSözClick() throws InterruptedException {
        // ------GİZLİLİK SÖZLEŞMESİNİ KALDIRIYORUZ
        driver.findElement(By.xpath("//span[@class='gg-icon gg-icon-close icon-close']")).click();
        Thread.sleep(2000);
    }
    public void AddCart(){
        WebElement hoverCart= driver.findElement(By.xpath("(//div[@class='cell-border-css'])[1]"));
        Actions hoverCartAct = new Actions(driver);
        hoverCartAct.moveToElement(hoverCart).perform();
        //Thread.sleep(1000);


        WebElement clickCart = driver.findElement(By.xpath("(//button[@class='gg-ui-button gg-ui-btn-primary'])[1]"));
        Actions clickCartAct = new Actions(driver);
        clickCartAct.moveToElement(clickCart).click().build().perform();

    }

    public void CheckCartPrice() throws InterruptedException {
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

    public void PageScrollDown(){
        //Sayfada aşağı doğru inme
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pageNumber=driver.findElement(By.xpath("//a[@class='current' and contains(text(),'1')]"));
        js.executeScript("arguments[0].scrollIntoView();",pageNumber);
    }

    public void PageTwoClick(){
        //2 numaralı sayfaya yönlendirme
        WebElement pageNumberTwoClick = driver.findElement(By.xpath("//a[contains(text(),'2')]"));
        pageNumberTwoClick.click();
    }

    public void CheckPageNumber(){
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

    public void CartProductPiece(){
        //-------------------SEPETTEKİ ÜRÜN sayısı
        WebElement checkCartPiece = driver.findElement(By.xpath("//p[@class='product-specs-quantity' and contains(text(),'2')]"));
        Assert.assertEquals(checkCartPiece.isEnabled(),true);
        if (checkCartPiece.isEnabled() == true){
            Log4j.info("Sepetteki ürün adedi 2 tanedir");
            System.out.println("Sepetteki ürün adedi 2 tanedir");
        }
        else{
            System.out.println("Ürün sayısı eksik");
        }
    }

    public void MouseHoverCart(){
        //Fare ile Sepete Üstüne Gelme
        WebElement mouseHoverCart=driver.findElement(By.xpath("//a[@class='dIB']"));
        Actions mouseAct = new Actions(driver);
        mouseAct.moveToElement(mouseHoverCart).perform();
    }

    public void CartProductDelete(){
        //Sepetteki Ürünü Silme
        WebElement cartDelete =driver.findElement(By.xpath("//a[@href='javascript:;']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",cartDelete);
    }

    public void CheckCartEmpty(){
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
