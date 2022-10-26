package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class IncidentPage extends ProjectSpecificMethod {
	public IncidentPage(RemoteWebDriver driver,Shadow shadow){
		this.driver=driver;
		
		this.shadow=shadow;
	}
	public IncidentPage incidentNum() {
		text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Inident NUmber"+text2);
		return this;
	}
	public IncidentPage shortDescription() {
		driver.findElement(By.id("incident.short_description")).sendKeys("Created via Automation");
	    return this;
	}
	public DropPage submitButton() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		return new DropPage(driver,shadow);
}
}