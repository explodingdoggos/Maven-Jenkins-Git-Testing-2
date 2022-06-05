package first;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class Selenium {
	
	WebDriver driver;

	@BeforeClass
	public void beforeAll() {
		System.out.println("Starting...");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\explo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void afterAll() {
		System.out.println("Ending...");
    	driver.quit();
	}
	
	@Test
    public void test(){
    	driver.get("http://www.google.com");
    	WebElement element=driver.findElement(By.name("q"));
    	element.sendKeys("Testing");
    	element.submit();
    	WebElement element2 = driver.findElement(By.className("mCBkyc"));
    	element2.click();
    	System.out.println("Page URL is: " + driver.getCurrentUrl());
//    	Assert.assertEquals(driver.getCurrentUrl(), "https://www.cbc.ca/news/politics/rapid-test-cease-2022-phac-1.6475870");
    	Assert.assertNotEquals(driver.getCurrentUrl(), null);
    }
	
	@Test
	public void test2() {
		driver.get("https://www.youtube.com/");
		WebElement element = driver.findElement(By.name("search_query"));
		element.sendKeys("Testing");
		element.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element2 = driver.findElement(By.linkText("Software Testing Full Course In 10 Hours | Software Testing Tutorial | Edureka"));
		element2.click();
    	System.out.println("Page URL is: " + driver.getCurrentUrl());
    	Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/watch?v=sO8eGL6SFsA");
    	Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.youtube.com/watch?v=2v3R2c1fG9c");
    	Assert.assertNotEquals(driver.getCurrentUrl(), null);
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(1,1);
	}
	
	@Test
	public void test5() {
		
	}
	
//	@Test
//	public void test3() {
//		driver.get("https://mail.google.com/mail/u/0/#inbox");
//		WebElement element = driver.findElement(By.className("whsOnd"));
//		element.sendKeys("yhancrypto@gmail.com");
//		element.submit();
//		WebElement element2 = driver.findElement(By.className("whsOnd"));
//		element2.sendKeys("20060321(Hyf)");
//		element2.submit();
//		WebElement element3 = driver.findElement(By.className("ElVfPpkd-LgbsSe"));
//		element3.click();
//    	Assert.assertEquals(driver.getCurrentUrl(), "https://mail.google.com/mail/u/0/#inbox");
//    	Assert.assertNotEquals(driver.getCurrentUrl(), null);
//	}
}