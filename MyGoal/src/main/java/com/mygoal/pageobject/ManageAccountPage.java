package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class ManageAccountPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	public ManageAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String manageAccountPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the ManageAccount  page has been stored.");
		return manageAccountPageUrl;
	}

	public String getCurrTitle() {
		String manageAccountPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the ManageAccount Page tile has been stored.");
		return manageAccountPageTitle;
	}
}
