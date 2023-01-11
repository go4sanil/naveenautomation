package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountCreated extends TestBase {
	
	
	public AccountCreated() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")	
	WebElement accountCreationSuccessTxt;
	
	public String getSuccessAccountCreatedTxt() {
		return accountCreationSuccessTxt.getText();
	}
	
}
