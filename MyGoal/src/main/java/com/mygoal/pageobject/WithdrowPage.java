package com.mygoal.pageobject;

import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class WithdrowPage extends BaseClass{

	ActionDriver actionDriver = new ActionDriver();

	public WithdrowPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String withdrowPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the Withdrow Page has been stored.");
		return withdrowPageUrl;
	}

	public String getCurrTitle() {
		String withdrowPageTitle = actionDriver.getTitle(getDriver());
		Log.info("The title of the Withdrow Page has been stored.");
		return withdrowPageTitle;
	}
}
