package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLogin;
import com.naveenautomation.pages.MyAccount;
import com.naveenautomation.pages.MyAccountInformation;

public class MyAccountInformationTest extends TestBase {

	AccountLogin accountLogin;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLogin = new AccountLogin();
	}

	@Test(dataProvider = "LoginDataProvider", dataProviderClass = ExcelUtils.class)
	public void VerifyUsersAreAbleToLoginSuccessFully(String userName, String password, String Fname, String Sname,
			String email, String phone) {

		MyAccount myAccount = accountLogin.login(userName, password);
		MyAccountInformation myaccntinfo = myAccount.clickOnEditAccountInfoLink();

		Assert.assertEquals(myaccntinfo.getTextFromfirstNameTextField(), Fname, "FirstName doesnot match");
		Assert.assertEquals(myaccntinfo.getTextFromSecondNameTextField(), Sname, "LastName doesnot match");
		Assert.assertEquals(myaccntinfo.getTextFromEmailTextField(), email, "Email doesnot match");
		Assert.assertEquals(myaccntinfo.getTextFromPhoneTextField(), phone, "Phone doesnot match");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
