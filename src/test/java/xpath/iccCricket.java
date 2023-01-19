package xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iccCricket {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/test/batting");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//table/descendant::tr"));
		for (int i = 1; i < list.size(); i++) {
			WebElement name = driver.findElement(By.xpath("//table/descendant::tr["+i+"]/td/a"));
			System.out.println(name.getText());
			
		}
		driver.quit();
		}
}