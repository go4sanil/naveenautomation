package com.naveenautomation.pages;

import com.naveenautomation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountInformation extends TestBase {

    @FindBy(css = "input[id='input-telephone']")
    WebElement phoneNumberTextField;
    @FindBy(css = "input[type='submit']")
    WebElement continueButton;

    public MyAccountInformation() {
        PageFactory.initElements(driver, this);
    }

    public MyAccount changePhoneNumber(String password) {
        phoneNumberTextField.clear();
        phoneNumberTextField.sendKeys(password);
        continueButton.click();
        return new MyAccount();

    }

}
