package base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertiesReader;

public class BaseBuilder {
	PropertiesReader pro = new PropertiesReader();
	RequestSpecBuilder builder;
	RequestSpecification reqspec;
	Response response;
	PrintStream log;
	public static String accessKey;
	public static String resourceUri;

	public RequestSpecification latestRateSpecBuilder() throws FileNotFoundException {
		builder = new RequestSpecBuilder();

		builder.setBaseUri(pro.getPropValue("ExchangeRateBaseURI"));

		System.out.println("Building Headers....");
		if(accessKey!=null) {
			builder.addQueryParam("access_key", accessKey);
		}else {
			builder.addQueryParam("access_key", pro.getPropValue("ACCESS_KEY"));
		}
		builder.setContentType("application/json");
		log = new PrintStream(new FileOutputStream("log.txt"));
		builder.addFilter(RequestLoggingFilter.logRequestTo(log));
		builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
		reqspec = builder.build();
		return reqspec;
	}
	

}
