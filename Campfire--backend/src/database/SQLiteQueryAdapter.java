package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import algorithms.Category;
import algorithms.Comparable;
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
		Connection connection = controller.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO student VALUES (?,?,?)");
		statement.setString(1, student.getEmail());
		statement.setString(2, student.getFname());
		statement.setString(3, student.getLname());
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
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
		ResultSet set = controller.returnQuery(statement);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		while(set.next()){
			String email = set.getString("email");
			String fname = set.getString("fname");
			String lname = set.getString("lname");
			ArrayList<Category> criteria = new ArrayList<Category>();
			Student stu = new Student(fname, lname, email, criteria);
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
}
