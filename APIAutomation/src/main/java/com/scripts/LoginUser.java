package com.scripts;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginUser {
	/*@DataProvider(name="dataforPost3")
	public Object[][] dataforPos3t() {
		
		
		
		
		
		return new Object [][] {
		    
				{"eve.holt@reqres.in", "cityslicka"},
				
				
		};	
			
		}*/
    @Test
	public void login() throws IOException{
		RestAssured.baseURI ="https://reqres.in";
		FileInputStream FileInputStream=new FileInputStream(new File("C:\\Users\\user\\git\\APIAutomation\\APIAutomation\\Json\\data.json"));
		/*JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); 
	  	requestParams.put("password",password);*/
		 
	  	 
	given()
	     .header("Content-Type", "application/json")
	     .body(IOUtils.toString(FileInputStream, "UTF-8")).
	
		 when()
         .post("https://reqres.in/api/login").
 then().
         statusCode(200)
        .log().all();
        
	}
}
