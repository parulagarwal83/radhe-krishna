package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class LoginPage extends BasePage {
    @FindBy(name = "user_name")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement login;

    @FindBy(xpath = "//div[contains(text(),'Please enter your password')]")
    WebElement noPasswordEntered;

    @FindBy(xpath = "//a[contains(text(),'Sign up as an Investor')]")
    WebElement signUpAsInvestor;

    @FindBy(xpath = "//p[contains(text(),'New to KredX?')]")
    WebElement onLoginPage;

    @FindBy(xpath = "//div[contains(text(),'Incorrect email or password.')]")
    WebElement errorMessageWrongPassword;

    @FindBy(xpath = "//div[contains(text(),'Please enter your registered email')]")
    WebElement emptyEmailField;

    @FindBy(xpath = "//div[contains(text(),'Email Provided is not valid')]")
    WebElement invalidEmailMessage;

    @FindBy(xpath = "//a[contains(text(),'Sign up as a Business')]")
    WebElement businessSignupLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering valid username")
    public LoginPage enterUsername(String username) {
        writeTextInField(email,username);
        return this;
    }

    @Step("Entering valid password")
    public LoginPage enterPassword(String password) {
        writeTextInField(this.password,password);
        return this;
    }

    public void submit() {
        login.click();
    }

    @Step("Verifying error message for no password entered")
    public String isPasswordErrorMessageVisible(){
        waitForElement(noPasswordEntered);
        return noPasswordEntered.getText();
    }

    @Step("Navigating to investor signup page")
    public LoginPage goToSignUpAsInvestorPage(){
        clickOnElement(signUpAsInvestor);
        return this;
    }

    @Step("Verifying user logout")
    public String isUserLoggedOut(){
        waitForElement(onLoginPage);
        return onLoginPage.getText().trim();
    }

    @Step("Input invalid password")
    public LoginPage inCorrectPassword() {
        writeTextInField(this.password,generateRandomPassword());
        return this;
    }

    @Step("Verification of incorrect password error message")
    public String isIncorrectPasswordErrorMessageVisible(){
        waitForElement(errorMessageWrongPassword);
        return errorMessageWrongPassword.getText();
    }

    @Step("Verification of no username entered error message")
    public String noUsernameEnteredMessage(){
        waitForElement(emptyEmailField);
        return emptyEmailField.getText();
    }

    @Step("Invalid email entered message")
    public String invalidEmailEnteredMessage(){
        waitForElement(invalidEmailMessage);
        return invalidEmailMessage.getText();
    }

    @Step("Click on business sign up link")
    public void clickOnBusinessSignuplink(){
        clickOnElement(businessSignupLink);
    }
}
