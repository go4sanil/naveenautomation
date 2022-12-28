package com.naveenautomation.tests;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLogin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePhoneNumberTest extends TestBase {
    AccountLogin accountLogin;

    @BeforeMethod
    public void setUp() {
        launchBrowser();
        accountLogin = new AccountLogin();
    }

    @Test
    public void VerifyUserIsAbleToUpdatePhoneNumberSuccessFully() {

        var myAccount = accountLogin.login("name1@gmail.com", "Password1");
        var myaccntinfo = myAccount.clickOnEditAccountInfoLink();

        var updatedMyAccount = myaccntinfo.changePhoneNumber("159753789");

        Assert.assertEquals(updatedMyAccount.getAccountUpdateConfirmationAlert(),
                "Success: Your account has been successfully updated.", "Account info update failed");

    }

    @AfterMethod
    public void teardown() {
        quitBrowser();
    }

}
