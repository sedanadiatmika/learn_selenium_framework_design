package rahulshettyacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productTitles;

    public Boolean VerifyProductDisplay(String productName) {
        Boolean match = productTitles.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout() {
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}
