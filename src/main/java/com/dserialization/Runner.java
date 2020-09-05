package com.dserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

public class Runner {
	public static final String CREATE_RECORD="/api/v1/create";
	
	@Test
    public  void testDetail() {
		
	
    	RestAssured.baseURI="http://dummy.restapiexample.com";
    	
    	
    	Employee e=new Employee();
    	e.setName("priyanka patil");
    	e.setAge("26");
    	e.setSalary("35000");
    	
    	Employeeresponse resp=new Employeeresponse();
    	
    	
    	resp=given()
		.contentType(ContentType.JSON)
		.body(e).log().all()
		.expect()
		.defaultParser(Parser.JSON)
		.when()
		.post(CREATE_RECORD)
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.as(Employeeresponse.class);
    	  
    	  System.out.println(resp.getStatus() +"status");
          System.out.println(resp.getData().getName()+"name");
          System.out.println(resp.getData().getAge()+"age");
          System.out.println((resp.getData().getSalary()+"salary"));
          System.out.println(resp.getData().getId()+"id");
      	
		
	}

}
