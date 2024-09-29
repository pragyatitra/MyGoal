package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.WithdrowPage;
import com.mygoal.utility.Log;

public class WithdrowPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private WithdrowPage withdrowPage;
    
	public WithdrowPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		withdrowPage = new WithdrowPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfWithdrowPage() {
		Log.startTestCase("VerifyCurrentURLOfWithdrowPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		withdrowPage=dashboardPage.verifyWithdrowClickFunctionality();
		String actualURL = withdrowPage.getCurrURL();
		String expectedURL = withdrowPage.getCurrURL();
		Log.info("Verifying url of withdrow Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified withdrow Page URL");
		Log.endTestCase("VerifyCurrentURLOfWithdrowPage");

	}

	@Test(groups = {"Smoke","Regression"})
	public void VerifyTitleOfWithdrowPage() {
		Log.startTestCase("VerifyTitleOfWithdrowPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		withdrowPage=dashboardPage.verifyWithdrowClickFunctionality();
		String actualTitle = withdrowPage.getCurrTitle();
		String expectedTitle = withdrowPage.getCurrTitle();
		Log.info("Verifying title of withdrow Page ");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified withdrow Page title");
		Log.endTestCase("VerifyTitleOfWithdrowPage");

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
