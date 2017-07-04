package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 09/06/17.
 */
public class CurrentDealsPage extends BasePage {

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Sv Industries 2')]]]]]/div[3]/div/div[2]/div/div/div/input")
    WebElement svIndustriesDealAmount;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Sv Industries 2')]]]]]/div[3]/div/div[2]/div[2]/div/button")
    WebElement svIndustriesBuyNowButton;

    @FindBy(xpath = "//div[div[div[h5[contains(text(),'Sv Industries 2')]]]]/div[2]/a/button")
    WebElement svIndustriesShowDealsButton;

    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    WebElement onCurrentDealsPageText;

    @FindBy(xpath = "//strong[contains(text(),'Transaction Successful')]")
    WebElement transactionSuccessfulText;

    @FindBy(xpath = "//div[@class='name']/span")
    WebElement clickOnProfileDropdown;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

    @FindBy(xpath = ".//span[contains(text(),'Continue Investing')]")
    WebElement continueInvestingButton;

    @FindBy(xpath = "//div[@class = 'header-balance']")
    WebElement headerBalanceText;

    public CurrentDealsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify on Current Deals page")
    public String verifyOnCurrentDealsPage(){
        waitForElement(onCurrentDealsPageText);
        return onCurrentDealsPageText.getText();
    }

    @Step("Enter deal amount for Ent-Name Deal")
    public CurrentDealsPage inputDealAmount(String amount){
        writeTextInField(svIndustriesDealAmount,amount);
        return this;
    }

    @Step("Click on Ent-Name Buy now")
    public void clickOnBuyNowButton(){
        clickOnElement(svIndustriesBuyNowButton);
    }

    @Step("Successful deal confirmation")
    public String getDealConfirmationMessage(){
        waitForElement(transactionSuccessfulText);
        return transactionSuccessfulText.getText();
    }

    @Step("User logged out")
    public CurrentDealsPage logoutUser(){
        waitForElementToBeClickable(clickOnProfileDropdown);
        clickOnProfileDropdown.click();
        logoutButton.click();
        return this;
    }

    @Step("Click on continue investing page")
    public CurrentDealsPage clickOnContinueInvestingButton(){
        clickOnElement(continueInvestingButton);
        return this;
    }
}
