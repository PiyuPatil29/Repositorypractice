package com.assignmentdashboard;

import java.util.List;

public class Course {
	private List<Coursesdetails> WebAutomation;
	private List<Coursesdetails> Api;

	public List<Coursesdetails> getWebAutomation() {
		return WebAutomation;
	}

	public void setWebAutomation(List<Coursesdetails> webAutomation) {
		WebAutomation = webAutomation;
	}

	public List<Coursesdetails> getApi() {
		return Api;
	}

	public void setApi(List<Coursesdetails> api) {
		Api = api;
	}

}
