package com.scripts;


import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class deleteUser {
	static String UserId;
	

	@Test
	public void DeleteUser() {

		RestAssured.baseURI = "https://reqres.in";
		UserId = updateUser.idnumber;
		System.out.println(UserId + "idnumber");
		given().

				when().delete("https://reqres.in/api/users/" + UserId).then().statusCode(204).log().all();
	}
}
