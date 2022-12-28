package com.naveenautomation.pages;

import com.naveenautomation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogin extends TestBase {

    @FindBy(css = "#input-email")
    WebElement emailInputField;
    @FindBy(css = "#input-password")
    WebElement passwordInputField;
    @FindBy(css = "input[type='submit']")
    WebElement loginBtn;
    @FindBy(css = "a[class='btn btn-primary']")
    WebElement continueBtn;
    @FindBy(css = "div.alert")
    WebElement alertBanner;

    public AccountLogin() {
        PageFactory.initElements(driver, this);
    }

    public void enterEmailInputField(String email) {
        emailInputField.sendKeys(email);
    }

    public void enterPasswordInputField(String password) {
        passwordInputField.sendKeys(password);
    }

    public MyAccount login(String email, String password) {
        enterEmailInputField(email);
        enterPasswordInputField(password);
        loginBtn.submit();
        return new MyAccount();

    }

    public RegisterAccount newCustomerRegistration() {
        continueBtn.click();
        return new RegisterAccount();
    }

    public String getTextFromAlertBanner() {
        return alertBanner.getText();
    }


}
