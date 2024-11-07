package window_handling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multiple_windowHandling {
	WebDriver driver;
	String base_url="https://demo.guru99.com/popup.php";
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void loadurl() {
		driver.get(base_url);
		driver.manage().window().maximize();
	}
	@Test
	public void test1() throws InterruptedException {
		String parentWindow=driver.getWindowHandle();//current window address
		System.out.println("Parent Window= "+driver.getTitle());
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String>allWindowHandles=driver.getWindowHandles();//multiple windows
		for(String handle:allWindowHandles) {
			if(!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				driver.findElement(By.name("emailid")).sendKeys("rustyn@gmail.com");
				//driver.findElement(By.name("btnLogin")).click();//submit button
				WebElement s=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
				s.click();
				Thread.sleep(1000);
//				System.out.println(s);
				driver.close();
				
			}
			driver.switchTo().window(parentWindow);
		}
		
	}
}
