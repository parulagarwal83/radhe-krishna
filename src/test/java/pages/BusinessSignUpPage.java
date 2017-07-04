package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 16/06/17.
 */
public class BusinessSignUpPage extends BasePage {

    @FindBy(name = "fullName")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "mobile")
    WebElement mobileField;

    @FindBy(name = "org_name")
    WebElement organizationNameField;

    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement signupButton;

    @FindBy(xpath = "//h3[contains(text(),'Thank you for Registering')]")
    WebElement successfulSignupText;

    @FindBy(xpath = "//li[contains(text(),'Please enter a valid email address')]")
    WebElement invalidEmailEnteredMessage;

    @FindBy(xpath = "//li[contains(text(),'Please enter a valid mobile number')]")
    WebElement invalidMobileNumberEnteredMessage;

    @FindBy(xpath = "//li[contains(text(),'Please enter name of your organisation')]")
    WebElement emptyOrganisationFieldMessage;

    public BusinessSignUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering name")
    public BusinessSignUpPage enterName(){
        writeTextInField(nameField,generateRandomName());
        return this;
    }

    @Step("Entering email")
    public BusinessSignUpPage enterEmail(){
        writeTextInField(emailField,generateRandomPassword() + data.getEmailId());
        return this;
    }

    @Step("Entering mobile number")
    public BusinessSignUpPage enterMobileNumber(){
        writeTextInField(mobileField,generateRandomMobileNumber());
        return this;
    }

    @Step("Entering organisation name")
    public BusinessSignUpPage enterOrganisationName(){
        writeTextInField(organizationNameField,generateRandomName());
        return this;
    }

    @Step("Click on submit button")
    public BusinessSignUpPage clickOnSubmitButton(){
        clickOnElement(signupButton);
        return this;
    }

    @Step("Returning successful sign up message")
    public String getSuccessfulSignupMessage(){
        waitForElement(successfulSignupText);
        return successfulSignupText.getText();
    }

    @Step("Input invalid email id")
    public BusinessSignUpPage enterInvalidEmailId(){
        writeTextInField(emailField,generateRandomName());
        return this;
    }

    @Step("Retrieving invalid email message")
    public String getInvalidEmailMessage(){
        waitForElement(invalidEmailEnteredMessage);
        return invalidEmailEnteredMessage.getText();
    }

    @Step("Input invalid mobile number")
    public BusinessSignUpPage enterInvalidMobileNumber(){
        writeTextInField(mobileField,data.getInvalidMobileNumber());
        return this;
    }

    @Step("Retrieving invalid mobile number message")
    public String getInvalidMobileNumberMessage(){
        waitForElement(invalidMobileNumberEnteredMessage);
        return invalidMobileNumberEnteredMessage.getText();
    }

    @Step("Setting empty organisation name")
    public BusinessSignUpPage clickOnOrganisationName(){
        clickOnElement(organizationNameField);
        clickOnElement(mobileField);
        return this;
    }

    @Step("Retrieving empty organisation field error message")
    public String getEmptyOrganisationFieldErrorMessage(){
        return emptyOrganisationFieldMessage.getText();
    }
}
