Feature: As a user, I should be able to enter the values in Simple form demo page

@smoke
Scenario: Enter text box field

	Given User launches the application
	And User is in Simple Form Demo Page
	And User enters text "Hello Subbu" in Enter Message text box
	And User clicks on Show Message Button
	Then User should be able to see the message as "Hello Subbu"
	
@Sanity
Scenario: Get Data from Excel sheet
	Given User enters Two Input fields data text fields from "TestData.xlsx"
	And clicks Get Total Button
	Then User should see the message mentioned in "TestData.xlsx"
	