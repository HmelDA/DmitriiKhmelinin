Feature: Service Different elements

  Scenario: Different elements page test
    Given I open JDI GitHub site
    Then Test site is opened
    When I login as user "Roman Iovlev"
    Then "Roman Iovlev" is loggined
    When I click on "Service" button in Header
    And I click on "Different elements" button in Service Dropdown
    Then "Different elements" page should be opened
    When I click on "Water" and "Wind" checkboxes
    Then Elements are checked
    And I click on "Selen" radio
    Then Radio is checked
    And I select "Yellow" color in dropdown
    Then Element is checked
    Then Log rows are displayed in the Log Panel and its status corresponding to selected checkboxes, radio and color



