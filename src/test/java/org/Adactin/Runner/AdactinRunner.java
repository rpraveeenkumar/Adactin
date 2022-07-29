package org.Adactin.Runner;

import org.Adactin.BaseClass.AdactinBaseClass;
import org.Adactin.Properties.PropertyReader;
import org.Adactin.pageObjectModel.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class AdactinRunner extends AdactinBaseClass{
	
	public static WebDriver driver = LaunchBrowser();
	public static PageObjectManager pom=new PageObjectManager(driver);
	
	public static void main(String[] args) throws Throwable {
		
		//LoginPage
		LaunchUrl(PropertyReader.getInstancePR().getURL());
		KeyToSend(pom.getInstanceLP().getId(), PropertyReader.getInstancePR().getUsername());
		KeyToSend(pom.getInstanceLP().getPassword(), PropertyReader.getInstancePR().getpassword());
		Click(pom.getInstanceLP().getLogin());
		
		
		//SearchHotelPage
		CurrentPage();
		Thread.sleep(1500);
		String loc = PropertyReader.getInstancePR().getlocation();
		SelectDropDown(pom.getInstaceSP().getLocation(), loc);
		String hotel = PropertyReader.getInstancePR().gethotel();
		SelectDropDown(pom.getInstaceSP().getHotel(), hotel);
		String roomtype = PropertyReader.getInstancePR().getroomtype();
		SelectDropDown(pom.getInstaceSP().getRoom_type(), roomtype);
		String rooms = PropertyReader.getInstancePR().getrooms();
		String reqrooms = rooms.concat(" Rooms");
		SelectDropDown(pom.getInstaceSP().getRoom_nos(), rooms);
		String inDate = PropertyReader.getInstancePR().getindate();
		KeyToSend(pom.getInstaceSP().getDatepick_in(), inDate);
		String outDate = PropertyReader.getInstancePR().getoutdate();
		KeyToSend(pom.getInstaceSP().getDatepick_out(), outDate);
		SelectDropDown(pom.getInstaceSP().getAdult_room(), PropertyReader.getInstancePR().getadult());
		SelectDropDown(pom.getInstaceSP().getChild_room(), PropertyReader.getInstancePR().getchild());
		Click(pom.getInstaceSP().getSubmit());
		Thread.sleep(3500);
		
		//SelectHotalPage
		CurrentPage();
		String selloc = pom.getInstanceSHP().getLocation().getAttribute("value");
		String selhotel = pom.getInstanceSHP().getHotel_name().getAttribute("value");
		String selRooms = pom.getInstanceSHP().getRooms().getAttribute("value");
		String selArrDate = pom.getInstanceSHP().getArr_date().getAttribute("value");
		String selDepDate = pom.getInstanceSHP().getDep_date().getAttribute("value");
		String selroomtype = pom.getInstanceSHP().getRoom_type().getAttribute("value");
		
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
		
		//bookingPage
		CurrentPage();
		KeyToSend(pom.getInstanceBP().getFirstname(), PropertyReader.getInstancePR().getfirstname());
		KeyToSend(pom.getInstanceBP().getLastname(), PropertyReader.getInstancePR().getlastname());
		KeyToSend(pom.getInstanceBP().getAddressspan(), PropertyReader.getInstancePR().getaddress());
		KeyToSend(pom.getInstanceBP().getCcnum(), PropertyReader.getInstancePR().getccnum());
		SelectDropDown(pom.getInstanceBP().getCctype(), PropertyReader.getInstancePR().getcctype());
		SelectDropDown(pom.getInstanceBP().getCcexpmonth(), PropertyReader.getInstancePR().getexpmonth());
		SelectDropDown(pom.getInstanceBP().getCcexpyear(), PropertyReader.getInstancePR().getexpyear());
		KeyToSend(pom.getInstanceBP().getCccvv(), PropertyReader.getInstancePR().getcvv());
		Click(pom.getInstanceBP().getBook_now());
		waitforElementVisiblity((pom.getInstanceBP().getOrderno()));
		String orderNum = pom.getInstanceBP().getOrderno().getAttribute("value");
		System.out.println("Your Booking order ID "+orderNum);
		Click(pom.getInstanceBP().getMy_itinerary());
		Thread.sleep(3000);
		
		
		//BookedItinerary
		CurrentPage();
		Thread.sleep(1500);
		Takesnip("AdactinSnip");
		Quit();
	}
	
}
