package com.scripts;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class updateUser {
	String update;
	static String idnumber;

	
	@DataProvider(name = "dataforPost1")
	public Object[][] dataforPost1() {

		return new Object[][] {

				{ "sona", "job" },

		};
	}
		@Test(dataProvider = "dataforPost1")
		public void updateUser(String name, String job) {
			RestAssured.baseURI = "https://reqres.in";
			JSONObject requestParams = new JSONObject();
			requestParams.put("name", name);
			requestParams.put("job", job);
			idnumber = createUser.id;
			System.out.println("UserId" + idnumber);
			update = given().header("Content-Type", "application/json").body(requestParams.toJSONString()).

					when().put("https://reqres.in/api/users/" + idnumber).

					then().assertThat().log().all().statusCode(200).extract().path("updatedAt");

			String updateAt = update.replace(":", "");
			updateAt = updateAt.replace("-", "");
			System.out.println("updateAt" + updateAt);
			System.out.println("UserId" + idnumber);

		}
}
