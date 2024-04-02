package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constants.FileConstants;
import pages.AccountsPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.OpportunitiesPage;
import pages.UserMenuPage;
import utilities.DataUtils;
import utilities.Utilities;

public class LoginTest extends BaseTest{
	
	private static final String MySettings = null;
	private static final WebDriver Webdriver = null;


	//@SuppressWarnings("null")
	@Test
	public void TC1(Method name) throws IOException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("Test started" + name.getName());
		WebDriver driver=BaseTest.getDriver();
		LoginPage lopge = new LoginPage(driver, test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		
		
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		
		lopge.clearPassword();
		
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		
		Assert.assertEquals(lopge.loginError.getText(),DataUtils.readErrorMessages("login.error.message"));
		
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		logger.info("Test Ended" + name.getName());
	}
	
	@Test
	public void TC2(Method name) throws IOException {
		
		ExtentTest test=extent.createTest(name.getName());
		WebDriver driver=BaseTest.getDriver();
		LoginPage lopge = new LoginPage(driver, test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(lopge.enterPassword(driver, DataUtils.readAccounts("valid.password")),"password should be entered");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(lopge.isFreeTrailSeen(driver),"Free trial should be seen");
		
	}
	
	@Test
	public void TC3() throws IOException {
		ExtentTest test=extent.createTest("TC3");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		
		UserMenuPage ump = new UserMenuPage(driver,test);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		Assert.assertTrue(lopge.selectRemeberMeCheckbox(),"Should select rememberme checkbox");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"User menu page should open");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");
		Utilities.waitForElement(driver, lopge.savedUsername);
		Assert.assertEquals(lopge.getSavedUsername(), DataUtils.readAccounts("valid.username"));
		
	}
	
	@Test
	public void TC4A() throws IOException, InterruptedException {
		ExtentTest test=extent.createTest("TC4A");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		
		//UserMenuPage ump = new UserMenuPage(driver,test);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.clickOnForgotYourPassword(driver),"Forgot Your Password? is displayed");
		Thread.sleep(5000);		
		
		Assert.assertTrue(lopge.forgotUsername(driver,DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.clickcontinue(driver), "Continue button should be clicked");
		
		
		Assert.assertTrue(lopge.clickonreturntologinpage(driver),"Return to login page should display");
	}
	
	@Test
	public void TC4B() throws IOException, InterruptedException {
		ExtentTest test=extent.createTest("TC4B");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		
		//UserMenuPage ump = new UserMenuPage(driver,test);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("invalid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("invalid.password")),"password should be entered");
		
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
	
		Assert.assertEquals(lopge.loginError.getText(),DataUtils.readErrorMessages("login.error.message1"));
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
	}
	
	@Test
	public void TC5() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("TC5");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(ump.isUserMenuSeen(driver),"User menu should be displayed");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"User menu page should open");
		Thread.sleep(3000);
		
		
	}
	
	
	//not working
	@Test
	public void TC6() throws IOException, InterruptedException{
		
		ExtentTest test = extent.createTest("myProfile_TC06");
		WebDriver driver = BaseTest.getDriver();
		LoginPage lopge = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver, test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"Should open user menu");
		Assert.assertTrue(ump.verifyUserMenuItems(),"Should match user menu options");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "My Profile"));
		Assert.assertTrue(ump.openEditProfileModal(driver),"Should open edit profile popup");
		Assert.assertTrue(ump.changeLastNameInAboutTab(driver, "ABCD"),"");
		Assert.assertTrue(ump.createAPost(driver, "Hello JAVA"),"Should create post");
		Assert.assertTrue(ump.uploadAFile(driver, FileConstants.FILE_UPLOAD_PATH),"Should upload a file");
		Assert.assertTrue(ump.uploadPhoto(driver, FileConstants.PHOTO_UPLOAD_PATH));
			
	}
	
	//not working
	@Test
	public void TC7() throws IOException, InterruptedException {
		ExtentTest test=extent.createTest("TC7");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(ump.isUserMenuSeen(driver),"User menu should be displayed");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"User menu page should open");
		Thread.sleep(3000);
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver,"My Settings"),"MySettings should be clicked");
		Thread.sleep(3000);
		Assert.assertTrue(ump.clickOnDisplayLayout(driver),"Display Layout should be clicked");
		Assert.assertTrue(ump.selectOptionInDisplayandLayout(driver, "Customize My Tabs"),"Customize my tabs should be selected");
		Assert.assertTrue(ump.selectOptionIncustomApp(driver, "Salesforce Chatter"),"Salesforce chatter should be selected");
		Thread.sleep(3000);
		
		Assert.assertTrue(ump.selectOptionReports(driver, "Reports"),"Reports should be selected");
		Thread.sleep(3000);
		//Assert.assertTrue(ump.clickOntabSave(driver),"save button should be clicked");
		Thread.sleep(3000);
	}
	
	
	//not working
	@Test
	public void TC8() throws IOException, InterruptedException {
		ExtentTest test=extent.createTest("TC8");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"User menu page should open");
		Thread.sleep(3000);
		Assert.assertTrue(ump.selectOptionDevloperConsole(driver, "Developer Console"),"Developer Console should be selected");
		Thread.sleep(3000);
