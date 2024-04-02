package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;

public class AccountsPage extends BasePage{

	public AccountsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	
	@FindBy(xpath="//*[@title='Accounts Tab']")
	public WebElement accounts;
	
	@FindBy(name="new")
	public WebElement newbutton;
	
	@FindBy(id="acc2")
	public  WebElement accountname;
	
	@FindBy(name="save")
	public WebElement savebutton;
	
	@FindBy(linkText="Create New View")
	public WebElement createnewview;
	
	@FindBy(xpath="//*[@id='fname']")
	public WebElement viewname;
	
	@FindBy(id="devname")
	public WebElement viewuniquename;
	
	@FindBy(xpath="(//*[@value=' Save '])[1]")
	public WebElement savebutton1;
	
	@FindBy(xpath="//[@title='View:']")
	public WebElement viewnamedrpdn;
	
	@FindBy(linkText="Edit")
	public WebElement editbutton;
	
	@FindBy(className="column")
	public WebElement filterfield;
	
	@FindBy(id="fop1")
	public WebElement operator;
	
	@FindBy(id="fval1")
	public WebElement value;
	
	@FindBy(id="colselector_select_0")
	public WebElement availableflds;
	
	@FindBy(className="rightArrowIcon")
	public WebElement rightarr;
	
	@FindBy(name="save")
	public WebElement savebutton2;
	
	@FindBy(name = "go")
	public WebElement contactsPageGoButton ;
	
	@FindBy(css="#fcf")
	public WebElement contactsPageViewDropdownList;
	
	
	public boolean selectOptionInViewNameDropDown(WebDriver driver, String optionName) {
		boolean isOptionSelected = false;
		WebElement viewnamedrpdn = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
		if (viewnamedrpdn.isDisplayed()) {
			viewnamedrpdn.click();
			isOptionSelected = true;
		} else {
			System.out.println("Option " + optionName + " not selected");
		}
		return isOptionSelected;
		
	}
	
	
	
	
		public boolean isAccountstabSeen(WebDriver driver) throws IOException {
			if (accounts.isDisplayed()) {
				test.info("accounts tab is seen");
				return true;
			} else {
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				test.info("accounts tab is not seen");
				return false;
			}
		}
	
		public boolean clickOnAccounts(WebDriver driver) throws IOException {
			if (accounts.isDisplayed()) {
				accounts.click();
				test.info("accounts tab is opened");
				return true;
			} else {
				test.fail("accounts tab is not opened");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}
		
		public boolean clickOnNewButton(WebDriver driver) throws IOException {
			if (newbutton.isDisplayed()) {
				newbutton.click();
				test.info("newbutton is clicked");
				return true;
			} else {
				test.fail("newbutton is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}
		
		
		public boolean clickOnEditButton(WebDriver driver) throws IOException {
			if (editbutton.isDisplayed()) {
				editbutton.click();
				test.info("edit button is clicked");
				return true;
			} else {
				test.fail("editbutton is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
		}		
			
		public boolean enterAccountName(WebDriver driver, String accountName) throws IOException, InterruptedException {
			if (accountname.isDisplayed()) {
				accountname.clear();
				accountname.sendKeys(accountName);
				savebutton.click();
				test.info("clicked on save  button");
				return true;
			} else {
				test.fail("Account name tab is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
			return false;

		}
		
		public boolean clickOnCreateNewViewLink(WebDriver driver) throws IOException {
			if (createnewview.isDisplayed()) {
				createnewview.click();
				test.info("create new view link is clicked");
				return true;
			} else {
				test.fail("new view link is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
	}
		
		public boolean enterViewName(WebDriver driver, String viewName) throws IOException, InterruptedException {
			if (viewname.isDisplayed()) {
				viewname.clear();
				viewname.sendKeys(viewName);
				test.info("Viewname is entered");
				return true;
				}else {
			
				test.fail("view name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
			return false;
			}
		}
		
		public boolean enternewViewName(WebDriver driver, String newviewName) throws IOException, InterruptedException {
			if (viewname.isDisplayed()) {
				viewname.clear();
				viewname.sendKeys(newviewName);
				test.info("Viewname is entered");
				return true;
				}else {
			
				test.fail("view name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
			return false;
			}
		}
		
		public boolean enterViewUniqueName(WebDriver driver, String viewUniqueName) throws IOException, InterruptedException {
			if (viewuniquename.isDisplayed()) {
				viewuniquename.clear();
				viewuniquename.sendKeys("");
				savebutton1.click();
				test.info("View unique name is entered");
				return true;
				
				}else {
			
				test.fail("view unique name is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
			return false;
			}
		}
		
		public boolean selectaccnme(WebDriver driver) throws InterruptedException {
			
			   Select s1 =new Select(driver.findElement(By.className("column")));
			   
			   s1.selectByVisibleText("Account Name");
			   
			   Thread.sleep(5000);
			return true;
			   
		}
		
		public boolean selectOperator(WebDriver driver) throws InterruptedException {
		 Select s =new Select(driver.findElement(By.id("fop1")));
		   s.selectByVisibleText("contains");
		   
		   return true;
		}


		public boolean enterValue(WebDriver driver, String Value) throws IOException, InterruptedException {
			if (value.isDisplayed()) {
				value.clear();
				value.sendKeys(Value);
				test.info("value is entered");
				return true;
				}else {
			
				test.fail("value is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			
			return false;
			}
		}
		
		public boolean selectAvailFields(WebDriver driver) throws InterruptedException {
			Select s3 =new Select(driver.findElement(By.id("colselector_select_0")));
			s3.selectByVisibleText("Last Activity");
			return true;
		}
		

		public boolean clickOnRightArr(WebDriver driver) throws IOException {
			if (rightarr.isDisplayed()) {
				rightarr.click();
				test.info("right arrow is clicked");
				return true;
			} else {
				test.fail("right arrow is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
	}
		
		
		public boolean clickOnSaveButton(WebDriver driver) throws IOException {
			if (savebutton2.isDisplayed()) {
				savebutton2.click();
				test.info("save button is clicked");
				return true;
			} else {
				test.fail("savebutton is not clicked");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				return false;
			}
	}
		
		public void selectOptionInDropdown(String  value) {
			Select select = new Select(contactsPageViewDropdownList);
			select.selectByVisibleText(value);
		
		
		}
		
		
}
		

