Feature: Login Module

  Background:
    Given user launches ParaBank application

  Scenario Outline: Login attempts with various credentials
    When user enters username "<username>" and password "<password>"
    And user clicks on login button
    Then the system outcome should be "<outcome>"

    Examples:

      | username    | password    | outcome |
      | pavan01   | Teja@123  | success |
      | jjdudjd  | Teja@123   | failure |
      | pavan01  | ibdv   | failure |
      |             |             | failure |
      | veerr   | veer123   | failure |

  Scenario: Verify all UI elements on login page
    Then login page UI elements should be displayed
