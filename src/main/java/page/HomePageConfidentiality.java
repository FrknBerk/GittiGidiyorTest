package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageConfidentiality extends BasePage{
    public HomePageConfidentiality(WebDriver driver) {
        super(driver);
    }

    By confidentialityAgreementClick = By.xpath("//span[@class='gg-icon gg-icon-close icon-close']");

    public void confidentialityAgreementClick(){
        click(confidentialityAgreementClick);
    }
}
