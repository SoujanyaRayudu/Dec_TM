/**
 * 
 */
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libraries.WebLibrary;

/**
 * @author rayud
 *
 */
public class AddContactDetails extends WebLibrary {
	
	    public AddContactDetails() {
		PageFactory.initElements(driver, this);
		launchApplication(BaseURL);
	}
	
	boolean status;
	
	@FindBy(xpath="//*[@id='menu_pim_viewMyDetails']") 
	public WebElement myTab;
	
	@FindBy(xpath = "//*[@id=\'sidenav\']/li[2]/a")
	public WebElement ContactDetails;
	
	@FindBy(xpath = "//*[@id='btnSave']")//*[@id="btnSave"]
	public WebElement BtnEdit;
	
	@FindBy(xpath = "//*[@id=\'contact_street1\']")
	public WebElement AddStreet1;
	

	@FindBy(xpath = "//*[@id=\'contact_street2\']")//*[@id="contact_street2"]
	public WebElement AddStreet2;
	
	@FindBy(xpath = "//*[@id=\'contact_country\']")
	public WebElement Country;
	
	@FindBy(xpath = "//*[@id='btnSave']")//*[@id="btnSave"]
	public WebElement BtnSave;
	
	
	public void mouseHoverMYTab() {
		status = moveToElement(myTab);
		logEvent(status, "MouseHover on Myinfo tab is successful", "MouseHover on Myinfo tab is not successful");
	}
	public void addMyinfoTab() {
		status = ClickElement(myTab);
		logEvent(status, "Click on Myinfo tab is successful", "Click on Myinfo tab is not successful");
	}
	public void AddContactDetailsTab() {
		status = ClickElement(ContactDetails);
		logEvent(status, "Click on ContactDetails tab is successful", "Click on ContactDetails tab is not successful");	
	}
	public void AddContactSavebtn() {
		status = ClickElement(BtnEdit);
		logEvent(status, "Click on ButtonEdit tab is successful", "Click on ButtonEdit tab is not successful");
		
	}
	public void addAddressStreet1(Object Street1) {
		status = SetText(AddStreet1, Street1);
		logEvent(status, "Address entered successfully", "Address entered is not entered successfully");
	}
	public void addAddressStreet2(Object Street2) {
		status = SetText(AddStreet2, Street2);
		logEvent(status, "Address entered successfully", "Address entered is not entered successfully");
	}
	public void addCountry(Object country) {
		try {
			selectByVisibleText(Country, country);
			status = true;
		    }
		catch (Exception e) {
			status = false;
		}
		logEvent(status, "Country type selected successfully", "Country type is not selected successfully");
	}
	public void clickSaveBtn() {
		status = ClickElement(BtnSave);
		logEvent(status, "Save button is clicked successfully", "Save button is not clicked successfully");
	}
}
