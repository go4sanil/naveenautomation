package com.naveenautomation.pages;

import com.naveenautomation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogout extends TestBase {

    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @FindBy(css = "#content p:first-of-type")
    WebElement accountLogoutMessageText;
    @FindBy(css = "div.buttons a")
    WebElement continueButton;

    public AccountLogout() {
        PageFactory.initElements(driver, this);
    }

    public String getAccountLogoutText() {

        return accountLogoutText.getText();
    }

    public String accountLogoutMessageText() {

        return accountLogoutMessageText.getText();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

}
