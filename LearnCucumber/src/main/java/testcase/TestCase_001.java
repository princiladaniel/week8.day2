package testcase;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;
import pages.CreateIncident;

public class TestCase_001 extends ProjectSpecificMethod{
	@Test
	public  void runCreateIncent() {
		CreateIncident ci=new CreateIncident(driver, shadow); 	
		ci.allPage().clickIncident()
		.newbutton().incidentNum()
		.shortDescription().submitButton().dropNumber().textValue();		
		
		
	}

}
