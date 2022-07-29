package org.Adactin.StepDefinition;

import java.io.IOException;
import org.Adactin.BaseClass.AdactinBaseClass;
import org.Adactin.Properties.PropertyReader;
import org.Adactin.pageObjectModel.PageObjectManager;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdactinStepDefinition extends AdactinBaseClass{

	public static WebDriver driver = LaunchBrowser();
	public static PageObjectManager pom=new PageObjectManager(driver);
	public static String loc;
	public static String hotel;
	public static String roomtype;
	public static String rooms; 
	public static String reqrooms;
	public static String inDate; 
	public static String outDate;
	public static String selloc;
	public static String selhotel;
	public static String selRooms;
	public static String selArrDate;
	public static String selDepDate;
	public static String selroomtype;
	
	@Before
	public void BeforeScenario(Scenario s) {
		String Scenarioname = s.getName();
		System.out.println("Scenario name is: "+Scenarioname);
	}
	
	@After
	public void AfterScenario(Scenario s) throws IOException {
		String Scenarioname = s.getName();
		String status = s.getStatus();
		System.out.println(Scenarioname+" : "+status);
		
		if (s.isFailed()) {
			Takesnip(Scenarioname);
		}
	}
	
	@Given("^User should launch the URL$")
	public void user_should_launch_the_URL() throws Throwable {
		LaunchUrl(PropertyReader.getInstancePR().getURL());
	}

	@When("^user enter \"([^\"]*)\" in username field$")
	public void user_enter_in_username_field(String username) throws Throwable {
		KeyToSend(pom.getInstanceLP().getId(), username);
	}

	@When("^user enter \"([^\"]*)\" in password field$")
	public void user_enter_in_password_field(String password) throws Throwable {
		KeyToSend(pom.getInstanceLP().getPassword(), password);
	}

	@Then("^user click login button to enter search hotel page$")
	public void user_click_login_button_to_enter_search_hotel_page() throws Throwable {
		Click(pom.getInstanceLP().getLogin());
		Thread.sleep(1500);
		CurrentPage();
	}

	@Given("^user choose the location$")
	public void user_choose_the_location() throws Throwable {
		loc = PropertyReader.getInstancePR().getlocation();
		SelectDropDown(pom.getInstaceSP().getLocation(), loc);
	}

	@When("^user choose a hotel$")
	public void user_choose_a_hotel() throws Throwable {
		hotel = PropertyReader.getInstancePR().gethotel();
		SelectDropDown(pom.getInstaceSP().getHotel(), hotel);
	}

	@When("^user choose the roomtype$")
	public void user_choose_the_roomtype() throws Throwable {
		roomtype = PropertyReader.getInstancePR().getroomtype();
		SelectDropDown(pom.getInstaceSP().getRoom_type(), roomtype);
	}

	@When("^user choose number of rooms$")
	public void user_choose_number_of_rooms() throws Throwable {
		rooms = PropertyReader.getInstancePR().getrooms();
		reqrooms = rooms.concat(" Rooms");
		SelectDropDown(pom.getInstaceSP().getRoom_nos(), rooms);
	}

	@When("^user enter the indate$")
	public void user_enter_the_indate() throws Throwable {
		inDate = PropertyReader.getInstancePR().getindate();
		KeyToSend(pom.getInstaceSP().getDatepick_in(), inDate);
	}

	@When("^user enter the outdate$")
	public void user_enter_the_outdate() throws Throwable {
		outDate = PropertyReader.getInstancePR().getoutdate();
		KeyToSend(pom.getInstaceSP().getDatepick_out(), outDate);
	}

	@When("^user choose enter adult details$")
	public void user_choose_enter_adult_details() throws Throwable {
		SelectDropDown(pom.getInstaceSP().getAdult_room(), PropertyReader.getInstancePR().getadult());
	}

	@When("^user choose enter child details$")
	public void user_choose_enter_child_details() throws Throwable {
		SelectDropDown(pom.getInstaceSP().getChild_room(), PropertyReader.getInstancePR().getchild());
	}

	@Then("^user click the submit button which navigate to select hotel page$")
	public void user_click_the_submit_button_which_navigate_to_select_hotel_page() throws Throwable {
		Click(pom.getInstaceSP().getSubmit());
		Thread.sleep(3500);
		CurrentPage();
	}

	@Given("^user verify the given details$")
	public void user_verify_the_given_details() throws Throwable {
		selloc = pom.getInstanceSHP().getLocation().getAttribute("value");
		selhotel = pom.getInstanceSHP().getHotel_name().getAttribute("value");
		selRooms = pom.getInstanceSHP().getRooms().getAttribute("value");
		selArrDate = pom.getInstanceSHP().getArr_date().getAttribute("value");
		selDepDate = pom.getInstanceSHP().getDep_date().getAttribute("value");
		selroomtype = pom.getInstanceSHP().getRoom_type().getAttribute("value");
		
	}

	@When("^user select the holel$")
	public void user_select_the_holel() throws Throwable {
		if(loc.equalsIgnoreCase(selloc) && hotel.equalsIgnoreCase(selhotel) && reqrooms.equalsIgnoreCase(selRooms) && inDate.equalsIgnoreCase(selArrDate)  
				&& outDate.equalsIgnoreCase(selDepDate) && roomtype.equalsIgnoreCase(selroomtype)) {
			Click(pom.getInstanceSHP().getSel());
			Click(pom.getInstanceSHP().getContin());
			System.out.println("Continue");
		}
		else {
			Click(pom.getInstanceSHP().getCan());
			System.out.println("Cancel");
		}
	}

	@When("^user click the continue button which navigates to the payment page$")
	public void user_click_the_continue_button_which_navigates_to_the_payment_page() throws Throwable {
		CurrentPage();
	}

	@Given("^user enter \"([^\"]*)\" in firstname field$")
	public void user_enter_in_firstname_field(String firstname) throws Throwable {
		KeyToSend(pom.getInstanceBP().getFirstname(), firstname);
	}

	@When("^user enter \"([^\"]*)\" in lastname field$")
	public void user_enter_in_lastname_field(String lastname) throws Throwable {
		KeyToSend(pom.getInstanceBP().getLastname(), lastname);
	}
	
	@When("^user enter \"([^\"]*)\" in address field$")
	public void user_enter_in_address_field(String address) throws Throwable {
		KeyToSend(pom.getInstanceBP().getAddressspan(), address);
	}

	@When("^user enter \"([^\"]*)\" in credit card_number field$")
	public void user_enter_in_credit_card_number_field(String card_number) throws Throwable {
		KeyToSend(pom.getInstanceBP().getCcnum(), card_number);
	}

	@When("^user choosing \"([^\"]*)\" as credit card_type$")
	public void user_choosing_as_credit_card_type(String card_type) throws Throwable {
		SelectDropDown(pom.getInstanceBP().getCctype(), card_type);
	}

	@When("^user choosing \"([^\"]*)\" in credit card type expiry_month$")
	public void user_choosing_in_credit_card_type_expiry_month(String expiry_month) throws Throwable {
		SelectDropDown(pom.getInstanceBP().getCcexpmonth(), expiry_month);
	}
	
	@When("^user choosing \"([^\"]*)\" in credit card type expiry_year$")
	public void user_choosing_in_credit_card_type_expiry_year(String expiry_year) throws Throwable {
		SelectDropDown(pom.getInstanceBP().getCcexpyear(), expiry_year);
	}

	@When("^user enter \"([^\"]*)\" in credit card CVV_number$")
	public void user_enter_in_credit_card_CVV_number(String CVV_number) throws Throwable {
		KeyToSend(pom.getInstanceBP().getCccvv(), CVV_number);
	}

	@Then("^user click booknow button, which direct to BookedItinerary page$")
	public void user_click_booknow_button_which_direct_to_BookedItinerary_page() throws Throwable {
		Click(pom.getInstanceBP().getBook_now());
		waitforElementVisiblity((pom.getInstanceBP().getOrderno()));
		String orderNum = pom.getInstanceBP().getOrderno().getAttribute("value");
		System.out.println("Your Booking order ID "+orderNum);
		Click(pom.getInstanceBP().getMy_itinerary());
		
	}

	@Given("^user navigated to Booked Itineray page$")
	public void user_navigated_to_Booked_Itineray_page() throws Throwable {
		Thread.sleep(1500);
		CurrentPage();
		Thread.sleep(1500);
	}

	@When("^Taking snip of booked ticket$")
	public void taking_snip_of_booked_ticket() throws Throwable {
		Takesnip("AdactinSnip");
	}


}
