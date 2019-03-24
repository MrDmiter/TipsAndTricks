package tests;

import base.AbstractTest;
import org.junit.Test;
import pages.*;

public class CheckoutTest extends AbstractTest {

    /** Verify adding product to the cart and removing from there */
    @Test
    public void testCheckoutTest() {

        // Open Site
        HomePage homePage = openSite();
        log("Opened Site");

        // Proceed to signInPage
        SignInPage signInPage = homePage.signInClick();
        log("Entered the signIn page");

        // Log in to the account
        MyAccountPage myAccountPage = signInPage.signIn();
        log("Signed in into account");

        // Hover over women tab
        myAccountPage.focusOnWomenTab();
        log("Hovered over women tab");

        // Click on the "evening dresses"
        EveningDressesPage eveningDressesPage = myAccountPage.clickOnEveningDresses();
        log("Clicked on the \"evening dresses\"");

        // Click on the product by its name
        ProductPage productPage = eveningDressesPage.clickOnProduct("Printed Dress");
        log("Clicked on the product by its name");

        // Click on color filter
        productPage.clickOnColor("pink");
        log("Clicked on filter");

        // Select size in dropdown (S,M,L)
        productPage.selectSizeInDropdown("L");
        log("Selected size");

        // Add to cart and continue shopping
        productPage.addToCartAndContinueShopping();
        log("Added to cart and continue shopping");

        // Verify parameters of the added product in the cart
        productPage.hoverOverShopCartAndVerifyColorAndSize("pink","L");
        log("Verified parametrs of the added product");

        // Remove product from cart
        productPage.removeProductFromCart();
        log("Removed from cart");

        // Verify that cart is empty
        productPage.verifyCartIsEmpty();
        log("Verified that cart is empty");
    }
}
