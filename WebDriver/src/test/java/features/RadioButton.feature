Feature: As a user, I should be able to enter select the radio button in the page

@smoke
Scenario: Perform action in Single radio button selection

	Given User launches the application
	And User is in Radio Button Demo Page
	And User selects "Female" radio button from "single radio demo"
	And User clicks on Get Checked value Button
	Then User should be able to see the message as "Radio button 'Female' is checked"
	

Scenario: Perform action on Group radio button selecton
	And User selects "Male" radio button from "group radio demo"
	And User selects "15 to 50" radio button from "group radio demo"
	And User clicks on "Get values" button from "single radio demo"
	Then User should be able to see the message as "Sex: Male" and "Age group: 15 - 50"
		
	

	