Feature: Login of LeafTaps
Background:
Given Launch the browser
And Load the 'http://leaftaps.com/opentaps/control/login'
And maximize the browser
Scenario Outline: Tc_001 Login positive flow
Given Enter the username as <username>
And Enter the password as <password>
When click the login button
#Then open home screen

#Scenario: Tc_001 Login negative flow
#Given Enter the password as crmsf
#When click on the login button
#But Error message is diplayed
Examples:
|username|password|
|'demosalesmanager'|'crmsfa'|
|'democsr'|'crmsfa'|
