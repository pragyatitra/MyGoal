package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class TransferPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	public TransferPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String transferPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the Transfer Page has been stored.");
		return transferPageUrl;
	}

	public String getCurrTitle() {
		String transferPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The title of the Transfer Page has been stored.");
		return transferPageTitle;
	}
}
