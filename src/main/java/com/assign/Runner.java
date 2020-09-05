package com.assign;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Runner {
	
	//private Rice rice;

	@Test
	public void testDetails() {
		Rice rice =new Rice();
		rice.setBasmati("85/KG");
		rice.setIndrayani("60/KG");
		rice.setKolam("58/KG");
		
		Salt salt=new Salt();
		salt.setTata("20/KG");
		salt.setCaptionCook("18/KG");
		
		
		Kitchen kitchen=new Kitchen();
		kitchen.setRice(rice);
		kitchen.setSalt(salt);
		
		
		Electronics electronics=new Electronics();
		electronics.setIphone7p("60000");
		electronics.setSonyLEDTV("80000");
		
		Products details=new Products();
		details.setName("piyu");
		details.setUrl("www.flipkart.com");
		details.setKitchen(kitchen);
		details.setElectronics(electronics);
		
		given().log().all()
		.body(details)
		.contentType("application/json")
		.when()
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}

}
