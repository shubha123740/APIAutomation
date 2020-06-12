package com.scripts;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginUser {
	@DataProvider(name="dataforPost3")
	public Object[][] dataforPos3t() {
		
		
		
		
		
		return new Object [][] {
		    
				{"eve.holt@reqres.in", "cityslicka"},
				
				
		};	
			
		}
    @Test(dataProvider="dataforPost3")
	public void login(String email,String password){
		RestAssured.baseURI ="https://reqres.in";
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); 
	  	requestParams.put("password",password);
		 
	  	 
	given()
	     .header("Content-Type", "application/json")
	     .body(requestParams.toJSONString()).
	
		 when()
         .post("https://reqres.in/api/login").
 then().
         statusCode(200);
        // log().all();
        
	}
}
