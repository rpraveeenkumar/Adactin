package org.Adactin.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookedItinerary {
	
	public static WebDriver driver;
	
	@FindBy (xpath = "//table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]")
	private WebElement allOrderID;
	
	@FindBy (xpath = "//table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr/td[1]")
	private WebElement selorderID;
			
	
	

}
