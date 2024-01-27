Feature: Maps

  @AddPlaceAndGetPlace @Regression
  Scenario Outline: Verify that the Add Place and Get Place feature functionalities are working as expected
    Given Create add place payload with "<name>" "<language>" "<address>"
    When User calls API with "AddPlaceApiResource" and "POST" HTTP request method
    Then To check if the API call was successful with a status code of 200
    And To check if "status" in the response body is "OK"
    And To check if "scope" in the response body is "APP"
    And Verify that place_Id created with respect to "<name>" using "GetPlaceApiResource"

    Examples:
      | name               | language | address |
      | The Phoenix House  | Hindi    | India   |
#      | The Peacock Palace | English  | US      |

  @DeletePlace @Regression
  Scenario: verify that the delete place feature functionality is working as expected
    Given Create delete place payload
    When User calls API with "DeletePlaceResource" and "POST" HTTP request method
    Then To check if the API call was successful with a status code of 200
    And To check if "status" in the response body is "OK"