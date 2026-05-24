Feature: Update Contact Information Module

Background:
  Given user launches ParaBank application
  And user logs into ParaBank application

Scenario: Navigate to update contact information page
  When user navigates to update contact info page
  Then update profile page should open

Scenario: Update contact details with valid data
  When user navigates to update contact info page
  And user enters valid contact details
  And user clicks on update profile button
  And contact information should be updated successfully
  Then updated contact information should be displayed
Scenario: Update contact details with invalid data
  When user navigates to update contact info page
  And user enters invalid contact details
  And user clicks on update profile button
  Then update contact error message should be displayed

