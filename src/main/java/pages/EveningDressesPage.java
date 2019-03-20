package pages;

import base.AbstractTest;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EveningDressesPage extends AbstractPage {

    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";

    // Constructor
    public EveningDressesPage(AbstractTest testClass) {
        super(testClass);
    }

    /**
     * Find product by the its name and click on it
     *
     * @param nameOfProduct
     * @return entity of the product page
     */
    public ProductPage clickOnProduct(String nameOfProduct) {
        testClass
                .getDriver()
                .findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, nameOfProduct)))
                .sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        String initialWindow = testClass.getDriver().getWindowHandle();
        Set<String> windows = testClass.getDriver().getWindowHandles();
        String newWindow = null;
        for (String window : windows) {
            if (!window.equals(initialWindow)) {
                newWindow = window;
            }
        }
        testClass.getDriver().switchTo().window(newWindow);

        return new ProductPage(testClass);
    }
}
