package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccount extends TestBase {

	public MyAccount() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.list-group a:last-of-type")
	WebElement logoutTextOnSideBar;

	@FindBy(css = "#content ul:last-of-type a")
	WebElement subscribeNewsletterLink;

	@FindBy(css = "div.alert")
	WebElement accountUpdateConfirmationAlert;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccountinfoLink;

	@FindBy(css = "input[type='submit']")
	WebElement continueButton;

	public MyAccountInformation clickOnEditAccountInfoLink() {
		editAccountinfoLink.click();
		return new MyAccountInformation();
	}

	public MyAccountInformation updatePhoneNumber(String phonenumber) {
		editAccountinfoLink.sendKeys(phonenumber);
		continueButton.submit();
		return new MyAccountInformation();
	}

	public AccountLogout clickOnLogoutLink() {
		logoutTextOnSideBar.click();
		return new AccountLogout();
	}

 

	public String getAccountUpdateConfirmationAlert() {
		return accountUpdateConfirmationAlert.getText();

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public NewsletterSubscription clickOnSubscribeNewsletterLink() {
		subscribeNewsletterLink.click();
		return new NewsletterSubscription();
	}

}
