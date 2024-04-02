package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utilities.DataUtils;
import utilities.Utilities;



/**
 * This class contains the object repository of login page
 * @author Sowmya
 *
 */



public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver,ExtentTest test) {
		
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(name="pw")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(css="#error")
	public WebElement loginError;
	
	@FindBy(id="un")
	public WebElement forgotUsername;
	
	@FindBy(linkText="Forgot Your Password?")
	public WebElement forgotPassword;
	
	
	@FindBy(name="forgotPassword")
	public WebElement forgotpasswordform;
	
	@FindBy(name="continue")
	public WebElement continueButton;
	
	@FindBy(xpath="//a[@class='primary button wide mb16']")
	public WebElement returntologinpage;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	/**
	 * This method enters the user name.call this when you are on login page
	 * @param driver webDriver type
	 * @param userName string type
	 * @return true if user name is entered
	 * @throws IOException 
	 */
	public Boolean enterUserName(WebDriver driver, String userName) throws IOException {
		if(username.isDisplayed()) {
			logger.info("username is displayed");
			username.sendKeys(userName);
			test.info("username is entered as " +username);
			return true;
		}else {
				test.fail("username element is not displayed ");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				
		}
		}
	
	public Boolean enterUsername(WebDriver driver,String userName) throws IOException {
		if (username.isDisplayed()) {
			username.sendKeys(userName);
			test.info("username is entered as "+userName);
			return true;
		} else {
			test.fail("username element is not displayed");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	
	/**
	 * This method enters the password .call this when you are on login page
	 * @param password string type
	 * @param driver webDriver type
	 * @return true if password is entered
	 * @throws IOException 
	 */
		
	public Boolean enterPassword(WebDriver driver, String pass) throws IOException {
		if(password.isDisplayed()) {
			password.sendKeys(pass);
			test.info("password is entered " + password);
			return true;
		}else {
				test.fail("password element is not displayed");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
		
		}
		
	}
	
	
	/**
	 * This method clicks on login button
	 * @param driver
	 * @return true if click is successfull
	 * @throws IOException 
	 */
	public Boolean clickonreturntologinpage(WebDriver driver) throws IOException {
		if(returntologinpage.isDisplayed()) {
			returntologinpage.click();
			test.pass("return to login page is clicked");
		
			return true;
		}else {
			test.fail("return to login page failed to click");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
	
  }
	
	
		public Boolean clickcontinue(WebDriver driver) throws IOException {
			if(continueButton.isDisplayed()) {
				continueButton.click();
				test.pass("continue Button is clicked");
			
				return true;
			}else {
				test.fail("continue Button failed to click");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
					return false;
				}
		}
		
		public Boolean clickLogin(WebDriver driver) throws IOException {
			if(loginButton.isDisplayed()) {
				loginButton.click();
				test.pass("login button is clicked");
			
				return true;
			}else {
				test.fail("login button failed to click");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
					return false;
				}
		}

	public void clearPassword() {
		test.info("Password is cleared");
		password.clear();
		
	}
	
	
	public boolean isFreeTrailSeen(WebDriver driver) throws IOException {
		test.fail("No free trial seen");
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		return false;
	}

	public boolean isSavedUsernameSeen() {
		if (savedUsername.isDisplayed()) {
			test.info("saved user name is seen");
			return true;
		} else {
			test.info("saved user name is not seen");
			return false;
		}
	}

	public String getSavedUsername() {
		return savedUsername.getText();
	}

	public boolean selectRemeberMeCheckbox() {
		boolean checkboxStatus = false;
		if (rememberMe.isSelected()) {
			checkboxStatus = true;
			test.info("remember me check box is already selected");
		} else {
			rememberMe.click();
			checkboxStatus = true;
		}
		return checkboxStatus;
	}
	
	public Boolean launchApp(WebDriver driver) throws IOException {
		driver.get(DataUtils.readAppLaunchUrl("prod.sfdc"));
		test.info("App launched");
		return true;
	}
	
	public Boolean loginToSFDC(WebDriver driver) throws IOException {
		boolean isLoginSuccess = false;
		boolean appLaunch = launchApp(driver);
		if(appLaunch) {
			enterUserName(driver, DataUtils.readAccounts("valid.username"));
			enterPassword(driver, DataUtils.readAccounts("valid.password"));
			clickLogin(driver);
			isLoginSuccess = true;
			test.pass("Logged in to SFDC");
		} else {
			test.fail("Should login in to SFDC");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver), "Login page error");
		}
		return isLoginSuccess;
	}

	public Boolean loginToSFDCinvalidusrnmepwd(WebDriver driver) throws IOException {
		boolean isLoginSuccess = false;
		boolean appLaunch = launchApp(driver);
		if(appLaunch) {
			enterUserName(driver, DataUtils.readAccounts("invalid.username"));
			enterPassword(driver, DataUtils.readAccounts("invalid.password"));
			clickLogin(driver);
			isLoginSuccess = true;
			test.pass("Logged in to SFDC");
		} else {
			test.fail("Should login in to SFDC");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver), "Login page error");
		}return isLoginSuccess;
	}
	
	

	public Boolean clickOnForgotYourPassword(WebDriver driver) throws IOException {
		if(forgotPassword.isDisplayed()) {
			forgotPassword.click();
			test.pass("Forgot Your Password is clicked");
			
			return true;
			
		}else {
			test.fail("ForgotYourPassword failed to click");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		
		
	}
	
	public Boolean forgotUsername(WebDriver driver, String userName) throws IOException {
		if(forgotUsername.isDisplayed()) {
			forgotUsername.sendKeys(userName);
			test.info("username is entered as " +username);
			return true;
		}else {
				test.fail("username element is not displayed ");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				}
				
		}
	
	
		
}

	






	
