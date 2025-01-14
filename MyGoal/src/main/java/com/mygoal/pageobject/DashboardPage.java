package com.mygoal.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mygoal.actiondriver.ActionDriver;
import com.mygoal.baseclass.BaseClass;
import com.mygoal.utility.Log;

public class DashboardPage extends BaseClass {
	

	ActionDriver actionDriver = new ActionDriver();
 
	@FindBy(css = "a.nav-link.tree-item.nav-accounts.nav-transactions.nav-manage_account")
	WebElement accountManagement;
	
	@FindBy(xpath = "//a[@href='./?page=accounts/manage_account']")
	WebElement newAccount;
	
	@FindBy(xpath = "//a[@href='./?page=accounts']")
	WebElement manageAccount;
	
	@FindBy(css = "a.nav-link.tree-item.nav-transaction.nav-deposit.nav-withdraw.nav-transfer")
	WebElement transaction;
	
	@FindBy(xpath = "//a[@href='./?page=transaction']")
	WebElement allTransactionHistory;
	
	@FindBy(xpath = "//a[@href='./?page=transaction/deposit']")
	WebElement deposite;
	
	@FindBy(xpath = "//a[@href='./?page=transaction/withdraw']")
	WebElement withdrow;
	
	@FindBy(xpath = "//a[@href='./?page=transaction/transfer']")
	WebElement transfer;
	
	@FindBy(xpath = "//a[@href='http://localhost/banking/admin/?page=announcements']")
	WebElement announcment;
	
	@FindBy(xpath = "//a[@href='http://localhost/banking/admin/?page=system_info']")
	WebElement Setting;
	
		
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public String getCurrURL() {
		String dashboardPageUrl = actionDriver.getCurrentURL(getDriver());
		Log.info("The URL of the dashboardPageUrl page has been stored.");
		return dashboardPageUrl;
	}
	
	public String getCurrTitle() {
		String dashboardPageUrlTitle = actionDriver.getTitle(getDriver());
		Log.info("The URL of the Dashboard page has been stored.");
		return  dashboardPageUrlTitle;
	}
	
	public String verifyAccountManagementClickFunctionality()
	{   
		Log.info("User is clicking on Account Management Option");
		actionDriver.click(getDriver(), accountManagement);
		Log.info("collect the text for verify the Account management option is clicked or not");
		String accountManagementText=newAccount.getText().toString();
		return accountManagementText;
		
	}
	public NewAccountPage verifyNewAccountClickFunctionality()
	{
		Log.info("User is clicking on Account Management Option");
		actionDriver.click(getDriver(), accountManagement);
		Log.info("User is clicking on New Account Option");
        actionDriver.click(getDriver(), newAccount);
        NewAccountPage newAccountPage = new NewAccountPage();
        return newAccountPage;
	}
	
	public ManageAccountPage verifyManagementAccountClickFunctionality()
	{
		Log.info("User is clicking on Account Management Option");
		actionDriver.click(getDriver(), accountManagement);
		Log.info("User is clicking on Manage Account Option");
        actionDriver.click(getDriver(), manageAccount);
        ManageAccountPage manageAccountPage = new ManageAccountPage();
        return manageAccountPage;
	}
	
	public String verifyTransactionClickFunctionality()
	{
		Log.info("User is clicking on Transactions Option");
		actionDriver.click(getDriver(), transaction);
		Log.info("collect the text for verify the transaction option is clicked or not");
		String accountManagementText=allTransactionHistory.getText().toString().trim();
		return accountManagementText;
		
	}
	public TransactionPage verifyTransactionHistoryClickFunctionality()
	{
		Log.info("User is clicking on Transactions Option");
		actionDriver.click(getDriver(), transaction);
		Log.info("User is clicking on all transaction Option");
        actionDriver.click(getDriver(), allTransactionHistory);
        TransactionPage transactionPage = new TransactionPage();
        return transactionPage;
		
	}
	public DepositPage verifyDepositClickFunctionality()
	{
		Log.info("User is clicking on Transactions Option");
		actionDriver.click(getDriver(), transaction);
		Log.info("User is clicking on deposit Option");
        actionDriver.click(getDriver(), deposite);
        DepositPage depositPage = new DepositPage();
        return depositPage;
	}
	public WithdrowPage verifyWithdrowClickFunctionality()
	{
		Log.info("User is clicking on Transactions Option");
		actionDriver.click(getDriver(), transaction);
		Log.info("User is clicking on withdrow Option");
        actionDriver.click(getDriver(), withdrow);
        WithdrowPage withdrowPage = new WithdrowPage();
        return withdrowPage;
		
	}
	public TransferPage verifyTransferClickFunctionality()
	{
		Log.info("User is clicking on Transactions Option");
		actionDriver.click(getDriver(), transaction);
		Log.info("User is clicking on transfer Option");
        actionDriver.click(getDriver(), transfer);
        TransferPage transferPage = new TransferPage();
        return transferPage;
	}
	public AnnouncementPage verifyAnnouncmentClickFunctionality()
	{
		
		Log.info("User is clicking on announcment Option");
        actionDriver.click(getDriver(), announcment);
        AnnouncementPage announcementPage = new AnnouncementPage();
        return announcementPage;
	}
	public SettingPage verifySettingClickFunctionality()
	{
		
		Log.info("User is clicking on setting Option");
        actionDriver.click(getDriver(), Setting);
        SettingPage settingPage = new SettingPage();
        return settingPage;
	}
	

}
