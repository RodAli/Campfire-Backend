package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algorithms.Student;

import algorithms.Comparable;
import algorithms.Course;
import algorithms.Holder;

public class StudentTest {

	private Student s1;
	private Student s2;
	private Student s3;
	
	public static class DummyComp implements Comparable{

		private int value;
		
		public DummyComp (int val){
			this.value = val;
		}
		
		public int getValue(){
			return this.value;
		}
		
		@Override
		public double Compare(Comparable other) {
			int checkagainst = ((DummyComp) other).getValue();
			return Math.abs(this.getValue() - checkagainst);
		}
		
	}
	
	private DummyComp d1 = new DummyComp(1);
	private DummyComp d2 = new DummyComp(5);
	private DummyComp d3 = new DummyComp(6);
	
	@Test
	public void testCreateStudents() {
		ArrayList<Comparable> c1 = new ArrayList<Comparable>();
		ArrayList<Comparable> c2 = new ArrayList<Comparable>();
		ArrayList<Comparable> c3 = new ArrayList<Comparable>();
		
		c1.add(d1);
		c2.add(d2);
		c3.add(d3);
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		assertEquals("Jane", s1.getFname());
		assertEquals("Doe", s1.getLname());
		assertEquals("J.Doe@gmail.com", s1.getEmail());
		assertEquals(c1, s1.getCriteria());
		
		
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", c2);
		assertEquals("John", s2.getFname());
		assertEquals("Smith", s2.getLname());
		assertEquals("J.Smith@gmail.com", s2.getEmail());
		assertEquals(c2, s2.getCriteria());
		
		
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", c3);
		assertEquals("Don", s3.getFname());
		assertEquals("Donaldson", s3.getLname());
		assertEquals("D.Donaldson@gmail.com", s3.getEmail());
		assertEquals(c3, s3.getCriteria());
		
		
	}
	
	@Test
	public void testGenerateScore() {
		ArrayList<Comparable> c1 = new ArrayList<Comparable>();
		ArrayList<Comparable> c2 = new ArrayList<Comparable>();
		
		
		c1.add(d1);
		c2.add(d2);
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", c2);
		
		Holder hold = s1.GenerateScore(s2);
		assertEquals(4.0, hold.getValue(), 0.01);
	}
	
	@Test
	public void testMatchWithClass() {
		ArrayList<Comparable> c1 = new ArrayList<Comparable>();
		ArrayList<Comparable> c2 = new ArrayList<Comparable>();
		ArrayList<Comparable> c3 = new ArrayList<Comparable>();
		
		c1.add(d1);
		c2.add(d2);
		c3.add(d3);
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", c3);
		
		Course course = new Course("CSC301", "Joey Freund");
		
		course.addStudent(s1);
		course.addStudent(s2);
		Student stu = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu.getEmail());
		
	}
	
	@Test
	public void testMatchWithMultipleStudents() {
		ArrayList<Comparable> c1 = new ArrayList<Comparable>();
		ArrayList<Comparable> c2 = new ArrayList<Comparable>();
		ArrayList<Comparable> c3 = new ArrayList<Comparable>();
		
		c1.add(d1);
		c2.add(d2);
		c3.add(d3);
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", c3);
		
		Course course = new Course("CSC301", "Joey Freund");
		
		course.addStudent(s1);
		course.addStudent(s3);
		course.addStudent(s2);
		Student stu = s2.getBestClassMatch(course);
		assertEquals("D.Donaldson@gmail.com", stu.getEmail());
		
		s2.notMatched(s3, course);
		
		Student stu2 = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu2.getEmail());
		
		s2.notMatched(s1, course);
		
		Student stu3 = s2.getBestClassMatch(course);
		assertNull(stu3);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddSameStudentTwiceToTheSameCourse(){
		ArrayList<Comparable> c1 = new ArrayList<Comparable>();
		c1.add(d1);
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		Course course = new Course("CSC301", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s1);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddSameEmailTwiceToTheSameCourse(){
		ArrayList<Comparable> c1 = new ArrayList<Comparable>();
		ArrayList<Comparable> c2 = new ArrayList<Comparable>();
		c1.add(d1);
		c2.add(d2);
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Doe@gmail.com", c2);
		Course course = new Course("CSC301", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s2);
		
	}
	
	/*
	 * @Vlad -- add tests here for getting best match for multiple criteria
	 * and for getting best match where one or more criteria don't match (but at least one 
	 * has to match) and a test expecting an exception when no criteria match.
	 * 
	 */
	
	

}
