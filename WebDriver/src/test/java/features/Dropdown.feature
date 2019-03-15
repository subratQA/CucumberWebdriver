Feature: As a user, I should be able to select dropdown item from list page

@smoke1
Scenario: Select Dropdown checkbox

	Given User launches the application
	And User is in Dropdown Page
	And User selects "Monday" from Select a Day Dropdown
	Then User verifies message displayed "Day selected :- Monday" for Select List Demo

