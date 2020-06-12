package com.scripts;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RegisterUser {
	@DataProvider(name="dataforPost")
	public Object[][] dataforPost() {
		
		
		return new Object [][] {
		    
				{"eve.holt@reqres.in", "pistol"},
				
				
		};	
			
		}
	
	
	@Test(dataProvider="dataforPost")
	public void register(String email,String password){
		RestAssured.baseURI ="https://reqres.in";
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); 
	  	requestParams.put("password", password);
	  
		
	given()
	     .header("Content-Type", "application/json")
	     .body(requestParams.toJSONString()).

		 when()
	     .post("https://reqres.in/api/register").
	then().
	     statusCode(200);
	     //log().all();
	    
	}
}
