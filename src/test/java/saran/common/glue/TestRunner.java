package saran.common.glue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.sample.report.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty","html:target/cucumber","json:Reports\\report.json"},
		features = "features",
		glue= "com/sample/glue",
		monochrome = true,
		dryRun= true,
		tags = "@Saran"
		) 
public class TestRunner {

	public TestRunner() {
	}
	@Before
	public void setUp() throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@AfterClass
	public static void afterClass() {
		//JVMReport.makeJVMReport("C:\\Users\\Owern\\eclipse-workspace\\Saravanan\\Reports\\cucumber.json");
	}
}
