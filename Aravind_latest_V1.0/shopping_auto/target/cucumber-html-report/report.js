$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Shopping.feature");
formatter.feature({
  "line": 1,
  "name": "Test Shopping site",
  "description": "",
  "id": "test-shopping-site",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "As a customer, I want to launch Shopping site",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Launch the shopping url",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I check whether website is opened",
  "keyword": "And "
});
formatter.match({
  "location": "shopping_auto.launch_the_shopping_url()"
});
formatter.result({
  "duration": 39096870900,
  "status": "passed"
});
formatter.match({
  "location": "shopping_auto.check_the_shopping_url()"
});
formatter.result({
  "duration": 30288800,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "As a customer, I want to Order a dress for First Time",
  "description": "",
  "id": "test-shopping-site;as-a-customer,-i-want-to-order-a-dress-for-first-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I click on the Women column to select Summer Dresses",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I am navigated to Summer Dresses section",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I Add a dress to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on cart to Check out",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I am navigated to Shipping Cart Summary Page to checkout",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I login as existing customer",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I choose address as home adress",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I proceed to checkout by agreeing terms and conditions",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I pay by Bank Wire",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I confirm Order",
  "keyword": "And "
});
formatter.match({
  "location": "shopping_auto.select_summer_dresses()"
});
formatter.result({
  "duration": 7797041600,
  "status": "passed"
});
formatter.match({
  "location": "shopping_auto.verify_summerdressessection()"
});
formatter.result({
  "duration": 52182100,
  "status": "passed"
});
formatter.match({
  "location": "shopping_auto.add_dress()"
});
formatter.result({
  "duration": 4373086600,
  "status": "passed"
});
formatter.match({
  "location": "shopping_auto.check_out()"
});
formatter.result({
  "duration": 5470075300,
  "status": "passed"
});
formatter.match({
  "location": "shopping_auto.shipping_checkout()"
});
formatter.result({
  "duration": 4876722400,
  "status": "passed"
});
formatter.match({
  "location": "shopping_auto.login_customer()"
});
formatter.result({
  "duration": 3096574500,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});