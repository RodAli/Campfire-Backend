package algorithms;

import java.util.ArrayList;

/*
 * A Course with students. Course name is a distinguishing 
 * feature.
 * 
 */
public class Course {

	private String name;
	private String instructor; //Unneeded? Here just in case.
	
	//All the students in this course.
	private ArrayList<Student> Students;
	
	public Course(String name, String instructor) {
		super();
		this.name = name;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}

	public ArrayList<Student> getStudents() {
		return Students;
	}
	
	/*
	 * Adds Student s to the implicit graph of
	 * this course.
	 * Also adds the student to the available matches
	 * of every other student for this course.
	 * 
	 */
	public void addStudent(Student s){
		s.MatchWithClass(this, true);
		for (Student stu : this.getStudents()){
			stu.addAvailablematches(this, s);
		}
		this.getStudents().add(s);
	}
	
}
