package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.WaitConstants;

public class Utilities {

	private static String SecondTab = null;
	private static final String Firsttab = null;
	private static final String FirstTab = null;
	private static final String WebDriver = null;

	public static boolean waitForElement(WebDriver driver, WebElement element) {
		Boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.EXPLICIT_WAIT_CONSTANT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		Boolean isElementDisappeared = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.EXPLICIT_WAIT_CONSTANT);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementDisappeared = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisappeared;
	}
	
	//to take screenshot
	public static String captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String dstPath = System.getProperty("user.dir")+"\\src\\test\\java\\screenshots\\"+dateFormat+"_sfdc.PNG";
		File dstFile = new File(dstPath);
		FileUtils.copyFile(sourceFile, dstFile);
		return dstPath;
	}
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public static void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static String windowHandles(WebDriver driver, String string) {
		
		Set<String>WindowsID=driver.getWindowHandles();
		Iterator<String>itr=WindowsID.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			SecondTab=itr.next();
		}
		driver.switchTo().window(SecondTab);
		driver.findElement(By.xpath("//*[@id='editors-body']")).click();
		driver.close();
		//driver.switchTo().window(FirstTab);
		return SecondTab;
		
	}
		public static void jsscroll(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700);");
	}
		
		
		public static WebElement fluentlyWait(WebElement element, WebDriver driver) {
			
			Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(30))
					.ignoring(NoSuchElementException.class);
			
			WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return element;
				}
			});
			
			return ele;
			
		}
		
			
}

	

