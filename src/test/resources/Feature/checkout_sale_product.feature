Feature: Checkout sales product and verify the cart

  @chrome
  Scenario: Add sale product to cart and verify total amount
    Given Add sale product "Absolue Eye Precious Cells"
    Given Add sale product "ck one Summer 3.4 oz"
    Then verify the total amount is "$118.00"