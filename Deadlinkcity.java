package junit_basic_programs;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deadlinkcity {
ChromeDriver driver;
String base_url="http://www.deadlinkcity.com/";
int blinks=0;

@Before
public void setUp() {
	driver=new ChromeDriver();
	driver.get(base_url);
}
@Test
public void linkscount() {
	List <WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("total links:"+links.size());
	for(WebElement tags:links) {
		String urls=tags.getAttribute("href");
		String text=tags.getText();
		//System.out.println("Text:"+text+" "+"URL"+urls);
	System.out.println("URLs"+urls);
	
//		verify(urls);
//		
//		}
//	}
//	private void verify(String urls)throws IOException{
	
		
		try {
			URL link=new URL(urls);//convert string to url
			HttpURLConnection con=(HttpURLConnection) link.openConnection();
			//con.connect();
			int responsecode=con.getResponseCode();
			if(responsecode==200) {
				System.out.println("success");
			}
			else if(responsecode>=400) {
				System.out.println("brokenlink---->"+urls);
				blinks++;
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	 System.out.println("total count of broken links: "+blinks);
}
}