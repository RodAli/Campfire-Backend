package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
		
		SQLiteController sqlcon = new SQLiteController();
		
		try {
			sqlcon.addStudent("Rod", "Mazloomi", "rod.mazloomi@hotmail.com");
			ResultSet set = sqlcon.getAllStudents();
			
			while(set.next()){
				System.out.println(set.getString("fname") + " " + 
									set.getString("lname") + " " +
									set.getString("email"));
			}
			
			sqlcon.closeConnectionToDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
