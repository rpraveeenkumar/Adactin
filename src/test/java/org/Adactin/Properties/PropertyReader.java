package org.Adactin.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public Properties prop;
	
	public static PropertyReader getInstancePR() throws IOException {
		PropertyReader pr=new PropertyReader();
		return pr;
	}
	
	public PropertyReader() throws IOException {
		File f=new File(".\\src\\test\\java\\org\\Adactin\\Properties\\Adactin.properties");
		FileInputStream fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
	}
	
	public String getURL() throws IOException {
		String URL = prop.getProperty("url");
		return URL;
	}
	
	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getlocation() {
		String location = prop.getProperty("location");
		return location;
	}
	
	public String gethotel() {
		String hotel = prop.getProperty("hotel");
		return hotel;
	}
	
	public String getroomtype() {
		String roomtype = prop.getProperty("roomtype");
		return roomtype;
	}
	
	public String getrooms() {
		String rooms = prop.getProperty("rooms");
		return rooms;
	}
	
	public String getindate() {
		String indate = prop.getProperty("indate");
		return indate;
	}
	
	public String getoutdate() {
		String outdate = prop.getProperty("outdate");
		return outdate;
	}
	
	public String getadult() {
		String adult = prop.getProperty("adult");
		return adult;
	}
	
	public String getchild() {
		String child = prop.getProperty("child");
		return child;
	}
	
	public String getfirstname() {
		String firstname = prop.getProperty("firstname");
		return firstname;
	}
	
	public String getlastname() {
		String lastname = prop.getProperty("lastname");
		return lastname;
	}
	
	public String getaddress() {
		String address = prop.getProperty("address");
		return address;
	}
	
	public String getccnum() {
		String ccnum = prop.getProperty("ccnum");
		return ccnum;
	}
	
	public String getcctype() {
		String cctype = prop.getProperty("cctype");
		return cctype;
	}
	
	public String getexpmonth() {
		String expmonth = prop.getProperty("expmonth");
		return expmonth;
	}
	
	public String getexpyear() {
		String expyear = prop.getProperty("expyear");
		return expyear;
	}
	
	public String getcvv() {
		String cvv = prop.getProperty("cvv");
		return cvv;
	}
	
	
	
	
}
