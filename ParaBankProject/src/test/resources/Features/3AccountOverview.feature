Feature: Account Overview Module

  Background:
    Given user launches ParaBank application
    And user logs into ParaBank application

  Scenario: Verify account overview page after login
    And click account overview
    Then account overview page should be displayed

  Scenario: Verify account details and balances are displayed
    Then account details and balances should be displayed
