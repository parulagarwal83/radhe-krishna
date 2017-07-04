package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BusinessSignUpPage;
import pages.LoginPage;

/**
 * Created by ken.dsilva on 16/06/17.
 */
@Listeners({TestListener.class})
public class BusinessSignupTest extends BaseTest {
    @Test
    public void successfulBusinessSignupTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnBusinessSignuplink();

        BusinessSignUpPage businessSignUpPage = PageFactory.initElements(driver, BusinessSignUpPage.class);
        businessSignUpPage.enterName()
                          .enterEmail()
                          .enterMobileNumber()
                          .enterOrganisationName()
                          .clickOnSubmitButton();

        Assert.assertEquals(businessSignUpPage.getSuccessfulSignupMessage(),data.getSuccessfulSignupText());
    }

    @Test
    public void invalidEmailSignupTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnBusinessSignuplink();

        BusinessSignUpPage businessSignUpPage = PageFactory.initElements(driver, BusinessSignUpPage.class);
        businessSignUpPage.enterName()
                          .enterInvalidEmailId()
                          .enterMobileNumber()
                          .enterOrganisationName();

        Assert.assertEquals(businessSignUpPage.getInvalidEmailMessage(),data.getInvalidSignupEmailMessage());
    }

    @Test
    public void invalidMobileSignupTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnBusinessSignuplink();

        BusinessSignUpPage businessSignUpPage = PageFactory.initElements(driver, BusinessSignUpPage.class);
        businessSignUpPage.enterName()
                          .enterEmail()
                          .enterInvalidMobileNumber()
                          .enterOrganisationName();

        Assert.assertEquals(businessSignUpPage.getInvalidMobileNumberMessage(),data.getMobileNumberErrorMessage());
    }

    @Test
    public void emptyOrganisationFieldTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.clickOnBusinessSignuplink();

        BusinessSignUpPage businessSignUpPage = PageFactory.initElements(driver, BusinessSignUpPage.class);
        businessSignUpPage.enterName()
                .enterEmail()
                .enterMobileNumber()
                .clickOnOrganisationName();

        Assert.assertEquals(businessSignUpPage.getEmptyOrganisationFieldErrorMessage(),data.getEmptyOrganisationErrorMessage());
    }
}
