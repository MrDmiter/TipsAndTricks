package tests;

import base.AbstractTest;
import org.junit.Test;
import pages.*;

public class CheckoutTest extends AbstractTest {

    /** Verify adding product to the cart and removing from there */
    @Test
    public void testCheckoutTest() {

        //Open Site
        HomePage homePage = openSite();
        log("Opened Site");

        //Proceed to signInPage
        SignInPage signInPage = homePage.signInClick();
        log("Entered the signIn page");

        //Log in to the account
        MyAccountPage myAccountPage = signInPage.signIn();
        log("Signed in into account");

        //Hover over women tab
        myAccountPage.focusOnElement();

        //Click on the "evening dresses"
        EveningDressesPage eveningDressesPage = myAccountPage.clickOnEveningDresses();
        ProductPage productPage = eveningDressesPage.clickOnProduct("Printed Dress");
        productPage.clickOnPinkColor();
        productPage.selectSizeInDropdown("L");
        productPage.addToCartAndProceedToCheckout();
        productPage.hoverOverShopCartAndVerifyColorAndSize();
        productPage.removeProductFromCart();
        productPage.verifyCartIsEmpty();







//        //Choose T-shirts category in the main menu
//        TShirtsPage tShirtsPage = myAccountPage.clickOnTShirts();
//        log("Entered t-shirts category");
//
//        //Enter the product page
//        ProductPage productPage = tShirtsPage.clickOnProduct("Faded Short Sleeve T-shirts");
//        log("Opened product");
//
//        //Check whether we on the right page comparing breadcrumbs
//        productPage.verifyBreadCrumbs("> Women>Tops>T-shirts>Faded Short Sleeve T-shirts");
//        log("Bread crumbs are verified");
//
//        //Add product to cart and proceed to checkout page
//        CheckoutPage checkoutPage = productPage.addToCartAndProceedToCheckout();
//        log("Added to cart");
//
//        //Verify whether the total price is changed depending on the amount of items in the cart
//        checkoutPage.verifyTotalPriceDependingOnTheAmountOfProductInTheCart(3);
//
//        //Remove all items from the cart
//        checkoutPage.removeFromCart();
//
//        //Verify that cart is empty
//        checkoutPage.verifyCartIsEmpty();
//        log("Item successfully deleted");
//
//        //Close site
//        closeSite();
//        log("Site is closed");
    }
}
