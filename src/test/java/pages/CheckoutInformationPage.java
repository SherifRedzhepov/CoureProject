package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage extends Base{
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(className = "title")
    private WebElement checkoutInfoTitle;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CheckoutOverviewPage inputCheckoutInfo(String firstName , String lastName , String postalCode){
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        continueBtn.click();
        return new CheckoutOverviewPage(driver);
    }
    public boolean isCheckOutInformationPage(){
        if (checkoutInfoTitle.getText().equals("Checkout: Your Information")){
            return true;
        }else {
            return false;
        }
    }
}
