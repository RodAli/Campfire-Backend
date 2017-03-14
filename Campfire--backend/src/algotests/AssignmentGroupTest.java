package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algorithms.AssignmentGroup;
import algorithms.Student;

public class AssignmentGroupTest {
	
	private Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", null);
	private Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", null);
	private Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", null);

	@Test
	public void TestConstructorWithPreDefinedGroup() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		AssignmentGroup g1 = new AssignmentGroup(stu, 1);
		
		assertEquals(1, g1.getgID());
		for (Student s : stu){
			assertTrue(g1.getStudentsInGroup().contains(s));
		}
		
	}
	
	@Test
	public void TestConstructorWithOneStudent() {
		AssignmentGroup g1 = new AssignmentGroup(s1, 1);
		
		assertEquals(1, g1.getgID());
		assertTrue(g1.getStudentsInGroup().contains(s1));
		assertEquals(1, g1.getStudentsInGroup().size());
		
		
	}
	
	@Test
	public void TestAddingAStudent() {
		AssignmentGroup g1 = new AssignmentGroup(s1, 1);
		
		assertEquals(1, g1.getgID());
		assertTrue(g1.getStudentsInGroup().contains(s1));
		assertEquals(1, g1.getStudentsInGroup().size());
		
		g1.addStudent(s2);
		assertTrue(g1.getStudentsInGroup().contains(s2));
		assertEquals(2, g1.getStudentsInGroup().size());
		
		
	}
	
	@Test
	public void TestMergingGroups() {
		AssignmentGroup g1 = new AssignmentGroup(s1, 1);
		
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s2, s3));
		AssignmentGroup g2 = new AssignmentGroup(stu, 2);
		
		int id = g1.mergeGroups(g2);
		assertEquals(id, g2.getgID());
		assertEquals(3, g2.getStudentsInGroup().size());
		
		
		
	}
	
	
	

}
