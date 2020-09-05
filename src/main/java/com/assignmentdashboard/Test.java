package com.assignmentdashboard;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Dashboard dash = new Dashboard();
		dash.setInstitute("testing shastra");
		dash.setWebsite("www.testingshastra.com");
		dash.setTotalfees("17000");
		
		Coursesdetails course1=new Coursesdetails();
		course1.setCoursename("Selenium");
		course1.setFees("15000");	
		
		Coursesdetails course2=new Coursesdetails();
		course2.setCoursename("protactor");
		course2.setFees("3000");
		
     List Webautomation=new ArrayList<Coursesdetails>();
     Webautomation.add(course1);
   //  Webautomation.add(add);
     Webautomation.add(course2);
     
     Coursesdetails api1=new Coursesdetails();
     api1.setCoursename("Rest-API");
     api1.setFees("1500");
     
     Coursesdetails api2=new Coursesdetails();
     api2.setCoursename("postman");
     api2.setFees("3000");
     
     List Api=new ArrayList<Coursesdetails>();
     Api.add(api1);
     Api.add(api2);
     
     Course course=new Course();
     course.setWebAutomation(Webautomation);
     course.setApi(Api);
     
     Details detail=new Details();
     detail.setDash(dash);
     detail.setCourse(course);
     
 	given().log().all()
	.body(detail)
	.contentType("application/json")
	.when()
	.post("http://dummy.restapiexample.com/api/v1/create")
	.then()
	.assertThat().statusCode(200)
	.log().all();

	
	}

}
