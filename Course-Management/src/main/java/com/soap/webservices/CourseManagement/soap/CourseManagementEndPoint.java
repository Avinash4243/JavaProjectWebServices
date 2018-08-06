package com.soap.webservices.CourseManagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.webservices.CourseManagement.soap.bean.Course;
import com.soap.webservices.CourseManagement.soap.service.CourseManagementService;

import course_management.com.courses.Coursedetails;
import course_management.com.courses.GetAllCourseDetailsRequest;
import course_management.com.courses.GetAllCourseDetailsResponse;

@Endpoint
public class CourseManagementEndPoint {
	@Autowired(required=true)
	CourseManagementService courseservice;
	@PayloadRoot(namespace="http://com.course-management/courses", 
			localPart="GetAllCourseDetailsRequest")	
	@ResponsePayload
	public  GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		Coursedetails coursedetails = new Coursedetails();
		Course course = courseservice.findById(request.getId());
		coursedetails.setId(course.getId());
		coursedetails.setDescription(course.getDescription());
		coursedetails.setName(course.getName());
		response.setCoursedetails(coursedetails);
		return response;
	}
}
