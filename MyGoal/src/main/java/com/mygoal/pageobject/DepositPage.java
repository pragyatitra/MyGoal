package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class DepositPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	public DepositPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String depositPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the Deposit page has been stored.");
		return depositPageUrl;
	}

	public String getCurrTitle() {
		String depositPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the Deposite Page tile has been stored.");
		return depositPageTitle;
	}

}
