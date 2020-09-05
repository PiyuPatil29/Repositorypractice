package com.serializationusingemployeeapi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Testserialization {

//	@Test(priority = 1)
	//public void testPostserialization() {
public static void main(String[] args) {
	

		Employee employee = new Employee();
		employee.setName("Ronny foe");
		employee.setSalary(40000);
		employee.setAge(30);

		given().log().all()
		.body(employee)
		.contentType("application/json")
		.when()
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
