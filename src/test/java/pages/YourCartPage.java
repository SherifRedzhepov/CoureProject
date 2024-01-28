package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends Base{
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(className = "title")
    private WebElement yourCartTitle;

    public YourCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public CheckoutInformationPage buyProductByCart(){
        checkoutBtn.click();
        return new CheckoutInformationPage(driver);
    }
    public boolean isYourCartPage(){
        if (yourCartTitle.getText().equals("Your Cart")){
            return true;
        }else {
            return false;
        }
    }
}
