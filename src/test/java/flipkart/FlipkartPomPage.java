package flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPomPage {
	public FlipkartPomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextbutton;
	
	public WebElement getnextbutton()
	{
		return nextbutton;
	}
	

}
