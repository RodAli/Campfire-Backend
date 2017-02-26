package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import algorithms.Category;
import algorithms.Comparable;
import algorithms.Course;
import algorithms.Student;

/**
 * Class that includes useful operations for creating queries
 * for extracting and inputting information in the database.
 */
public class SQLiteQueryAdapter {
	
	/**
	 * Given a student object, stores this student in the student table in the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param student instance that needs to be stored in that database
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static void addStudent(SQLiteController controller, Student student) throws SQLException, ClassNotFoundException{
		// Get the connection instance
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");
		// Build the query from the fields given
		statement.setString(1, student.getEmail());
		statement.setString(2, student.getFname());
		statement.setString(3, student.getLname());
		statement.setString(4, student.getPass());
		// Run the query
		controller.updateQuery(statement);
	}
	
	/**
	 * Get all the students in the database and return them in an ArrayList.
	 * @param controller instance of SQLiteController with a connection to database
	 * @return a List of all the students in the database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Student> allStudents(SQLiteController controller) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		// Prepare query to get all students
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
		ResultSet set = controller.returnQuery(statement);
		
		// Loop through all students and add to array list
		ArrayList<Student> studentList = new ArrayList<Student>();
		while(set.next()){
			String email = set.getString("email");
			String fname = set.getString("fname");
			String lname = set.getString("lname");
			String pass = set.getString("pass");
			
			Student stu = new Student(fname, lname, email, pass, null, null);
			studentList.add(stu);
		}
		return studentList;
	}
	
	/**
	 * Check if a student with a given email exists in the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param email of the student we are checking if they exist
	 * @return true, if the user with email exists, false otherwise
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean studentExists(SQLiteController controller, String email) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM student WHERE email=?");
		statement.setString(1, email);
		ResultSet set = controller.returnQuery(statement);
		
		// Count the number of students with this email. (Should be 1 or 0)
		int count = 0;
		while (set.next()){
			count++;
		}
		
		// Return if this student with email exists
		return count > 0;
	}
	
	/**
	 * Get the student with specified email, if student is not found null is returned.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param email of the student that needs to be returned
	 * @return Student object if student is found, return null otherwise
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Student getStudent(SQLiteController controller, String email) throws SQLException, ClassNotFoundException{
		// Make sure student exists
		if (studentExists(controller, email)){
			Connection connection = controller.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM student WHERE email=?");
			statement.setString(1, email);
			ResultSet set = controller.returnQuery(statement);
			if (set.next()){
				String fname = set.getString("fname");
				String lname = set.getString("lname");
				String pass = set.getString("pass");
				
				Student student = new Student(fname, lname, email, pass, null, null);
				return student;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param controller
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void deleteStudent(SQLiteController controller, String email) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE email = ?");
		statement.setString(1, email);
		controller.updateQuery(statement);
		// TODO remove student from coursetostudent table
	}
	
	/**
	 * Delete all the students in the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void deleteAllStudents(SQLiteController controller) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM student");
		controller.updateQuery(statement);
		// Remove all the enrollments
		deleteAllEnrollments(controller);
	}
	
	/**
	 * Add a course object to be stored in the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param course instance of Course object to be stored in the database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void addCourse(SQLiteController controller, Course course) throws SQLException, ClassNotFoundException{
		// Get the connection instance
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO course VALUES (?,?,?)");
		// Build the query from the fields given
		statement.setString(1, course.getCourseCode());
		statement.setString(2, course.getName());
		statement.setString(3, course.getInstructor());
		// Run the query
		controller.updateQuery(statement);
		
		//TODO add all the courses students into the database
	}
	
	/**
	 * Get all the courses stored in the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @return an ArrayList of Course of all the courses in the database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Course> allCourses(SQLiteController controller) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM course");
		
		ResultSet set = controller.returnQuery(statement);
		
		ArrayList<Course> courseList = new ArrayList<Course>();
		while(set.next()){
			String code = set.getString("code");
			String name = set.getString("name");
			String instructor = set.getString("instructor");
			
			Course course = new Course(code, name, instructor);
			courseList.add(course);
		}
		
		// TODO Add all the student objects enrolled in each course
		return courseList;
	}
	
	/**
	 * Determine if a particular course exists within the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param courseCode code of the course that is being searched for
	 * @return true if a course with given courseCode exists, false otherwise
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean courseExists(SQLiteController controller, String courseCode) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM course WHERE code=?");
		statement.setString(1, courseCode);
		ResultSet set = controller.returnQuery(statement);
		
		// Count the number of courses with this code. (Should be 1 or 0)
		int count = 0;
		while (set.next()){
			count++;
		}
		
		// Return if this course with code exists
		return count > 0;
	}
	
	/**
	 * Return Course instance identified by the course code given.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param code of the that is being requested
	 * @return Course instance identified by the course code that is given
	 */
	public static Course getCourse(SQLiteController controller, String code) throws SQLException, ClassNotFoundException{
		// Make sure course exists
		if (courseExists(controller, code)){
			Connection connection = controller.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM course WHERE code=?");
			statement.setString(1, code);
			ResultSet set = controller.returnQuery(statement);
			if (set.next()){
				String name = set.getString("name");
				String instructor = set.getString("instructor");
				
				Course course = new Course(code, name, instructor);
				
				// TODO add all the student objects in this course
				return course;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * Remove a particular course from the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @param code of the course that is needed to be deleted
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void deleteCourse(SQLiteController controller, String code) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM course WHERE code = ?");
		//TODO also remove this course from the course to student table
		statement.setString(1, code);
		controller.updateQuery(statement);
	}
	
	/**
	 * Delete all the courses in the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void deleteAllCourses(SQLiteController controller) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM course");
		controller.updateQuery(statement);
		// Remove all the enrollments
		deleteAllEnrollments(controller);
	}
	
	/**
	 * Delete all the enrollments of students in courses from the database.
	 * @param controller instance of SQLiteController with a connection to database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void deleteAllEnrollments(SQLiteController controller) throws SQLException, ClassNotFoundException{
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM coursetostudent");
		controller.updateQuery(statement);
	}
}
