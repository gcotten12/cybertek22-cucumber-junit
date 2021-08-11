Feature: TryIt editor application

  @wip
  Scenario: Double click test
    Given user is on tryit editor page
    And user switches to "iframeResult"
    When user double clicks on double click text
    Then text's style attribute value should contain "red"