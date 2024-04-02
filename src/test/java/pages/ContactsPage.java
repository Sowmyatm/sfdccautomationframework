package pages;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;

public class ContactsPage extends BasePage{
	
	public ContactsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
		
	}
	protected static Logger logger=LogManager.getLogger();

	
	@FindBy(xpath="//a[@title='Contacts Tab']")
	public WebElement contacts;
	
	@FindBy(name="new")
	public WebElement newbutton;
	

	@FindBy(id="name_lastcon2")
	public WebElement lastname1;
	
	
	@FindBy(name="con4")
	public WebElement accname;
	
	@FindBy(name="save")
	public WebElement savebutton;
	
	@FindBy(linkText="Create New View")
	public WebElement createnewview;
	
	@FindBy(id="fname")
	public WebElement viewname;
	
	@FindBy(name="devname")
	public WebElement viewuniqname;
	
	@FindBy(name="save")
	public WebElement savebutton1;
	
	@FindBy(xpath="//select[@id='hotlist_mode']")
	public WebElement recentlycreated;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement dropdwnbutton;
	
	@FindBy(linkText="Gowda")
	public WebElement name;
	
	@FindBy(name="devname")
	public WebElement viewuniqname1;
	
	@FindBy(name="cancel")
	public WebElement cancelbutton;
	
	@FindBy(xpath="(//input[@maxlength='80'])[1]")
	public WebElement viewuniqname2;
	
	@FindBy (id="name_lastcon2")
	public WebElement lastname;
	
	@FindBy(id="con4")
	public WebElement accountname;
	
	@FindBy(name="save_new")
	public WebElement saveandnewbutton;
	
	
	
	
	
	
