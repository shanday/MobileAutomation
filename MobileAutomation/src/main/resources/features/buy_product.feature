Feature: Buy Product on Sauce Labs App
  Scenario: User buys 2 blue backpacks on Sauce Labs App
    Given User is on the home screen
    When User selects Sauce Lab Back Packs product
    And User selects Blue color
    And User increases the item quantity
    And User adds the product to the cart
    And User proceeds to checkout
    Then User should be redirected to the login page