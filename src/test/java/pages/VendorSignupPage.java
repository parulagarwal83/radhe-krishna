package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 17/06/17.
 */
public class VendorSignupPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Full Name as on PAN card or Passport*']")
    WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Organisation Name*']")
    WebElement organisationNameField;

    @FindBy(xpath = "//input[@placeholder='Email Address (Username)*']")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement mobileNumberField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'Company')]")
    WebElement successfulFirstStepMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter a valid email address')]")
    WebElement invalidEmailEnteredMessage;

    @FindBy(xpath = "//span[@class = 'glyphicon glyphicon-triangle-bottom']")
    WebElement dropDownButton;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

    @FindBy(xpath = "//span[contains(text(),'Please use a country code starting with +(plus) along with phone number')]")
    WebElement invalidMobileErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter a password with minimum of 8 characters')]")
    WebElement insufficientCharacterPasswordMessage;

    @FindBy(xpath = "//div[input[@placeholder = 'Organisation Name*']]/span")
    WebElement emptyOrganisationFieldErrorMessage;

    public VendorSignupPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering valid name")
    public VendorSignupPage enterName(){
        writeTextInField(nameField,generateRandomName());
        return this;
    }

    @Step("Entering valid organisation name")
    public VendorSignupPage enterOrganisationName(){
        writeTextInField(organisationNameField,generateRandomName());
        return this;
    }

    @Step("Entering valid email Address")
    public VendorSignupPage enterEmailId(){
        writeTextInField(emailAddressField,generateRandomPassword()+data.getEmailId());
        return this;
    }

    @Step("Entering valid mobile number")
    public VendorSignupPage enterMobileNumber(){
        writeTextInField(mobileNumberField,generateRandomMobileNumber());
        return this;
    }
    @Step("Entering valid name")
    public VendorSignupPage enterName(String name){
        writeTextInField(nameField,name);
        return this;
    }

    @Step("Entering valid organisation name")
    public VendorSignupPage enterOrganisationName(String orgName){
        writeTextInField(organisationNameField,orgName);
        return this;
    }

    @Step("Entering valid email Address")
    public VendorSignupPage enterEmailId(String email){
        writeTextInField(emailAddressField,email);
        return this;
    }

    @Step("Entering valid mobile number")
    public VendorSignupPage enterMobileNumber(String mobileNum){
        writeTextInField(mobileNumberField, mobileNum);
        return this;
    }

    @Step("Entering valid password")
    public VendorSignupPage enterPassword(){
        writeTextInField(passwordField,generateRandomPassword());
        return this;
    }

    @Step("Clicking on Sign up button")
    public VendorSignupPage clickOnSubmitButton(){
        clickOnElement(submitButton);
        return this;
    }

    @Step("Retriving successful sign up message")
    public String firstStepValidationMessage(){
        waitForElement(successfulFirstStepMessage);
        return successfulFirstStepMessage.getText();
    }

    @Step("Logging out")
    public void clickOnLogout(){
        clickOnElement(dropDownButton);
        clickOnElement(logoutButton);
    }

    @Step("Input invalid email id")
    public VendorSignupPage enterInvalidEmailId(){
        writeTextInField(emailAddressField,generateRandomName());
        return this;
    }

    @Step("Retrieving invalid email message")
    public String getInvalidEmailMessage(){
        waitForElement(invalidEmailEnteredMessage);
        return invalidEmailEnteredMessage.getText();
    }

    @Step("Entering invalid mobile number")
    public VendorSignupPage enterInvalidMobile(){
        writeTextInField(mobileNumberField,data.getInvalidMobileNumber());
        return this;
    }

    @Step("Retrieving invalid mobile error message")
    public String getInvalidMobileErrorMessage(){
        waitForElement(invalidMobileErrorMessage);
        return invalidMobileErrorMessage.getText();
    }

    @Step("Entering insufficient character password")
    public VendorSignupPage inputInsufficientCharacterPassword(){
        writeTextInField(passwordField,data.getInsufficientCharacterPassword());
        return this;
    }

    @Step("Retriving insufficient character password error message")
    public String getInsufficientCharacterPasswordErrorMessage(){
        waitForElement(insufficientCharacterPasswordMessage);
        return insufficientCharacterPasswordMessage.getText();
    }

    @Step("Click on organisation name")
    public VendorSignupPage clickOnOrganisationField(){
        clickOnElement(organisationNameField);
        return this;
    }

    @Step("Retrieving empty organisation field error message")
    public String emptyOrganisationFieldErrorMessage(){
        waitForElement(emptyOrganisationFieldErrorMessage);
        return emptyOrganisationFieldErrorMessage.getText();
    }

    @Step("Retrieving error message")
    public String getInvalidErrorMessage(String message) {
        WebElement errorMessage = findElement("xpathWithValue", "//span[contains(text(), '%')]", message);
        return errorMessage.getText();
    }
}
