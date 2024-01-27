Feature: Maps

  Scenario Outline: Verify that the Add Place and Get Place feature functionality is working as expected
    Given Create add place payload with "<name>" "<language>" "<address>"
    When User calls API with an http request
    Then To check if the API call was successful with a status code of 200
    And To check if "status" in the response body is "OK"
    And To check if "scope" in the response body is "APP"
    And Verify that place_Id created with respect to "<name>" using "getPlaceAPI"

    Examples:
      | name              | language | address |
      | The Dragon's Lair | Hindi    | India   |
#      | The Phoenix House | English  | US      |