//		Assert.assertTrue(ump.selectOptionDevloperConsole(driver, driver.close());
//		//Assert.assertTrue(ump.selectOptionDevloperConsole(driver, Utilities.windowHandles(driver, "closebutton")), "Move to sencond window");
//		Thread.sleep(3000);
//		
		
	}
	
	
	@Test
	public void TC9() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("TC9");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"User menu page should open");
		Thread.sleep(3000);
		//Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");
		//Assert.assertTrue(ump.verifyUserMenuItems());
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");
	}
	
	
	
	//Assertequals need to be corrected
	@Test
	public void TC10() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("TC10");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		AccountsPage accpg =new AccountsPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(accpg.clickOnAccounts(driver),"Accounts tab should be clicked");
		Assert.assertTrue(accpg.clickOnNewButton(driver),"New button shoulb be clicked");
		Thread.sleep(3000);
		Assert.assertTrue(accpg.enterAccountName(driver,DataUtils.readAccounts("account.name")),"account name should be entered");
		//Assert.assertEquals(DataUtils.readAccounts("account.name"), driver.getTitle());
		
	}
	
	
	@Test
	public void TC11() throws IOException, InterruptedException {
			
			ExtentTest test=extent.createTest("TC11");
			WebDriver driver=BaseTest.getDriver();
			
			LoginPage lopge = new LoginPage(driver, test);
			AccountsPage accpg =new AccountsPage(driver,test);
			//UserMenuPage ump = new UserMenuPage(driver,test);
			Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
			Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
			Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
			
			Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
			Assert.assertTrue(accpg.clickOnAccounts(driver),"Accounts tab should be clicked");
			
			Assert.assertTrue(accpg.clickOnCreateNewViewLink(driver),"New view link should be clicked");
			Assert.assertTrue(accpg.enterViewName(driver, DataUtils.readAccounts("view.name")),"View name should be eneterd");
			Assert.assertTrue(accpg.enterViewUniqueName(driver, DataUtils.readAccounts("view.unique.name")),"unique name should be enetered");
			Thread.sleep(3000);
	}
	
	
	
	@Test
	
	public void TC12() throws IOException, InterruptedException {
			
			ExtentTest test=extent.createTest("TC12");
			WebDriver driver=BaseTest.getDriver();
			
			LoginPage lopge = new LoginPage(driver, test);
			AccountsPage accpg =new AccountsPage(driver,test);
			//UserMenuPage ump = new UserMenuPage(driver,test);
			Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
			Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
			Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
			Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
			Assert.assertTrue(accpg.clickOnAccounts(driver),"Accounts tab should be clicked");
			
			
//			Assert.assertTrue(accpg.selectOptionInViewNameDropDown(driver, "View Name"),"View name should be displayed");
//			Thread.sleep(3000);
			
			Assert.assertTrue(accpg.clickOnEditButton(driver),"Edit button should be clicked");
			Assert.assertTrue(accpg.enterViewName(driver, DataUtils.readAccounts("new.view.name")),"New View name should be eneterd");
			Thread.sleep(3000);
			
			Assert.assertTrue(accpg.selectaccnme(driver),"Account name should be selected");
			Assert.assertTrue(accpg.selectOperator(driver),"Contains should be selected");
			Assert.assertTrue(accpg.enterValue(driver, DataUtils.readAccounts("value")),"value should be entered");
	
			Assert.assertTrue(accpg.clickOnRightArr(driver),"right arrow should be clicked");
			Assert.assertTrue(accpg.clickOnSaveButton(driver),"Save button should be clicked");
			
	}
	
	@Test
	public void TC15() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("TC15");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		
		Assert.assertTrue(oppo.clickOnOpportunities(driver),"opportunities tab is clicked");
		Assert.assertTrue(oppo.selectOptionInOpportunitiesDropDown(driver, "oppodrpdwnOptions"));
		Thread.sleep(3000);
		
	}
	
	//Needto be completed
	
	@Test
	public void TC16() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("TC16");
		WebDriver driver=BaseTest.getDriver();
		
		LoginPage lopge = new LoginPage(driver, test);
		OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		
		Assert.assertTrue(oppo.clickOnOpportunities(driver),"opportunities tab is clicked");
		
		
		
		
	}
	
		@Test
		public void TC17() throws IOException, InterruptedException {
				
				ExtentTest test=extent.createTest("TC17");
				WebDriver driver=BaseTest.getDriver();
				
				LoginPage lopge = new LoginPage(driver, test);
				OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
				//UserMenuPage ump = new UserMenuPage(driver,test);
				Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
				Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
				Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
				
				Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
				
				Assert.assertTrue(oppo.clickOnOpportunities(driver),"opportunities tab is clicked");
				Assert.assertTrue(oppo.clickOnOpporPipeLine(driver),"opportunities pipeline is clicked");
				Thread.sleep(3000);
			
		}
		
		
		@Test
		public void TC18() throws IOException, InterruptedException {
			
			ExtentTest test=extent.createTest("TC18");
			WebDriver driver=BaseTest.getDriver();
			
			LoginPage lopge = new LoginPage(driver, test);
			OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
			//UserMenuPage ump = new UserMenuPage(driver,test);
			Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
			Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
			Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
			
			Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
			
			Assert.assertTrue(oppo.clickOnOpportunities(driver),"opportunities tab should be clicked");
			Assert.assertTrue(oppo.clickOnStuckOppor(driver),"Stuck opportunities link should be clicked");
			Thread.sleep(3000);
		}
		
			@Test
			public void TC19() throws IOException, InterruptedException {
						
			ExtentTest test=extent.createTest("TC19");
			WebDriver driver=BaseTest.getDriver();
						
			LoginPage lopge = new LoginPage(driver, test);
			OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
			//UserMenuPage ump = new UserMenuPage(driver,test);
			Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
			Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
			Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
						
			Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
						
			Assert.assertTrue(oppo.clickOnOpportunities(driver),"opportunities tab should be clicked");
			Assert.assertTrue(oppo.selectCurrentNextfq(driver),"Current and next fq should be selected");
			Thread.sleep(3000);
			Assert.assertTrue(oppo.selectOpenOppor(driver),"open opportunities should be clicked");
			Thread.sleep(3000);
			Assert.assertTrue(oppo.clickOnRunReport(driver),"Run Report should be clicked");
			Thread.sleep(3000);
			
			String expectedstring = "Opportunity Report ~ Salesforce - Developer Edition";
			String actual = driver.getTitle();
			Assert.assertEquals(actual, expectedstring);
			
		}
			@Test
			public void TC20() throws IOException, InterruptedException {
				
				ExtentTest test=extent.createTest("TC20");
				WebDriver driver=BaseTest.getDriver();
							
				LoginPage lopge = new LoginPage(driver, test);
				LeadsPage leads=new LeadsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
				//UserMenuPage ump = new UserMenuPage(driver,test);
				Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
				Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
				Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
							
				Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
				
				Assert.assertTrue(leads.clickOnLeadsPage(driver),"Leads page should be clicked");
				String actual=driver.getTitle();
				String expected="Leads: Home ~ Salesforce - Developer Edition";
				Assert.assertEquals(actual, expected);
				
			}
			
			@Test
			public void TC21() throws IOException, InterruptedException {
				
				ExtentTest test=extent.createTest("TC21");
				WebDriver driver=BaseTest.getDriver();
							
				LoginPage lopge = new LoginPage(driver, test);
				LeadsPage leads=new LeadsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
				//UserMenuPage ump = new UserMenuPage(driver,test);
				Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
				Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
				Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
							
				Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
				
				Assert.assertTrue(leads.clickOnLeadsPage(driver),"Leads page should be clicked");
				Assert.assertTrue(leads.LeadsPageDropDown(driver, "LeadsPageDropDown"),"leads dropdown should be displayed");
				Thread.sleep(3000);
			
			}
			
			@Test
			public void TC22() throws IOException, InterruptedException {
				
				ExtentTest test=extent.createTest("TC22");
				WebDriver driver=BaseTest.getDriver();
							
				LoginPage lopge = new LoginPage(driver, test);
				LeadsPage leads=new LeadsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
				UserMenuPage ump = new UserMenuPage(driver,test);
				Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
				Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
				Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
							
				Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
				
				Assert.assertTrue(leads.clickOnLeadsPage(driver),"Leads page should be clicked and todays leads should get selected");
				Assert.assertTrue(ump.clickOnUserMenu(driver),"user menu should be displayed");
				Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");
				Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
				Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");				
				Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
				Assert.assertTrue(leads.clickOnLeadsPage(driver),"Leads page should be clicked and todays leads should be displayed");
				Assert.assertTrue(leads.clickOnGo(driver),"Go button should be clicked");
				String expected= "Leads ~ Salesforce - Developer Edition";
				String actual =driver.getTitle();
				Assert.assertEquals(actual, expected);
				Thread.sleep(3000);
			}
	
	@Test
	public void TC23() throws IOException, InterruptedException {
				
		ExtentTest test=extent.createTest("TC23");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		LeadsPage leads=new LeadsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
							
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
				
		Assert.assertTrue(leads.clickOnLeadsPage(driver),"Leads page should be clicked and todays leads should be displayed");
		Thread.sleep(3000);
		
	}
	
	
	@Test
	public void TC24() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("TC24");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		LeadsPage leads=new LeadsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
							
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(leads.clickOnLeadsPage(driver),"Leads page should be clicked");
		
		Assert.assertTrue(leads.clickOnNewButton(driver),"new button should be clecked");
		Assert.assertTrue(leads.enterLasttName(driver, DataUtils.readAccounts("last.name")),"last name should be enetred");
		Assert.assertTrue(leads.enterCompanyName(driver, DataUtils.readAccounts("company.name") ),"company name should be entered");
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		Assert.assertTrue(leads.clickOnSaveButton(driver),"save button should be clicked)");
	}	
	
	@Test
	public void TC25(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");	
		Assert.assertTrue(contact.clickOnNewButton(driver),"New button should be clicked");
		logger.info("New button is clicked");
		Assert.assertTrue(contact.enterLastName1(driver, DataUtils.readAccounts("last.name1")),"last name should be entered");
		logger.info("Last name is entered");
		Assert.assertTrue(contact.enterAccountName(driver, DataUtils.readAccounts("account.name1")),"Account name should be entered");
		logger.info("Account name is entered");
		Assert.assertTrue(contact.clickOnSaveButton(driver),"Save button should be clicked");
		logger.info("Save button is clicked");
		Thread.sleep(3000);
		String expected ="Contact: Gowda ~ Salesforce - Developer Edition";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		logger.info("Actual string matches with the expected string");
		logger.info("*************Test ended********************");
		
		
	}	
	//generate random 
	@Test
	public void TC26(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");	
		Assert.assertTrue(contact.clickOnCreateNewView(driver),"create new view link should be clicked");
		logger.info("create new view is clicked");
		
		int length=10;
		Boolean useLetters=true;
		Boolean useNumbers=true;
		String generatedString= RandomStringUtils.random(length, useLetters, useNumbers);
		Assert.assertTrue(contact.enterViewName(driver, DataUtils.readAccounts(generatedString)),"view name should be entered");
		Thread.sleep(3000);
		logger.info("view name is entered");
		
		Assert.assertTrue(contact.enterViewUniqName(driver, DataUtils.readAccounts(generatedString)),"view unique name should be entered");
		logger.info("view unique name is entered");
		Thread.sleep(3000);
		Assert.assertTrue(contact.clickOnSaveButton1(driver),"Save button1 should be clicked");
		logger.info("Save button1 is clicked");
		Thread.sleep(3000);
		String expected="Contacts ~ Salesforce - Developer Edition";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		logger.info("****************Test ended*******************");
		
	}
	
	
	@Test
	public void TC27(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");
		
		Assert.assertTrue(contact.selectOptionInRecentlyCreatedDropDown(driver, "recently created dropdrown is displayed"));
		Thread.sleep(3000);
		
	}
	
	//table handling and fluent wait
	@Test
	public void tableHandling() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = extent.createTest("loginToSF_TC02");
		LoginPage lp = new LoginPage(driver, test);
		AccountsPage ap = new AccountsPage(driver, test);
		
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver,DataUtils.readAccounts("valid.username")), "user name should be entered");
		Assert.assertTrue(lp.enterPassword(driver, DataUtils.readAccounts("valid.password")), "password should be entered");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(2000);
		ap.selectOptionInDropdown("My Contacts");
		ap.contactsPageGoButton.click();
		Thread.sleep(3000);
