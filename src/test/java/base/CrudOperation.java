package base;

import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CrudOperation  {
	static Response response;
	RequestSpecification reqspec;
	public static String resourceUri;
	
	public Response performGETcall(String apiName) throws FileNotFoundException {
		APIResources resourceAPI;
		
		if(apiName.equalsIgnoreCase("LatestRates")) 
		{
			resourceAPI= APIResources.valueOf(apiName);
			reqspec = new BaseBuilder().latestRateSpecBuilder();
			System.out.println("Sending GET request to: "+resourceAPI.getResource()+" service");
			reqspec = RestAssured.given().spec(reqspec);
			response = reqspec.get(resourceAPI.getResource()).then().extract().response();
		}
		else if(resourceUri!=null) {
			reqspec = new BaseBuilder().latestRateSpecBuilder();
			System.out.println("Sending GET request to: "+resourceUri+" service");
			reqspec = RestAssured.given().spec(reqspec);
			response = reqspec.get(resourceUri).then().extract().response();
		}
		else if(apiName.equalsIgnoreCase("DateRates")) 
		{
			reqspec = new BaseBuilder().dateSpecBuilder();
			System.out.println("Sending GET request to: "+resourceUri+" service");
			reqspec = RestAssured.given().spec(reqspec);
			response = reqspec.get(resourceUri).then().extract().response();
		}
		return response;
	}
	

}
