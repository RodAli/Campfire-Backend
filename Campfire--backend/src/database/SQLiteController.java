package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteController {
	
	// Our connection instance to the database
	private static Connection connection = null;
	private static Statement statement = null;
	private static boolean initialized = false;
	
	/**
	 * Connect to the database Campfire.db database.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void connectToDB() throws SQLException, ClassNotFoundException{
		// Set up the database connection
		Class.forName("org.sqlite.JDBC");
	    connection = DriverManager.getConnection("jdbc:sqlite:Campfire.db");
	    statement = connection.createStatement();
	    
	    // Verify on first instance of this class that we are connected to the database
	    if (!initialized){
	    	initialized = true;
	    	
	    	// Check if the student table exists in the database
	    	String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='student'";
	    	ResultSet result = statement.executeQuery(query);
	    	
	    	// If the student table does not exist in database, create it 
	    	if(!result.next()){
	    		String createQuery = "CREATE TABLE student(" + 
	    							 "id integer primary key autoincrement," +
	    							 "email TEXT," +
	    							 "fname TEXT," + 
	    							 "lname TEXT);";
	    		statement.executeUpdate(createQuery);
	    	}
	    }
	}
	
	/**
	 * Query all the students in the Campfire.db database.
	 * @return a ResultSet of all students and all their information
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getAllStudents() throws SQLException, ClassNotFoundException{
		// Check if we need to connect to the database, do so if needed
		if (connection == null){
			System.out.println("1");
			connectToDB();
		}
		
		// Return all students
		String query = "SELECT * FROM student";
		return statement.executeQuery(query);
	}
	
	//TODO: DUMMY METHOD CHANGE LATER TO TAKE AN OBJECT OF STUDENT
	public void addStudent(String fname, String lname, String email) throws SQLException, ClassNotFoundException{
		// Check if we need to connect to the database, do so if needed
		if (connection == null){
			connectToDB();
		}
		
		// Get the user from database based on arguments
		String query = "INSERT INTO student values(?,?,?,?)";
		PreparedStatement prepState = connection.prepareStatement(query);
		prepState.setString(2, email);
		prepState.setString(3, fname);
		prepState.setString(4, lname);
		prepState.execute();
	}
	
	
	/**
	 * End the connection to the Campfire.db database.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void closeConnectionToDB() throws SQLException, ClassNotFoundException{
		// Close connection and statement object
		statement.close();
		connection.close();
	}
	
	
}
