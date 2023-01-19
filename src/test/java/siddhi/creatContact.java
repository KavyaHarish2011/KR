package siddhi;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class creatContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys("ayyer");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		List<WebElement> title = driver.findElements(By.xpath("//a[@title=\"Contacts\"]"));
		int count=0;
		for(int i=0;i<title.size();i++)
		{
			if(title.get(i).getText().equals("ayyer"))
			{
				count++;
			}
		}
		if(count>0)
		{
			System.out.println("Testcase is passed");
		}
		else
		{
			System.out.println("Testcase is failed");
		}
		
		driver.quit();
	}		

}
