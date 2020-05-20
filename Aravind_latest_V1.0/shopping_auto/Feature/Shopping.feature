Feature: Test Shopping site

Background: As a customer, I want to launch Shopping site
Given Launch the shopping url
And I check whether website is opened

@run
Scenario: As a customer, I want to Order a dress for First Time
When I click on the Women column to select Summer Dresses
Then I am navigated to Summer Dresses section
And I Add a dress to the cart
And I click on cart to Check out
Then I am navigated to Shipping Cart Summary Page to checkout
And I login as existing customer with "aravindc@maveric-systems.com" and "Apples123"
And I choose address as home adress
And I proceed to checkout by agreeing terms and conditions
And I pay by Bank Wire
And I confirm Order

@run
Scenario: As a customer, I want to Register into website
When I click on Sign in to register
And I click on Create Account by verifying whether Email is already registered
Then I am navigated to Registeration page
And I enter all the info related to Personal Information
And I verify personal Information with the Address column
And I enter all the required information in Address
And I complete the registeration process
And I verify whther I am logged In

@run
Scenario: As a customer, I want to Order one more dress
When I search T-shirt in search box
And I add a dress of two different colours to the cart
And I click on cart to Check out
Then I am navigated to Shipping Cart Summary Page to checkout
And I login as existing customer with "aravindc@maveric-systems.com" and "Apples123"
And I choose address as home adress
And I proceed to checkout by agreeing terms and conditions
And I pay by Bank Wire
And I confirm Order

@run
Scenario: As a customer, I want to update my address
When I click on Sign in
And I enter my credentials that is specified in properties file
And I click on My Addresses to update my address with New Address
Then I verify whether Address is updated

@run
Scenario Outline: As a tester, I want to test scenario outline in Fashion website
When I click on Sign in
And I enter my credentials "<username>" and "<password>"
Then I logged out
Examples:
    | username   | password |
    | aravindc@maveric-systems.com | Apples123 |
    | boss@gmail.com | romeo123 |
