package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Declaration
	@FindBy(name= "user_name") private WebElement UsernameTF;
	@FindBy(name="user_password") private WebElement passwordTF;
	@FindBy(id="submitButton") private WebElement loginButton;
	
//Initalization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//Declaration
		public void loginToApp(String username, String password) {
			UsernameTF.sendKeys(username);
			passwordTF.sendKeys(password);
			loginButton.click();
		}
	
}
