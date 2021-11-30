package com.qa.logomedia.stepDefs;
import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;




public class CalculatorApiTests {
	

	
	public static String getCurrectValue() {
		
		RestAssured.baseURI = "https://qa-test-rpncalc.azurewebsites.net/";
		 
		Response response = given().contentType(ContentType.JSON). 
				
		when().get("/api/RpnCalc/stack").
		
		then().log().all().extract().response();
		
		Assert.assertEquals(200, response.statusCode());	
		
		return response.body().asString();
	}
	
	
	
	
	public static void addNumber(String num1) {
		
		RestAssured.baseURI = "https://qa-test-rpncalc.azurewebsites.net/";
		 
		
		Response response = given().contentType(ContentType.JSON). 
				
		when().post("/api/RpnCalc/push?value="+ num1).
		
		then().log().all().extract().response();
		
		Assert.assertEquals(200, response.statusCode());
	
	
	}
	
//	
//	@Test
//	public void  testingAddition() {
//		
//		deleteMethod();
//		addNumber("10");
//		addNumber("10");
//		performOperation("Addition",200);
//		String expected = getCurrectValue();
//		System.out.print("EXPECTED    " + expected.toString());
//		Assert.assertEquals(expected, "[20]");
//		
//		
//		
//	}
	
	
	
	
	
	
	
	
	public static void performOperation(String operation, int statusCode) {
		RestAssured.baseURI  = "https://qa-test-rpncalc.azurewebsites.net";
		
		Response response = given().contentType(ContentType.JSON). 
				
				when().post("/api/RpnCalc/operation?operationType="+operation).
				
				then().log().all().extract().response();
				
			Assert.assertEquals(statusCode, response.statusCode());
			System.out.print("THIS IS BODY "+ response.body().asString());
	}
	
	
	
	
	
	
	
	


@Test
public void  negativeDivisionByZero() {
	
	deleteMethod();
	addNumber("10");
	addNumber("0");
	performOperation("Division",500);
	String expected = getCurrectValue();
	System.out.print("EXPECTED    " + expected.toString());
	Assert.assertEquals(expected, "[]");
	
	
	
}


//@Test
//public void  multiplicationTwoNegativeNums() {
//	
//	deleteMethod();
//	addNumber("-10");
//	addNumber("-14");
//	performOperation("Multiplication",200);
//	String expected = getCurrectValue();
//	System.out.print("EXPECTED    " + expected.toString());
//	Assert.assertEquals(expected, "[140]");
//	
//	
//	
//}



	
	
	public static void  deleteMethod() {
		
		
		RestAssured.baseURI  =  
				"https://qa-test-rpncalc.azurewebsites.net";
		
		Response response = given().contentType(ContentType.JSON). 
				
				when().delete("/api/RpnCalc").
				
				then().log().all().extract().response();
				
			Assert.assertEquals(200, response.statusCode());
			System.out.print("THIS IS BODY "+ response.body());
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	