package page;

import log.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageCartPrice extends BasePage{
    public HomePageCartPrice(WebDriver driver) {
        super(driver);
    }

    By cartPrice = By.xpath("//span[@class='product-new-price']");
    By productPrice = By.xpath("(//div[@class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 padding-none extra-discount '])[1]");


    public void checkCartPrice() throws InterruptedException {
        threadSleep();
        String readCartPrice=readText(cartPrice);
        threadSleep();
        String readProductPrice = readText(productPrice);
        threadSleep();
        if (readCartPrice.equals(readProductPrice)){
            Log4j.info("Sepetteki ürün fiyatı ile ürün fiyatı eşleşiyor");
            System.out.println("Sepetteki ürün fiyatı ile ürün fiyatı eşleşiyor");
        }
        else{
            System.out.println("Sepeti kontrol ediniz.");
        }
    }

    public void threadSleep() throws InterruptedException {
        Thread.sleep(2000);
    }
}
