Feature: Wikipedia search functionality
  As a user, I should be able to search terms and see relevant information
  Case: Search for "Steve Jobs", the title, the header, and the image header
  should be displayed as "Steve Jobs"


  Scenario: Wikipedia Search Functionality Title Verification
    Given user lands on Wikipedia home page
    When user types "Steve Jobs" in the search box
    And clicks the search button
    Then user sees "Steve Jobs" in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    Given user lands on Wikipedia home page
    When user types "Steve Jobs" in the search box
    And clicks the search button
    Then user sees "Steve Jobs" is in the main header

    @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Header Verification
    Given user lands on Wikipedia home page
    When user types "<searchValue>" in the search box
    And clicks the search button
    Then user sees "<expectedMainHeader>" is in the main header
    Then user sees "<expectedTitle>" in the wiki title

    Examples: search terms we are going to use in this template are below
      | searchValue   | expectedMainHeader | expectedTitle |
      | Tony Romo     | Tony Romo          | Tony Romo     |
      | Steve Jobs    | Steve Jobs         | Steve Jobs    |
      | Josh Hamilton | Josh Hamilton      | Josh Hamilton |


  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user lands on Wikipedia home page
    When user types "Steve Jobs" in the search box
    And clicks the search button
    Then user sees "Steve Jobs" is in the image header





