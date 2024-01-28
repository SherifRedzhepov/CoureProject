package url.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.util.TestUtil;
import pages.LoginPage;
import pages.ProductPage;

public class SuccessfulLogin extends TestUtil {

      @Test
    private void successfulLog(){
          LoginPage loginPage = new LoginPage(driver);
          ProductPage productPage = loginPage.login("standard_user","secret_sauce");

          Assert.assertTrue(productPage.isAt());
    }
}

