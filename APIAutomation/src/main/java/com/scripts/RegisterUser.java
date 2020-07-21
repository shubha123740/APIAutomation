package com.scripts;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RegisterUser {
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest extentTest;
	@BeforeTest
	public void extentReportSetup() {
		
		//location of the extent report
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		 
		 extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

		// General information releated to application
		extent.setSystemInfo("Application Name", "Google Test");
		extent.setSystemInfo("User Name", "Ankur Jain");
		extent.setSystemInfo("Envirnoment", "Production");
		System.out.println("mineeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	}

	@AfterSuite
	public void endReport() {
		System.out.println("mineeeeeeeeeeeeee7677eeeeeeeeeeeeeeeeeeeeeeeeeeee");
		extent.flush();
	}
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
