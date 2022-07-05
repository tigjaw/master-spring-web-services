package com.in28minutes.coursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.coursemanagement.bean.Course;
import com.in28minutes.coursemanagement.courses.CourseDetails;
import com.in28minutes.coursemanagement.courses.GetCourseDetailsRequest;
import com.in28minutes.coursemanagement.courses.GetCourseDetailsResponse;
import com.in28minutes.coursemanagement.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace = "http://in28minutes.com/coursemanagement/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetails(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		Course course = service.findByID(request.getId());
		
		CourseDetails details = new CourseDetails();
		details.setId(course.getId());
		details.setName(course.getName());
		details.setDescription(course.getDesc());
		response.setCourseDetails(details);
		return response;
	}
}