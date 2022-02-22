package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libraries.WebLibrary;

public class AddEmployee_HRM extends WebLibrary{
	
	public AddEmployee_HRM() {
		PageFactory.initElements(driver, this);
		launchApplication(BaseURL);
	}
	
	boolean status;
	
	@FindBy(xpath="//*[@id='firstName']")
	public WebElement addEmployeeFirstName;
	
	@FindBy(xpath="//*[@id='lastName']")
	public WebElement addEmployeeLastName;
	
	@FindBy(xpath="//*[@id='photofile']")
	public WebElement addEmployeeFileUpload;
	
	@FindBy(xpath="//*[@id='chkLogin']")
	public WebElement addEmployeeCreateLoginDetails;
	
	@FindBy(xpath="//*[@id='user_name']")
	public WebElement addEmployeeUserName;
	
	@FindBy(xpath="//*[@id='user_password']")
	public WebElement addEmployeePassword;
	
	@FindBy(xpath="//*[@id='re_password']")
	public WebElement addEmployeeRePassword;
	
	@FindBy(xpath="//*[@id='btnSave']")
	public WebElement addEmployeeSaveBtn;
	
	public void addEmpFirstName(Object firstName) {
		status = SetText(addEmployeeFirstName, firstName);
		logEvent(status, "First name entered successfully", "First name is not entered successfully");
	}
	
	public void addEmpLastName(Object lastName) {
		status = SetText(addEmployeeLastName, lastName);
		logEvent(status, "Last name entered successfully", "Last name is not entered successfully");
	}
	
	public void uploadFile(String path) {
		status = fileUpload(addEmployeeFileUpload, path);
		logEvent(status, "File uploaded successfull", "File uploaded is not successfull");
	}
	
	public void addEmployeeCreateLoginDetails() {
		status = ClickElement(addEmployeeCreateLoginDetails);
		logEvent(status, "Check box clicked successfully", "Check box is not clicked successfully");
	}
	
	public void addEmployeeUserName(Object userName) {
		status = SetText(addEmployeeUserName, userName);
		logEvent(status, "User name entered successfully", "User name is not entered successfully");
	}
	
	public void addEmployeePassword(Object password) {
		status = SetText(addEmployeePassword, password);
		logEvent(status, "Password entered successfully", "Password is not entered successfully");
	}
	
	public void addEmployeeRePassword(Object rePassword) {
		status = SetText(addEmployeeRePassword, rePassword);
		logEvent(status, "Re-Password entered successfully", "Re-Password is not entered successfully");
	}
	
	public void addEmployeeSaveBtn() {
		status = ClickElement(addEmployeeSaveBtn);
		logEvent(status, "Save button clicked successfully", "Save button is not clicked successfully");
	}
	
	
	
	
	
}
