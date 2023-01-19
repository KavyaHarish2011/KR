package flipkart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartQuantity {
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
		Thread.sleep(5000);
		
        
        WebElement total = driver.findElement(By.xpath("//span[contains(text(),'422')]"));
        String totaltext = total.getText();
        String text[]=totaltext.split(" ");
        ArrayList a1= new ArrayList();
        for(int i=0;i<text.length;i++)
        {
        	a1.add(text[i]);
        }
        int totalelements= Integer.parseInt((String) a1.get(5));
        System.out.println(totalelements);
        int sum=0;
        while(true)
        {
        
         List<WebElement> names = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        	Thread.sleep(2000);
        	sum=sum+names.size();
        if(sum==totalelements)
        {
        	System.out.println("The total sum is "+sum+   " test case passed");
        	break;
        	
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(5000);
        }
        
        driver.quit();
	    
		
		
	}

}
