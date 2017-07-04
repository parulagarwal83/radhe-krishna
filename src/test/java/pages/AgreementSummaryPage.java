package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Abc on 4/14/2017.
 */
public class AgreementSummaryPage extends BasePage {

    @FindBy(id="checkbox-accept")
    WebElement acceptCheckbox;

    @FindBy(id="checkbox-risks")
    WebElement riskCheckbox;

    @FindBy(xpath="//button[contains(text(),'Click here to sign')]")
    WebElement confirmButton;

    @FindBy(xpath="//div[@class='m-signature-pad--body']")
   public static WebElement signatureTextArea;

    @FindBy(xpath = "//button[contains(text(),'Accept and Send OTP')]")
    WebElement afterSignButton;

    @FindBy(xpath = "//label[input[@value = 'VIRTUAL-PAD']]")
    WebElement virtualPadOption;

    @FindBy(xpath = "//div[@id='root']/div/div[2]/button")
    WebElement dismissPopup;

    @FindBy(xpath = "//input[@placeholder = 'Enter OTP']")
    WebElement inputOtp;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    WebElement verifyOtp;

    @FindBy(xpath = "//div[div[contains(text(),'Aadhaar No.*')]]/div/div/input")
    WebElement aadhaarNumberField;

    @FindBy(xpath = "//div[contains(text(),'Please enter a valid Aadhaar number')]")
    WebElement invalidAadhaarErrorMessage;

    @FindBy(className = "close")
    WebElement closeWindow;

    @FindBy(xpath = "//div[contains(text(),'OTP verification failed')]")
    WebElement invalidOtpMessage;

    @FindBy(xpath = "//div[@class='name']/span")
    WebElement clickOnProfileDropdown;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

    @FindBy(xpath = "//div[@class = 'fade in modal']")
    WebElement popupBackground;

    @FindBy(xpath = "//h3[contains(text(),'Agreement Summary')]")
    WebElement agreementSummaryText;

    public AgreementSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select T&C checkbox")
    public AgreementSummaryPage selectAcceptCheckbox(){
        waitForElementToBeClickable(acceptCheckbox);
        clickOnElement(acceptCheckbox);
        return this;
    }

    @Step("Select risk involved checkbox")
    public AgreementSummaryPage selectRiskCheckbox(){
        waitForElementToBeClickable(riskCheckbox);
        clickOnElement(riskCheckbox);
        return this;
    }

    @Step("Click on Select here to sign button")
    public AgreementSummaryPage clickConfirmButton(){
        driver.switchTo().defaultContent();
        clickOnElement(confirmButton);
        return this;
    }

    @Step("Click on accept to proceed to payment button")
    public AgreementSummaryPage acceptAndSendOtp(){
        explicitlyWaitForElement(afterSignButton);
        clickOnElement(afterSignButton);
        return this;
    }

    @Step("Selecting virtual pad option")
    public AgreementSummaryPage selectVirtualPadOption(){
        waitForElementToBeClickable(virtualPadOption);
        clickOnElement(virtualPadOption);
        return this;
    }

    @Step("Dismissing help pop up")
    public AgreementSummaryPage dismissHelpPopup(){
        WebDriverWait wait = new WebDriverWait(driver, config.getWaitForFrameTimeout());
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        driver.switchTo().frame(1);
        clickOnElement(dismissPopup);
        return this;
    }

    @Step("Signature on virtual pad")
    public AgreementSummaryPage signatureOnVirtualPad(){
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(AgreementSummaryPage.signatureTextArea,135,15) //start points x axis and y axis.
                .clickAndHold().moveByOffset(165,15).moveByOffset(185,15)
                .build();
        drawAction.perform();
        return this;
    }

    @Step("input and verify OTP")
    public AgreementSummaryPage inputOtpAndVerify(){
        writeTextInField(inputOtp,data.getOtp());
        clickOnElement(verifyOtp);
        return this;
    }

    @Step("Input invalid Aadhaar number")
    public AgreementSummaryPage enterInvalidAadharNumber(){
        writeTextInField(aadhaarNumberField,data.getRandomText());
        return this;
    }

    @Step("Retrieving invalid Aadhar error message")
    public String getInvalidAadhaarErrorMessage(){
        waitForElement(invalidAadhaarErrorMessage);
        return invalidAadhaarErrorMessage.getText();
    }

    @Step("Close agreement window")
    public AgreementSummaryPage closeAgreementWindow(){
        clickOnElement(closeWindow);
        waitForElementToDisappear(popupBackground);
        return this;
    }

    @Step("Input invalid Otp")
    public AgreementSummaryPage inputInvalidOtp(){
        writeTextInField(inputOtp,data.getInvalidMobileNumber());
        clickOnElement(verifyOtp);
        return this;
    }

    @Step("Retrieving invalid Otp")
    public String invalidOtpMessage(){
        waitForElement(invalidOtpMessage);
        return invalidOtpMessage.getText();
    }

    @Step("User logged out")
    public void logoutUser(){
        clickOnElement(clickOnProfileDropdown);
        logoutButton.click();
    }

    @Step("Verifying submit button is not visible")
    public boolean clickHereToSigninButtonNotClickable(){
        return isNotClickable(confirmButton);
    }

    @Step("Verify on agreement summary page")
    public String onAgreementSummaryPage(){
        return agreementSummaryText.getText();
    }
}
