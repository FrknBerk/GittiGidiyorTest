
import base.Base;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.*;

public class GittiGidiyorTest extends Base {
    @Test
    public void GittiGidiyor() throws InterruptedException {
        String search ="Bilgisayar";

        HomePage homePage = new HomePage(driver);
        homePage.pageLoadAssert();

        /*LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginButton();*/

        HomePageSearch homePageSearch = new HomePageSearch(driver);
        homePageSearch.search(search);

        HomePageImage homePageImage = new HomePageImage(driver);
        //homePageImage.imageClick();

        HomePageConfidentiality homePageConfidentiality = new HomePageConfidentiality(driver);
        homePageConfidentiality.confidentialityAgreementClick();

        HomePageScroll pageScroll = new HomePageScroll(driver);
        pageScroll.pageScrollDown();

        HomePageTwo pageTwo = new HomePageTwo(driver);
        pageTwo.pageTwoClick();

        homePage.checkPageNumberTwo();

        HomePageAddCart pageAddCart = new HomePageAddCart(driver);
        pageAddCart.addCart();
        pageAddCart.cartClick();

        HomePageCartPrice homePageCartPrice = new HomePageCartPrice(driver);
        homePageCartPrice.checkCartPrice();

        //Add cart two product
        pageAddCart.addCart();
        pageAddCart.cartClick();

        homePage.cartProductPiece();
        homePage.hoverCartMouse();

        HomePageCartDelete homePageCartDelete = new HomePageCartDelete(driver);
        homePageCartDelete.cartProductDelete();

        homePage.hoverCartMouse();
        HomePageCartEmpty homePageCartEmpty = new HomePageCartEmpty(driver);
        homePageCartEmpty.checkCartEmpty();
    }

}
