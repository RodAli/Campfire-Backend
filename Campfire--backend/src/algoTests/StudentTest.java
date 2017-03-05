package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import algorithms.Student;
import algorithms.CSCCoursesCriteria;
import algorithms.Comparable;
import algorithms.Course;
import algorithms.ElectivesCriteria;
import algorithms.HobbiesCriteria;
import algorithms.Holder;
import algorithms.ProgrammingLanguagesCriteria;
import algorithms.ScheduleCriteria;

public class StudentTest {

	private Student s1;
	private Student s2;
	private Student s3;
	private ArrayList<Comparable> c1 = new ArrayList<Comparable>();
	private ArrayList<Comparable> c2 = new ArrayList<Comparable>();
	private ArrayList<Comparable> c3 = new ArrayList<Comparable>();
	
	
	public void addingCSCCourses(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC300"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC324", "CSC318"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("CSC324", "CSC369"));
		
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1);
		CSCCoursesCriteria CSC2 = new CSCCoursesCriteria(S2);
		CSCCoursesCriteria CSC3 = new CSCCoursesCriteria(S3);
		
		c1.add(CSC1);
		c2.add(CSC2);
		c3.add(CSC3);
	}

	public void addingElectives(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("History", "Biology", "Physics"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("History", "Biology", "Philosophy", "Women and Gender Studies"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("Astronomy", "Anthropology", "Physics"));
		
		ElectivesCriteria E1 = new ElectivesCriteria(S1);
		ElectivesCriteria E2 = new ElectivesCriteria(S2);
		ElectivesCriteria E3 = new ElectivesCriteria(S3);
		
		c1.add(E1);
		c2.add(E2);
		c3.add(E3);
	}
	
	public void addingHobbies(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Grooming Cats", "Math"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Breathing", "TV", "Studying", "Math"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("Talking", "VideoGames", "TV", "Breathing"));
		
		HobbiesCriteria H1 = new HobbiesCriteria(S1);
		HobbiesCriteria H2 = new HobbiesCriteria(S2);
		HobbiesCriteria H3 = new HobbiesCriteria(S3);
		
		c1.add(H1);
		c2.add(H2);
		c3.add(H3);
	}
	
	public void addingProgramming(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Java", "C", "Racket"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Java", "C", "C++", "HTML"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("JavaScript", "C", "C++", "HTML"));
		
		ProgrammingLanguagesCriteria PL1 = new ProgrammingLanguagesCriteria(S1);
		ProgrammingLanguagesCriteria PL2 = new ProgrammingLanguagesCriteria(S2);
		ProgrammingLanguagesCriteria PL3 = new ProgrammingLanguagesCriteria(S3);
		
		c1.add(PL1);
		c2.add(PL2);
		c3.add(PL3);
	}
	
	public void addingSchedule(){
		HashMap<String, ArrayList<String>> S1 = new HashMap<String, ArrayList<String>>(); 
		HashMap<String, ArrayList<String>> S2 = new HashMap<String, ArrayList<String>>(); 
		HashMap<String, ArrayList<String>> S3 = new HashMap<String, ArrayList<String>>(); 
		
		ArrayList<String> MTimesS1 = new ArrayList<String>(Arrays.asList("5", "6", "7"));
		ArrayList<String> TTimesS1 = new ArrayList<String>(Arrays.asList("1", "2", "3"));
		ArrayList<String> STimesS1 = new ArrayList<String>(Arrays.asList("0", "1", "2"));
		ArrayList<String> MTimesS2 = new ArrayList<String>(Arrays.asList("8", "9", "10"));
		ArrayList<String> TTimesS2 = new ArrayList<String>(Arrays.asList("11", "4", "10", "5"));
		ArrayList<String> STimesS2 = new ArrayList<String>(Arrays.asList("3", "4"));
		ArrayList<String> MTimesS3 = new ArrayList<String>(Arrays.asList("5", "6"));
		ArrayList<String> TTimesS3 = new ArrayList<String>(Arrays.asList("1", "5", "6"));
		ArrayList<String> STimesS3 = new ArrayList<String>(Arrays.asList("10", "11"));
		
		S1.put("Monday", MTimesS1);
		S1.put("Tuesday", TTimesS1);
		S1.put("Saturday", STimesS1);
		S2.put("Monday", MTimesS2);
		S2.put("Tuesday", TTimesS2);
		S2.put("Sunday", STimesS2);
		S3.put("Monday", MTimesS3);
		S3.put("Tuesday", TTimesS3);
		S3.put("Sunday", STimesS3);
		
		ScheduleCriteria SC1 = new ScheduleCriteria(S1);
		ScheduleCriteria SC2 = new ScheduleCriteria(S2);
		ScheduleCriteria SC3 = new ScheduleCriteria(S3);
		
		c1.add(SC1);
		c2.add(SC2);
		c3.add(SC3);
	}
	
	public void addAll(){
		addingCSCCourses();
		addingElectives();
		addingHobbies();
		addingProgramming();
		addingSchedule();
	}
	
	@Test
	public void testCreateStudents() {
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		assertEquals("Jane", s1.getFname());
		assertEquals("Doe", s1.getLname());
		assertEquals("J.Doe@gmail.com", s1.getEmail());
		assertEquals(c1, s1.getCriteria2());
		
		
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		assertEquals("John", s2.getFname());
		assertEquals("Smith", s2.getLname());
		assertEquals("J.Smith@gmail.com", s2.getEmail());
		assertEquals(c2, s2.getCriteria2());
		
		
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		assertEquals("Don", s3.getFname());
		assertEquals("Donaldson", s3.getLname());
		assertEquals("D.Donaldson@gmail.com", s3.getEmail());
		assertEquals(c3, s3.getCriteria2());
	}
	
	@Test
	public void testGenerateScore() {
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		Holder hold = s1.GenerateScore(s2);
		assertEquals(7.0, hold.getValue(), 0.01);
	}
	
	@Test
	public void compareAllStudents(){
		addAll();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Doe@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Holder holds12 = s1.GenerateScore(s2);
		Holder holds13 = s1.GenerateScore(s3);
		Holder holds21 = s2.GenerateScore(s1);
		Holder holds23 = s2.GenerateScore(s3);
		Holder holds31 = s3.GenerateScore(s1);
		Holder holds32 = s3.GenerateScore(s2);
		
		assertEquals(7.0, holds12.getValue(), 0.01);
		assertEquals(6.0, holds13.getValue(), 0.01);
		assertEquals(7.0, holds21.getValue(), 0.01);
		assertEquals(8.0, holds23.getValue(), 0.01);
		assertEquals(6.0, holds31.getValue(), 0.01);
		assertEquals(8.0, holds32.getValue(), 0.01);
	}
	
	@Test
	public void testMatchWithClass() {
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		course.addStudent(s1);
		course.addStudent(s2);
		//course.addStudent(s3);
		//course.addStudent(s3);
		Student stu = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu.getEmail());
		
	}
	
	@Test
	public void testMatchWithMultipleStudents() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		/*
		 * Switching order of addStudent(s3) and addStudent(s2) breaks the test case???
		 */
		course.addStudent(s1);
		course.addStudent(s3);
		course.addStudent(s2);
		Student stu = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu.getEmail());
		
		s2.notMatched(s3, course);
		
		Student stu2 = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu2.getEmail());
		
		s2.notMatched(s1, course);
		
		Student stu3 = s2.getBestClassMatch(course);
		assertNull(stu3);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddSameStudentTwiceToTheSameCourse(){
		addAll();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s1);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddSameEmailTwiceToTheSameCourse(){
		addAll();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Doe@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s2);
	}
}
