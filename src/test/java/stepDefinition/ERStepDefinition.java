package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ERStepDefinition {
	
	@Given("The user have proper Access key")
	public void the_user_have_proper_access_key() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
	@When("The user sents {string} request to {string} API with API key")
	public void the_user_sents_request_to_api_with_api_key(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
	@Then("API should return status as {int}")
	public void api_should_return_status_as(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}


}
