Feature: User Management API


  @Create
  Scenario: Create a new user
    Given I create a user with name "Kakha" and job "TA"
    Then the user should be created with name "Kakha" and job "TA"
    And the user ID and creation date should not be null

  @Create
  Scenario: Create user with missing job
    Given I create a user with name "" and job ""
    Then the user should not have an id


  @Read
  Scenario: Get an existing user
    Given I request to get the user with ID 1
    Then the user with ID 1 should be returned with email "george.bluth@reqres.in"
    And the user's first name should be "George" and last name should be "Bluth"
    And the support URL should contain "contentcaddy.io"
    And the response status code should be 200

    @Read
    Scenario: Get a non-existent user
    Given I request to get the non-existent user with ID 9999
    Then no support data should be available
    And the response status code should be 404

  @Update
  Scenario: Update an existing user
    Given I update the user with ID 5 to have name "luka" and job "TA"
    Then the user should be updated with name "luka" and job "TA"
    And the update date should not be null
  @Update
  Scenario: Update a user with invalid data
    Given I update the user with ID 3 with empty name and job
    Then the user's name and job should not be empty
  @Update
  Scenario: Update non-existing user
    Given I update the user with ID 999999999 to have name "Kakha" and job "TA"
    Then the response status code should be 404

  @Delete
    Scenario: Delete existing user
    When I delete the user with ID 2
    Then the response status code should be 204
    And the user should be deleted successfully
  @Delete
  Scenario: Delete an existing user
    Given I delete the user with ID 12
    Then the response status code should be 204
    Then the user should be deleted successfully

  @Delete
  Scenario: Delete a non-existent user
    Given I delete the non-existent user with ID 999999
    Then the response status code should be 404
