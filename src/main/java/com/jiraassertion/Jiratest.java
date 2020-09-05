package com.jiraassertion;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.Assert;

import static io.restassured.RestAssured.given;

import com.jira.apis.Payload;
public class Jiratest {
	
	public static final String CREATE_SESSION="/rest/auth/1/session";
	public static final String CREATE_ISSUE="/rest/api/2/issue";
	public static final String CREATE_COMMENT="/rest/api/2/issue/{key}/comment";
	public static final String CREATE_ATTACHMENT="/rest/api/2/issue/{key}/attachments";
	
	
	public static SessionFilter sessionFilter=new SessionFilter();
	
	public static void createSession() {
		
		String response=given().log().all()
		.header("content-type","application/json")
		.body(Payload.reqBody())
		.filter(sessionFilter).when()
		.post(CREATE_SESSION)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().asString();
		
		JsonPath js=new JsonPath(response);
		String value=js.getString("session.value");
		Assert.assertNotNull(value);
		System.out.println(value);
	}
	
	public static void createIssue() {
		
         given().log().all()
         .contentType(ContentType.JSON)
		.body(Payload.createIssue())
		.filter(sessionFilter)
		.when().post(CREATE_ISSUE)
		.then().log().all()
		.assertThat().statusCode(201);
		
		JsonPath js=new JsonPath(Payload.createIssue());
		String key=js.get("fields.project.key");
		Assert.assertNotNull(key);
		System.out.println(key);
		
		
	}
	 public static void addComment() {
		 
		String response= given()
		 .contentType(ContentType.JSON)
		 .pathParam("key", "SCRUM-65")
		 .body(Payload.createComment())
		 .log().all().filter(sessionFilter)
		 .when().post(CREATE_COMMENT)
		 .then().log().all()
		 .assertThat().statusCode(201)
		 .extract().asString();
		 
		 JsonPath js=new JsonPath(response);
		 String value=js.get("body");
		 Assert.assertNotNull(value);
		 System.out.println(value);
		 
	 }
	 
	 public static void addAttachment() {
		 
		 given().log().all()
		 .header("X-Atlassian-Token","nocheck")
		 .header("content-type","multipart/form-data")
		 .filter(sessionFilter)
		 .pathParam("key", "SCRUM-65")
		 .header("content-type","multipart/form-data")
		 .multiPart("file",new File("C:\\Users\\Hp\\Desktop\\payload.png"))
		 .when().post(CREATE_ATTACHMENT)
		 .then().log().all()
		 .assertThat().statusCode(200);
	 }
	
	

	public static void main(String[] args) {
		RestAssured.baseURI="http://localhost:8082";
		createSession();
		createIssue();
		addComment();
		addAttachment();
		

	}

}
