package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement plusButton;
	@FindBy(xpath="//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement newOrganization; 

	//Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickplusButton() {
		plusButton.click();
	}
	
	public String getNewOrganization() {
		return newOrganization.getText();
	}
}
