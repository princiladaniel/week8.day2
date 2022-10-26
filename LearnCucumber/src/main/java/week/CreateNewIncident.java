package week;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewIncident {
	public static void main(String[] args) throws InterruptedException {
		//1. Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev122520.service-now.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.switchTo().frame("gsft_main");
		//2. Login with valid credentials username as admin and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@123");
		driver.findElement(By.id("sysverb_login")).click();

		//3. Click All
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		//4.Click  Incidents in Fillter navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		//5. Click on Create new option and fill the manadatory fields
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Inident NUmber"+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created via Automation");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();

		//6. Verify the newly created incident 
		//( copy the incident number and paste it in search field and 
		//enter then verify the instance number created or not)

		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
		//// Verify exists !
		//driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text); 
		

	}
}

