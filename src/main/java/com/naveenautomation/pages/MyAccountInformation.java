package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountInformation extends TestBase {

	public MyAccountInformation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='input-firstname']")
	WebElement firstNameTextField;
	@FindBy(css = "input[id='input-lastname']")
	WebElement secondNameTextField;
	@FindBy(css = "input[id='input-email']")
	WebElement emailTextField;
	@FindBy(css = "input[id='input-telephone']")
	WebElement phoneNumberTextField;
	@FindBy(css = "input[type='submit']")
	WebElement continueButton;

	public MyAccount changePhoneNumber(String password) {
		phoneNumberTextField.clear();
		phoneNumberTextField.sendKeys(password);
		continueButton.click();
		return new MyAccount();

	}

	public String getTextFromfirstNameTextField() {
			return firstNameTextField.getAttribute("value");
	}

	public String getTextFromSecondNameTextField() {
		return secondNameTextField.getAttribute("value");
	}

	public String getTextFromEmailTextField() {
		return emailTextField.getAttribute("value");
	}

	public String getTextFromPhoneTextField() {
		return phoneNumberTextField.getAttribute("value");
	}

}
