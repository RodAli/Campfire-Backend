package database;

import java.sql.SQLException;
import java.util.ArrayList;

import algorithms.Student;
import algorithms.Category;
import algorithms.Comparable;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
		
		SQLiteController sqlcon = new SQLiteController();
		
		try {
			ArrayList<Category> blank = new ArrayList<Category>();
			Student stu = new Student("Joe", "Lulu", "asdf@mail.com", blank);
			
			//SQLiteQueryAdapter.addStudent(sqlcon, stu);
			
			ArrayList<Student> allStudents = SQLiteQueryAdapter.allStudents(sqlcon);
			
			for(int i = 0; i < allStudents.size(); i++){
				String text = allStudents.get(i).getEmail() + "\t" + 
								allStudents.get(i).getFname() + "\t" + 
								allStudents.get(i).getLname();
				System.out.println(text);
			}
			
			System.out.println(SQLiteQueryAdapter.studentExists(sqlcon, "goo@mail.com"));
			
			sqlcon.closeConnectionToDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
