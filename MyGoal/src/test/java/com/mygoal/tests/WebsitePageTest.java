package com.mygoal.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.WebsitePage;
import com.mygoal.utility.Log;

import junit.framework.Assert;

public class WebsitePageTest extends BaseClass {

	private LoginPage loginPage;
	private WebsitePage websitePage;

		
		public WebsitePageTest()
		{
			super();
		}
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup()
		{
			launchApp(prop.getProperty("browser"));
			loginPage = new LoginPage();
			websitePage = new WebsitePage();
		}
		
		@Test(groups = {"Smoke","Sanity","Regression"})
		public void verifyUrlOfWebsitePage()
		{
			Log.startTestCase("verifyUrlOfWebsitePage");
			loginPage.verifyGotoWebsiteFunctionality();
			String actualUrl = websitePage.getCurrURL();
			String expectedUrl ="http://localhost/banking/";
			Log.info("Verifying if user is able to navigate into the website page");
			Assert.assertEquals(actualUrl, expectedUrl);
			Log.info("User has been successful navigate into the website page.");
			Log.endTestCase("verifyUrlOfWebsitePage");

		}
		
		@Test(groups = {"Smoke","Sanity","Regression"})
		public void verifyTitleOfWebsitePage()
		{
			Log.startTestCase("verifyTitleOfWebsitePage");
			loginPage.verifyGotoWebsiteFunctionality();
			String actualTitle = websitePage.getCurrTitle();
			String expectedTitle ="State bank of India";
			Log.info("Verifying the title if user is able to navigate into the website page");
			Assert.assertEquals(actualTitle, expectedTitle);
			Log.info("Title is matched with expected title State bank of India");
			Log.endTestCase("verifyTitleOfWebsitePage");

		}
		
		@Test(groups = {"Sanity"})
		public void verifyHomeoptionTest()
		{
			Log.startTestCase("verifyHomeoptionTest");
			loginPage.verifyGotoWebsiteFunctionality();
			String actualMessage = websitePage.verifyHomeoption();
			String expectedMessage ="Welcome State bank Of India";
			Log.info("Verifying the Heading if user is able to navigate into the Home page");
			Assert.assertEquals(actualMessage, expectedMessage);
			Log.info("Heading is matched with expected heading of Home Page");
			Log.endTestCase("verifyHomeoptionTest");

		}
		
		@Test(groups = {"Smoke"})
		public void verifyAnnouncementsOptionTest()
		{
			Log.startTestCase("verifyAnnouncementsOptionTest");
			loginPage.verifyGotoWebsiteFunctionality();
			String actualMessage = websitePage.verifyAnnouncementsOption();
			String expectedMessage ="Announcements";
			Log.info("Verifying the Heading if user is able to navigate into the Announcement page");
			Assert.assertEquals(actualMessage, expectedMessage);
			Log.info("Heading is matched with expected heading of Announcement Page");
			Log.endTestCase("verifyAnnouncementsOptionTest");

		}
		@Test(groups = {"Regression"})
		public void verifyAboutOptionTest()
		{
			Log.startTestCase("verifyAboutOptionTest");
			loginPage.verifyGotoWebsiteFunctionality();
			String actualMessage = websitePage.verifyAboutOption();
			String expectedMessage ="About State bank Of India";
			Log.info("Verifying the Heading if user is able to navigate into the About page");
			Assert.assertEquals(actualMessage, expectedMessage);
			Log.info("Heading is matched with expected heading of About Page");
			Log.endTestCase("verifyAboutOptionTest");

		}
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
}
