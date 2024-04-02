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

public class LeadsPage extends BasePage{

	public  LeadsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	
	@FindBy(linkText="Leads")
	public WebElement leads;
	
	@FindBy(tagName="select")
	public WebElement leadsdrpdwn;
	
	@FindBy(linkText="Today's Leads")
	public String todaysleads;
	
	@FindBy(xpath="//input[@value=' Go! ']")
	public WebElement gobutton;
	
	@FindBy(name="new")
	public WebElement newbutton;
	
	@FindBy (id="lea3")
	public WebElement companyname;
	
	@FindBy (name="name_lastlea2")
	public WebElement lastname;
	
	@FindBy (name="save")
	public WebElement savebutton;
	
	public boolean clickOnLeadsPage(WebDriver driver) throws IOException {
		if (leads.isDisplayed()) {
			leads.click();
			test.info("leads page is opened");
			return true;
		} else {
			test.fail("leads page is not opened");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	
	public boolean clickOnSaveButton(WebDriver driver) throws IOException {
		if (savebutton.isDisplayed()) {
			savebutton.click();
			test.info("save button is opened");
			return true;
		} else {
			test.fail("save button is not opened");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
		
		public boolean enterCompanyName(WebDriver driver1, String firstName1) throws IOException{
			if (companyname.isDisplayed()) {
				companyname.clear();
			
				companyname.sendKeys(firstName1);
				test.info("companyname is entered");
				return true;
				}else {
			
				test.fail("companyname is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver1));
			
			return false;
			}
		
	
	}
		
		
		public boolean enterLasttName(WebDriver driver1, String firstName1) throws IOException{
			if (lastname.isDisplayed()) {
				lastname.clear();
			
				lastname.sendKeys(firstName1);
				test.info("lastname is entered");
				return true;
				}else {
			
				test.fail("lastname is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver1));
			
			return false;
			}
			
		}	
	
	public boolean clickOnNewButton(WebDriver driver) throws IOException {
		if (newbutton.isDisplayed()) {
			newbutton.click();
			test.info("newbutton is opened");
			return true;
		} else {
			test.fail("newbutton is not opened");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	
	}
	
	@SuppressWarnings("null")
	public boolean LeadsPageDropDown(WebDriver driver, String optionName) {
		
	 Select l = new Select(driver.findElement(By.tagName("select")));
		
     List<WebElement> m = l.getOptions();
     System.out.println("Drodown list items are: ");
     //iterate through options till list size
     for (int j = 0; j < m.size(); j++) {
        String s = m.get(j).getText();
        
        System.out.println(s);
     }
	
     driver.findElement(By.tagName("select")).click();
     Select s = null;
	s.selectByVisibleText("Today's Leads");

     
     return true;

}
//	public boolean TodaysLeads(WebDriver driver, String optionName) {
//		Select s = new Select(driver.findElement(By.tagName("select")));
//		if(s.selectByVisibleText(todaysleads)){
//		{
//			return true;
//		}else
//				return false;
//			
//		}
//	

			public boolean clickOnGo(WebDriver driver) throws IOException {
			if (gobutton.isDisplayed()) {
				gobutton.click();
				test.info("go button is opened");
				return true;
			} else {
				test.fail("go button is not opened");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		
		}
		

		
		
}
