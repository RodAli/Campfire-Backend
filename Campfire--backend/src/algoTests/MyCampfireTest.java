package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import algorithms.Student;

public class MyCampfireTest {

		private Student s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", null);
		private Student s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", null);
		private Student s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", null);

		@Test
		public void TestConstructorWithPreDefinedGroup() {
			ArrayList<Student> campfire = s1.getCampfire().getMembers();
			assertEquals(0, campfire.size());
		}
		
		@Test
		public void TestConstructorWithOneStudent() {
			s1.getCampfire().addMember(s2);
			s1.getCampfire().addMember(s3);
			ArrayList<Student> campfire = s1.getCampfire().getMembers();
			assertEquals(2, campfire.size());
		}
		
}