Feature: Checking Hotel Booking Functionality Of Adactin Hotel

Scenario: Login Functionality 
Given User should launch the URL
When user enter "rpraveeenkumar95" in username field 
And user enter "Mine1+6." in password field
Then user click login button to enter search hotel page

Scenario: Choosing the loaction and hotel Functionality 
Given user choose the location 
When user choose a hotel 
And user choose the roomtype
And user choose number of rooms
And user enter the indate
And user enter the outdate
And user choose enter adult details
And user choose enter child details
Then user click the submit button which navigate to select hotel page

Scenario: user verify the hotel details and select the holel
Given user verify the given details
When user select the holel
And user click the continue button which navigates to the payment page

Scenario: payment functionality
Given user enter "Praveen" in firstname field
When user enter "kumar" in lastname field
And user enter "7/441, hope park, kotagiri, Nilgiri - 643217" in address field
And user enter "9876543210123456" in credit card_number field
And user choosing "VISA" as credit card_type
And user choosing "1" in credit card type expiry_month
And user choosing "2022" in credit card type expiry_year
And user enter "987" in credit card CVV_number
Then user click booknow button, which direct to BookedItinerary page

Scenario: validating the Booking functionality
Given user navigated to Booked Itineray page
When Taking snip of booked ticket

