@smoke_test
Feature: Smoke test

  Scenario Outline: Go to <module> and verify title: <title>
    Given user is on the login page
    When user logs in as "<user_type>"
    And user navigates to "<tab>" and "<module>"
    Then user verifies that page title is "<title>"

    Examples:
      | user_type     | tab        | module          | title                                                              |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |

    # How to run smoke test with specific tag from terminal ?
    #
    #in terminal ,we write (run) : mvn clean verify -Dcucumber.options="--tags @smoke_test"
    #-D is for environment variable
    # this is for quiet operation ,maven dont throw too much outputs :
    # mvn clean verify -Dcucumber.options="--tags @smoke_test" -q

  # another better method to run smoke test is :
  # 1, we added profile in pom.xml
  # 2, then we run in terminal : mvn clean test -P Smoke  --> P means Profile
  # this command run smoke test based on profile id, not based on entire build to run
