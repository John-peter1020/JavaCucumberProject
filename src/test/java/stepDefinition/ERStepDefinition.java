package stepDefinition;

import java.io.FileNotFoundException;
import org.junit.Assert;
import utilities.Utilities;
import base.BaseBuilder;
import base.CrudOperation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.PropertiesReader;

public class ERStepDefinition extends CrudOperation {
	PropertiesReader pro = new PropertiesReader();
	public static Response response;
	JsonPath js;
	
	
	@Given("^The user have proper Access key$")
	public void the_user_have_proper_Access_key() throws Exception {
		BaseBuilder.accessKey = pro.getPropValue("ACCESS_KEY");
	}
	
	@When("The user sents {string} request to {string} API with API key")
	public void the_user_sents_request_to_api_with_api_key(String requestType, String apiName) throws FileNotFoundException  {
		if(requestType.equalsIgnoreCase("GET")) {
			response = performGETcall(apiName);
		}
	}
	
	@Then("API should return status as {int}")
	public void api_should_return_status_as(int int1) {
		System.out.println("Status Code: "+response.statusCode());
		Assert.assertEquals(response.statusCode(), int1);
	}

	
	@Then("API should return {string} as {string} in response body")
	public void api_should_return_as_in_response_body(String string, String string2) {
		js = Utilities.rawToJson(response);
		Assert.assertEquals(js.get(string).toString(), string2);
	}
	
	@When("an incorrect or incomplete resource uri is provided as {string}")
	public void an_incorrect_or_incomplete_resource_uri_is_provided_as(String string) {
		CrudOperation.resourceUri=string;
	}

	@When("The user sents {string} request to {string} API with date as {string}")
	public void the_user_sents_request_to_api_with_date_as(String requestType, String apiName, String date) throws FileNotFoundException {
		if(requestType.equalsIgnoreCase("GET")) {
			CrudOperation.resourceUri="/v1/"+date;
			response = performGETcall(apiName);
		}
	}
	
	
}
