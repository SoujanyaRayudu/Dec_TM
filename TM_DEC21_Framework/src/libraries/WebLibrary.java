package libraries;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.DriverClass;
import reports.Generate_Reports;

public class WebLibrary extends DriverClass {

	static boolean status;
	
	/*
	 * Method Name : File Upload
	 * 
	 * Description : This method is used to upload the file
	 * 
	 * Input: driver
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 */
	public boolean fileUpload(WebElement element, String path) {
		try {
		element.sendKeys(path);
		status = true;
		}
		catch(Exception e) {
			status = false;
		}
		return status;
		
	}
	

	/*
	 * Method Name : launchApplication
	 * 
	 * Description : This method is used to open the URL
	 * 
	 * Input:: driver
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 */
	public boolean launchApplication(String URL) {

		try {
			driver.get(URL);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	public static void selectByVisibleText(WebElement element, Object text) {

		try {
//		WebElement element = driver
//				.findElement(By.xpath("//*[@id='applyleave_txtLeaveType']"));
////		WebElement element = driver
////				.findElement(By.xpath("//*[@id='applyleave_txtLeaveType']/option[text()='" + leaveType + "']"));
		Select sc = new Select(element);
		sc.selectByVisibleText(text.toString());
		status = true;
		}
		catch(Exception e) {
			status = false;
		}
	}
	
	public boolean SetTextAndEnter(WebElement element, Object text) {

		try {
			element.click();
			element.clear();
			element.sendKeys(text.toString());
			pressEnterKey();
			status = true;

		} catch (Exception e) {
			e.getMessage();
			status = false;
		}
		return status;

	}
	
	public static void pressEnterKey() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void pressEscapeKey() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean moveToElement(WebElement element) {

		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
			status = true;
		} catch (Exception e) {
			status = false;
		}

		return status;

	}

	/*
	 * Method Name : clickElement
	 * 
	 * Description : This method is used to Click the Element
	 * 
	 * Input:: WebElement
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 */
	public boolean ClickElement(WebElement element) {

		try {
			element.click();
			status = true;

		} catch (Exception e) {
			e.getMessage();
			status = false;
		}
		return status;

	}

	/*
	 * Method Name : setText
	 * 
	 * Description : This method is used to send the data to input text field
	 * 
	 * Input:: WebElement and text Data
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 * 
	 */
	public boolean SetText(WebElement element, Object text) {

		try {
			element.click();
			element.clear();
			element.sendKeys(text.toString());
			status = true;

		} catch (Exception e) {
			e.getMessage();
			status = false;
		}
		return status;

	}

	/*
	 * Method Name : setTextandEscape
	 * 
	 * Description : This method is used to send the data to input text field and
	 * Click on Escape button
	 * 
	 * Input:: WebElement and text Data
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 * 
	 */
	public boolean SetTextAndEscape(WebElement element, String text) {

		try {
			element.click();
			element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.ESCAPE);
			status = true;

		} catch (Exception e) {
			e.getMessage();
			status = false;
		}
		return status;

	}
	
	public static void logEvent(boolean status, String PassDescription, String FailDescription) {

		if (status==true) {
			Generate_Reports.logEvent("Pass", PassDescription);
			System.out.println("		<<>> " + PassDescription + " <<>>");

		} else {
			Generate_Reports.logEvent("Fail", FailDescription);
			System.out.println("		<<>> " + FailDescription + " <<>>");
			
		}

	}

}
