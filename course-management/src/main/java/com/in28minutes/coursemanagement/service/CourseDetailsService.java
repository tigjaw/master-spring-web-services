package com.in28minutes.coursemanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.coursemanagement.bean.Course;

@Component
public class CourseDetailsService {
	
	private static List<Course> courses = new ArrayList<>();
	
	static {
		Course course1 = new Course(1, "Spring", "10 Steps");
		Course course2 = new Course(1, "Spring MVC", "10 Examples");
		Course course3 = new Course(1, "Spring Boot", "6k Students");
		Course course4 = new Course(1, "Maven", "Most popular maven course");
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
	}

	public Course findByID(int id) {
		for (Course course : courses) {
			if (id == course.getId()) {
				return course;
			}
		}
		return null;
	}
	
	public List<Course> findAll() {
		return courses;
	}
	
	public int deleteById(int id) {
		Iterator<Course> it = courses.iterator();
		while (it.hasNext()) {
			Course course = it.next();
			if (course.getId() == id) {
				it.remove();
				return 1;
			}
		}
		return 0;
	}
}