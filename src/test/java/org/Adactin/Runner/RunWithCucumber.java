package org.Adactin.Runner;

import org.Adactin.BaseClass.AdactinBaseClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Praveen\\Selenium\\eclipse-workspace 2\\AdactinCucum\\src\\test\\java\\org\\Adactin\\Features\\Adactin.feature", 
					glue = "org.Adactin.StepDefinition", monochrome = true, dryRun = false, strict = false,
					plugin = {"html:Report/Adactin.html","json:Report/Adactin.json", 
					"com.cucumber.listener.ExtentCucumberFormatter:Report/AdactinExt.html"}	)

public class RunWithCucumber extends AdactinBaseClass {

	public static WebDriver driver; ;
	
	@BeforeClass
	public static void BrowserOpen() {
		driver = LaunchBrowser();
	}
	
	@AfterClass
	public static void BrowserClose() {
		Quit();
	}
	
}
