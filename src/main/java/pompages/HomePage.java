package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains all the elements, locators and respective business libraries
 * @author haris
 *
 */
public class HomePage {
	//Declaration
	@FindBy(xpath ="//a[text()='Organizations']") private WebElement organizationsTab;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement administrationIcon;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signOutButton;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to click on organizations tab
	 */
	public void clickOrganization() {
		organizationsTab.click();
	}
	
	/**
	 * This method is used to sign out of the application
	 * @param web
	 */
	public void signOutOfApp(WebDriverUtility web) {
	web.mouseHover(administrationIcon);
	}
}
