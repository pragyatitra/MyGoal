package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class SettingPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	public SettingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String settingPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the Setting Page has been stored.");
		return settingPageUrl;
	}

	public String getCurrTitle() {
		String settingPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The title of the Setting Page has been stored.");
		return settingPageTitle;
	}
}
