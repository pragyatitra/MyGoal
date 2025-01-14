package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.SettingPage;
import com.mygoal.utility.Log;

public class SettingPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private SettingPage settingPage;
    
	public SettingPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		settingPage = new SettingPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfsettingPage() {
		Log.startTestCase("VerifyCurrentURLOfsettingPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		settingPage=dashboardPage.verifySettingClickFunctionality();
		String actualURL = settingPage.getCurrURL();
		String expectedURL = settingPage.getCurrURL();
		Log.info("Verifying url of setting page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified setting Page URL");
		Log.endTestCase("VerifyCurrentURLOfsettingPage");

	}

	@Test(groups = {"Regression"})
	public void VerifyTitleOfSettingPage() {
		Log.startTestCase("VerifyTitleOfManageAccountPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		settingPage=dashboardPage.verifySettingClickFunctionality();
		String actualTitle = settingPage.getCurrTitle();
		String expectedTitle = settingPage.getCurrTitle();
		Log.info("Verifying title of setting Page");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified setting Page title");
		Log.endTestCase("VerifyTitleOfManageAccountPage");

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}

