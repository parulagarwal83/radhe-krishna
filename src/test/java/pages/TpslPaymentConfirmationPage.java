package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 03/06/17.
 */
public class TpslPaymentConfirmationPage extends BasePage {

    @FindBy(xpath = "//input[@id='button']")
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'TPSL BANKING SYSTEM')]")
    WebElement tpslConfirmationHeader;

    public TpslPaymentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void confirmTransaction(){
        clickOnElement(submitButton);
    }

    @Step("Verification of TPSL Payment Confirmation page landing")
    public void onTpslPaymentConfirmaitonPage(){
        waitForElement(tpslConfirmationHeader);
        System.out.println("On TPSL Payment Confirmation page");
    }
}
