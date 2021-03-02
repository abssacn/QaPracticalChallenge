package org.QaPracticalChallange.stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.QaPracticalChallange.actions.Actions;
import org.QaPracticalChallange.utils.SeleniumDriverMethods;


public class Stepdefinition {

    @Given("^the customer is on swagLabs landing page$")
    public void the_customer_is_on_swaglabs_landing_page() throws Throwable {
        SeleniumDriverMethods.launchBrowser();
    }

    @When("^customer enters their login credentials (.+) and (.+)$")
    public void customer_enters_their_login_credentials_and(String username, String password) {
        Actions.Login(username,password);
    }

    @And("^swagLabs home page must load successfully$")
    public void swaglabs_home_page_must_load_successfully() {
    }

    @And("^a customer add two products to your shopping cart$")
    public void a_customer_add_two_products_to_your_shopping_cart() {
        Actions.AddProducts();
    }

    @Then("^a customer confirm that the correct products are added to your cart$")
    public void a_customer_confirm_that_the_correct_products_are_added_to_your_cart() {
        Actions.verifyValueAdded();
    }

    @Then("^a customer confirm that the correct products are added to the cart$")
    public void aCustomerConfirmThatTheCorrectProductsAreAddedToTheCart() {
        Actions.verifyValueAdded();
    }

    @And("^a customer add the personal information (.*) (.*) and (.*)$")
    public void aCustomerAddThePersonalInformationFirstnameLastnameAndPostalcode(String name, String surname, String postalAdd) throws Throwable {
        Actions.enterDetails(name, surname, postalAdd);
    }

    @Then("^on the Checkout, the verify screen confirms that the total price is correct the sum of the two products$")
    public void onTheCheckoutTheVerifyScreenConfirmsThatTheTotalPriceIsCorrectTheSumOfTheTwoProducts() throws Throwable{
        Actions.assertAndConfirmsOrder();
    }

    @Then("^a customer finishes an order$")
    public void aCustomerFinishesAnOrder() {
        Actions.finishOrder();
    }

    @Then("^confirm that the order confirmation screen is displayed$")
    public void confirm_that_the_order_confirmation_screen_is_displayed() throws Throwable {
        Actions.finaliseOrder();
    }

}
