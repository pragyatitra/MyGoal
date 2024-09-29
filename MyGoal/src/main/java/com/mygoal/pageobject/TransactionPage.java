package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class TransactionPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	public TransactionPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String transactionPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the Transaction Page has been stored.");
		return transactionPageUrl;
	}

	public String getCurrTitle() {
		String transactionPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The title of the Transaction Page has been stored.");
		return transactionPageTitle;
	}
}
