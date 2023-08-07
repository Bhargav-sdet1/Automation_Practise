
Feature: Validating Login API

  Scenario: Verifying Login API with valid Email and PWD
    Given Login payload
    When user calls "Login" with POST HTTP request
    Then the API call got success with  200
    And "status" in response body is "OK"
    And "message" in response body is "Login Successfully"
    

