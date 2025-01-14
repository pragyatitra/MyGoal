package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.TransactionPage;
import com.mygoal.utility.Log;

public class TransactionPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private TransactionPage transactionPage;
    
	public TransactionPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		transactionPage = new TransactionPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfTransactionPage() {
		Log.startTestCase("VerifyCurrentURLOfTransactionPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		transactionPage=dashboardPage.verifyTransactionHistoryClickFunctionality();
		String actualURL = transactionPage.getCurrURL();
		String expectedURL = transactionPage.getCurrURL();
		Log.info("Verifying url of transaction Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified transaction Page URL");
		Log.endTestCase("VerifyCurrentURLOfTransactionPage");

	}

	@Test(groups = {"Regression"})
	public void VerifyTitleOfTransactionPage() {
		Log.startTestCase("VerifyTitleOfTransactionPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		transactionPage=dashboardPage.verifyTransactionHistoryClickFunctionality();
		String actualTitle = transactionPage.getCurrTitle();
		String expectedTitle = transactionPage.getCurrTitle();
		Log.info("Verifying title of transaction Page ");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified transaction Page title");
		Log.endTestCase("VerifyTitleOfTransactionPage");

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}


