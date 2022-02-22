package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import libraries.WebLibrary;

public class LoginPage_HRM extends WebLibrary{
	
	public LoginPage_HRM() {
		launchApplication(BaseURL);
	}
	
	boolean status;
	
	@FindBy(xpath="//*[@id='txtUsername']")
	public WebElement userName;
	
	@FindBy(xpath="//*[@id='txtPassword']") 
	public WebElement passWord;
	
	@FindBy(xpath="//*[@id='btnLogin']") 
	public WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='logInPanelHeading']") 
	public WebElement loginText;
	
	public void UserName(Object userName) {
		status = SetText(this.userName, userName);
		logEvent(status, "User name entered successfully", "User name is not entered successfully");
	}
	
	public void Password(Object passWord) {
		status = SetText(this.passWord, passWord);
		logEvent(status, "Password entered successfully", "Password is not entered successfully");
	}
	
	public void Login() {
		status = ClickElement(loginBtn);
		logEvent(status, "Login button is clicked successfully", "Login button is not clicked successfully");
	}	
	
}
