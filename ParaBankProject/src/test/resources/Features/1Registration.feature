Feature: Registration Module
Background:
	Given user launches ParaBank application
	
  Scenario: Navigate to registration page
    When user navigates to registration page
    Then registration page should open

  Scenario: Register new user with valid details
    When user navigates to registration page
    And user enters valid registration details
    And clicks on Register button
    Then user account should be created successfully

  Scenario: Register user with missing mandatory fields
    When user navigates to registration page
    And user submits empty registration form
    Then error messages should be displayed