package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algorithms.Assignment;
import algorithms.AssignmentGroup;
import algorithms.CSCCoursesCriteria;
import algorithms.Comparable;
import algorithms.Course;
import algorithms.Student;

public class AssignmentTest {
	
	@SuppressWarnings("unused")
	private Student s1;
	@SuppressWarnings("unused")
	private Student s2;
	@SuppressWarnings("unused")
	private Student s3;
	
	Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
	
	private ArrayList<Comparable> c1 = new ArrayList<Comparable>();
	private ArrayList<Comparable> c2 = new ArrayList<Comparable>();
	private ArrayList<Comparable> c3 = new ArrayList<Comparable>();
	
	ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC300"));
	ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC324", "CSC318"));
	ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("CSC324", "CSC369"));
	
	CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1, 1);
	CSCCoursesCriteria CSC2 = new CSCCoursesCriteria(S2, 1);
	CSCCoursesCriteria CSC3 = new CSCCoursesCriteria(S3, 1);
	
	

	@Test
	public void TestPopulate() {
		
		c1.add(CSC1);
		c2.add(CSC2);
		c3.add(CSC3);
		
		Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		Assignment A1 = new Assignment(1, "A1", course, 2);
		A1.populate();
		
		assertEquals(3, A1.getGroups().size());
		
		ArrayList<Student> students = new ArrayList<>();
		for (AssignmentGroup g : A1.getGroups()){
			assertEquals(1, g.getStudentsInGroup().size());
			for (Student s : g.getStudentsInGroup()){
				students.add(s);
			}
		}
		
		for (Student stu : course.getStudents()){
			assertTrue(students.contains(stu));
		}
		
		
	}
	
	@Test
	public void TestProperMatching(){
		c1.add(CSC1);
		c2.add(CSC2);
		c3.add(CSC3);
		
		Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		Assignment A1 = new Assignment(1, "A1", course, 2);
		A1.populate();
		
		AssignmentGroup g = A1.combineGroups(A1.getGroups().get(0), A1.getGroups().get(1));
		assertEquals(2, g.getStudentsInGroup().size());
		assertEquals(2, A1.getGroups().size());
		
	}
	
	@Test
	public void TestInvalidMatchingWhereNewGroupisTooBig(){
		c1.add(CSC1);
		c2.add(CSC2);
		c3.add(CSC3);
		
		Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		Assignment A1 = new Assignment(1, "A1", course, 2);
		A1.populate();
		AssignmentGroup g2 = A1.getGroups().get(2);
		
		AssignmentGroup g = A1.combineGroups(A1.getGroups().get(0), A1.getGroups().get(1));
		assertEquals(2, g.getStudentsInGroup().size());
		assertEquals(2, A1.getGroups().size());
		
		AssignmentGroup g3 = A1.combineGroups(g2, g);
		assertNull(g3);
		
		System.out.println(A1.getGroups().toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestInvalidMatchingWhereGroupDoesNotExist(){
		c1.add(CSC1);
		c2.add(CSC2);
		c3.add(CSC3);
		
		Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		Assignment A1 = new Assignment(1, "A1", course, 2);
		A1.populate();
		
		AssignmentGroup g3 = new AssignmentGroup(new ArrayList<Student>(), -1);
		A1.combineGroups(A1.getGroups().get(0), g3);
		
		
	}

}
