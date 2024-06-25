package rahulshettyacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement selectCountry;

    @FindBy(xpath = "//button[contains(@class,'ta-item')]")
    WebElement selectCountryList;

    @FindBy(css = ".action__submit")
    WebElement submitButton;

    @FindBy(css = ".ta-results")
    By confirmPage;

    public void setSelectCountry(String country) {
        Actions a = new Actions(driver);
        a.sendKeys((selectCountry), country).build().perform();
//        waitForElementToAppear(confirmPage);
        selectCountryList.click();
    }

    public ConfirmationPage submitCheckout() {
        submitButton.click();
        return new ConfirmationPage(driver);
    }


}
