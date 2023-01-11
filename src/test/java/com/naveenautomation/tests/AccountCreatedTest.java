package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountCreated;
import com.naveenautomation.pages.AccountLogin;
import com.naveenautomation.pages.RegisterAccount;

public class AccountCreatedTest extends TestBase {

	AccountLogin accountLogin;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLogin = new AccountLogin();
	}

	@Test
	public void VerifyUserIsAbleToCreateAccountSuccessFully() {

		RegisterAccount registerAccount = accountLogin.newCustomerRegistration();

		AccountCreated accountCreated = registerAccount.signUp("FirstName", "LastName", "name1@gmail.com", "123852456",
				"Password1", "Password1");

		Assert.assertEquals(accountCreated.getSuccessAccountCreatedTxt(), "Your Account Has Been Created!",
				"Account not created");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
