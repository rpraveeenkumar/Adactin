package org.Adactin.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
	public WebDriver driver;
	
	@FindBy (id = "location")
	private WebElement location;	//New York
	
	@FindBy (id = "hotels")
	private WebElement hotel; //Hotel Sunshine
	
	@FindBy (id = "room_type")
	private WebElement room_type; //Super Deluxe
	
	@FindBy(id = "room_nos")
	private WebElement room_nos; //1
	
	@FindBy (id = "datepick_in")
	private WebElement datepick_in; //15/08/2022
	
	@FindBy (id = "datepick_out")
	private WebElement datepick_out; //20/08/2022
	
	@FindBy (id = "adult_room")
	private WebElement adult_room; //2
	
	@FindBy (id = "child_room")
	private WebElement child_room; //0
	
	@FindBy (id = "Submit")
	private WebElement Submit; //0
	
	public SearchHotelPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoom_type() {
		return room_type;
	}

	public WebElement getRoom_nos() {
		return room_nos;
	}

	public WebElement getDatepick_in() {
		return datepick_in;
	}

	public WebElement getDatepick_out() {
		return datepick_out;
	}

	public WebElement getAdult_room() {
		return adult_room;
	}

	public WebElement getChild_room() {
		return child_room;
	}

	public WebElement getSubmit() {
		return Submit;
	}
}
