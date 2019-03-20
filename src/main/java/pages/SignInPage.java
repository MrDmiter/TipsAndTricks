package pages;

import base.AbstractTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.YamlParser;

public class SignInPage extends AbstractPage {

    // Web Elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    private WebElement signInBtn;

    /**
     * Constructor
     *
     * @param testClass
     */
    public SignInPage(AbstractTest testClass) {
        super(testClass);
    }

    /**
     * Sign in to the account
     *
     * @return
     */
    public MyAccountPage signIn() {
        // Enter email
        testClass.waitElementToBeClickable(emailTextField);
        emailTextField.sendKeys(YamlParser.getYamlFile().getEmail());
        // Enter password
        passTextField.sendKeys(YamlParser.getYamlFile().getPassword());
        // Click on the sign in button
        signInBtn.click();
        return new MyAccountPage(testClass);
    }
}
