  package window_handling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Snapdeal {
	WebDriver driver;
	String base_url="https://snapdeal.com/";
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
    public void test1() {
    	String parentwindow=driver.getWindowHandle();
    	System.out.println("Parent Window= "+driver.getTitle());
    	WebElement searchbar=driver.findElement(By.xpath("//*[@id=\"inputValEnter\"]"));
    	searchbar.sendKeys("teddy bear");
    	WebElement searchbtn=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[2]/button")); 
    	searchbtn.click();
    	
    	WebElement frstimg1=driver.findElement(By.xpath("//*[@id=\"6917529673397380080\"]/div[1]/a/picture/img"));
    	frstimg1.click();
    	
    	Set<String>allWindowHandles=driver.getWindowHandles();
    	for(String handle:allWindowHandles) {
    		if(!handle.equalsIgnoreCase(parentwindow)) {
    			driver.switchTo().window(handle);
    			WebElement prodname=driver.findElement(By.xpath("//*[@id=\"productOverview\"]/div[2]/div/div[1]/div[1]/div[1]/h1"));
    			System.out.println("product name is "+prodname.getText());
    			WebElement price=driver.findElement(By.xpath("//*[@id=\"buyPriceBox\"]/div[2]/div[1]/div[1]/div[1]/span[1]"));
    			System.out.println("Product price is "+price.getText());
    			WebElement addcart=driver.findElement(By.id("add-cart-button-id"));
    			//JavascriptExecutor js=(JavascriptExecutor)driver;
    			//js.executeScript("arguments[0].scrollIntoView();", addcart);
    			addcart.click();
    			WebElement chkout=driver.findElement(By.xpath("//*[@id=\"cartProductContainer\"]/div/div[2]/div[2]/div/div[2]/a"));
    			chkout.click();
    		}
    	}
    	
    }
}
