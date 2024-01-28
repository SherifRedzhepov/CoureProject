package url.tests;

import org.testng.annotations.Test;
import base.util.TestUtil;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

public class AddProductsToCart extends TestUtil {

    @Test(dataProvider = "products list")
    public void addToCart(String productName){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        productPage.addProductToCart(productName);
        softAssert.assertEquals(productPage.numOfItemsInCart(),1);
    }
}
