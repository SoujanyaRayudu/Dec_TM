package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libraries.WebLibrary;

public class WelcomePage_HRM extends WebLibrary{
	
	public WelcomePage_HRM() {
		PageFactory.initElements(driver, this);
		launchApplication(BaseURL);
	}
	
	boolean status;
	
	@FindBy(xpath="//*[@id='menu_pim_viewPimModule']") 
	public WebElement pimTab;
	
	@FindBy(xpath="//*[@id='menu_pim_addEmployee']")
	public WebElement addEmployeeTab;
	
	@FindBy(xpath="//*[@id='menu_leave_viewLeaveModule']") 
	public WebElement leaveTab;
	
	@FindBy(xpath="//*[@id='menu_leave_Entitlements']")
	public WebElement EntitlementsTab;
	
	@FindBy(xpath="//*[@id='menu_leave_addLeaveEntitlement']") 
	public WebElement addEntitlementsTab;
	
	@FindBy(xpath="//*[@id='menu_leave_viewLeaveList']") 
	public WebElement leaveListTab;
	
	public void mouseHoverPIMTab() {
		status = moveToElement(pimTab);
		logEvent(status, "MouseHover on PIM is successful", "MouseHover on PIM is not successful");
	}
	
	public void addEmployeeTab() {
		status = ClickElement(addEmployeeTab);
		logEvent(status, "Click on addEmployeeTab is successful", "Click on addEmployeeTab is not successful");
	}
	
	public void mouseHoverLeaveTab() {
		status = moveToElement(leaveTab);
		logEvent(status, "MouseHover on leave is successful", "MouseHover on leave is not successful");
	}
	
	public void mouseHoverEntitlementsTab() {
		status = moveToElement(EntitlementsTab);
		logEvent(status, "MouseHover on entitlements is successful", "MouseHover on entitlements is not successful");
	}
	
	public void addEntitlementsTab() {
		status = ClickElement(addEntitlementsTab);
		logEvent(status, "Click on add entitlements is successful", "Click on add entitlements is not successful");
	}

}
