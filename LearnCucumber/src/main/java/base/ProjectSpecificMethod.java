package base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class ProjectSpecificMethod {
	public  RemoteWebDriver driver;
	public   Shadow shadow;
	public static String text2;
	@BeforeMethod
	public  void preCondition() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	shadow = new Shadow(driver);
	driver.get("https://dev141581.service-now.com"); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//   Create your own credentials
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("iX-66uY+DwSi");
	driver.findElement(By.id("sysverb_login")).click();
	 
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
