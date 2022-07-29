package org.Adactin.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	
	public WebDriver driver;

	@FindBy (id = "hotel_name_0")
	private WebElement hotel_name;
	
	@FindBy (id = "location_0")
	private WebElement location;
	
	@FindBy (id = "rooms_0")
	private WebElement rooms;
	
	@FindBy (id = "arr_date_0")
	private WebElement arr_date;
	
	@FindBy (id = "dep_date_0")
	private WebElement dep_date;
	
	@FindBy (id = "room_type_0")
	private WebElement room_type;
	
	@FindBy (id = "continue")
	private WebElement contin;
	
	@FindBy (id = "cancel")
	private WebElement can;
	
	@FindBy (id = "radiobutton_0")
	private WebElement sel;
	
	public SelectHotelPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHotel_name() {
		return hotel_name;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getArr_date() {
		return arr_date;
	}

	public WebElement getDep_date() {
		return dep_date;
	}

	public WebElement getRoom_type() {
		return room_type;
	}
	
	public WebElement getContin() {
		return contin;
	}

	public WebElement getCan() {
		return can;
	}
	
	public WebElement getSel() {
		return sel;
	}
}
