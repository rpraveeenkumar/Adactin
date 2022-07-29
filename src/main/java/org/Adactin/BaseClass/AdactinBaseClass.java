package org.Adactin.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdactinBaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static WebDriver LaunchBrowser() {
		System.getProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		ChromeOptions opt = new ChromeOptions();
		String browserName = opt.getBrowserName();
		System.out.println(browserName);
		opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("disable-popup-blocking");
		return driver;
		
	}
	
	public static void LaunchUrl(String url) throws Throwable {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		String title = driver.getTitle();
		System.out.println("User navigated to: "+title);

	}
	
	public static void CurrentPage() {
		String title = driver.getTitle();
		System.out.println("User navigated to : "+title);
	}
	
	public static WebDriver Click(WebElement path) {
		path.click();
		return driver;
	}
	
	public static WebDriver KeyToSend(WebElement path, String key) {
		path.clear();
		path.sendKeys(key);
		return driver;
	}
	
	public static void SelectDropDown(WebElement element, String value) {
		try {
			Select sc=new Select(element);
			sc.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static WebDriverWait waitforElementVisiblity(WebElement Element) {
		WebDriverWait wb = new WebDriverWait(driver, 30);
		wb.until(ExpectedConditions.visibilityOf(Element));
		return wb;
	}
	
	public static WebDriver Takesnip(String filename) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File snip = ts.getScreenshotAs(OutputType.FILE);
		File loc = new File(System.getProperty("user.dir")+"\\Snips\\"+filename+".png");
		FileUtils.copyFile(snip, loc);
		return driver;
	}
	
	public static WebDriver Quit() {
		driver.close();
		driver.quit();
		return driver;
	}
	
	public void propertyFile() throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\java\\org\\Adactin\\Properties\\Adactin.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
}
