package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.ManageAccountPage;
import com.mygoal.utility.Log;

public class ManageAccountPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ManageAccountPage manageAccountPage;
    
	public ManageAccountPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		manageAccountPage = new ManageAccountPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfManageAccountPage() {
		Log.startTestCase("VerifyCurrentURLOfManageAccountPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		manageAccountPage=dashboardPage.verifyManagementAccountClickFunctionality();
		String actualURL = manageAccountPage.getCurrURL();
		String expectedURL = manageAccountPage.getCurrURL();
		Log.info("Verifying url of ManageAccount page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified ManageAccount URL");
		Log.endTestCase("VerifyCurrentURLOfManageAccountPage");

	}

	@Test(groups = {"Smoke"})
	public void VerifyTitleOfManageAccountPage() {
		Log.startTestCase("VerifyTitleOfManageAccountPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		manageAccountPage=dashboardPage.verifyManagementAccountClickFunctionality();
		String actualTitle = manageAccountPage.getCurrTitle();
		String expectedTitle = manageAccountPage.getCurrTitle();
		Log.info("Verifying title of ManageAccount page");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified ManageAccount title");
		Log.endTestCase("VerifyTitleOfManageAccountPage");

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}

