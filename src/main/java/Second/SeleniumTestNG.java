package Second;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class SeleniumTestNG {

	WebDriver driver;
	
	@BeforeClass
	public void beforeAll(){
		System.out.println("Starting...");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\explo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void afterAll() {
		System.out.println("Ending");
		driver.quit();
	}
	
	public void SignIn() {
		WebElement SignIn = driver.findElement(By.linkText("Sign in"));
		SignIn.click();
		WebElement Email = driver.findElement(By.name("email"));
		WebElement Password = driver.findElement(By.name("passwd"));
		WebElement SignInButton = driver.findElement(By.name("SubmitLogin"));
		Email.sendKeys("yyiiffaannhhaann@gmail.com");
		Password.sendKeys("11111");
		SignInButton.click();
	}
	
	@Test
	public void MainTest() {
		driver.get("http://automationpractice.com/index.php");
		SignIn();
		WebElement SignOut = driver.findElement(By.linkText("Sign out"));
		SignOut.click();
		SignIn();
		WebElement dresses = driver.findElement(By.linkText("DRESSES"));
		dresses.click();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://automationpractice.com/index.php");
		WebElement dresses2 = driver.findElement(By.linkText("DRESSES"));
		dresses2.click();
		driver.switchTo().window(tabs.get(0));
		driver.close();
		driver.switchTo().window(tabs.get(1));
		WebElement Casual = driver.findElement(By.linkText("Casual Dresses"));
		Casual.click();
		((JavascriptExecutor) driver).executeScript("window.history.go(-1)");
		List<WebElement> Exists = driver.findElements(By.linkText("Contact us"));
		Assert.assertTrue(Exists.size()!= 0);
		WebElement search = driver.findElement(By.name("search_query"));
		search.sendKeys("Dress");
		search.submit();
		List<WebElement> Exists1 = driver.findElements(By.linkText("Printed Summer Dress"));
		List<WebElement> Exists2 = driver.findElements(By.linkText("Testing For Failure"));
		Assert.assertTrue(Exists1.size()!= 0);
		Assert.assertFalse(Exists2.size()!= 0);
	}
}
