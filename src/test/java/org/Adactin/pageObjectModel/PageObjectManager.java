package org.Adactin.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
	public WebDriver driver;
	
	
	public PageObjectManager(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public LoginPage getInstanceLP() {
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	
	public SearchHotelPage getInstaceSP() {
		SearchHotelPage sp=new SearchHotelPage(driver);
		return sp;
	}
	
	public SelectHotelPage getInstanceSHP() {
		SelectHotelPage shp = new SelectHotelPage(driver);
		return shp;
	}
	
	public BookingPage getInstanceBP() {
		BookingPage bp = new BookingPage(driver);
		return bp;
	}
	
}