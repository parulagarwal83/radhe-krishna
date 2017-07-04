package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
@Listeners({TestListener.class})
public class LoginFlowTest extends BaseTest {
    @Test
    public void LoginSuccessfulTest() {
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                 .enterPassword(data.getPassword())
                 .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());

        dashboardPage.logoutUser();
        Assert.assertEquals(loginPage.isUserLoggedOut(),data.getUserLoggedOutMessage());
    }

    @Test
    public void noPasswordEnteredTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .submit();
        Assert.assertEquals(loginPage.isPasswordErrorMessageVisible(),data.getNoPasswordMessage());
    }

    @Test
    public void incorrectPasswordEnteredTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                 .inCorrectPassword()
                 .submit();
        Assert.assertEquals(loginPage.isIncorrectPasswordErrorMessageVisible(),data.getIncorrectPasswordErrorMessage());
    }

    @Test
    public void emptyCredentialsTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage
                .submit();
        Assert.assertEquals(loginPage.noUsernameEnteredMessage(),data.getNoEmailMessage());
        Assert.assertEquals(loginPage.isPasswordErrorMessageVisible(),data.getNoPasswordMessage());
    }

    @Test
    public void invalidEmailEnteredTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.enterUsername(data.getName())
                 .enterPassword(data.getPassword())
                 .submit();
        Assert.assertEquals(loginPage.invalidEmailEnteredMessage(),data.getInvalidEmail());
    }
}