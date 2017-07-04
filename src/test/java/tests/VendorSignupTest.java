package tests;

import base.BaseTest;
import dataprovider.VendorSignupDataProvider;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.VendorSignupPage;

/**
 * Created by ken.dsilva on 17/06/17.
 */
@Listeners({TestListener.class})
public class VendorSignupTest extends BaseTest {
    @Test
    public void successfulVendorSignupTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterOrganisationName()
                        .enterEmailId()
                        .enterMobileNumber()
                        .enterPassword()
                        .clickOnSubmitButton();

        Assert.assertEquals(vendorSignupPage.firstStepValidationMessage(),data.getSuccessfulFirstStepSignupMessage());
        vendorSignupPage.clickOnLogout();
    }

    @Test(dataProviderClass = VendorSignupDataProvider.class, dataProvider = "signup")
    public void negativeSignupTests(String name, String orgName, String mobileNum, String emailAddress, String expectedError) {
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName(name)
                .enterMobileNumber(mobileNum)
                .enterEmailId(emailAddress)
                .enterOrganisationName(orgName);

        Assert.assertEquals(vendorSignupPage.getInvalidErrorMessage(expectedError), expectedError);
    }

    @Test
    public void insufficientCharacterPasswordVendorSignupTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterOrganisationName()
                        .enterEmailId()
                        .inputInsufficientCharacterPassword()
                        .enterMobileNumber();

        Assert.assertEquals(vendorSignupPage.getInsufficientCharacterPasswordErrorMessage(),data.getInsufficientCharactersErrorMessage());
    }

    @Test
    public void emptyOrganisationFieldVendorSignUpTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterEmailId()
                        .enterMobileNumber()
                        .clickOnOrganisationField()
                        .enterPassword();

        Assert.assertEquals(vendorSignupPage.emptyOrganisationFieldErrorMessage(),data.getEmptyOrganisationError());
    }
}
