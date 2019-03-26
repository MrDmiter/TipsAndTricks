package pages;

import base.AbstractTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Categories;

import java.util.Set;

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
    @FindBy(xpath = "//a[@title='Women']")
    private WebElement dresses;

    @FindBy(
            xpath =
                    "//ul[@class='submenu-container clearfix first-in-line-xs']/li/ul/li/a[@title='Evening Dresses']")
    private WebElement eveningDresses;

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

    /** Hover over Women tab */
    public void focusOnTab(Categories tab) {
        Actions builder = new Actions(testClass.getDriver());
        switch (tab){
            case WOMENS:
                builder.moveToElement(dresses).build().perform();
                break;
            case DRESSES:
                break;
            case TSHIRTS:
                break;
            default:
                System.out.println("Such tab isn`t exist");
                break;
        }

    }

    /** Click on the evening dresses */
    public EveningDressesPage clickOnEveningDresses() {
        testClass.waitElementToBeVisible(eveningDresses);
        eveningDresses.click();
        return new EveningDressesPage(testClass);
    }

    /** Get cookies */
    public void getCookiesNameAndValue() {
        Set<Cookie> cookies = testClass.getDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(
                    "Cookie name - "
                            + cookie.getName()
                            + " "
                            + "Cookie value - "
                            + cookie.getValue());
        }
    }
}
