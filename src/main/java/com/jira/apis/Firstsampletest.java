package com.jira.apis;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;


public class Firstsampletest {
	   public static SessionFilter session=new SessionFilter();   
	    
	
	public static final String CREATE_PATH="/rest/auth/1/session";
	public static final String CREATE_ISSUE="/rest/api/2/issue";
	public static final String CREATE_COMMENT="/rest/api/2/issue/{key}/comment";
	public static final String CREATE_ATTACHMENT="/rest/api/2/issue/{key}/attachments";

    
	@Test(priority = 1)
	public void testUserdetail() {
     RestAssured.baseURI="http://localhost:8082";
       
    
     given().log().all().contentType(ContentType.JSON)
     .body(Payload.reqBody()).filter(session)
     .when().post(CREATE_PATH)
     .then().log().all().assertThat().statusCode(200)
     .extract().body().asString();
	}
	@Test(priority = 2)
     	public void createIssue() {	
		 RestAssured.baseURI="http://localhost:8082";
     	
		given().log().all().contentType(ContentType.JSON)
		.body(Payload.createIssue()).filter(session)
		.when().post(CREATE_ISSUE)
		.then().log().all().assertThat().statusCode(201)
		.extract().body().asString();
     	}
	@Test(priority = 3)
		public static void createComment(){
		 RestAssured.baseURI="http://localhost:8082";

		given().log().all().contentType(ContentType.JSON)
		.pathParam("key", "SCRUM-21")
		.body(Payload.createComment()).filter(session)
		.when().post(CREATE_COMMENT)
		.then().log().all().assertThat().statusCode(201);
		
		}
	@Test(priority = 4)
	   public static void createAttachment() {
		 RestAssured.baseURI="http://localhost:8082";
		   
		given().log().all().header("X-Atlassian-Token","nocheck")
		.header("Content-Type","multipart/form-data")
		.filter(session)
		.pathParam("key", "SCRUM-21")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("C:\\Users\\Hp\\eclipse-workspace\\Assignment\\Input\\Payload.json"))
		.when().post(CREATE_ATTACHMENT)
		.then().log().all().assertThat()
		.statusCode(200);
		 
	
		}

}
