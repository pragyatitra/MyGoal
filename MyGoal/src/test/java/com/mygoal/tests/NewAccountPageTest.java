package com.mygoal.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.ManageAccountPage;
import com.mygoal.pageobject.NewAccountPage;
import com.mygoal.utility.DatabaseTestingLibrary;
import com.mygoal.utility.Log;

public class NewAccountPageTest extends BaseClass {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private NewAccountPage newAccountPage;
	private ManageAccountPage manageAccountPage;
	DatabaseTestingLibrary databaseTest;
	

		
		public NewAccountPageTest()
		{
			super();
		}
		
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup()
		{
			launchApp(prop.getProperty("browser"));
			loginPage = new LoginPage();
			dashboardPage = new DashboardPage();
			newAccountPage = new NewAccountPage();
			manageAccountPage = new ManageAccountPage();
			databaseTest = new DatabaseTestingLibrary();
		}
		
		@Test(groups = {"Smoke","Sanity","Regression"},priority = 1)
		public void verifyUrlOfNewAccountPage()
		{
			Log.startTestCase("verifyUrlOfNewAccountPage");
			loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
					prop.getProperty("password"));
			dashboardPage.verifyNewAccountClickFunctionality();
			String actualUrl = newAccountPage.getCurrURL();
			String expectedUrl =newAccountPage.getCurrURL();
			Log.info("Verifying the URL of New Account Page");
			Assert.assertEquals(actualUrl, expectedUrl);
			Log.info("User has been successful verified the URL of New Account Page.");
			Log.endTestCase("verifyUrlOfNewAccountPage");

		}
		
		@Test(groups = {"Smoke","Sanity","Regression"},priority = 2)
		public void verifyTitleOfNewAccountPage()
		{
			Log.startTestCase("verifyTitleOfNewAccountPage");
			loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
					prop.getProperty("password"));
			dashboardPage.verifyNewAccountClickFunctionality();
			String actualTitle = newAccountPage.getCurrTitle();
			String expectedTitle =newAccountPage.getCurrTitle();;
			Log.info("Verifying the title of the New Account page");
			Assert.assertEquals(actualTitle, expectedTitle);
			Log.info("Title is matched with expected title State bank of India");
			Log.endTestCase("verifyTitleOfNewAccountPage");

		}
		
		@Test(groups = {"Smoke","Sanity","Regression"},priority = 3)
		public void verifyAccountCreationFunctionalityWithValiddataTest() throws InterruptedException
		{   
			Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;
            String numberString = Integer.toString(randomNumber);
			Log.startTestCase("verifyAccountCreationFunctionalityWithValiddataTest");
			loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
					prop.getProperty("password"));
			dashboardPage.verifyNewAccountClickFunctionality();
			manageAccountPage = newAccountPage.verifyAccountCreationFunctionalityWithValiddata(numberString, "Anish", "Kumar", "Jha", "anish@gmail.com", "843123", "900000");
			String actualTitle = manageAccountPage.getCurrTitle();
			String expectedTitle =manageAccountPage.getCurrTitle();;
			Log.info("Verifying the title of the New Account page");
			Assert.assertEquals(actualTitle, expectedTitle);
			Log.info("Title is matched with expected title State bank of India");
			Log.info("Data is being validated in the database.");
			Assert.assertTrue(databaseTest.verifyIntegerValue("SELECT * FROM accounts", 2, randomNumber));
			Log.info("data has matched with the database.");
			Log.endTestCase("verifyAccountCreationFunctionalityWithValiddataTest");

		}
		
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
		
}
