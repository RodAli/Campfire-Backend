package database;

import java.sql.SQLException;
import java.util.ArrayList;

import algorithms.Student;
import algorithms.Category;
import algorithms.Comparable;
import algorithms.Course;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
		
		SQLiteController sqlcon = new SQLiteController();
		
		try {
			SQLiteQueryAdapter.deleteAllCourses(sqlcon);
			SQLiteQueryAdapter.deleteAllStudents(sqlcon);
			
			Student stu1 = new Student("Joe", "Lulu", "joe@mail.com", "pass1", null, null);
			Student stu2 = new Student("Mark", "Savage", "mark@mail.com", "pass2", null, null);
			Student stu3 = new Student("Lucy", "Vander", "lucy@mail.com", "pass3", null, null);
			
			SQLiteQueryAdapter.addStudent(sqlcon, stu1);
			SQLiteQueryAdapter.addStudent(sqlcon, stu2);
			SQLiteQueryAdapter.addStudent(sqlcon, stu3);
			
			ArrayList<Student> allStudents = SQLiteQueryAdapter.allStudents(sqlcon);
			
			for(int i = 0; i < allStudents.size(); i++){
				String text = allStudents.get(i).getEmail() + "\t" + 
								allStudents.get(i).getFname() + "\t" + 
								allStudents.get(i).getLname() + "\t" +
								allStudents.get(i).getPass();
				System.out.println(text);
			}
			
			System.out.println(SQLiteQueryAdapter.studentExists(sqlcon, "mark@mail.com"));
			System.out.println(SQLiteQueryAdapter.getStudent(sqlcon, "lucy@mail.com").getEmail());
			System.out.println("-----------------------------------------");
			
			Course course = new Course("CSC108", "Intro to Programming", "Paul Gries");
			SQLiteQueryAdapter.addCourse(sqlcon, course);
			
			ArrayList<Course> allCourses = SQLiteQueryAdapter.allCourses(sqlcon);
			for(int i = 0; i < allCourses.size(); i++){
				String text = allCourses.get(i).getCourseCode() + "\t" + 
								allCourses.get(i).getName() + "\t" + 
								allCourses.get(i).getInstructor();
				System.out.println(text);
			}
			System.out.println(SQLiteQueryAdapter.courseExists(sqlcon, "CSC108"));
			System.out.println(SQLiteQueryAdapter.getCourse(sqlcon, "CSC108").getCourseCode());
			
			sqlcon.closeConnectionToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
