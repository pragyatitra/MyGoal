package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class AnnouncementPage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	public AnnouncementPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String announcementPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the announcement page has been stored.");
		return announcementPageUrl;
	}

	public String getCurrTitle() {
		String announcementPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the Announcement Page title has been stored.");
		return announcementPageTitle;
	}

}
