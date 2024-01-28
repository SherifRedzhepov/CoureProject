package url.tests;

import base.util.TestUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class BuyProduct extends TestUtil {

    @Test
    public void buyProduct(){

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");

        productPage.addProductToCart("backpack");
        productPage.addProductToCart("bolt-t-shirt");

        SoftAssert softAssert = new SoftAssert();

        YourCartPage yourCartPage = productPage.openShoppingContainer();
        softAssert.assertTrue(yourCartPage.isYourCartPage());

        CheckoutInformationPage checkoutInformationPage = yourCartPage.buyProductByCart();
        softAssert.assertTrue(checkoutInformationPage.isCheckOutInformationPage());

        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.inputCheckoutInfo("Name", "Lastname","3242l");
        softAssert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPage());

        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.checkOutFinish();
        softAssert.assertTrue(checkoutCompletePage.isCheckoutCompletePage());

        softAssert.assertAll();
    }
}
