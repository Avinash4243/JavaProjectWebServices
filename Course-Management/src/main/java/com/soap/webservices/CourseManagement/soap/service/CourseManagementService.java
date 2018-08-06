package com.soap.webservices.CourseManagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservices.CourseManagement.soap.bean.Course;

@Component
public class CourseManagementService {
	private static List<Course> courses = new ArrayList<>();
	static {
		
		Course course1 = new Course(101, ".Net", "From Microsoft!!");
		Course course2 = new Course(102, "JAVA", "Object Oriented");
		Course course3 = new Course(103, "Data Science", "IBM");
		Course course4 = new Course(104, "JavaScript", "Udemy");
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
	}
	public Course findById(int id) {
		
		for(Course course: courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		return null;
	}
	List<Course> findAll(){
		return courses;
	}
	boolean deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId()==id) {
				iterator.remove();
				return true;
			}
		}
	
	return false;
	}
}
