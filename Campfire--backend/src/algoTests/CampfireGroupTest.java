package algoTests;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algorithms.CampfireGroup;
import algorithms.Student;

public class CampfireGroupTest {
	
	private Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", null);
	private Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", null);
	private Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", null);

	@Test
	public void ConstructorTest() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		CampfireGroup g = new CampfireGroup("A1", stu, 3);
		
		assertEquals("A1", g.getName());
		assertEquals(stu, g.getMembers());
		assertEquals(3, g.getSize());
	}
	
	@Test
	public void retrieveAllStudentsTest() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		CampfireGroup g = new CampfireGroup("A1", stu, 3);
	
		assertEquals(s1, g.getMembers().get(0));
		assertEquals(s2, g.getMembers().get(1));
		assertEquals(s3, g.getMembers().get(2));
		
	}
	
	@Test
	public void AddAMemberToGroupTest() {
		ArrayList<Student> stu = new ArrayList<Student>();
		CampfireGroup g = new CampfireGroup("A1", stu, 3);
		
		assertEquals(0, g.getMembers().size());
		
		g.addMember(s1);
		
		assertEquals(1, g.getMembers().size());
		
		g.addMember(s2);
		
		assertEquals(2, g.getMembers().size());
		
		g.addMember(s3);
		
		assertEquals(3, g.getMembers().size());
		
	}
	
	@Test
	public void RemoveStudentTest() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		CampfireGroup g = new CampfireGroup("A1", stu, 3);
		
		assertEquals(3, g.getMembers().size());
		
		g.removeMember(s1);
		
		assertEquals(2, g.getMembers().size());
		
		g.removeMember(s2);
		
		assertEquals(1, g.getMembers().size());
		
		g.removeMember(s3);
		
		assertEquals(0, g.getMembers().size());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TryToAddStudentsToFullClassTest() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1));
		CampfireGroup g = new CampfireGroup("A1", stu, 1);
		
		g.addMember(s3);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TryToRemoveUnknownStudentFromListTest() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1));
		CampfireGroup g = new CampfireGroup("A1", stu, 1);
		
		g.removeMember(s3);
	}
	
	@Test
	public void TryToAddAnExistingStudentTest() {
		ArrayList<Student> stu = new ArrayList<Student>(Arrays.asList(s1));
		CampfireGroup g = new CampfireGroup("A1", stu, 2);
		
		assertEquals(1, g.getMembers().size());
		
		g.addMember(s1);
		
		assertEquals(1, g.getMembers().size());
	}
	

}
