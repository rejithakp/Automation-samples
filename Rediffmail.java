package junit_basic_programs;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Rediffmail {
	ChromeDriver driver;
	String base_url="https://register.rediff.com/register/register.php?FormName=user_details";
	@Before
	public void setUp() {
		driver=new ChromeDriver();
		driver.get(base_url);
	}
	@Test
	public void title_verification() {
		String expectedtitle="Rediffmail Free Unlimited Storage";
		String actualtitle=driver.getTitle();
		System.out.println(expectedtitle);
		//System.out.println(actualtitle);
		if(actualtitle.equals(expectedtitle)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}	
	}
	@Test
	public void verify_heading() {
		String src=driver.getPageSource();
		if(src.contains("Create a Rediffmail account")) {
			System.out.println("heading is correct");
		}
		else {
			System.out.println("heading is incorrect");
		}	
	}
	@Test
	public void verify_contents() {
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("Rustyn Brady");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("rusty@rediffmail.com");
		driver.findElement(By.xpath("//*[@id=\"newpasswd\"]")).sendKeys("Rustyn.123");
		driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).sendKeys("Rustyn.123");
		driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).sendKeys("rustyn@rediffmail.com");
		driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys("7907774951");
		Select day=new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")));
		day.selectByIndex(15);
		Select month=new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")));
		month.selectByValue("08");
		Select year=new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")));
		year.selectByVisibleText("2022");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]")).click();
		Select country=new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		country.selectByVisibleText("India");
		Select city=new Select(driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")));
		city.selectByVisibleText("Cochin");
}
}
