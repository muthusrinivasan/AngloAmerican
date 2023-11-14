Feature: Verify filter functionality

  @chrome
  Scenario: To verify the filter in home page
    Given I select "Fragrance" from search field
    Then I enter "CK" in it and search
    And I verify 3 products in search result
    Then All product should have "CK" in its name 
