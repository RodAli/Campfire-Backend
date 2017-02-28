package databaseTests;

import static org.junit.Assert.*;


import java.sql.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.Course;
import algorithms.Student;
import database.SQLiteController;
import database.SQLiteQueryAdapter;


/**
 * Tests queries that get data
 */
public class TestQueries {
	static SQLiteController sqlcon; 
	
	@BeforeClass
	public static void setup() {
		sqlcon = new SQLiteController();
		setup(sqlcon);
	}
	
	@AfterClass
	public static void tearDown() throws ClassNotFoundException, SQLException {
		sqlcon.closeConnectionToDB();
	}
	
	/* Before insertion, you must check if that Student already exists! */
	@Test(expected = SQLException.class)
	public void testAddStudentAndGetStudent2() throws ClassNotFoundException, SQLException {
		Student cartman = new Student("Eric", "Cartman", "cartman@mail.com", "respect my authoritah", null, null);
		SQLiteQueryAdapter.addStudent(sqlcon, cartman);
		SQLiteQueryAdapter.addStudent(sqlcon, cartman);
	}
	@Test
	public void testAddStudentAndGetStudent() throws ClassNotFoundException, SQLException {
		Student cartman = new Student("Eric", "Cartman", "cartman@mail.com", "respect my authoritah", null, null);
		SQLiteQueryAdapter.addStudent(sqlcon, cartman);
		assertNotNull(SQLiteQueryAdapter.getStudent(sqlcon, "cartman@mail.com"));
	}
	
    @Test
    public void testAllStudentsAndDeleteStudent() throws ClassNotFoundException, SQLException {
    	ArrayList<Student> students = SQLiteQueryAdapter.allStudents(sqlcon);
    	int oldStudentPop = students.size();
    	SQLiteQueryAdapter.deleteStudent(sqlcon, "joe@mail.com");
    	students = SQLiteQueryAdapter.allStudents(sqlcon);
    	assertEquals(oldStudentPop - 1, students.size());
    }
    
    public void testStudentExists() throws ClassNotFoundException, SQLException {
    	assertFalse(SQLiteQueryAdapter.studentExists(sqlcon, "marsh@mail.com"));
    	
    	Student randy = new Student("Randy", "Marsh", "marsh@mail.com", "I am Lorde", null, null);
    	SQLiteQueryAdapter.addStudent(sqlcon, randy);
    	
    	assertTrue(SQLiteQueryAdapter.studentExists(sqlcon, "marsh@mail.com"));
    }
    
    public void testDeleteAllStudents() throws ClassNotFoundException, SQLException {
    	SQLiteQueryAdapter.deleteAllStudents(sqlcon);
    	
    	assertEquals(0, SQLiteQueryAdapter.allStudents(sqlcon).size());
    }
    
    public void testAddCourseAndAllCourses() throws ClassNotFoundException, SQLException {
    	ArrayList<Course> courses = SQLiteQueryAdapter.allCourses(sqlcon);
    	
    	int oldNumOfCourses = courses.size();
    	Course csc458 = new Course("CSC458", "Computer Networking Systems", "Yashar Ganjali");
    	SQLiteQueryAdapter.addCourse(sqlcon, csc458);
    	
    	courses = SQLiteQueryAdapter.allCourses(sqlcon);
    	assertEquals(oldNumOfCourses + 1, courses.size());
    	
    	assertEquals(csc458, SQLiteQueryAdapter.getCourse(sqlcon, "CSC458"));
    	
    	SQLiteQueryAdapter.deleteCourse(sqlcon, "CSC458");
    	courses = SQLiteQueryAdapter.allCourses(sqlcon);
    	assertEquals(oldNumOfCourses, courses.size());
    	
    	SQLiteQueryAdapter.deleteAllCourses(sqlcon);
    	assertEquals(0, SQLiteQueryAdapter.allCourses(sqlcon));
    }
    
    @Test(expected = SQLException.class)
    public void testEnrollStudentNotInDB() throws ClassNotFoundException, SQLException {
    	Student kenny = new Student("Kenny", "McCormick", "kenny@mail.com", "muffle muffle muffle", null, null);
    	SQLiteQueryAdapter.enrolStudentInCourse(sqlcon, "kenny@mail.com", "CSC108");
    }
    
    
    /**
     * Sets up a simple database
     * @param sqlcon
     */
    private static void setup(SQLiteController sqlcon){
		try {
			SQLiteQueryAdapter.deleteAllCourses(sqlcon);
			SQLiteQueryAdapter.deleteAllStudents(sqlcon);
			
			Student stu1 = new Student("Joe", "Lulu", "joe@mail.com", "pass1", null, null);
			Student stu2 = new Student("Mark", "Savage", "mark@mail.com", "pass2", null, null);
			Student stu3 = new Student("Lucy", "Vander", "lucy@mail.com", "pass3", null, null);
			
			SQLiteQueryAdapter.addStudent(sqlcon, stu1);
			SQLiteQueryAdapter.addStudent(sqlcon, stu2);
			SQLiteQueryAdapter.addStudent(sqlcon, stu3);
			
			Course course1 = new Course("CSC108", "Intro to Programming", "Paul Gries");
			Course course2 = new Course("CSC209", "Object Oriented Programming", "Diane Horton");
			SQLiteQueryAdapter.addCourse(sqlcon, course1);
			SQLiteQueryAdapter.addCourse(sqlcon, course2);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}