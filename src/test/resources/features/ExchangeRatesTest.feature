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
Feature: Exchange Rate API Test

  @tag1
  Scenario: Verify Rates API with Valid Status Code 
  	Given The user have proper Access key
    When The user sents "GET" request to "LatestRates" API with API key 
    Then API should return status as 200

	@tag2
  Scenario: Verify Rates API with Valid response
    Given The user have proper Access key
    When The user sents "GET" request to "LatestRates" API with API key
    Then API should return "success" as "true" in response body
    
	@tag3
  Scenario: Verify Rates API gives proper response when resource uri is incorrect
    Given The user have proper Access key
    When an incorrect or incomplete resource uri is provided as "/api/"
    When The user sents "GET" request to "incorrectpath" API with API key
    Then API should return "success" as "false" in response body    
    