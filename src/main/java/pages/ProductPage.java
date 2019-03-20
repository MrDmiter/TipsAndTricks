package pages;

import base.AbstractTest;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//li/a[@name='Pink']")
    private WebElement pinkColor;

    @FindBy(xpath = "//span[contains(.,'Add to cart')]")
    private WebElement cart;

    @FindBy(xpath = "//span[contains(.,'Continue shopping')]")
    private WebElement continueShoppingbtn;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement viewCart;

    @FindBy(xpath = "//div[@class='product-atributes']/a")
    private WebElement orderAtributes;

    @FindBy(xpath = "//span[@class='remove_link']")
    private WebElement removeProductFromCartbtn;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private WebElement cartIsEmpty;

    @FindBy(xpath = "//select[@name='group_1']")
    private WebElement dropdownField;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(AbstractTest testClass) {
        super(testClass);
    }

    /** Choose pink color */
    public void clickOnPinkColor() {
        pinkColor.click();
    }

    /**
     * Select size in the dropdown
     *
     * @param size
     */
    public void selectSizeInDropdown(String size) {
        Select dropdown = new Select(dropdownField);
        dropdown.selectByVisibleText(size);
    }

    /** Add to cart and continue shopping */
    public void addToCartAndContinueShopping() {
        cart.click();
        testClass.waitElementToBeVisible(continueShoppingbtn);
        continueShoppingbtn.click();
    }

    /** Verify chosen color and size in the cart */
    public void hoverOverShopCartAndVerifyColorAndSize() {
        Actions action = new Actions(testClass.getDriver());
        action.moveToElement(viewCart).build().perform();
        testClass.waitElementToBeVisible(orderAtributes);
        Assert.assertEquals("Pink, L", orderAtributes.getText());
    }

    /** Remove product from cart */
    public void removeProductFromCart() {
        testClass.waitElementToBeClickable(removeProductFromCartbtn);
        removeProductFromCartbtn.click();
    }

    /** Verify that cart is empty, close open tab and come back to initial tab */
    public void verifyCartIsEmpty() {
        testClass.waitElementToBeVisible(cartIsEmpty);
        Assert.assertEquals("(empty)", cartIsEmpty.getText());
        String actualWindow = testClass.getDriver().getWindowHandle();
        Set<String> windowHandles = testClass.getDriver().getWindowHandles();
        String windowToSwitchTo = null;
        for (String windowHandle : windowHandles) {
            if (windowHandle != actualWindow) {
                windowToSwitchTo = windowHandle;
            }
        }
        testClass.getDriver().switchTo().window(windowToSwitchTo);
        testClass.getCookies();
        testClass.getDriver().close();
    }
}
