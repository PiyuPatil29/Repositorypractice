package com.serializationusingemployeeapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Cardetails {

	@Test
	public void testDetails() {
		// TODO Auto-generated method stub
		Car car=new Car();
		car.setMake("Mahindra");
		car.setModel("XUV500");
		car.setVariant("W10");
		car.setColor("red");
		
		Engine detail=new Engine();
		detail.setCapacity("2179cc");
		detail.setFuelType("140HP");
		detail.setPower("diseal");
		car.setDetail(detail);
		
		given().log().all()
		.body(car)
		.contentType("application/json")
		.when()
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then().assertThat().statusCode(200)
		.log().all();
	
	}
}