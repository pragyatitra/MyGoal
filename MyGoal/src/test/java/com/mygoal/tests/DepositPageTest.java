package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.DepositPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.utility.Log;

public class DepositPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private DepositPage depositPage;
    
	public DepositPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		depositPage = new DepositPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfDepositPage() {
		Log.startTestCase("VerifyCurrentURLOfDepositPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		depositPage=dashboardPage.verifyDepositClickFunctionality();
		String actualURL = depositPage.getCurrURL();
		String expectedURL = depositPage.getCurrURL();
		Log.info("Verifying url of deposit page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified deposit URL");
		Log.endTestCase("VerifyCurrentURLOfDepositPage");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyTitleOfDepositPage() {
		Log.startTestCase("VerifyTitleOfDepositPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		depositPage=dashboardPage.verifyDepositClickFunctionality();
		String actualTitle = depositPage.getCurrTitle();
		String expectedTitle = depositPage.getCurrTitle();
		Log.info("Verifying title of Deposit page");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified Deposit title");
		Log.endTestCase("VerifyTitleOfDepositPage");

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
