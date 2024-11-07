package date_picker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Date_picker {
	WebDriver driver;
	String base_url="https://www.trivago.com/";
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
	public void datepicker() throws InterruptedException {
		//check in button
		WebElement chkin=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div/fieldset/button[1]/span"));
		//*[@id="__next"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div/fieldset/button[1]/span
		chkin.click();
		datepickermethod("February 2025","24");
	}
	private void datepickermethod(String expmonth, String expdate) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		while(true) {
			//month comparison
			String actualmnth=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3")).getText();
			//System.out.println(actualmnth);
			if(actualmnth.equals(expmonth)) {
				System.out.println("month= "+actualmnth);
				break;
			}
			else {
				//forward/next button xpath
				driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]/span")).click();
			}
		}
		//all dates stored in a list
		List<WebElement>alldates=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));
		for(WebElement dateelement:alldates) {
			String date=dateelement.getText();
			if(date.equals(expdate)) {
				System.out.println("date= "+date);
				dateelement.click();
				break;
			}
		}
	}
}
