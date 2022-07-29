package org.Adactin.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	public WebDriver driver;
	
	@FindBy(id = "first_name")
	private WebElement firstname;
	
	@FindBy(id = "last_name")
	private WebElement lastname;
	
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressspan;
	
	@FindBy(id = "cc_num")
	private WebElement ccnum;
	
	@FindBy(id = "cc_type")
	private WebElement cctype; //VISA
	
	@FindBy(id = "cc_exp_month")
	private WebElement ccexpmonth; 	//1
	
	@FindBy(id = "cc_exp_year")
	private WebElement ccexpyear;  //2022

	@FindBy(id = "cc_cvv")
	private WebElement cccvv;
	
	@FindBy(id = "book_now")
	private WebElement book_now;
	
	@FindBy (id = "order_no")
	private WebElement orderno;
	
	@FindBy (id = "my_itinerary")
	private WebElement my_itinerary;
	
	public void setMy_itinerary(WebElement my_itinerary) {
		this.my_itinerary = my_itinerary;
	}

	public BookingPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddressspan() {
		return addressspan;
	}

	public WebElement getCcnum() {
		return ccnum;
	}

	public WebElement getCctype() {
		return cctype;
	}

	public WebElement getCcexpmonth() {
		return ccexpmonth;
	}

	public WebElement getCcexpyear() {
		return ccexpyear;
	}

	public WebElement getCccvv() {
		return cccvv;
	}

	public WebElement getBook_now() {
		return book_now;
	}
	
	public WebElement getOrderno() {
		return orderno;
	}
	
	public WebElement getMy_itinerary() {
		return my_itinerary;
	}
	
	
}
