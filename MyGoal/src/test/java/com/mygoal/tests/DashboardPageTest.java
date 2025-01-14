package com.mygoal.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygoal.baseclass.BaseClass;
import com.mygoal.pageobject.AnnouncementPage;
import com.mygoal.pageobject.DashboardPage;
import com.mygoal.pageobject.DepositPage;
import com.mygoal.pageobject.LoginPage;
import com.mygoal.pageobject.ManageAccountPage;
import com.mygoal.pageobject.NewAccountPage;
import com.mygoal.pageobject.SettingPage;
import com.mygoal.pageobject.TransactionPage;
import com.mygoal.pageobject.TransferPage;
import com.mygoal.pageobject.WithdrowPage;
import com.mygoal.utility.Log;

public class DashboardPageTest extends BaseClass {
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private NewAccountPage newAccountPage;
	private ManageAccountPage manageAccountPage;
	private TransactionPage transactionPage;
	private DepositPage depositPage;
	private WithdrowPage withdrowPage;
	private TransferPage transferPage;
	private AnnouncementPage announcementPage;
	private SettingPage settingPage;

	public DashboardPageTest() {
		super();
	}

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(prop.getProperty("browser"));
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		newAccountPage = new NewAccountPage();
		manageAccountPage = new ManageAccountPage();
		transactionPage = new TransactionPage();
		depositPage = new DepositPage();
		withdrowPage = new WithdrowPage();
		transferPage = new TransferPage();
		announcementPage = new AnnouncementPage();
		settingPage = new SettingPage();
	}

	@Test(groups = {"Smoke"})
	public void VerifyCurrURL() {
		Log.startTestCase("VerifyCurrURL");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		String actualURL = dashboardPage.getCurrURL();
		String expectedURL = dashboardPage.getCurrURL();
		Log.info("Verifying url of dashboard page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified dashboard URL");
		Log.endTestCase("VerifyCurrURL");

	}

	@Test(groups = {"Smoke","Sanity"})
	public void VerifyTitleOfDashboard() {
		Log.startTestCase("VerifyTitleOfDashboard");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		String actualTitle = dashboardPage.getCurrTitle();
		String expectedTitle = dashboardPage.getCurrTitle();
		Log.info("Verifying title of dashboard page");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Successfully verified dashboard title");
		Log.endTestCase("VerifyTitleOfDashboard");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyAccountManagementClickFunctionalityTest() {
		Log.startTestCase("verifyAccountManagementClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		String actualMessage = dashboardPage.verifyAccountManagementClickFunctionality();
		String expectedTitle = "New Account";
		Log.info("Verifying Account management button is working or not");
		Assert.assertEquals(actualMessage, expectedTitle);
		Log.info("Successfully verified Account management button");
		Log.endTestCase("verifyAccountManagementClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyNewAccountClickFunctionalityTest() {
		Log.startTestCase("verifyNewAccountClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		newAccountPage = dashboardPage.verifyNewAccountClickFunctionality();
		String actualURL = newAccountPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=accounts/manage_account";
		Log.info("Verifying New Account button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified New Account button");
		Log.endTestCase("verifyNewAccountClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyManagementAccountClickFunctionalityTest() {
		Log.startTestCase("verifyManagementAccountClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		manageAccountPage = dashboardPage.verifyManagementAccountClickFunctionality();
		String actualURL = manageAccountPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=accounts";
		Log.info("Verifying Manage Account button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Manage Account button");
		Log.endTestCase("verifyManagementAccountClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyTransactionClickFunctionalityTest() {
		Log.startTestCase("verifyTransactionClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		String actualMessage = dashboardPage.verifyTransactionClickFunctionality();
		String expectedTitle = "Transaction";
		Log.info("Verifying Transaction button is working or not");
		Assert.assertEquals(actualMessage, expectedTitle);
		Log.info("Successfully verified Transaction button");
		Log.endTestCase("verifyTransactionClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyTransactionHistoryClickFunctionalityTest() {
		Log.startTestCase("verifyTransactionHistoryClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		transactionPage = dashboardPage.verifyTransactionHistoryClickFunctionality();
		String actualURL = transactionPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=transaction";
		Log.info("Verifying Transaction for all button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Transaction for All button");
		Log.endTestCase("verifyTransactionHistoryClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyDepositClickFunctionalityTest() {
		Log.startTestCase("verifyDepositClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		depositPage = dashboardPage.verifyDepositClickFunctionality();
		String actualURL = depositPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=transaction/deposit";
		Log.info("Verifying Deposite button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Deposite button");
		Log.endTestCase("verifyDepositClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyWithdrowClickFunctionalityTest() {
		Log.startTestCase("verifyWithdrowClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		withdrowPage = dashboardPage.verifyWithdrowClickFunctionality();
		String actualURL = withdrowPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=transaction/withdraw";
		Log.info("Verifying Withdrow button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Withdrow button");
		Log.endTestCase("verifyWithdrowClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyTransferClickFunctionalityTest() {
		Log.startTestCase("verifyTransferClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		transferPage = dashboardPage.verifyTransferClickFunctionality();
		String actualURL = transferPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=transaction/transfer";
		Log.info("Verifying Transfer button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Transfer button");
		Log.endTestCase("verifyTransferClickFunctionalityTest");

	}

	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyAnnouncmentClickFunctionalityTest() {
		Log.startTestCase("verifyAnnouncmentClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		announcementPage = dashboardPage.verifyAnnouncmentClickFunctionality();
		String actualURL = announcementPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=announcements";
		Log.info("Verifying Announcement button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Announcement button");
		Log.endTestCase("verifyAnnouncmentClickFunctionalityTest");

	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifySettingClickFunctionalityTest() {
		Log.startTestCase("verifySettingClickFunctionalityTest");
		loginPage.verifyLoginWithValidUsernameAndValidPassword(prop.getProperty("username"),
				prop.getProperty("password"));
		settingPage = dashboardPage.verifySettingClickFunctionality();
		String actualURL = settingPage.getCurrURL();
		String expectedURL = "http://localhost/banking/admin/?page=system_info";
		Log.info("Verifying Setting button is working or not");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Successfully verified Setting button");
		Log.endTestCase("verifySettingClickFunctionalityTest");

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
