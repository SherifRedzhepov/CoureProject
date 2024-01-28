package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends Base{

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(className = "title")
    private WebElement checkoutOverviewTitle;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CheckoutCompletePage checkOutFinish(){
        finishBtn.click();
        return new CheckoutCompletePage(driver);
    }
    public boolean isCheckoutOverviewPage(){
        if (checkoutOverviewTitle.getText().equals("Checkout: Overview")){
            return true;
        }else {
            return false;
        }
    }
}
