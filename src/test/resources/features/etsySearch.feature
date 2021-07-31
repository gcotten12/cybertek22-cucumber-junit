@smoke
Feature: Etsy search feature

  Scenario: Etsy default title verification
    Given user is on Etsy landing page
    Then user should see Etsy title as expected

    #expected : Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone


  Scenario: Etsy search functionality verification
    Given user is on Etsy landing page
    When user types Wooden Spoon in the search bar
    And user clicks to search button
    Then user sees title is Wooden Spoon | Etsy