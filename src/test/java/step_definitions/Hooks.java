package step_definitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //execute this code only when place id is null
        //write a code that will give you place id
        StepDefinitions stepDefinitions = new StepDefinitions();
        if (StepDefinitions.placeId == null) {
            stepDefinitions.create_add_place_payload_with("The Emerald Castle", "French", "France");
            stepDefinitions.user_calls_api_with_and_http_request_method("AddPlaceApiResource", "POST");
            stepDefinitions.verify_that_place_id_created_with_respect_to_using("The Emerald Castle", "GetPlaceApiResource");
        }
    }
}
