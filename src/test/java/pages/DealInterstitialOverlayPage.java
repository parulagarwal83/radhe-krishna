package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 09/06/17.
 */
public class DealInterstitialOverlayPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    WebElement proceedButton;

    @FindBy(xpath = "//div[contains(text(),'*Expected Returns')]")
    WebElement expectedReturnsText;

    @FindBy(xpath = "//button[contains(text(),'Browse More Deals')]")
    WebElement dealOverviewText;

    @FindBy(className = "close")
    WebElement closeWindowButton;

    @FindBy(xpath = "//div[@class = 'fade in modal']")
    WebElement popupBackground;

    public DealInterstitialOverlayPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Proceed button")
    public void clickOnProceedButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(proceedButton);
        clickOnElement(proceedButton);
    }

    @Step("verify on deal interstitial page")
    public String verifyOnDealInterstitialPage(){
        return dealOverviewText.getText();
    }

    @Step("click on close window button")
    public void clickOnCloseWindowButton(){
        clickOnElement(closeWindowButton);
        waitForElementToDisappear(popupBackground);
    }
}
