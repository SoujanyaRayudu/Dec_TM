/**
 * 
 */
package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import pages.AddContactDetails;
import pages.LoginPage_HRM;
import pages.WelcomePage_HRM;

/**
 * @author rayud
 *
 */

public class TC_04AddContactDetails  extends DriverClass  {

	@Test
	public void TC_01_VerifyLoginPage() throws InterruptedException {
		Object[] data = ReadRowData(CurrentTestCaseName);	
		LoginPage_HRM loginpage = PageFactory.initElements(driver, LoginPage_HRM.class);
    	AddContactDetails AddDetails=PageFactory.initElements(driver,AddContactDetails.class);
	    loginpage.UserName(data[0]);
		loginpage.Password(data[1]);
		loginpage.Login();		
		AddDetails.mouseHoverMYTab();
		AddDetails.addMyinfoTab();
		AddDetails.AddContactDetailsTab();
		AddDetails.AddContactSavebtn();
		AddDetails.addAddressStreet1(data[2]);
		AddDetails.addAddressStreet2(data[3]);
		AddDetails.addCountry(data[4]);
		Thread.sleep(3000);
		AddDetails.clickSaveBtn();
	}
	
}