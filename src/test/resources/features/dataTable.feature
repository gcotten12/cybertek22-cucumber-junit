Feature: Examples of Cucumber data table implementations


  Scenario: Something happens
    #Given user does something
    Then user should see below words displayed
    #Data table created with pipes
      | Apple      |
      | Kiwi       |
      | Strawberry |
      | Mango      |
      | Tomato     |


  Scenario: Library login example using data table
    Given user is on the login page of library app
    When user enters username and password as below
      | username | student11@library |
      | password | tScBPCUr          |
      Then user should see title is Library
