import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Runner {
	
	@Test
	public void testDetail() {
		
		Dashboard dashboard =new Dashboard();
		dashboard.setInstitute("Testing Shastra");
		dashboard.setWebsite("https://www.testing shastra.com");
		dashboard.setTotalfees("17000");
		
		
		Coursesdetail cdwebautomation=new Coursesdetail();
		cdwebautomation.setCoursename("selenium");
		cdwebautomation.setFees("18000");
	   
		
		Coursesdetail cd1webautomation=new Coursesdetail();
		cd1webautomation.setCoursename("protactor");
		cd1webautomation.setFees("3000");
		
		Coursesdetail  cdRestapi=new Coursesdetail();
		cdRestapi.setCoursename("RestApi");
		cdRestapi.setFees("1500");
		
		Coursesdetail cdRestapi2=new Coursesdetail();
		cdRestapi2.setCoursename("postman");
		cdRestapi2.setFees("7000");
		
		List WebAutomation=new ArrayList<Coursesdetail>();
		WebAutomation.add(cdwebautomation);
		WebAutomation.add(cd1webautomation);
	
		
		List api=new ArrayList<Coursesdetail>();
		api.add(cdRestapi);
		api.add(cdRestapi2);
		
		
		Courses course1=new Courses();
		course1.setWebAutomation(WebAutomation);
		course1.setApi(api);
		
		Details detail=new Details();
		detail.setDashboard(dashboard);
		detail.setCourses(course1);
		//detail.setCourses(course1);
		
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