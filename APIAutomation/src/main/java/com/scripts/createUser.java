package com.scripts;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
public class createUser {
	static String response;
	static List<String> list = new ArrayList<String>();
	static String id;

	@DataProvider(name = "dataforPost2")
	public Object[][] dataforPost2() {

	

		return new Object[][] {

				{ "morpheus", "leader" }, { "sonam", "leader" }, { "shubha", "leader" }, { "shikha", "job" },
				{ "sonia", "leader" },

		};

	}

	@Test(dataProvider = "dataforPost2")
	public static void createusers(String name, String job) {
		RestAssured.baseURI = "https://reqres.in";
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", name);
		requestParams.put("job", job);

		list.add(response);
		for (int i = 0; i < list.size(); i++) {
			if (i == 4) {
				id = response;
				System.out.println(id);
			}
		}

		response = given().header("Content-Type", "application/json").body(requestParams.toJSONString()).

				when().post("https://reqres.in/api/users").

				then().assertThat().statusCode(201)
//.extract().body().asString()
				.extract().path("id");

	}

}
