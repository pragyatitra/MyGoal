package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.TransferPage;
import com.mygoal.utility.Log;

public class TransferPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private TransferPage transferPage;
    
	public TransferPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		transferPage = new TransferPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfTransferPage() {
		Log.startTestCase("VerifyCurrentURLOfTransferPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		transferPage=dashboardPage.verifyTransferClickFunctionality();
		String actualURL = transferPage.getCurrURL();
		String expectedURL = transferPage.getCurrURL();
		Log.info("Verifying url of Transfer Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Transfer Page URL");
		Log.endTestCase("VerifyCurrentURLOfTransferPage");

	}

	@Test(groups = {"Regression"})
	public void VerifyTitleOfTransferPage() {
		Log.startTestCase("VerifyTitleOfTransferPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		transferPage=dashboardPage.verifyTransferClickFunctionality();
		String actualTitle = transferPage.getCurrTitle();
		String expectedTitle = transferPage.getCurrTitle();
		Log.info("Verifying title of transfer Page ");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified transfer Page title");
		Log.endTestCase("VerifyTitleOfTransferPage");

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
