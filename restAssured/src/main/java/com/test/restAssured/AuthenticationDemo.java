package com.test.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class AuthenticationDemo {
	
	@Test
	public void preEmptive(){
		
		int code = RestAssured.given().auth().preemptive().basic("ToolsQA","TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusCode();
		System.out.println(code);
	}
	
	@Test
	public void preEmptiveFail(){
		
		String asString = RestAssured.given().auth().preemptive().basic("ToolsQA","TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").asString();
	  int statusCode = RestAssured.given().auth().basic("ToolsQA","TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusCode();
	String statusLine = RestAssured.given().auth().basic("ToolsQA","TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusLine();
		System.out.println(asString);
		System.out.println(statusCode);
		System.out.println(statusLine);
	}


}
