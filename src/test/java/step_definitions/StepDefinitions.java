package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import resources.APIResource;
import resources.TestData;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinitions extends Utils {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpecification;
    Response response;
    TestData testData = new TestData();
    static String placeId;

    @Given("Create add place payload with {string} {string} {string}")
    public void create_add_place_payload_with(String name, String language, String address) throws IOException {
        requestSpec = given().spec(getRequestSpecification())
                .body(testData.getAddPlacePayload(name, language, address));
    }

    @When("User calls API with {string} and {string} HTTP request method")
    public void user_calls_api_with_and_http_request_method(String resource, String HTTPRequestMethod) {
/*
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
*/

        APIResource apiResource = APIResource.valueOf(resource);
        System.out.println(apiResource.getResource());

        if (HTTPRequestMethod.equalsIgnoreCase("POST")) {
            response = requestSpec.when().post(apiResource.getResource());
        } else if (HTTPRequestMethod.equalsIgnoreCase("GET")) {
            response = requestSpec.when().get(apiResource.getResource());
        }
    }

    @Then("To check if the API call was successful with a status code of {int}")
    public void to_check_if_the_api_call_was_successful_with_a_status_code_of(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("To check if {string} in the response body is {string}")
    public void to_check_if_in_the_response_body_is(String key, String expectedValue) {
        Assert.assertEquals(expectedValue, getResponseValue(response, key));
    }

    @Then("Verify that place_Id created with respect to {string} using {string}")
    public void verify_that_place_id_created_with_respect_to_using(String expectedName, String resource) throws IOException {
        placeId = getResponseValue(response, "place_id");
        requestSpec = given().spec(getRequestSpecification()).queryParam("place_id", placeId);
        user_calls_api_with_and_http_request_method(resource, "GET");
        String actualName = getResponseValue(response, "name");
        Assert.assertEquals(actualName, expectedName);
    }

    @Given("Create delete place payload")
    public void create_delete_place_payload() throws IOException {
        requestSpec = given().spec(getRequestSpecification()).body(testData.getDeletePlacePayload(placeId));
    }

}
