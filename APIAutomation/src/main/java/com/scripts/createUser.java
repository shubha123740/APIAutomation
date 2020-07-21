package com.scripts;
import static io.restassured.RestAssured.given;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import io.restassured.internal.util.IOUtils;
public class createUser {
	static String response;
	static List<String> list = new ArrayList<String>();
	static String id;

	/*@DataProvider(name = "dataforPost2")
	public Object[][] dataforPost2() {

	

		return new Object[][] {

				{ "morpheus", "leader" }, { "sonam", "leader" }, { "shubha", "leader" }, { "shikha", "job" },
				{ "sonia", "leader" },

		};

	}*/

	@Test
	public static void createusers() throws IOException {
		
		FileInputStream FileInputStream=new FileInputStream(new File("C:\\Users\\user\\git\\APIAutomation\\APIAutomation\\Json\\data.json"));
		RestAssured.baseURI = "https://reqres.in";
		/*JSONObject requestParams = new JSONObject();
		requestParams.put("name", name);
		requestParams.put("job", job);*/

		
		response = given().header("Content-Type", "application/json").body(IOUtils.toString(FileInputStream, "UTF-8")).

				when().post("https://reqres.in/api/users").

				then().assertThat().statusCode(201)
//.extract().body().asString()
				.extract().path("id");
		System.out.println(id);

	}

}
