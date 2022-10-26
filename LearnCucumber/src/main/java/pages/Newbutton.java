package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class Newbutton extends ProjectSpecificMethod {
	public  Newbutton(RemoteWebDriver driver,Shadow shadow) {
		this.driver=driver;
		this.shadow=shadow;
	}
	public IncidentPage  newbutton() {
		
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		System.out.println(driver.getTitle());
		WebElement newClick = driver.findElement(By.xpath("//button[text()='New']"));
		 //driver.executeScript("arguments[0].click();", newClick);
		driver.findElement(By.id("sysverb_new")).click();
		return new IncidentPage(driver,shadow);
		
}
}
