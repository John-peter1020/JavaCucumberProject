package stepDefinition;

import org.junit.Assert;
import base.CrudOperation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.PropertiesReader;

public class ERStepDefinition extends CrudOperation {
	PropertiesReader pro = new PropertiesReader();
	public static Response response;
	
	
	@Given("The user have proper Access key")
	public void the_user_have_proper_access_key() {
		CrudOperation.accessKey = pro.getPropValue("ACCESS_KEY");
	}
	@When("The user sents {string} request to {string} API with API key")
	public void the_user_sents_request_to_api_with_api_key(String string, String string2) {
		if(string.equalsIgnoreCase("GET")) {
			response = performGETcall(string2);
		}
	}
	@Then("API should return status as {int}")
	public void api_should_return_status_as(int int1) {
		System.out.println("Status Code: "+response.statusCode());
		Assert.assertEquals(response.statusCode(), int1);
	}


}
