package junit_basic_programs;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_handling {
	ChromeDriver driver;
	String base_url="C:\\Users\\rejitha\\automation\\selenium\\alert1.html";
	
	@Before
	public void setUp() {
		driver=new ChromeDriver();
		driver.get(base_url);
		driver.manage().window().maximize();
	}
	@Test
	public void alert_handle() throws InterruptedException {
		WebElement btn=driver.findElement(By.xpath("//input[@value=\"display alert box\"]"));
		btn.click();
		Alert a=driver.switchTo().alert();//to handle alert here Alert is an interface
		Thread.sleep(2000);
		
		String msg=a.getText();//to retrieve value from webpage
		System.out.println(msg);
		if(msg.equals("hello...i'm a alert box!!!!")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		a.accept();//to click ok button
	}
	

}
