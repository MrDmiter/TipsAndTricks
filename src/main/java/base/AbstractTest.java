package base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.YamlParser;

public class AbstractTest {

    // Instances of the Webdriver and WebdriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    // Logger
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // Rule
    @Rule public RunTestRule runTestRule = new RunTestRule(this);

    /** Constructor */
    public AbstractTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Get driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait element to be clickable
     *
     * @param webElement
     */
    public void waitElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Wait element to be visible
     *
     * @param webElement
     */
    public void waitElementToBeVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Open site
     *
     * @return
     */
    public HomePage openSite() {
        driver.get(YamlParser.getYamlFile().getSite());
        return new HomePage(this);
    }

    /**
     * Write down info message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    public void waitTillTextToBePresentInElementValue(String locator, int expectedValue) {
        wait.until(
                ExpectedConditions.textToBePresentInElementValue(
                        By.xpath(locator), String.valueOf(expectedValue)));
    }

    /**
     * Get current date and time
     *
     * @return current date and time
     */
    public String getDateTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    /** Get cookies */
    public void getCookiesAndPrintInConsole() {
        Set<Cookie> cookies = getDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(
                    "Cookie name - "
                            + cookie.getName()
                            + " "
                            + "Cookie value - "
                            + cookie.getValue());
        }
    }

    /** Close site */
    public void closeSite() {
        driver.quit();
    }
}
