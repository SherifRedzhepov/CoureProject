package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends Base{

    @FindBy(className = "title")
    private WebElement checkoutCompleteTitle;
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public boolean isCheckoutCompletePage(){
        if (checkoutCompleteTitle.getText().equals("Checkout: Complete!")){
            return true;
        }else {
            return false;
        }
    }
}
