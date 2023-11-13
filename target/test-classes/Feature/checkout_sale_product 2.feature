Feature: Sale product checkout

  @chrome
  Scenario: Checkout of sale prodduct
    Given Add two sale product to cart
    Then verify the total amount is "$118.00"