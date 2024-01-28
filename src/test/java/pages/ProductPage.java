package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Base{

    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    @FindBy(className = "title")
    private WebElement productTitle;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement openShoppingContainer;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isAt(){
        if (productTitle.getText().equals("Products")){
            return true;
        }else {
            return false;
        }
    }
    public void addProductToCart(String itemTitle){
        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + itemTitle));
        itemToBeAdded.click();
    }
    public int numOfItemsInCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }
    public YourCartPage openShoppingContainer(){
        openShoppingContainer.click();
        return new YourCartPage(driver);
    }
}

