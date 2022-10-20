package com.in28minutes.coursemanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.coursemanagement.bean.Course;

@Component
public class CourseDetailsService {
	
	private static List<Course> courses = new ArrayList<>();
	
	public enum Status {
		SUCCESS, FAILURE;
	}
	
	static {
		Course course1 = new Course(1, "C-ONE", "One Course to rule them all");
		Course course2 = new Course(2, "C-TWO", "Two blind mice");
		Course course3 = new Course(3, "C-THREE", "The Three amigos");
		Course course4 = new Course(4, "C-FOUR", "The Fantastic Four");
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
	
	public Status deleteById(int id) {
		Iterator<Course> it = courses.iterator();
		while (it.hasNext()) {
			Course course = it.next();
			if (course.getId() == id) {
				it.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
}