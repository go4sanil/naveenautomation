package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLogin;

public class AccountLoginTest extends TestBase {

	@BeforeMethod
    public void setUp() {
        launchBrowser();
    }

    @Test
    public void verifyLogin() {
        AccountLogin accountLogin = new AccountLogin();
        accountLogin.login("name1@gmail.com", "Password1");
        Assert.assertEquals(driver.getTitle(), "My Account1", "Page Title text doesn't match");
    }
 
	@AfterMethod
    public void tearDown() {
        quitBrowser();

    }

}
