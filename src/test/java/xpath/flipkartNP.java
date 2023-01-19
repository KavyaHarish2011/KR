package xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartNP {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("iphone");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
		Thread.sleep(2000);
		
        List<WebElement> listname = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> listprice = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
	    System.out.println("Name and price of "+listname.size()+" iphone models");
	    System.out.println("Iphone Models                                  Price");
	    System.out.println("__________________________________________________________________");
	    
		for (int i = 0; i < listname.size(); i++) {
	    	System.out.println(listname.get(i).getText()+"          "+listprice.get(i).getText());
			
		}
			
		driver.quit();

}
}