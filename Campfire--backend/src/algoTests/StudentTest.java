package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

import algorithms.Student;
import algorithms.Assignment;
import algorithms.CSCCoursesCriteria;
import algorithms.CampfireGroup;
import algorithms.Comparable;
import algorithms.Course;
import algorithms.ElectivesCriteria;
import algorithms.HobbiesCriteria;
import algorithms.Holder;
import algorithms.PinCourse;
import algorithms.PinGroup;
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
		
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1, 1);
		CSCCoursesCriteria CSC2 = new CSCCoursesCriteria(S2, 1);
		CSCCoursesCriteria CSC3 = new CSCCoursesCriteria(S3, 1);
		
		c1.add(CSC1);
		c2.add(CSC2);
		c3.add(CSC3);
	}

	public void addingElectives(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("History", "Biology", "Physics"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("History", "Biology", "Philosophy", "Women and Gender Studies"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("Astronomy", "Anthropology", "Physics"));
		
		ElectivesCriteria E1 = new ElectivesCriteria(S1, 1);
		ElectivesCriteria E2 = new ElectivesCriteria(S2, 1);
		ElectivesCriteria E3 = new ElectivesCriteria(S3, 1);
		
		c1.add(E1);
		c2.add(E2);
		c3.add(E3);
	}
	
	public void addingHobbies(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Grooming Cats", "Math"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Breathing", "TV", "Studying", "Math"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("Talking", "VideoGames", "TV", "Breathing"));
		
		HobbiesCriteria H1 = new HobbiesCriteria(S1, 1);
		HobbiesCriteria H2 = new HobbiesCriteria(S2, 1);
		HobbiesCriteria H3 = new HobbiesCriteria(S3, 1);
		
		c1.add(H1);
		c2.add(H2);
		c3.add(H3);
	}
	
	public void addingProgramming(){
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Java", "C", "Racket"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Java", "C", "C++", "HTML"));
		ArrayList<String> S3 = new ArrayList<String>(Arrays.asList("JavaScript", "C", "C++", "HTML"));
		
		ProgrammingLanguagesCriteria PL1 = new ProgrammingLanguagesCriteria(S1, 1);
		ProgrammingLanguagesCriteria PL2 = new ProgrammingLanguagesCriteria(S2, 1);
		ProgrammingLanguagesCriteria PL3 = new ProgrammingLanguagesCriteria(S3, 1);
		
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
		
		ScheduleCriteria SC1 = new ScheduleCriteria(S1, 2);
		ScheduleCriteria SC2 = new ScheduleCriteria(S2, 2);
		ScheduleCriteria SC3 = new ScheduleCriteria(S3, 2);
		
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
		assertEquals(c1, s1.getCriteria());
		
		
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		assertEquals("John", s2.getFname());
		assertEquals("Smith", s2.getLname());
		assertEquals("J.Smith@gmail.com", s2.getEmail());
		assertEquals(c2, s2.getCriteria());
		
		
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		assertEquals("Don", s3.getFname());
		assertEquals("Donaldson", s3.getLname());
		assertEquals("D.Donaldson@gmail.com", s3.getEmail());
		assertEquals(c3, s3.getCriteria());
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
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		/*
		 * !!!!!!!!!!!!!!!!!!!!Important!!!!!!!!!!!!!!!!!!!
		 * Need to call MatchWithClass(course, false) for every active
		 * user whenever someone is added to the graph (except the person
		 * who was just added).
		 * Otherwise you will get a null pointer.
		 */
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
	
	
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
	
	@Test
	public void testGetBackCriteria(){
		addAll();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);

		
		/*
		 * Calling the methods WITHOUT the toString() will just return them with
		 * their respective type, thus you can manipulate, work and extract from them.
		 * 
		 */
		
		assertEquals("[CSC301, CSC369, CSC300]", s1.getCSCCourses().toString());
		assertEquals("[History, Biology, Physics]", s1.getElectives().toString());
		assertEquals("[Eating, Walking, Grooming Cats, Math]", s1.getHobbies().toString());
		assertEquals("[Java, C, Racket]", s1.getProgramming().toString());
		assertEquals("{Monday=[5, 6, 7], Tuesday=[1, 2, 3], Saturday=[0, 1, 2]}"
				, s1.getCalendar().toString());
		
	}
	
	//STILL NEED TO MAKE SURE CORNER CASES WORK!
	/*
	@Test
	public void testCompareNulls(){
		addAll();
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", null);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", null);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", null);
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		Holder holder = s1.GenerateScore(s2);
		assertEquals(0.0, holder.getValue(), 0.01);
	}*/
	
	
	
	@Test
	public void testEnrollModifiesHashMaps() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
		s1.enroll(course);
		
		assertNotNull(s1.getGroupsForAssignment().get(course.getName()));
		assertTrue(s1.getGroupsForAssignment().get(course.getName()).isEmpty());
		
		assertNotNull(s1.getSavedAvailableMatches().get(course.getName()));
		assertTrue(s1.getSavedAvailableMatches().get(course.getName()).isEmpty());
		
		assertEquals(null, s1.getCurAssignmentForCourse().get(course.getName()));
		
	}
	
	@Test
	public void testAddAssignmentWithOneAssignment() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
		s1.enroll(course);
		Assignment a = new Assignment(1, "A1", course, 2);
		
		s1.addAssignment(course, a, true);
		
		assertEquals(null, s1.getGroupsForAssignment().get(course.getName()).get(a));
		assertEquals(2, s1.getSavedAvailableMatches().get(course.getName()).get(a).size());
		assertEquals(a, s1.getCurAssignmentForCourse().get(course.getName()));
	}
	
	@Test
	public void testSwappingAssignments() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
		s1.enroll(course);
		Assignment a = new Assignment(1, "A1", course, 2);
		
		s1.addAssignment(course, a, true);
		
		assertEquals(null, s1.getGroupsForAssignment().get(course.getName()).get(a));
		assertEquals(2, s1.getSavedAvailableMatches().get(course.getName()).get(a).size());
		assertEquals(a, s1.getCurAssignmentForCourse().get(course.getName()));
		
		Student stu = s1.getBestClassMatch(course);
		assertEquals("D.Donaldson@gmail.com", stu.getEmail());
		
		s1.notMatched(s3, course);
		assertEquals(1, s1.getAvailablematches().get(course.getName()).size());
		
		Assignment a2 = new Assignment(2, "A2", course, 3);
		s1.addAssignment(course, a2, false);
		
		assertEquals(null, s1.getGroupsForAssignment().get(course.getName()).get(a2));
		assertEquals(2, s1.getSavedAvailableMatches().get(course.getName()).get(a2).size());
		assertEquals(a2, s1.getCurAssignmentForCourse().get(course.getName()));
		
		//A new assignment was swapped in so the new available matches were loaded
		assertEquals(2, s1.getAvailablematches().get(course.getName()).size());
		
	}
	
	
	@Test
	public void testRestoreMatches() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
		s1.enroll(course);
		Assignment a = new Assignment(1, "A1", course, 2);
		
		s1.addAssignment(course, a, true);
		
		assertEquals(null, s1.getGroupsForAssignment().get(course.getName()).get(a));
		assertEquals(2, s1.getSavedAvailableMatches().get(course.getName()).get(a).size());
		assertEquals(a, s1.getCurAssignmentForCourse().get(course.getName()));
		
		Student stu = s1.getBestClassMatch(course);
		assertEquals("D.Donaldson@gmail.com", stu.getEmail());
		
		s1.notMatched(s3, course);
		assertEquals(1, s1.getAvailablematches().get(course.getName()).size());
		
		s1.save(course);
		
		//Both the saved value and the currently loaded values are changed
		s1.restoreMatches(course, s1.getCurAssignmentForCourse().get(course.getName()));
		assertEquals(2, s1.getAvailablematches().get(course.getName()).size());
		assertEquals(2, s1.getSavedAvailableMatches().get(course.getName()).get(a).size());
		
		//All the matches are restored
		stu = s1.getBestClassMatch(course);
		assertEquals("D.Donaldson@gmail.com", stu.getEmail());
		
	}
	
	/*
	 * All test cases starting here are for CampfireGroup tests with multiple students.
	 * Test cases include all corner cases that have been considered and basic implementation
	 * to check whether the code is working.
	 * 
	 */
	
	@Test
	public void testMakeBasicCampfireGroup() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
		s1.createGroup(course, "A1", 3, 1);
		
		assertEquals(1, s1.getCampfires().get(course).size());
		assertEquals(0, s1.getGroup(course, "A1").getCurrentSize());
		
	}
	
	@Test
	public void testCreateMultipleCampfireGroupsWithMultipleCourses() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course301 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course343 = new Course("CSC343", "Introduction to Databases", "Diane Horton");
		
		course301.addStudent(s1);
		course301.addStudent(s2);
		course301.addStudent(s3);
		course343.addStudent(s1);
		course343.addStudent(s2);
		course343.addStudent(s3);
		
		s2.MatchWithClass(course301, false);
		s1.MatchWithClass(course301, false);
		s2.MatchWithClass(course343, false);
		s1.MatchWithClass(course343, false);
		
		s1.createGroup(course301, "A1", 7, 1);
		s1.createGroup(course343, "A1", 2, 2);
		s1.createGroup(course343, "A2", 3, 3);
		
		assertEquals(2, s1.getCampfires().size());
		
		assertEquals(1, s1.getCampfires().get(course301).size());
		assertEquals(2, s1.getCampfires().get(course343).size());

		assertEquals(7, s1.getGroup(course301, "A1").getSize());
		assertEquals(2, s1.getGroup(course343, "A1").getSize());
		assertEquals(3, s1.getGroup(course343, "A2").getSize());
	}
	
	@Test
	public void CombiningMultipleStudentsWithMultipleGroupsAndMembers() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course301 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course343 = new Course("CSC343", "Introduction to Databases", "Diane Horton");
		
		course301.addStudent(s1);
		course301.addStudent(s2);
		course301.addStudent(s3);
		course343.addStudent(s1);
		course343.addStudent(s2);
		course343.addStudent(s3);
		
		s2.MatchWithClass(course301, false);
		s1.MatchWithClass(course301, false);
		s2.MatchWithClass(course343, false);
		s1.MatchWithClass(course343, false);
		
		s1.createGroup(course301, "A1", 7, 1);
		s1.createGroup(course343, "A1", 2, 2);
		s1.createGroup(course343, "A2", 3, 3);
		
		s2.createGroup(course301, "A1", 7, 1);
		s2.createGroup(course343, "A1", 2, 2);
		s2.createGroup(course343, "A2", 3, 3);
		
		s3.createGroup(course301, "A1", 7, 1);
		s3.createGroup(course343, "A1", 2, 2);
		s3.createGroup(course343, "A2", 3, 3);
		
		//Put s1 and s2 into group A1-Course301
		
		s1.unionMembers(course301, "A1", s2);
		
		assertEquals(1, s1.getGroup(course301, "A1").getMembers().size());
		assertEquals(1, s2.getGroup(course301, "A1").getMembers().size());
		
		//Put s3 and (s1 and s2) into group A1-Course301
		
		s1.unionMembers(course301, "A1", s3);
		
		assertEquals(2, s1.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course301, "A1").getMembers().size());
		
		//Put s3 and s1 into group A2-Course343
		
		s1.unionMembers(course343, "A2", s3);
		
		assertEquals(1, s1.getGroup(course343, "A2").getMembers().size());
		assertEquals(1, s3.getGroup(course343, "A2").getMembers().size());
		
		/* s1 should now have Course301-A1 Members:[John, Don] 
		 * 					  Course343-A1 Members:[]
		 * 					  Course343-A2 Members:[Don]
		 */
		
		ArrayList<String> course301A1group = new ArrayList<String>();
		ArrayList<String> course343A1group = new ArrayList<String>();
		ArrayList<String> course343A2group = new ArrayList<String>();
		
		for(Student stu : s1.getGroup(course301, "A1").getMembers()){
			course301A1group.add(stu.getFname());
		}
		
		assertEquals("[John, Don]", course301A1group.toString());
		
		for(Student stu : s1.getGroup(course343, "A1").getMembers()){
			course343A1group.add(stu.getFname());
		}
		
		assertEquals("[]", course343A1group.toString());
		
		for(Student stu : s1.getGroup(course343, "A2").getMembers()){
			course343A2group.add(stu.getFname());
		}
		
		assertEquals("[Don]", course343A2group.toString());
		
	}
	
	@Test
	public void KickingMultipleStudentsWithMultipleGroupsAndMembers() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course301 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course343 = new Course("CSC343", "Introduction to Databases", "Diane Horton");
		
		course301.addStudent(s1);
		course301.addStudent(s2);
		course301.addStudent(s3);
		course343.addStudent(s1);
		course343.addStudent(s2);
		course343.addStudent(s3);
		
		s2.MatchWithClass(course301, false);
		s1.MatchWithClass(course301, false);
		s2.MatchWithClass(course343, false);
		s1.MatchWithClass(course343, false);
		
		s1.createGroup(course301, "A1", 7, 1);
		s1.createGroup(course343, "A1", 2, 2);
		s1.createGroup(course343, "A2", 3, 3);
		
		s2.createGroup(course301, "A1", 7, 1);
		s2.createGroup(course343, "A1", 2, 2);
		s2.createGroup(course343, "A2", 3, 3);
		
		s3.createGroup(course301, "A1", 7, 1);
		s3.createGroup(course343, "A1", 2, 2);
		s3.createGroup(course343, "A2", 3, 3);
		
		//Fill Up all the Groups with Students
		
		s1.unionMembers(course301, "A1", s2);
		s1.unionMembers(course301, "A1", s3);
		s1.unionMembers(course343, "A1", s2);
		s1.unionMembers(course343, "A1", s3);
		s1.unionMembers(course343, "A2", s2);
		s1.unionMembers(course343, "A2", s3);
		
		//Check that groups are full
		
		assertEquals(2, s1.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s1.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s1.getGroup(course343, "A2").getMembers().size());
		assertEquals(2, s2.getGroup(course343, "A2").getMembers().size());
		assertEquals(2, s3.getGroup(course343, "A2").getMembers().size());
		
		//Remove s1 from A1-Course343
		
		s2.kickMember(course343, "A1", s1);
		
		//assertNull(s1.getGroup(course343, "A1"));
		
		assertEquals(1, s2.getGroup(course343, "A1").getMembers().size());
		assertEquals(1, s3.getGroup(course343, "A1").getMembers().size());
		
		//Remove s2 and s3 from A2-Course343
		
		s2.kickMember(course343, "A2", s3);
		s1.kickMember(course343, "A2", s2);
		
		//assertNull(s2.getGroup(course343, "A2"));
		//assertNull(s3.getGroup(course343, "A2"));

		assertEquals(0, s1.getGroup(course343, "A2").getMembers().size());
		
		//Remove s3 from A1-Course343

		s2.kickMember(course343, "A1", s3);
		
		//assertNull(s3.getGroup(course343, "A1"));
		
		assertEquals(0, s2.getGroup(course343, "A1").getMembers().size());
		
		
		/* 
		 * s2 should now have Course301-A1 Members:[Jane, Don] 
		 * 					  Course343-A1 Members:[]
		 * s1 should now have Course343-A2 Members:[]
		 * 
		 */
		
		ArrayList<String> course301A1group = new ArrayList<String>();
		ArrayList<String> course343A1group = new ArrayList<String>();
		ArrayList<String> course343A2group = new ArrayList<String>();
		
		for(Student stu : s2.getGroup(course301, "A1").getMembers()){
			course301A1group.add(stu.getFname());
		}
		
		assertEquals("[Jane, Don]", course301A1group.toString());
		
		for(Student stu : s2.getGroup(course343, "A1").getMembers()){
			course343A1group.add(stu.getFname());
		}
		
		assertEquals("[]", course343A1group.toString());
		
		for(Student stu : s1.getGroup(course343, "A2").getMembers()){
			course343A2group.add(stu.getFname());
		}
		
		assertEquals("[]", course343A2group.toString());
		
	}

	@Test
	public void LeavingACampfireGroup() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course301 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course343 = new Course("CSC343", "Introduction to Databases", "Diane Horton");
		
		course301.addStudent(s1);
		course301.addStudent(s2);
		course301.addStudent(s3);
		course343.addStudent(s1);
		course343.addStudent(s2);
		course343.addStudent(s3);
		
		s2.MatchWithClass(course301, false);
		s1.MatchWithClass(course301, false);
		s2.MatchWithClass(course343, false);
		s1.MatchWithClass(course343, false);
		
		s1.createGroup(course301, "A1", 7, 1);
		s1.createGroup(course343, "A1", 2, 2);
		s1.createGroup(course343, "A2", 3, 3);
		
		s2.createGroup(course301, "A1", 7, 1);
		s2.createGroup(course343, "A1", 2, 2);
		s2.createGroup(course343, "A2", 3, 3);
		
		s3.createGroup(course301, "A1", 7, 1);
		s3.createGroup(course343, "A1", 2, 2);
		s3.createGroup(course343, "A2", 3, 3);
		
		//Fill Up all the Groups with Students
		
		s1.unionMembers(course301, "A1", s2);
		s1.unionMembers(course301, "A1", s3);
		s1.unionMembers(course343, "A1", s2);
		s1.unionMembers(course343, "A1", s3);
		s1.unionMembers(course343, "A2", s2);
		s1.unionMembers(course343, "A2", s3);
		
		//Check that groups are full
		
		assertEquals(2, s1.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s1.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s1.getGroup(course343, "A2").getMembers().size());
		assertEquals(2, s2.getGroup(course343, "A2").getMembers().size());
		assertEquals(2, s3.getGroup(course343, "A2").getMembers().size());
		
		//Student leaves a group
		
		s1.leaveGroup(course301, "A1");
		//Check if the group was deleted
		assertEquals(0, s1.getCampfiresByCourse(course301).size());
		
		//Check if the other users are now missing a member
		assertEquals(1, s2.getGroup(course301, "A1").getMembers().size());
		assertEquals(1, s3.getGroup(course301, "A1").getMembers().size());	

	}
	
	public void LeavingAllGroupsForACourse() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course301 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		Course course343 = new Course("CSC343", "Introduction to Databases", "Diane Horton");
		
		course301.addStudent(s1);
		course301.addStudent(s2);
		course301.addStudent(s3);
		course343.addStudent(s1);
		course343.addStudent(s2);
		course343.addStudent(s3);
		
		s2.MatchWithClass(course301, false);
		s1.MatchWithClass(course301, false);
		s2.MatchWithClass(course343, false);
		s1.MatchWithClass(course343, false);
		
		s1.createGroup(course301, "A1", 7, 1);
		s1.createGroup(course343, "A1", 2, 2);
		s1.createGroup(course343, "A2", 3, 3);
		
		s2.createGroup(course301, "A1", 7, 1);
		s2.createGroup(course343, "A1", 2, 2);
		s2.createGroup(course343, "A2", 3, 3);
		
		s3.createGroup(course301, "A1", 7, 1);
		s3.createGroup(course343, "A1", 2, 2);
		s3.createGroup(course343, "A2", 3, 3);
		
		//Fill Up all the Groups with Students
		
		s1.unionMembers(course301, "A1", s2);
		s1.unionMembers(course301, "A1", s3);
		s1.unionMembers(course343, "A1", s2);
		s1.unionMembers(course343, "A1", s3);
		s1.unionMembers(course343, "A2", s2);
		s1.unionMembers(course343, "A2", s3);
		
		//Check that groups are full
		
		assertEquals(2, s1.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course301, "A1").getMembers().size());
		assertEquals(2, s1.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s2.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s3.getGroup(course343, "A1").getMembers().size());
		assertEquals(2, s1.getGroup(course343, "A2").getMembers().size());
		assertEquals(2, s2.getGroup(course343, "A2").getMembers().size());
		assertEquals(2, s3.getGroup(course343, "A2").getMembers().size());
		
		//Check the amount of groups inside csc343
		assertEquals(2, s1.getCampfiresByCourse(course343).size());
		
		//Student leaves a group
		s1.byebyeCruelWorld(course343);
		
		//Check if all the groups were deleted
		assertEquals(0, s1.getCampfiresByCourse(course343).size());
		
		//Check if the other users are now missing a member in all the groups for that course
		assertEquals(1, s2.getGroup(course343, "A1").getMembers().size());
		assertEquals(1, s3.getGroup(course343, "A1").getMembers().size());	
		assertEquals(1, s2.getGroup(course343, "A2").getMembers().size());
		assertEquals(1, s3.getGroup(course343, "A2").getMembers().size());	

	}
	
	////////////////////Testing TreeMap
	@Test
	public void testSortedMatches() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		/*
		 * !!!!!!!!!!!!!!!!!!!!Important!!!!!!!!!!!!!!!!!!!
		 * Need to call MatchWithClass(course, false) for every active
		 * user whenever someone is added to the graph (except the person
		 * who was just added).
		 * Otherwise you will get a null pointer.
		 */
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
	
	
		Student stu = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu.getEmail());
		
		
		List<Student> students = s2.validSortedStudents(course);
		assertEquals("J.Doe@gmail.com", students.get(0).getEmail());
		assertEquals("D.Donaldson@gmail.com", students.get(1).getEmail());
		
		s2.notMatched(s1, course);
		students = s2.validSortedStudents(course);
		assertEquals("D.Donaldson@gmail.com", students.get(0).getEmail());
		
		
	
		
	}
	
	/*
	 * How to work with the new PIN and Student Test
	 */
	
	@Test
	public void testPINsystem(){
		//I am going to be playing two roles, to make it more clear on what is going on (or should be I think)
		//be going in the front end.
		
		//Lets make a students
		Student stu = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", null);
		Student stu2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		
		//Assume someone creates a course
		
		//First initialize the PIN map for groups and courses
		PinCourse allCourses = new PinCourse();
		PinGroup allGroups = new PinGroup();
		
		//Create the course
		Course course1 = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		//Generate a PIN code for the course and put it in the map
		allCourses.addPinCourse(course1);
		
		//Get the new PIN designated to the course (pretend that the prof gives this pin to students in class)
		String PINc = allCourses.findPin(course1); 
		
		//Students go and use the PIN to enter into the course (you can have a checker if he enters the right pin)
		allCourses.getCoursePins().get(PINc).addStudent(stu);
		allCourses.getCoursePins().get(PINc).addStudent(stu2);
		
		//Since the student joined the course we will also add the course to the students campfires map. 
		//But with no groups.
		stu.getCampfires().put(allCourses.getCoursePins().get(PINc), new ArrayList<CampfireGroup>());
		stu2.getCampfires().put(allCourses.getCoursePins().get(PINc), new ArrayList<CampfireGroup>());
		
		//Now the course has those students
		assertTrue(course1.getStudents().contains(stu));
		assertTrue(course1.getStudents().contains(stu2));
		
		//And the students are ready to make campfire groups for the added course
		assertEquals(0, stu.getCampfires().get(course1).size());
		assertEquals(0, stu2.getCampfires().get(course1).size());
		
		//Now the someone decides to make a group
		CampfireGroup group1 = new CampfireGroup("A1", new ArrayList<Student>(), 4, 1152091);
		
		//Generate the PIN code for the group and put in the map
		allGroups.addPinGroup(group1);
		
		//Get the new PIN designated to the groups (pretend that the prof gives this pin to students in class) 
		String PINg = allGroups.findPin(group1);
		
		//Students then use the PIN to create the groups in their campfire.
		stu.getCampfires().get(course1).add(allGroups.getGroupPins().get(PINg));
		stu2.getCampfires().get(course1).add(allGroups.getGroupPins().get(PINg));
		
		//Now both students have that empty static group in their courses
		assertTrue(stu.getCampfiresByCourse(course1).contains(group1));
		assertTrue(stu2.getCampfiresByCourse(course1).contains(group1));
		
		/*
		 * After this you are back to all the other test cases. Where you can manipulate 
		 * the groups any way you want. The whole point of the PIN system is just to create
		 * these static super groups and give further control of the formation. 
		 */
		
		//Quick examples
		//Adding both students to each others group
		assertEquals(0, stu.getGroup(course1, group1.getName()).getMembers().size());
		stu.unionMembers(course1, group1.getName(), stu2);
		assertEquals(1, stu.getGroup(course1, group1.getName()).getMembers().size());
		assertEquals(1, stu2.getGroup(course1, group1.getName()).getMembers().size());
		
		//And so on... Exactly the same as it always has been.
	}
	
	@Test
	public void testRemoveStudent() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		
		
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
		s2.createGroup(course, "A1", 7, 1);
		s2.createGroup(course, "A2", 2, 2);
		s2.createGroup(course, "A3", 3, 3);
		
	
	
		Student stu = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu.getEmail());
		
		
		s2.leaveCourse(course);
		assertFalse(s2.getAvailablematches().containsKey(course.getName()));
		assertFalse(s2.getMatchvalues().containsKey(course.getName()));
		assertFalse(s2.getCampfires().containsKey(course));
		assertFalse(course.getStudents().contains(s2));
		assertFalse(s1.getMatchvalues().get(course.getName()).containsKey(s2));
		assertFalse(s1.getAvailablematches().get(course.getName()).contains(s2));
		assertFalse(s3.getMatchvalues().get(course.getName()).containsKey(s2));
		assertFalse(s3.getAvailablematches().get(course.getName()).contains(s2));
		
		
	
		
	}
	
	
	@Test
	public void testMatchStudents() {
		
		addAll();
		
		s1 = new Student("Jane", "Doe", "J.Doe@gmail.com", "pass", c1);
		s2 = new Student("John", "Smith", "J.Smith@gmail.com", "pass", c2);
		s3 = new Student("Don", "Donaldson", "D.Donaldson@gmail.com", "pass", c3);
		
		Course course = new Course("CSC301", "Intro to Software Engineering", "Joey Freund");
		
		
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
	
		s2.MatchWithClass(course, false);
		s1.MatchWithClass(course, false);
		
	
		Student stu = s2.getBestClassMatch(course);
		assertEquals("J.Doe@gmail.com", stu.getEmail());
		
		
		s2.match(course, s1);
		assertTrue(s2.getMatchedStudents().containsKey(course.getName()));
		assertTrue(s2.getMatchedStudents().get(course.getName()).contains(s1));
		assertFalse(s2.getAvailablematches().get(course.getName()).contains(s1));
		assertTrue(s1.getMatchedStudents().containsKey(course.getName()));
		assertTrue(s1.getMatchedStudents().get(course.getName()).contains(s2));
		assertFalse(s1.getAvailablematches().get(course.getName()).contains(s2));
		
		
		
		
	
		
	}


}
