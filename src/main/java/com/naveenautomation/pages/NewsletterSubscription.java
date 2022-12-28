package com.naveenautomation.pages;

import com.naveenautomation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterSubscription extends TestBase {

    @FindBy(css = "div.col-sm-10 label:first-of-type input")
    WebElement yesRadioButton;
    @FindBy(css = "div.col-sm-10 label:last-of-type input")
    WebElement noRadioButton;
    @FindBy(css = "input[type='submit']")
    WebElement continueButton;

    public NewsletterSubscription() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnYesRadioButton() {
        yesRadioButton.click();
    }

    public void clickOnNoRadioButton() {
        noRadioButton.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void subscribeToNewsletter() {
        clickOnYesRadioButton();
        clickOnContinueButton();

    }

    public void unsubscribeToNewsletter() {
        clickOnNoRadioButton();
        clickOnContinueButton();

    }

    public MyAccount subscribeOrUnsubscribeToNewsletter() {

        if (!yesRadioButton.isSelected()) {
            subscribeToNewsletter();
        } else {
            unsubscribeToNewsletter();
        }
        return new MyAccount();
    }

}
