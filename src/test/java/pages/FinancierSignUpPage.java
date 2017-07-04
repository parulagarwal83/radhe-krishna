package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 26/05/17.
 */
public class FinancierSignUpPage extends BasePage {

    @FindBy(name = "name")
    WebElement enterUserName;

    @FindBy(xpath = "//input[@type = 'tel']")
    WebElement enterMobileNumber;

    @FindBy(name = "email")
    WebElement enterEmailId;

    @FindBy(name = "password")
    WebElement enterPassword;

    @FindBy(id = "checkbox-accept")
    WebElement checkBox;

    @FindBy(xpath = "//strong[contains(text(),'WELCOME ABOARD KREDX!')]")
    WebElement welcomeToKredx;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Please enter a valid email address')]")
    WebElement invalidEmailIdMessage;

    @FindBy(xpath = "//div[contains(text(),'Please enter your full name')]")
    WebElement nameFieldErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Please enter a valid mobile number')]")
    WebElement mobileNumberErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Please enter a password with minimum of 8 characters')]")
    WebElement insufficientCharactersErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Please accept the Terms and Conditions')]")
    WebElement uncheckedTermsAndConditions;

    @FindBy(xpath = "//em[contains(text(),'This is a top-10 common password')]")
    WebElement weakPasswordInputMessage;

    public FinancierSignUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input random username")
    public FinancierSignUpPage enterUserName(){
//        enterUserName.sendKeys(generateRandomName());
        writeTextInField(enterUserName,generateRandomName());
        return this;
    }

    @Step("Input random mobile number")
    public FinancierSignUpPage enterMobileNumber(){
//        enterMobileNumber.sendKeys(generateRandomMobileNumber());
        writeTextInField(enterMobileNumber,generateRandomMobileNumber());
        return this;
    }

    @Step("Input random email id")
    public FinancierSignUpPage enterEmailId(String emailId){
//        enterEmailId.sendKeys(generateRandomPassword() + emailId);
        writeTextInField(enterEmailId,generateRandomPassword() + emailId);
        return this;
    }

    @Step("Input invalid email id")
    public FinancierSignUpPage inputInvalidEmailId(){
//        enterEmailId.sendKeys(generateRandomName());
        writeTextInField(enterEmailId,generateRandomName());
        return this;
    }

    @Step("Input random password")
    public FinancierSignUpPage enterPassword(){
//        enterPassword.sendKeys(generateRandomPassword());
        writeTextInField(enterPassword,generateRandomPassword());
        return this;
    }

    @Step("Accept T&C checkbox")
    public FinancierSignUpPage selectCheckBox(){
//        waitForElement(checkBox);
//        checkBox.click();
        clickOnElement(checkBox);
        return this;
    }

    @Step("Verification of Account created page landing")
    public String onAccountCreatedPage(){
        waitForElement(welcomeToKredx);
        return welcomeToKredx.getText();
    }

    @Step("Clicking of submit SignUp button")
    public FinancierSignUpPage clickOnSubmitButton(){
//        submitButton.click();
        clickOnElement(submitButton);
        return this;
    }

    @Step("Verify invalid email id message retrived")
    public String verifyInvalidSignupMessage(){
        return invalidEmailIdMessage.getText();
    }

    @Step("Verify empty Name field message")
    public String verifyEmptyNameFieldMessage(){
        return nameFieldErrorMessage.getText();
    }

    @Step("Verify empty mobile number message")
    public String verifyEmptyMobileFieldMessage(){
        return mobileNumberErrorMessage.getText();
    }

    @Step("Verify empty email id message")
    public String verifyEmptyEmptyEmailIdMessage(){
        return invalidEmailIdMessage.getText();
    }

    @Step("Verify empty password message")
    public String verifyEmptyPasswordMessage(){
        return insufficientCharactersErrorMessage.getText();
    }

    @Step("Verify unchecked terms and conditions message")
    public String verifyCheckboxNotSelectedMessage(){
        return uncheckedTermsAndConditions.getText();
    }

    @Step("Input less than 7 character password")
    public FinancierSignUpPage inputInsufficientCharacterPassword(){
        writeTextInField(enterPassword,generateRandomPasswordOfSevenCharacters());
        return this;
    }

    @Step("Input weak password")
    public FinancierSignUpPage inputWeakPassword(String weakPassword){
        writeTextInField(enterPassword,weakPassword);
        return this;
    }

    @Step("Weak password input message")
    public String weakPasswordInputMessage(){
        waitForElement(weakPasswordInputMessage);
        return weakPasswordInputMessage.getText();
    }

    @Step("Input invalid mobile number")
    public FinancierSignUpPage inputInvalidMobileNumber(String mobileNumber){
        writeTextInField(enterMobileNumber,mobileNumber);
        return this;
    }
}
