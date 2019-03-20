package pages;

import base.AbstractTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    // Instance of BaseTest
    protected AbstractTest testClass;
    
    // Web Elements
    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement stickySignInBtn;

    @FindBy(
            xpath =
                    "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='T-shirts']")
    private WebElement tShirts;


    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(AbstractTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Click on the sign in button on the home page
     *
     * @return
     */
    public SignInPage signInClick() {
        testClass.waitElementToBeClickable(stickySignInBtn);
        stickySignInBtn.click();
        return new SignInPage(testClass);
    }



}
