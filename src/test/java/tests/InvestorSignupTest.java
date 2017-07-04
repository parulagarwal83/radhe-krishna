package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FinancierSignUpPage;
import pages.LoginPage;

/**
 * Created by ken.dsilva on 26/05/17.
 */
@Listeners({TestListener.class})
public class InvestorSignupTest extends BaseTest {
//  will rewrite this test once delete api is available
//    @Test
//    public void successfulSignUpTest(){
//        driver.get(data.getUrl());
//        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
//        loginPage.goToSignUpAsInvestorPage();
//
//        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver,FinancierSignUpPage.class);
//        financierSignUpPage.enterUserName()
//                           .enterMobileNumber()
//                           .enterEmailId(data.getEmailId())
//                           .enterPassword()
//                           .selectCheckBox()
//                           .clickOnSubmitButton();
//
//        Assert.assertEquals(financierSignUpPage.onAccountCreatedPage(),data.getCreatedAccountMessage());
//    }

    @Test
    public void invalidEmailSignUpTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.goToSignUpAsInvestorPage();

        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver, FinancierSignUpPage.class);
        financierSignUpPage.enterUserName()
                           .enterMobileNumber()
                           .inputInvalidEmailId()
                           .enterPassword()
                           .selectCheckBox()
                           .clickOnSubmitButton();
        Assert.assertEquals(financierSignUpPage.verifyInvalidSignupMessage(),data.getInvalidSignupEmailMessage());
    }

    @Test
    public void emptyFieldsSignupTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.goToSignUpAsInvestorPage();

        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver, FinancierSignUpPage.class);
        financierSignUpPage.clickOnSubmitButton();

        Assert.assertEquals(financierSignUpPage.verifyEmptyNameFieldMessage(),data.getNameFieldErrorMessage());
        Assert.assertEquals(financierSignUpPage.verifyEmptyMobileFieldMessage(),data.getMobileNumberErrorMessage());
        Assert.assertEquals(financierSignUpPage.verifyEmptyEmptyEmailIdMessage(),data.getInvalidSignupEmailMessage());
        Assert.assertEquals(financierSignUpPage.verifyEmptyPasswordMessage(),data.getInsufficientCharactersErrorMessage());
        Assert.assertEquals(financierSignUpPage.verifyCheckboxNotSelectedMessage(),data.getTermsAndConditionsErrorMessage());
    }

    @Test
    public void insufficientCharacterPasswordTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.goToSignUpAsInvestorPage();

        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver, FinancierSignUpPage.class);
        financierSignUpPage.enterUserName()
                           .enterEmailId(data.getEmailId())
                           .inputInsufficientCharacterPassword()
                           .enterMobileNumber()
                           .selectCheckBox()
                           .clickOnSubmitButton();
        Assert.assertEquals(financierSignUpPage.verifyEmptyPasswordMessage(),data.getInsufficientCharactersErrorMessage());
    }

    @Test
    public void weakSignupPasswordTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.goToSignUpAsInvestorPage();

        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver, FinancierSignUpPage.class);
        financierSignUpPage.enterUserName()
                           .enterEmailId(data.getEmailId())
                           .inputWeakPassword(data.getWeakPassword())
                           .enterMobileNumber()
                           .selectCheckBox()
                           .clickOnSubmitButton();

        Assert.assertEquals(financierSignUpPage.weakPasswordInputMessage(),data.getWeakPasswordMessage());
    }

    @Test
    public void invalidMobileNumberTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.goToSignUpAsInvestorPage();

        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver, FinancierSignUpPage.class);
        financierSignUpPage.enterUserName()
                           .enterEmailId(data.getEmailId())
                           .inputInvalidMobileNumber(data.getInvalidMobileNumber())
                           .enterPassword()
                           .selectCheckBox()
                           .clickOnSubmitButton();

        Assert.assertEquals(financierSignUpPage.verifyEmptyMobileFieldMessage(),data.getMobileNumberErrorMessage());
    }
}
