package com.mygoal.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class WebsitePage extends BaseClass {

	ActionDriver actionDriver = new ActionDriver();

	String homeMessage = null;
	String AnnouncementsMessage = null;
	String AboutMessage = null;

	@FindBy(xpath = "//span[@class='navbar-toggler-icon']")
	WebElement navigationButton;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeOption;

	@FindBy(xpath = "//h1[text()='Welcome State bank Of India']")
	WebElement textOfHomeOption;

	@FindBy(xpath = "//a[text()='Announcements']")
	WebElement AnnouncementsOption;

	@FindBy(xpath = "//h1[text()='Announcements']")
	WebElement textOfAnnouncementsOption;

	@FindBy(xpath = "//a[text()='About']")
	WebElement AboutOption;

	@FindBy(xpath = "//h1[text()='About State bank Of India']")
	WebElement textOfAboutOption;

	public WebsitePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() {
		String websitePageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the Website page has been stored.");
		return websitePageUrl;
	}

	public String getCurrTitle() {
		String websitePageTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the Website page has been stored.");
		return websitePageTitle;
	}

	public String verifyHomeoption() {
		actionDriver.implicitWait(getDriver(), 5);
		Log.info("The user has clicked on the home option.");
		actionDriver.JSClick(getDriver(), homeOption);
		Log.info("The title of the home page has been stored.");
		homeMessage = textOfHomeOption.getText().toString();
		return homeMessage;

	}

	public String verifyAnnouncementsOption() {
		Log.info("The user has clicked on the announcement option.");
		actionDriver.click(getDriver(), AnnouncementsOption);
		Log.info("The title of the announcement page has been stored.");
		AnnouncementsMessage = textOfAnnouncementsOption.getText().toString();
		return AnnouncementsMessage;
	}

	public String verifyAboutOption() {
		Log.info("The user has clicked on the about option.");
		actionDriver.click(getDriver(), AboutOption);
		Log.info("The title of the about page has been stored.");
		AboutMessage = textOfAboutOption.getText().toString();
		return AboutMessage;
	}

}
