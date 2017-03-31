package algoTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import algorithms.Course;
import algorithms.PinCourse;

public class PinCourseTest {

	/*
	 * Adding a course to the PIN map. Pay attention to the println statement
	 * so you know exactly what the PIN looks like. If you still are unsure.
	 */
	@Test
	public void TestAddingAPinCourse() {
		
		PinCourse allCourses = new PinCourse();
		Course course1 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		allCourses.addPinCourse(course1);
		
		String pin = allCourses.findPin(course1); 
		System.out.println(pin);
		
		assertEquals(course1, allCourses.getCoursePins().get(pin));
		
	}
	
	/* 
	 * Simple addition of multiple courses, with designated PINS.
	 */
	@Test
	public void AddingMultiplePinCourses() {
		
		PinCourse allCourses = new PinCourse();
		Course course1 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course2 = new Course("CSC343", "Intro to Databases", "Diane Horton");
		
		allCourses.addPinCourse(course1);
		allCourses.addPinCourse(course2);
		
		assertEquals(2, allCourses.getCoursePins().size());
		
		String pin = allCourses.findPin(course1); 
		
		assertEquals(course1, allCourses.getCoursePins().get(pin));	
	}
	
	/*
	 * A hard test to check. But, no PIN should be the same. We have a lot of combinations.
	 * A LOOOOOOOOT of combinations.
	 * 
	 */
	@Test
	public void NoPinShouldBeTheSame() {
		PinCourse allCourses = new PinCourse();
		
		Course course1 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course2 = new Course("CSC343", "Intro to Databases", "Diane Horton");
		
		allCourses.addPinCourse(course1);
		allCourses.addPinCourse(course2);
		
		String pin = allCourses.findPin(course1); 
		String pin2 = allCourses.findPin(course2); 
		
		Assert.assertFalse(allCourses.getCoursePins().get(pin2).equals(allCourses.getCoursePins().get(pin)));	
	}
	
	/*
	 * Remove a course by using the PIN.
	 */
	@Test
	public void removeACourse() {
		
		PinCourse allCourses = new PinCourse();
		
		Course course1 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course2 = new Course("CSC343", "Intro to Databases", "Diane Horton");
		
		allCourses.addPinCourse(course1);
		allCourses.addPinCourse(course2);
		
		assertEquals(2, allCourses.getCoursePins().size());
		
		String pin = allCourses.findPin(course1); 
		String pin2 = allCourses.findPin(course2); 
		
		Assert.assertFalse(allCourses.getCoursePins().get(pin2).equals(allCourses.getCoursePins().get(pin)));
		
		allCourses.removePinCourse(pin);
		
		assertEquals(1, allCourses.getCoursePins().size());
	
	}

}
