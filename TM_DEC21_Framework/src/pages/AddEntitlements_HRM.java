package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import libraries.WebLibrary;

public class AddEntitlements_HRM extends WebLibrary {

	/*
	 * As soon as you create a new class, please follow the below steps to complete
	 * the implementation of pages 1. we have to extend the WebLibrary 2. boolean
	 * true; 3. Using @FindBy we have to get all elements of the page 4. Develop the
	 * behavior/functionality of the element on the page 5. Create a constructor for
	 * the class to initialize the elements in the page
	 */

	boolean status;

	@FindBy(xpath = "//*[@id='entitlements_employee_empName']")
	public WebElement empName;

	@FindBy(xpath = "//*[@id='entitlements_leave_type']")
	public WebElement leaveType;

	@FindBy(xpath = "//*[@id='entitlements_entitlement']")
	public WebElement addEntitlement;

	@FindBy(xpath = "//*[@id='btnSave']")
	public WebElement saveBtn;

	public void employeeName(Object EmpName) {

		status = SetTextAndEnter(empName, EmpName);
		logEvent(status, "Employee name entered successfully", "Employee name is not entered successfully");
	}

	public void leaveType(Object leaveTypeOption) {
		try {
			selectByVisibleText(leaveType, leaveTypeOption);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		logEvent(status, "Leave type selected successfully", "Leave type is not selected successfully");
	}

	public void addEntitlement(Object numOfEntitlements) {
		status = SetText(addEntitlement, numOfEntitlements);
		logEvent(status, "Entitlements added successfully", "Entitlements is not added successfully");
	}

	public void clickSaveBtn() {
		status = ClickElement(saveBtn);
		logEvent(status, "Save button is clicked successfully", "Save button is not clicked successfully");
	}

}
