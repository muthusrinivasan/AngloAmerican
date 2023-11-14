Feature: End to end order scenario as Guest

  @chrome
  Scenario: To verify sucessful order as Guest
    Given Add product "Skinsheen Bronzer Stick" and checkout
  	Then I choose continue as "guest"
  	Then I fill the user details
  	And I confirm order
  	Then verify the confirm message " Your Order Has Been Processed!"
