Feature: Transfer Funds Module

Background:
  Given user launches ParaBank application
  And user logs into ParaBank application

Scenario: Navigate to transfer funds page
  When user navigates to transfer funds page
  Then transfer funds page should open

Scenario: Transfer funds between accounts with valid data
  When user navigates to transfer funds page
  And user enters valid transfer amount
  And user clicks on transfer button
  And funds should be transferred successfully
  Then success transfer message should be displayed

Scenario: Transfer funds with invalid amount
  When user navigates to transfer funds page
  And user enters invalid transfer amount
  And user clicks on transfer button
  Then transfer error message should be displayed

