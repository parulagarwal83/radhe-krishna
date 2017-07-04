package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 03/06/17.
 */
public class TpslLoginPage extends BasePage {

    @FindBy(name = "cid")
    WebElement customerName;

    @FindBy(name = "pwd")
    WebElement password;

    @FindBy(xpath = "//input[@id='button']")
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'TPSL BANKING SYSTEM')]")
    WebElement tpslLoginPageHeader;

    public TpslLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering TPSL customer name")
    public TpslLoginPage inputName(String tpslName){
        writeTextInField(customerName,tpslName);
        return this;
    }

    @Step("Entering TPSL password")
    public TpslLoginPage inputPassword(String tpslpassword){
        writeTextInField(password,tpslpassword);
        return this;
    }

    @Step("Clicking on TPSL form submit button")
    public void clickOnSubmitButton(){
        clickOnElement(submitButton);
    }

    @Step("Verification of TPSL login page loading")
    public void verifyOnTpslLandingPage(){
        waitForElement(tpslLoginPageHeader);
        System.out.println("On TPSL login page");
    }
}
