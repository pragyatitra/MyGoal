package com.mygoal.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.dataprovider.DataProviders;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.WebsitePage;
import com.mygoal.utility.Log;

public class LoginPageTest extends BaseClass {

private LoginPage loginPage;
private WebsitePage websitePage;
private DashboardPage dashboardPage;

	
	public LoginPageTest()
	{
		super();
	}
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(@Optional("Edge")String browser)
	{
		launchApp(browser);
		loginPage = new LoginPage();
	}
	
	@Test(groups = { "Smoke", "Regression" })
	public void verifyUrlOfLoginPage()
	{
		Log.startTestCase("verifyUrlOfLoginPage");
		String actualUrl = loginPage.getCurrURL();
		String expectedUrl ="http://localhost/banking/admin/login.php";
		Log.info("Verifying if user is able to navigate into the login page");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("User has been successful navigate into the login page.");
		Log.endTestCase("verifyUrlOfLoginPage");

	}
	
	@Test(groups = { "Smoke", "Regression" })
	public void verifyTitleOfLoginPage()
	{
		Log.startTestCase("verifyTitleOfLoginPage");
		String actualTitle = loginPage.getCurrTitle();
		String expectedTitle ="State bank of India";
		Log.info("Verifying the title if user is able to navigate into the Login page");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Title is matched with expected title State bank of India");
		Log.endTestCase("verifyTitleOfLoginPage");

	}
	@Test(groups = { "Smoke", "Sanity", "Regression" })
	public void verifyLoginWithValidUsernameAndValidPassword()
	{   dashboardPage = new DashboardPage();
		Log.startTestCase("verifyLoginWithValidUsernameAndValidPassword");
		dashboardPage =loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),prop.getProperty("password"));
		//dashboardPage =loginPage.verifyLoginWithValidUsernameAndValidPassword(myUserName,myPassword);
		String actualURL=dashboardPage.getCurrURL();
		String expectedURL="http://localhost/banking/admin/";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login has been successful.");
		Log.endTestCase("verifyLoginWithValidUsernameAndValidPassword");
	}
	
	@Test(groups = { "Smoke", "Sanity", "Regression" })
	public void verifyLoginWithInvalidUsernameAndInvalidPassword()
	{  
		Log.startTestCase("verifyLoginWithInvalidUsernameAndInvalidPassword");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("invalidusername"),prop.getProperty("invalidpassword"));
		String actualError=loginPage.getErrorMessage();
		String expectedError=" Incorrect username or password";
		Log.info("Verifying if user is enter wrong username and wrong password");
		Assert.assertEquals(actualError, expectedError);
		Log.info("The error message matched.");
		Log.endTestCase("verifyLoginWithInvalidUsernameAndInvalidPassword");
		
	}
	
	@Test(groups = { "Smoke", "Sanity", "Regression" })
	public void verifyTheGotoWebsiteButtonFunctionality()
	{  websitePage = new WebsitePage();
		Log.startTestCase("verifyTheGotoWebsiteButtonFunctionality");
		websitePage = loginPage.verifyGotoWebsiteFunctionality();
		String actualURL=websitePage.getCurrURL();
		String expectedURL="http://localhost/banking/";
		Log.info("Verifying if user is able to navigate into the website page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("User has been successful navigate into the website page.");
		Log.endTestCase("verifyTheGotoWebsiteButtonFunctionality");

		
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
