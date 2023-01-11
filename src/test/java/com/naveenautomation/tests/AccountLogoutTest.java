package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLogin;
import com.naveenautomation.pages.AccountLogout;
import com.naveenautomation.pages.MyAccount;

public class AccountLogoutTest extends TestBase {

    AccountLogin accountLogin;

    
	@BeforeMethod
    public void setUp() {
        launchBrowser();
        accountLogin = new AccountLogin();
    }

    @Test
    public void verifyLogout() {

        MyAccount myAccountPage = accountLogin.login("name1@gmail.com", "Password1");

        AccountLogout accountLogout = myAccountPage.clickOnLogoutLink();

        Assert.assertEquals(accountLogout.getAccountLogoutText(), "Account Logout", "Logout error");
        Assert.assertEquals(accountLogout.accountLogoutMessageText(),
                "You have been logged off your account. It is now safe to leave the computer.",
                "Account Logout text message not matching");

        accountLogout.clickOnContinueButton();
    }

  
	@AfterMethod
    public void tearDown() {
        quitBrowser();

    }

}
