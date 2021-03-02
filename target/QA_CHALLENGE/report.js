$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/booking.feature");
formatter.feature({
  "line": 3,
  "name": "Checkout booking functionality",
  "description": "",
  "id": "checkout-booking-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@flightBooking"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Products booking",
  "description": "",
  "id": "checkout-booking-functionality;products-booking",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "the customer is on swagLabs landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "customer enters their login credentials \u003cuserName\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "a customer add two products to your shopping cart",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "a customer confirm that the correct products are added to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "a customer add the personal information \u003cfirstname\u003e \u003clastname\u003e and \u003cpostalcode\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "on the Checkout, the verify screen confirms that the total price is correct the sum of the two products",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "a customer finishes an order",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "confirm that the order confirmation screen is displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "checkout-booking-functionality;products-booking;",
  "rows": [
    {
      "cells": [
        "userName",
        "password",
        "firstname",
        "lastname",
        "postalcode"
      ],
      "line": 16,
      "id": "checkout-booking-functionality;products-booking;;1"
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce",
        "QA",
        "Engineer",
        "1680"
      ],
      "line": 17,
      "id": "checkout-booking-functionality;products-booking;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 17,
  "name": "Products booking",
  "description": "",
  "id": "checkout-booking-functionality;products-booking;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@flightBooking"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the customer is on swagLabs landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "customer enters their login credentials standard_user and secret_sauce",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "a customer add two products to your shopping cart",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "a customer confirm that the correct products are added to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "a customer add the personal information QA Engineer and 1680",
  "matchedColumns": [
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "on the Checkout, the verify screen confirms that the total price is correct the sum of the two products",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "a customer finishes an order",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "confirm that the order confirmation screen is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.the_customer_is_on_swaglabs_landing_page()"
});
formatter.result({
  "duration": 3302694808,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 40
    },
    {
      "val": "secret_sauce",
      "offset": 58
    }
  ],
  "location": "Stepdefinition.customer_enters_their_login_credentials_and(String,String)"
});
formatter.result({
  "duration": 4270494901,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.a_customer_add_two_products_to_your_shopping_cart()"
});
formatter.result({
  "duration": 114291159,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.aCustomerConfirmThatTheCorrectProductsAreAddedToTheCart()"
});
formatter.result({
  "duration": 388830993,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "QA",
      "offset": 40
    },
    {
      "val": "Engineer",
      "offset": 43
    },
    {
      "val": "1680",
      "offset": 56
    }
  ],
  "location": "Stepdefinition.aCustomerAddThePersonalInformationFirstnameLastnameAndPostalcode(String,String,String)"
});
formatter.result({
  "duration": 582189296,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.onTheCheckoutTheVerifyScreenConfirmsThatTheTotalPriceIsCorrectTheSumOfTheTwoProducts()"
});
formatter.result({
  "duration": 2045711376,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.aCustomerFinishesAnOrder()"
});
formatter.result({
  "duration": 65459004,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.confirm_that_the_order_confirmation_screen_is_displayed()"
});
formatter.result({
  "duration": 2046871827,
  "status": "passed"
});
