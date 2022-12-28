package com.naveenautomation.pages;

import com.naveenautomation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreated extends TestBase {


    @FindBy(css = "#content h1")
    WebElement accountCreationSuccessTxt;

    public AccountCreated() {
        PageFactory.initElements(driver, this);
    }

    public String getSuccessAccountCreatedTxt() {
        return accountCreationSuccessTxt.getText();
    }

}
