package pages;

import base.AbstractTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

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
    public MyAccountPage(AbstractTest testClass) {
        super(testClass);
    }

    /** Hover over Women tab */
    public void focusOnWomenTab() {
        Actions builder = new Actions(testClass.getDriver());
        builder.moveToElement(dresses).build().perform();
        testClass.waitElementToBeVisible(eveningDresses);
    }

    /** Click on the evening dresses */
    public EveningDressesPage clickOnEveningDresses() {
        eveningDresses.click();
        return new EveningDressesPage(testClass);
    }
}
