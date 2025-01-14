package com.mygoal.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class NewAccountPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	@FindBy(xpath = "//input[@name='account_number']")
	WebElement accountNumber;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='middlename']")
	WebElement middleName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//button[@id='generate_pass']")
	WebElement passwordButton;

	@FindBy(xpath = "//input[@name='pin']")
	WebElement pin;

	@FindBy(xpath = "//input[@name='balance']")
	WebElement balance;

	@FindBy(xpath = "//button[text()='Save' and @form='account-form']")
	WebElement saveButton;

	public NewAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String newAccountPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the NewAccount Page has been stored.");
		return newAccountPageUrl;
	}

	public String getCurrTitle() {
		String newAccountPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the NewAccount Page tile has been stored.");
		return newAccountPageTitle;
	}

	public ManageAccountPage verifyAccountCreationFunctionalityWithValiddata(String acNumber, String fName,
			String mName, String lName, String emailid, String mypin, String openingBalance) {
		actionDriver.type(accountNumber, acNumber);
		actionDriver.type(firstName, fName);
		actionDriver.type(middleName, mName);
		actionDriver.type(lastName, lName);
		actionDriver.type(email, emailid);
		actionDriver.click(getDriver(), passwordButton);
		actionDriver.type(pin, mypin);
		actionDriver.type(balance, openingBalance);
		actionDriver.click(getDriver(), saveButton);
		ManageAccountPage manageAccountPage = new ManageAccountPage();
		return manageAccountPage;
	}

}
