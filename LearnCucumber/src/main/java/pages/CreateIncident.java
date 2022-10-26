package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class CreateIncident extends ProjectSpecificMethod{

	public  CreateIncident (RemoteWebDriver driver,Shadow shadow) {
	this.driver=driver;
	this.shadow=shadow;
	
	}
	public  CreateIncident allPage() {
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
		return this;
}
public Newbutton clickIncident() {
		//4.Click  Incidents in Filter navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		System.out.println(driver.getTitle());
		return new Newbutton(driver,shadow);
}
	
}
