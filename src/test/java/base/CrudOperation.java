package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utilities.PropertiesReader;

public class CrudOperation {
	
	public static String accessKey;

	public Response performGETcall(String apiName) {
		PropertiesReader pro = new PropertiesReader();

		RequestSpecBuilder builder = new RequestSpecBuilder();

		builder.setBaseUri(pro.getPropValue("ExchangeRateBaseURI"));
		builder.addQueryParam("access_key", accessKey);
		builder.setContentType("application/json");
		RequestSpecification reqspec = builder.build();
		reqspec = RestAssured.given().spec(reqspec);
		Response response = null;
		if(apiName.equals("LatestRates")) {
			response = reqspec.get("/v1/latest/").then().extract().response();
		}
		System.out.println(response);
		return response;
	}

	public Response performPOSTcall(String apiName) {
		Response response = null;

		return response;
	}

}
