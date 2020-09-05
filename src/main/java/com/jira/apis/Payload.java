package com.jira.apis;

public class Payload {
	public static String reqBody() {
		return "{\r\n" + 
				"	\"username\":\"AdityaPatil\",\r\n" + 
				"	\"password\": \"adityapatil29\"\r\n" + 
				"	\r\n" + 
				"}";		
	}
	public static String createIssue() {
		return "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"SCRUM\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"Piyu\",\r\n" + 
				"       \"description\": \"Giving demo for creating a story on rest api\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Story\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
				
	}
	public static String createComment() {
		return "{\"body\":\r\n" + 
				"\"Sample comment\"\r\n" + 
				"}";
	}



}
