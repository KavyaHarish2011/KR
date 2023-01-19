package siddhi;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact {
	public static void main(String[] args) throws InterruptedException, IOException {
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
		driver.findElement(By.name("lastname")).sendKeys("jha");
		driver.findElement(By.xpath("//input[@name=\"account_id\"]/../img[@src=\"themes/softed/images/select.gif\"]")).click();
	    Runtime.getRuntime().exec("C:\\Users\\haris\\Desktop\\autoscripts\\contacts1.exe");
	    Thread.sleep(10000);
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		Thread.sleep(2000);
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
			if(title.get(i).getText().equals("jha"))
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
