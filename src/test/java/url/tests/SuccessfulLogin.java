package url.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.util.TestUtil;
import pages.LoginPage;
import pages.ProductPage;
import java.time.Duration;

public class SuccessfulLogin extends TestUtil {

      @Test
    private void successfulLog(){
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

          LoginPage loginPage = new LoginPage(driver);
          ProductPage productPage = loginPage.login("standard_user","secret_sauce");

          wait.until(ExpectedConditions.visibilityOf(productPage.productTitle));

          Assert.assertTrue(productPage.isAt());
    }
}

