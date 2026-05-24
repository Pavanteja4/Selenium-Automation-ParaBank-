Feature: Logout Module

  Background:
    Given user launches ParaBank application
    And user logs into ParaBank application

  Scenario: Verify logout functionality
    When user clicks on logout link
    Then user should be logged out successfully

  Scenario: Verify session termination after logout
    When user clicks on logout link
    And user navigates back via browser history
    Then user session should be terminated
