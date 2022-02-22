package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import pages.AddEmployee_HRM;
import pages.LoginPage_HRM;
import pages.WelcomePage_HRM;

public class TC02_AddEmployee extends DriverClass {

	@Test
	public void TC_10_AddEmployee() throws InterruptedException {
		Object[] data = ReadRowData(CurrentTestCaseName);
		LoginPage_HRM lp = PageFactory.initElements(driver, LoginPage_HRM.class);
		WelcomePage_HRM wp = PageFactory.initElements(driver, WelcomePage_HRM.class);
		AddEmployee_HRM ae = PageFactory.initElements(driver, AddEmployee_HRM.class);
		
		lp.UserName(data[0]);
		lp.Password(data[1]);
		lp.Login();
		
		wp.mouseHoverPIMTab();
		wp.addEmployeeTab();
		
		ae.addEmpFirstName(data[2]);
		ae.addEmpLastName(data[3]);
		ae.uploadFile("C:\\Users\\hp\\Desktop\\New.png");
		Thread.sleep(3000);
		ae.addEmployeeCreateLoginDetails();
		ae.addEmployeeUserName(data[4]);
		ae.addEmployeePassword(data[5]);
		ae.addEmployeeRePassword(data[6]);
		ae.addEmployeeSaveBtn();
		
		
		
		
		
	}

}
