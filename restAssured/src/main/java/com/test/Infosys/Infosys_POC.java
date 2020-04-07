package com.test.Infosys;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Infosys_POC {
	
	@Test// Prints the getBody() method for the given API 
	public void testResponseOpenWeather_GetRequest(){
		// The resonse hold the entire data from the get Request
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1");
		String responseBody = resp.getBody().asString();
			ResponseBody body = resp.getBody();
		System.out.println("Response Body is =>  " + responseBody);
		System.out.println("-----------------------------------------");
		System.out.println("This is from response body "+body);
		  
	    //to get last received session id from the server and print the value returned
	    String id=resp.getSessionId();
	    System.out.println("Session ID: "+ id);
	    
	    //to get the value of the content-type header field and print the value returned
	    String contentType = resp.getContentType();
	    System.out.println("Content-Type value: "+contentType);
		
	}
	
	

	@Test// Prints the getBody() method for the given API 
	public void testopenWeather_BaseURI_RequestSpecification(){
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/forecast/daily";

				RequestSpecification httprequest = RestAssured.given();
				Response response = httprequest.request(Method.GET, "?id=524901&appid=b1b15e88fa797225412429c1c50c122a1");
				int statusCode = response.getStatusCode();
				System.out.println(statusCode);
						String contentType = response.getContentType();
						System.out.println(contentType);
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is =>  " + responseBody);
				
				String statusLine = response.getStatusLine();
				System.out.println("Status Line: "+statusLine );
				System.out.println("-----------------------------------");
				
				
				Headers allHeaders = response.getHeaders();
				for(Header header : allHeaders) {
					System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
				}
				
				System.out.println("-----------------------------------------");
				
				String coontentType = response.header("Content-Type");
				System.out.println("Content-Type value: " + coontentType);
				// Reader header is passed with exact header name as argument.
				// In the below line,we will get header named "Server"
				String serverType =  response.header("Server");
				System.out.println("Server value: " + serverType);
				// Reader header is passed with exact header name as argument.
				// In the below line,we will get header named "Date"
				String date = response.header("Date");
				 System.out.println("Date value: " + date);
	}
	
	@Test// Prints the getBody() method for the given API 
	public void JsonPath(){
		// The resonse hold the entire data from the get Request
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1");
		String responseBody = resp.getBody().asString();
		ResponseBody body = resp.getBody();
	System.out.println("Response Body is =>  " + responseBody);
	
		io.restassured.path.json.JsonPath json = resp.jsonPath();
		Object object = json.get("city.geoname_id");
		System.out.println("The status cod is : "+object.toString());
		
		
	}
	

}
