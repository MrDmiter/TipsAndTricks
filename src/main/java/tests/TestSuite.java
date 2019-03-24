package tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class works as suite. You can run as many tests as you want
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CheckoutTest.class,
        OpenSiteAndClickTheLinkTest.class})
public class TestSuite {
}
