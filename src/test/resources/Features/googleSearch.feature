Feature: Feature to test google search.

Scenario: Check if google search is working properly.

Given Browser is open
And User is on google search page
When User enters a keyword in search box
And User hits enter button
Then User gets the matching result 

