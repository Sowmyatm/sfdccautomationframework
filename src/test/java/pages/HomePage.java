package pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
		
	}
	protected static Logger logger=LogManager.getLogger();


	
	@FindBy(linkText="Sowmya Abcd")
	public WebElement fnamelname;
	
	@FindBy(xpath="//img[@title='Edit Profile'][1]")
	public WebElement editprofile;
	
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	public WebElement iframe;
	
	@FindBy(xpath="//input[@value='Save All']")
	public WebElement saveall;
	
	
	
	
	
	
	
	public boolean clickOnFnameLname(WebDriver driver) throws IOException {
		if (fnamelname.isDisplayed()) {
			fnamelname.click();
			test.info("Fname lname is clicked");
			return true;
		} else {
			test.fail("Fname lname is not clicked");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	public boolean clickOnEditProfile(WebDriver driver) throws IOException, InterruptedException {
		if (editprofile.isDisplayed()) {
			editprofile.click();
			test.info("edit profile is clicked");
			return true;
		} else {
			test.fail("edit profile is not clicked");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			//return false;
		}
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("About")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("lastName")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("lastName")).sendKeys("Abcd");
		Thread.sleep(3000);
		return false;
	}
	
	public boolean clickOnSaveAllButton(WebDriver driver) throws IOException {
		if (saveall.isDisplayed()) {
			saveall.click();
			test.info("save all button is clicked");
			return true;
		} else {
			test.fail("save all button is not clicked");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			

			WebElement e = driver.findElement(By.linkText("Sowmya Abcd"));
			if(e.isDisplayed()) {
			System.out.println("TC34 Passed");
			}else
				System.out.println("TC34 failed");
			return false;
		}
	}
}

