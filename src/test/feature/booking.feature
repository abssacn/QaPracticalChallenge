@flightBooking

Feature: Checkout booking functionality

  Scenario Outline: Login to the system
    Given the customer is on swagLabs landing page
    When customer enters their login credentials <userName> and <password>
    And a customer add two products to your shopping cart
    And a customer confirm that the correct products are added to the cart
    And a customer add the personal information <firstname> <lastname> and <postalcode>
    And on the Checkout, the verify screen confirms that the total price is correct the sum of the two products
    And a customer finishes an order
    Then confirm that the order confirmation screen is displayed

    Examples:
      | userName      | password     | firstname | lastname | postalcode |
      | standard_user | secret_sauce | QA        | Engineer | 1680       |



