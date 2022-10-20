package com.in28minutes.coursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.coursemanagement.bean.Course;
import com.in28minutes.coursemanagement.courses.CourseDetails;
import com.in28minutes.coursemanagement.courses.DeleteCourseDetailsRequest;
import com.in28minutes.coursemanagement.courses.DeleteCourseDetailsResponse;
import com.in28minutes.coursemanagement.courses.GetAllCourseDetailsRequest;
import com.in28minutes.coursemanagement.courses.GetAllCourseDetailsResponse;
import com.in28minutes.coursemanagement.courses.GetCourseDetailsRequest;
import com.in28minutes.coursemanagement.courses.GetCourseDetailsResponse;
import com.in28minutes.coursemanagement.service.CourseDetailsService;
import com.in28minutes.coursemanagement.service.CourseDetailsService.Status;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace = "http://in28minutes.com/coursemanagement/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		Course course = service.findByID(request.getId());
		return mapCourseDetails(course);
	}
	
	@PayloadRoot(namespace = "http://in28minutes.com/coursemanagement/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		List<Course> courses = service.findAll();
		return mapAllCourseDetails(courses);
	}
	
	@PayloadRoot(namespace = "http://in28minutes.com/coursemanagement/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
		Status status = service.deleteById(request.getId());
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails details = new CourseDetails();
		details.setId(course.getId());
		details.setName(course.getName());
		details.setDescription(course.getDesc());
		return details;
	}
	
	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Course course : courses) {
			CourseDetails details = mapCourse(course);
			response.getCourseDetails().add(details);
		}
		return response;
	}
	
	private com.in28minutes.coursemanagement.courses.Status mapStatus(Status status) {
		if (status == Status.FAILURE) {
			return com.in28minutes.coursemanagement.courses.Status.FAILURE;
		}
		return com.in28minutes.coursemanagement.courses.Status.SUCCESS;
	}
}