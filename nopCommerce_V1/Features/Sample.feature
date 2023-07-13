#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login feature file
  I want to use this template for Login

  @tag1
  Scenario: Successful Login with Valid Credentials
    Given User launch chrome browser
    And some other precondition
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And USer enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login"
    And close browser

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
