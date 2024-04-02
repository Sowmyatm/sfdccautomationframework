package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;

public class OpportunitiesPage extends BasePage{


	public  OpportunitiesPage(WebDriver driver, ExtentTest test) {
			PageFactory.initElements(driver, this);
			this.test = test;
		}
		
		
		
		@FindBy(xpath="//a[@title='Opportunities Tab']")
		public WebElement opportunities;
		
		@FindBy(id="fcf") 
		public List<WebElement>oppodrpdwnOptions;
		
		@FindBy(linkText="Opportunity Pipeline")
		public WebElement opporpipeline;
		
		@FindBy(linkText="Stuck Opportunities")
		public WebElement stuckoppor;
		
		@FindBy(xpath="//select[@id='quarter_q']")
		public WebElement currentnextfq;
		
		@FindBy(xpath="//select[@id='open']")
		public WebElement openoppor;
		
		@FindBy(xpath="//input[@value='Run Report']")
		public WebElement runreport;
		
		
		public boolean clickOnOpportunities(WebDriver driver) throws IOException {
			if (opportunities.isDisplayed()) {
				opportunities.click();
				test.info("opportunities tab is opened");
				return true;
			} else {
				test.fail("opportunities tab is not opened");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}
		
		public boolean selectOptionInOpportunitiesDropDown(WebDriver driver, String optionName) {
			//boolean isOptionSelected = false;
			WebElement oppodrpdwn = driver.findElement(By.id("fcf"));
			if (oppodrpdwn.isDisplayed()) {
				oppodrpdwn.click();
				//isOptionSelected = true;
			} 
//			else {
//				System.out.println("Option " + optionName + " not selected");
//			}
			return true;
			
		}
		
		public boolean clickOnOpporPipeLine(WebDriver driver) throws IOException {
			if (opporpipeline.isDisplayed()) {
				opporpipeline.click();
				test.info("opportunities pipeline is clicked");
				return true;
			} else {
				test.fail("opportunities pipeline is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}
		
		public boolean clickOnStuckOppor(WebDriver driver) throws IOException {
			if (stuckoppor.isDisplayed()) {
				stuckoppor.click();
				test.info("stuck opportunities is clicked");
				return true;
			} else {
				test.fail("stuck opportunities is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}
		
		
		public boolean selectCurrentNextfq(WebDriver driver) throws InterruptedException {
			
			Select select=new Select(driver.findElement(By.xpath("//select[@id='quarter_q']")));
			select.selectByVisibleText("Current and Next FQ");
			return true;
	}
		
		
		public boolean selectOpenOppor(WebDriver driver) throws InterruptedException {
		
			Select select1=new Select(driver.findElement(By.xpath("//select[@id='open']")));
			select1.selectByVisibleText("Open Opportunities");
			return true;
		}	
		
		
		public boolean clickOnRunReport(WebDriver driver) throws IOException {
			if (runreport.isDisplayed()) {
				runreport.click();
				test.info("Run Report is clicked");
				return true;
			} else {
				test.fail("Run Report is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}		
		}
		
		
}



