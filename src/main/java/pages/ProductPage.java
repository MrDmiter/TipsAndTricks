package pages;

import base.AbstractTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

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

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(AbstractTest testClass) {
        super(testClass);
    }



    /**
     * Choose pink color
     */
    public void clickOnPinkColor(){
        pinkColor.click();
    }
    public void selectSizeInDropdown(String size){
        Select dropdown = new Select(testClass.getDriver().findElement(By.xpath("//select[@name='group_1']")));
        dropdown.selectByVisibleText(size);
    }
    public void addToCartAndProceedToCheckout(){
        cart.click();
        testClass.waitElementToBeVisible(continueShoppingbtn);
        continueShoppingbtn.click();
    }

    public void hoverOverShopCartAndVerifyColorAndSize(){
        Actions action = new Actions(testClass.getDriver());
        action.moveToElement(viewCart).build().perform();
        testClass.waitElementToBeVisible(orderAtributes);
        Assert.assertEquals("Pink, L",orderAtributes.getText());
    }

    public void removeProductFromCart(){
        testClass.waitElementToBeClickable(removeProductFromCartbtn);
        removeProductFromCartbtn.click();
    }

    public void verifyCartIsEmpty(){
        testClass.waitElementToBeVisible(cartIsEmpty);
        Assert.assertEquals("(empty)",cartIsEmpty.getText());
        String actualWindow = testClass.getDriver().getWindowHandle();
        Set<String> windowHandles = testClass.getDriver().getWindowHandles();
        String windowToSwitchTo = null;
        for (String windowHandle : windowHandles) {
            if(windowHandle!=actualWindow){
                windowToSwitchTo=windowHandle;
            }
        }

        testClass.getDriver().switchTo().window(windowToSwitchTo);
        testClass.getCookies();
        testClass.getDriver().close();


    }


}