//	@FindBy(name="new")
//	public WebElement newbutton;
	
	
	
	public boolean clickOnContacts(WebDriver driver) throws IOException {
		if (contacts.isDisplayed()) {
			contacts.click();
			test.info("contacts tab is clicked");
			return true;
		} else {
			test.fail("contacts tab is not clicked");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
		public boolean clickOnNewButton(WebDriver driver) throws IOException {
			if (newbutton.isDisplayed()) {
				newbutton.click();
				test.info("new button is clicked");
				return true;
			} else {
				test.fail("new button  is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				}
			}
		
	
		public boolean enterLastName1(WebDriver driver, String Lastname1) throws IOException, InterruptedException {
			if (lastname1.isDisplayed()) {
				lastname1.clear();
				lastname1.sendKeys(Lastname1);
				test.info("Last name is entered");
				return true;
					
			}else {
				
				test.fail("Last name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
				return false;	
	
			}
		
		}
		
		public boolean enterAccountName(WebDriver driver, String Accountname1) throws IOException, InterruptedException {
			if (accname.isDisplayed()) {
				accname.clear();
				accname.sendKeys(Accountname1);
				test.info("Account Name is entered");
				return true;
					
			}else {
				
				test.fail("Account Name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
				return false;	
	
			}
		}	
		
		public boolean clickOnSaveButton(WebDriver driver) throws IOException {
			if (savebutton.isDisplayed()) {
				savebutton.click();
				test.info("save button is clicked");
				return true;
			} else {
				test.fail("save button is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}
		
		public boolean clickOnCreateNewView(WebDriver driver) throws IOException {
			if (createnewview.isDisplayed()) {
				createnewview.click();
				test.info("Create New View is clicked");
				return true;
			} else {
				test.fail("Create New View is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				
			}
		}
			public boolean enterViewName(WebDriver driver, String View_name) throws IOException, InterruptedException {
				int length=10;
				Boolean useLetters=true;
				Boolean useNumbers=true;
				String generatedString= RandomStringUtils.random(length, useLetters, useNumbers);
				if (viewname.isDisplayed()) {
					viewname.clear();
					viewname.sendKeys(generatedString);
					test.info("Last name is entered");
					return true;
						
				}else {
					
					test.fail("view name is not visible");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				
					return false;	
		
				}
			}
		public boolean enterViewUniqName(WebDriver driver, String View_Uniq_name) throws IOException, InterruptedException {
			int length=10;
			Boolean useLetters=true;
			Boolean useNumbers=true;
			String generatedString= RandomStringUtils.random(length, useLetters, useNumbers);
			if (viewuniqname.isDisplayed()) {
				viewuniqname.clear();
				viewuniqname.sendKeys(generatedString);
				test.info("view unique name is entered");
				return true;
						
			}else {
					
			    test.fail("view unique name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				
				return false;	
		
				}
			}
		
		public boolean clickOnSaveButton1(WebDriver driver) throws IOException {
			if (savebutton1.isDisplayed()) {
				savebutton1.click();
				test.info("save button1 is clicked");
				return true;
			} else {
				test.fail("save button1 is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				
			}
		}
		
		public boolean selectOptionInRecentlyCreatedDropDown(WebDriver driver, String optionName) {
			boolean isOptionSelected = false;
			WebElement recentlycreated = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
			if (recentlycreated.isDisplayed()) {
				recentlycreated.click();
				isOptionSelected = true;
			} else {
				System.out.println(" not selected");
			}
			return isOptionSelected;
			
		}
		
		public boolean clickOnDropdown(WebDriver driver) throws IOException {
			if (dropdwnbutton.isDisplayed()) {
				dropdwnbutton.click();
				test.info("dropdwnbutton is clicked");
				return true;
			} else {
				test.fail("dropdwnbutton is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				
			}
		}

		public boolean selectOptionInDropDownBtton(WebDriver driver, String optionName) {
			boolean isOptionSelected = false;
			WebElement dropdwnbutton = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
			if (dropdwnbutton.isDisplayed()) {
				dropdwnbutton.click();
				isOptionSelected = true;
			} else {
				System.out.println("Option " + optionName + " not selected");
			}
			return isOptionSelected;
			
//			Select l = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
//			 l.selectByVisibleText("My Contacts");
//			return isOptionSelected;
			
			
		}

		public boolean clickOnName(WebDriver driver) throws IOException {
			if (name.isDisplayed()) {
				name.click();
				test.info("name is clicked");
				return true;
			} else {
				test.fail("name is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				
			}
		}
		
		public boolean enterViewUniqueName(WebDriver driver, String viewUniqueName) throws IOException, InterruptedException {
			if (viewuniqname1.isDisplayed()) {
				viewuniqname1.clear();
				viewuniqname1.sendKeys(viewUniqueName);
				savebutton1.click();
				test.info("View unique name is entered");
				return true;
				
				}else {
			
				test.fail("view unique name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
			return false;
			}
		}
		public boolean viewErrorMessage(WebDriver driver, String viewUniqueName) throws IOException, InterruptedException {	
		String s1="Error: You must enter a value";
		WebElement e = driver.findElement(By.xpath("//div[@class='errorMsg']"));
		if(e.getText().equals(s1)) {
			System.out.println("TC30 is passed");
			
		}else
			System.out.println("TC30  failed");
		return true;
		
		}
		
		
		public boolean clickOnCancelButton(WebDriver driver) throws IOException {
			if (cancelbutton.isDisplayed()) {
				cancelbutton.click();
				test.info("cancel button is clicked");
				return true;
			} else {
				test.fail("cancel button is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
				
			}
		}
		
		
		

		public boolean enterViewUniqueName2(WebDriver driver, String viewuniquename1) throws IOException, InterruptedException {
			if (viewuniqname2.isDisplayed()) {
				viewuniqname2.clear();
				viewuniqname2.sendKeys(viewuniquename1);
				savebutton1.click();
				test.info("View unique name is entered");
				return true;
				
				}else {
			
				test.fail("view unique name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
			return false;
			}
			
		}

			public boolean enterViewName1(WebDriver driver, String viewName1) throws IOException, InterruptedException {
				if (viewname.isDisplayed()) {
					viewname.clear();
					viewname.sendKeys(viewName1);
					savebutton1.click();
					test.info("View  name is entered");
					return true;
					
					}else {
				
					test.fail("view name is not visible");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				
				return false;
			}			
		}
			
			public boolean enterLastName(WebDriver driver, String Lastname) throws IOException, InterruptedException {
				if (lastname.isDisplayed()) {
					lastname.clear();
					lastname.sendKeys(Lastname);
					test.info("last is entered");
					return true;
						
				}else {
					
					test.fail("Account Name is not visible");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				
					return false;	
		
				}	
			}
			public boolean enterAccountName1(WebDriver driver, String Accountname) throws IOException, InterruptedException {
				if (accountname.isDisplayed()) {
					accountname.clear();
					accountname.sendKeys(Accountname);
					test.info("Account Name is entered");
					return true;
						
				}else {
					
					test.fail("Account Name is not visible");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				
					return false;	
		
				}	
			}
			
			
			public boolean clickOnSaveAndNewButton(WebDriver driver) throws IOException {
				if (saveandnewbutton.isDisplayed()) {
					saveandnewbutton.click();
					test.info("save and newbutton is clicked");
					return true;
				} else {
					test.fail("save and newbutton is not clicked");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
					return false;
				}
			}	
  
		}

		