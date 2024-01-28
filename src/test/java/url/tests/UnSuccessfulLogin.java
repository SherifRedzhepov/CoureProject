package url.tests;

import base.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class UnSuccessfulLogin extends TestUtil {
    @Test(dataProvider = "invalidLoginParameters")
    public void unSuccessfulLoginTest(String userName , String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password);

        Assert.assertTrue(loginPage.isErrorBtnDisplayed());
    }
}
