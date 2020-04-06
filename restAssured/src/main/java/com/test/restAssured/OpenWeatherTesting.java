package com.test.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherTesting {
	
	@Test
	public void testResponseOpenWeather(){
		// The resonse hold the entire data from the get Request
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/"
				+ "weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int status =resp.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status,200);
		
	}
	@Test
	public void testResponseOpenWeather_tc002(){
		// The resonse hold the entire data from the get Request
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/"
				+ "weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int status =resp.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status,400);
		
	}

	@Test
	public void testResponseOpenWeather_tc003(){
		// The resonse hold the entire data from the get Request
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/"
				+ "weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String resp_body=resp.asString();
		System.out.println(resp_body);
		
	}
	@Test
	public void testResponseOpenWeather_tc004(){
		// The resonse hold the entire data from the get Request
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/"
				+ "weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String resp_body=resp.asString();
		System.out.println(resp.getTime());
		
	}



}
