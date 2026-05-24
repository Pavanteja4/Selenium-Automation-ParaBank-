Feature: Bill Pay Module

Background:
  Given user launches ParaBank application
  And user logs into ParaBank application

Scenario: Navigate to bill pay page
  When user navigates to bill pay page
  Then bill pay page should open

Scenario: Pay bill using valid details
  When user navigates to bill pay page
  And user enters valid bill pay details
  And user clicks on send payment button
  Then bill payment should be successful

Scenario: Pay bill using invalid details
  When user navigates to bill pay page
  And user enters invalid bill pay details
  And user clicks on send payment button
  Then bill payment error message should be displayed