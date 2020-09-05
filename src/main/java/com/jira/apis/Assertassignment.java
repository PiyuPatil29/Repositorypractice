package com.jira.apis;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class Assertassignment {
	public static final String CREATE_SESSION="/rest/auth/1/session";
	public static final String CREATE_ISSUE="/rest/api/2/issue";
	public static final String CREATE_COMMENT="/rest/api/2/issue/{key}/comment";
	public static final String CREATE_ATTACHMENT="/rest/api/2/issue/{key}/attachments";
	
	
	public static  SessionFilter session=new SessionFilter();

	@Test(priority = 1)
	public static void createSession() {
		
		RestAssured.baseURI = "http://localhost:8082";
      		//Session created
		String StrSession =Payload.reqBody();
		
		String Createsession=given().contentType(ContentType.JSON)
		.body(StrSession).log().all()
		.filter(session).when()
		.post(CREATE_SESSION)
		.then().log().all().assertThat()
		.statusCode(200)
		.body("session.value",notNullValue())
		.extract().body().asString();

	}
	@Test(priority = 2)
	public void createIssue() {
		RestAssured.baseURI = "http://localhost:8082";
		
	//	  String Createissue=Payload.createIssue();
		  
		  String response= given().contentType(ContentType.JSON)
		  .body(Payload.createIssue()).log().all()
		  .filter(session).when()
		  .post(CREATE_ISSUE)
		  .then().log().all().assertThat()
		  .statusCode(201)
		   .body("id",notNullValue())
		   .extract().body().asString();
		
	}
	@Test(priority = 3)
	public void addComment() {
		RestAssured.baseURI = "http://localhost:8082";
		
	     String response=	given().contentType(ContentType.JSON)
		.pathParam("key", "SCRUM-36")
		.body(Payload.createComment())
		.log().all()
		.filter(session).when()
		.post(CREATE_COMMENT)
		.then().log().all().assertThat()
		.statusCode(201)
		.body("body",notNullValue())
		.extract().body().asString();
			
	}
	@Test(priority = 4)
	public void addAttachment() {
		RestAssured.baseURI="http://localhost:8082";
		   
		given().log().all().header("X-Atlassian-Token","nocheck")
		.header("Content-Type","multipart/form-data")
		.filter(session)
		.pathParam("key", "SCRUM-36")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("C:\\Users\\Hp\\eclipse-workspace\\Assignment\\Input\\Payload.json"))
		.when().post(CREATE_ATTACHMENT)
		.then().log().all().assertThat()
		.statusCode(200)
		.body("filename", notNullValue())
		 .extract().body().asString();
		
	}
}
