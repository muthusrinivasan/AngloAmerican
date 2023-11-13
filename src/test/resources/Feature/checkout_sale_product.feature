Feature: Checkout sales product and verify the cart

  @chrome
  Scenario: Add sale product to cart and verify total amount
    Given Add two sale product to cart
    Then verify the total amount is "$118.00"