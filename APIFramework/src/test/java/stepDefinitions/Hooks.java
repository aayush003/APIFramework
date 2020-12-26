package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//execute this case only when placeid is null
		StepDefinition sd = new StepDefinition();
		
		if(StepDefinition.place_id == null)
		{
		sd.add_place_payload("Shiti", "Mallu", "Kumar Colony");
		sd.user_calls_with_post_http_request("AddPalceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("Shiti", "GetPlaceAPI");
		}
	}

}
