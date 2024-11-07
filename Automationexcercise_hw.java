package seleniumtestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Automationexcercise_hw {
	WebDriver driver;
	String base_url="https://automationexercise.com/";
	@BeforeTest
	public void setUp() {
	driver=new ChromeDriver();
	}
	@BeforeMethod
	public void loadurl() {
		driver.get(base_url);
		driver.manage().window().maximize();
	}
	@Test
	public void logo_verification() throws InterruptedException {
					Thread.sleep(2000);
			boolean logo=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img")).isDisplayed();
			
			if(logo) {
				System.out.println("pass");
			}
			else {
				System.out.println("failed");	
			        }
	}
	
	@Test
	public void signup() throws InterruptedException {
		WebElement sign=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		sign.click();
		WebElement name=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		name.sendKeys("Rustyn");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
		email.sendKeys("Rusttttutuuu@gmail.com");
		WebElement signup=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		signup.click();
		WebElement gender=driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
		gender.click();
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pass.sendKeys("Rustyn.123");
		Select day=new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
		day.selectByIndex(15);
		Select month=new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
		month.selectByValue("8");
		Select year=new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
		year.selectByVisibleText("2021");
		WebElement chk1=driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
		chk1.click();
		WebElement chk2=driver.findElement(By.xpath("//*[@id=\"optin\"]"));
		chk2.click();
		WebElement fname=driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		fname.sendKeys("Rustyn");
		WebElement lname=driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
		lname.sendKeys("Addie");
		WebElement cmpny=driver.findElement(By.xpath("//*[@id=\"company\"]"));
		cmpny.sendKeys("UST");
		WebElement addrs1=driver.findElement(By.xpath("//*[@id=\"address1\"]"));
	    addrs1.sendKeys("Edhan villa");
		WebElement addrs2=driver.findElement(By.xpath("//*[@id=\"address2\"]"));
		addrs2.sendKeys("north beypore");
		Select country=new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		country.selectByValue("India");
		WebElement state=driver.findElement(By.xpath("//*[@id=\"state\"]"));
		state.sendKeys("Kerala");
		WebElement city=driver.findElement(By.xpath("//*[@id=\"city\"]"));
	    city.sendKeys("calicut");
		WebElement zip=driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
		zip.sendKeys("673015");
		WebElement mob=driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
	    mob.sendKeys("8139805036");
	    WebElement crtacc=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
	    crtacc.click();
	
	
	   
	    	String src=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2")).getText();
			if(src.contains("ACCOUNT CREATED!")) {
				System.out.println("heading is correct");
			}
			else {
				System.out.println("heading is incorrect");
			}
	  
	    	//WebElement contnu=driver.findElement(By.xpath("//a[text()=\"Continue\"]"));
	    	WebElement contnu=driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]"));
	    	//WebElement contnu=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
	    	contnu.click();
            boolean loginname=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).isDisplayed();
			
			if(loginname) {
				System.out.println("logged In pass");
			}
			else {
				System.out.println("logged In failed");	
			        }
			WebElement fstimg=driver.findElement(By.xpath("html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", fstimg);
			fstimg.click();
			Thread.sleep(2000);
			WebElement viewprod=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a"));
			viewprod.click();
			
	    	//WebElement frstprod=driver.findElement(By.xpath("//img[@alt=\"ecommerce website products\"]"));
	    	//frstprod.click();
		
	    	WebElement addcrt=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
	    	addcrt.click();
	    	Thread.sleep(1000);
	    	WebElement viewcrt=driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]"));
	    	viewcrt.click();
	    	WebElement chkout=driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
	    	chkout.click();		
	    	
	    	List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println("total links:"+links.size());
			for(WebElement tags:links) {
				String urls=tags.getAttribute("href");
				String text=tags.getText();
				System.out.println("Text"+text+" "+"URLs"+urls);
			}
			WebElement logout=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
			logout.click();		
	    }
	}



