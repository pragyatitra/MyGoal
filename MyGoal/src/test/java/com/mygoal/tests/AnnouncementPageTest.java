package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.AnnouncementPage;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.LoginPage;

import com.mygoal.utility.Log;

public class AnnouncementPageTest extends BaseClass{

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private AnnouncementPage announcementPage;
    
	public AnnouncementPageTest() {
		super();
	}
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		announcementPage = new AnnouncementPage();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void VerifyCurrentURLOfAnnouncmentPage() {
		Log.startTestCase("VerifyCurrentURLOfAnnouncmentPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		announcementPage=dashboardPage.verifyAnnouncmentClickFunctionality();
		String actualURL = announcementPage.getCurrURL();
		String expectedURL = announcementPage.getCurrURL();
		Log.info("Verifying url of Announcment page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Announcment URL");
		Log.endTestCase("VerifyCurrentURLOfAnnouncmentPage");

	}

	@Test(groups = {"Smoke","Regression"})
	public void VerifyTitleOfAnnouncmentPage() {
		Log.startTestCase("VerifyTitleOfAnnouncmentPage");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		announcementPage=dashboardPage.verifyAnnouncmentClickFunctionality();
		String actualTitle = announcementPage.getCurrTitle();
		String expectedTitle = announcementPage.getCurrTitle();
		Log.info("Verifying title of Announcment page");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified Announcment title");
		Log.endTestCase("VerifyTitleOfAnnouncmentPage");

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
