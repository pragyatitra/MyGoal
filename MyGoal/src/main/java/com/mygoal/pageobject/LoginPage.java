package com.mygoal.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class LoginPage extends BaseClass {
	ActionDriver actionDriver = new ActionDriver();
	
	String message=null;
	
	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Go to Website']")
	WebElement gotoWebsiteBtn;
	
	@FindBy(xpath = "//div[text()=' Incorrect username or password']")
	WebElement errorMessage;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrURL() {
		String loginPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the LoginPageUrl page has been stored.");
		return loginPageUrl;
	}
	
	public String getCurrTitle() {
		String loginPageUrlTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the Login page has been stored.");
		return  loginPageUrlTitle;
	}

	public DashboardPage verifyLoginWithValidUsernameAndValidPassword(String userId, String pass) {

		Log.info("The user has entered a valid user ID.");
		actionDriver.type(userName, userId);
		Log.info("The user has entered a valid password.");
		actionDriver.type(password, pass);
		Log.info("The user has clicked the sign-in button.");
		actionDriver.click(getDriver(), loginBtn);
		DashboardPage dashboardPage = new DashboardPage();
		return dashboardPage;

	}

	public DashboardPage verifyLoginWitInvalidUsernameAndInvalidPassword(String userId, String pass) {

		Log.info("The user has entered a invalid user ID.");
		actionDriver.type(userName, userId);
		Log.info("The user has entered a invalid password.");
		actionDriver.type(password, pass);
		Log.info("The user has clicked the sign-in button.");
		actionDriver.click(getDriver(), loginBtn);
		DashboardPage dashboardPage = new DashboardPage();
		return dashboardPage;

	}

	public WebsitePage verifyGotoWebsiteFunctionality() {
		Log.info("The user has clicked the goto website button.");
		actionDriver.click(getDriver(), gotoWebsiteBtn);
		WebsitePage websitePage = new WebsitePage();
		return websitePage;
	}
	
	public String getErrorMessage()
	{
		Log.info("The error message is being stored.");
		message=errorMessage.getText().toString().trim();
		Log.info("The error message has been stored.");
		return message;
	}
}
