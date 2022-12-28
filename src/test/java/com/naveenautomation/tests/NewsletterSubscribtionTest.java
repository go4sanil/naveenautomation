package com.naveenautomation.tests;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLogin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewsletterSubscribtionTest extends TestBase {

    AccountLogin accountLogin;

    @BeforeMethod
    public void setUp() {
        launchBrowser();
        accountLogin = new AccountLogin();
    }

    @Test
    public void VerifyUserIsAbleToSignUpSuccessFully() {

        var myAccount = accountLogin.login("test@testemail.com", "test@testemail.com");

        var newsletterSubscription = myAccount.clickOnSubscribeNewsletterLink();
        var myAccountReloaded = newsletterSubscription.subscribeOrUnsubscribeToNewsletter();

        Assert.assertEquals(myAccountReloaded.getAccountUpdateConfirmationAlert(),
                "Success: Your newsletter subscription has been successfully updated!", "NewsLetter Error");

        Assert.assertEquals(myAccountReloaded.getPageTitle(), "My Account", "Title doesnot match");

    }

    @AfterMethod
    public void teardown() {
        quitBrowser();
    }

}
