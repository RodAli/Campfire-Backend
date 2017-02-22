package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algorithms.Student;
import algorithms.Category;
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
	
	private Category student1A = new Category("A", 4);
	private Category student1B = new Category("B", 6);
	private Category student1C = new Category("C", 3);
	private Category student2A = new Category("A", 1);
	private Category student2C = new Category("C", 7);
	private Category student3A = new Category("A", 7);
	private Category student3D = new Category("D", 12);
	private Category student4D = new Category("D", 12);
	private ArrayList<Category> c1 = new ArrayList<Category>();
	private ArrayList<Category> c2 = new ArrayList<Category>();
	private ArrayList<Category> c3 = new ArrayList<Category>();
	private ArrayList<Category> c4 = new ArrayList<Category>();
	
	public void addCategories(){
		c1.add(student1A);
		c1.add(student1B);
		c1.add(student1C);
		c2.add(student2A);
		c2.add(student2C);
		c3.add(student3A);
		c3.add(student3D);
		c4.add(student4D);
	}
	
	@Test
	public void testCreateStudents() {
		
		addCategories();
		
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
		
		addCategories();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", c2);
		
		Holder hold = s1.GenerateScore(s2);
		assertEquals(7.0, hold.getValue(), 0.01);
	}
	
	@Test
	public void testMatchWithClass() {
		
		addCategories();
		
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
		
		addCategories();
		
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
		addCategories();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		Course course = new Course("CSC301", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s1);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddSameEmailTwiceToTheSameCourse(){
		addCategories();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Doe@gmail.com", c2);
		Course course = new Course("CSC301", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s2);
		
	}
	
	@Test
	public void compareStudentToAll(){
		addCategories();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", c1);
		s2 = new Student("John", "Smith", "J.Doe@gmail.com", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", c3);
		
		Holder holds12 = s1.GenerateScore(s2);
		Holder holds13 = s1.GenerateScore(s3);
		Holder holds21 = s2.GenerateScore(s1);
		Holder holds23 = s2.GenerateScore(s3);
		Holder holds31 = s3.GenerateScore(s1);
		Holder holds32 = s3.GenerateScore(s2);
		assertEquals(7.0, holds12.getValue(), 0.01);
		assertEquals(3.0, holds13.getValue(), 0.01);
		assertEquals(7.0, holds21.getValue(), 0.01);
		assertEquals(6.0, holds23.getValue(), 0.01);
		assertEquals(3.0, holds31.getValue(), 0.01);
		assertEquals(6.0, holds32.getValue(), 0.01);
	}
}