//		//thead/tr/td[6]
		
		for(int i=4; i<=7; i++) {
				String name = driver.findElement(By.xpath("//thead/tr/td["+i+"]")).getText();
				System.out.print(name+"    ");
			
		}
		
		for(int i=1; i<=20; i++) {
			for(int j=4; j<=7; j++) {
				String name = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])["+i+"]//tr//td["+j+"]")).getText();
				System.out.print(name+"    ");
			}
			System.out.println();
		}
		
		Utilities.fluentlyWait(ap.contactsPageGoButton, driver).click();
		
	}
	
	@Test(dataProvider="login test data")
	public void loginToSFDC(String username, String pass) throws IOException {
		WebDriver driver =BaseTest.getDriver();
		ExtentTest test=extent.createTest("loginToSFDC");
		LoginPage lopge = new LoginPage(driver, test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, username),"user name should be entered");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(lopge.enterPassword(driver, pass),"password should be entered");
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		
	}
	
	@DataProvider(name="login test data")
	public Object[][] loginCreds(){
		return new Object[][] {
			{"nov22.sowmyatm@gmail.com","Sowmyatm@123"},
			{"xyz@abc.com", "ty12"}};
					
		}
	
	
	@DataProvider(name="login test accounts")
	public Object[][] loginAccounts(){
		return new Object[][] {
			{"nov22.sowmyatm@gmail.com","Sowmyatm@123"},
			{"xyz@abc.com", "ty12"}};
					
		}
	
	
	@Test
	public void TC28(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");
		Assert.assertTrue(contact.clickOnDropdown(driver),"Dropdown button should be clicked");
		Thread.sleep(3000);
		logger.info("Dropdown is clicked");
		Assert.assertTrue(contact.selectOptionInDropDownBtton(driver, "My Contacts"),"My contacts should be selected");
		Thread.sleep(3000);
		logger.info("****************Test ended*******************");
		
	}
	
	
	@Test
	public void TC29(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");
		Assert.assertTrue(contact.clickOnName(driver),"Name should be clicked");
		Thread.sleep(3000);
		logger.info("name link is clicked");
		String expected="Contact: Gowda ~ Salesforce - Developer Edition";
		String Actual=driver.getTitle();
		Assert.assertEquals(Actual, expected);
		logger.info("actual string matches with expected string");
		logger.info("****************Test ended*******************");
		
	}	
	
	@Test
	public void TC30(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");
		Assert.assertTrue(contact.clickOnCreateNewView(driver),"Create new view link should be clicked");
		logger.info("Create new link should be clicked");
		Assert.assertTrue(contact.enterViewUniqueName(driver, DataUtils.readAccounts("view.uniq.name")),"unique name should be entered");
		Thread.sleep(5000);
		logger.info("unique name should be entered");
		
		Assert.assertTrue(contact.clickOnSaveButton1(driver),"save button should be clicked");
		logger.info("save button should be clicked");
		Thread.sleep(3000);
//		String expected ="Error: You must enter a value";
		
				

//				String s1="Error: You must enter a value";
//				WebElement e = driver.findElement(By.xpath("//div[@class='errorMsg']"));
//				if(e.getText().equals(s1)) {
//					System.out.println("TC30 is passed");
//					
//				}else
//					System.out.println("TC30  failed");
		Assert.assertTrue(contact.viewErrorMessage(driver, "error message should be displayed"));	
		logger.info("error message should be displayed");
		Thread.sleep(3000);
		logger.info("****************Test ended*******************");
		
	}
	
	@Test
	public void TC31(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");
		Assert.assertTrue(contact.clickOnCreateNewView(driver),"Create new view link should be clicked");
		logger.info("Create new link is clicked");
		Assert.assertTrue(contact.enterViewName1(driver, DataUtils.readAccounts("view.name1")),"view name should be entered");
		logger.info("view name is entered");
		Assert.assertTrue(contact.enterViewUniqueName2(driver, DataUtils.readAccounts("viewuniquename1")),"unique name should be entered");
		Thread.sleep(5000);
		logger.info("unique name is entered");
		Thread.sleep(3000);
		Assert.assertTrue(contact.clickOnCancelButton(driver),"Cancel button should be clicked");
		logger.info("cancel button is clicked");
		String expected ="Contacts: Home ~ Salesforce - Developer Edition";
		String actual =driver.getTitle();
		Assert.assertEquals(actual, expected);
		logger.info("Actual string matches with expected string");
		logger.info("****************Test ended*******************");
		
		
	}
	
	
	@Test
	public void TC32(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		//LeadsPage leads=new LeadsPage(driver,test);
		ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(contact.clickOnContacts(driver),"Contacts tab should be clicked");
		logger.info("Contacts tab is clicked");
		Assert.assertTrue(contact.clickOnNewButton(driver),"new button should be clicked");
		logger.info("new button is clicked");
		Assert.assertTrue(contact.enterLastName(driver, DataUtils.readAccounts("last.name2")));
		logger.info("last name is entered");
		Assert.assertTrue(contact.enterAccountName1(driver, DataUtils.readAccounts("account.name2")));
		logger.info("account name is entered");
		Thread.sleep(3000);
		Assert.assertTrue(contact.clickOnSaveAndNewButton(driver),"Save and new button should be clicked");
		logger.info("Save and new button is clicked");
		String expected="Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		logger.info("actual string matches with expected string");
		logger.info("****************Test ended*******************");
		
	}
	
	@Test
	public void TC33(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		HomePage home=new HomePage(driver,test);
		//LeadsPage leads=new LeadsPage(driver,test);
		//ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(home.clickOnFnameLname(driver),"Fname Lname should be clicked");
		logger.info("Fname Lname is clicked");
		Thread.sleep(3000);
		String expected="User: Sowmya Abcd ~ Salesforce - Developer Edition";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		logger.info("Actual matches with the expected string");
		logger.info("****************Test ended*******************");
		
	}
	
	//Check it again
	@Test
	public void TC34(Method name) throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest(name.getName());
		logger.info("****************Test started*******************");
		WebDriver driver=BaseTest.getDriver();
							
		LoginPage lopge = new LoginPage(driver, test);
		HomePage home=new HomePage(driver,test);
		//LeadsPage leads=new LeadsPage(driver,test);
		//ContactsPage contact = new ContactsPage(driver,test);
				//OpportunitiesPage oppo =new OpportunitiesPage(driver,test);
		//UserMenuPage ump = new UserMenuPage(driver,test);
		Assert.assertTrue(lopge.launchApp(driver),"It should launch salesforceapp");
		Assert.assertTrue(lopge.enterUserName(driver, DataUtils.readAccounts("valid.username")),"user name should be entered");
		logger.info("Username is entered");
		Assert.assertTrue(lopge.enterPassword(driver,DataUtils.readAccounts("valid.password")),"password should be entered");
		logger.info("Password is entered");				
		Assert.assertTrue(lopge.clickLogin(driver),"Login button should be clicked");
		Assert.assertTrue(home.clickOnFnameLname(driver),"Fname Lname should be clicked");
		logger.info("Fname Lname is clicked");
		Thread.sleep(3000);
		Assert.assertTrue(home.clickOnEditProfile(driver),"Edit profile link should be clicked");
		logger.info("Edit profile link is clicked");
		Assert.assertTrue(home.clickOnSaveAllButton(driver),"save all button should be clicked");
		logger.info("Edit profile link is clicked");
		logger.info("****************Test ended*******************");
		
	}
	
}

//Assert.assertTrue(contact.selectOptionInDropDownBtton(driver, "My Contacts should be selectd"));
//Thread.sleep(3000);
