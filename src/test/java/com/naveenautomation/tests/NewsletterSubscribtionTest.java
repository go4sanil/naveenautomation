package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLogin;
import com.naveenautomation.pages.MyAccount;
import com.naveenautomation.pages.NewsletterSubscription;

public class NewsletterSubscribtionTest extends TestBase {

	AccountLogin accountLogin;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLogin = new AccountLogin();
	}

	@Test
	public void VerifyUserIsAbleToSubscribeNewsletterSuccessFully() {

		MyAccount myAccount = accountLogin.login("test@testemail.com", "test@testemail.com");

		NewsletterSubscription newsletterSubscription = myAccount.clickOnSubscribeNewsletterLink();
		MyAccount myAccountReloaded = newsletterSubscription.subscribeOrUnsubscribeToNewsletter();

		Assert.assertEquals(myAccountReloaded.getAccountUpdateConfirmationAlert(),
				"Success: Your newsletter subscription has been successfully updated!", "NewsLetter Error");

		Assert.assertEquals(myAccountReloaded.getPageTitle(), "My Account", "Title doesnot match");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
