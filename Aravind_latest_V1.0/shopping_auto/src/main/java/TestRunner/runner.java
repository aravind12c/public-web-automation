package TestRunner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import Stepdefination.shopping_auto;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "Feature",
		glue= {"Stepdefination"},
		tags="@run",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
		)
public class runner {
	shopping_auto newobj = new shopping_auto();
	
	 @BeforeClass
	    public static void setup() {
	        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	       extentProperties.setReportPath("target/myreport.html");
	    }

	    @AfterClass
	    public static void teardown() {
	        Reporter.loadXMLConfig(new File("C:\\Users\\aravindc\\Desktop\\Aravind_latest_V1.0\\shopping_auto\\target\\extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.Fashion"));
	        Reporter.setSystemInfo("os", "Windows");
	        Reporter.setTestRunnerOutput("Extended Report");
	}
	
	     
		
	
}
