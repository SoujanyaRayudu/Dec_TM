/**
 * 
 */
package pages;

import org.openqa.selenium.support.PageFactory;

import libraries.WebLibrary;

/**
 * @author hp
 *
 */
public class TestClass extends WebLibrary{
	
	
	public TestClass() {
	
		PageFactory.initElements(driver, this);
		launchApplication(BaseURL);
	}
	
	boolean status;	
	
}
