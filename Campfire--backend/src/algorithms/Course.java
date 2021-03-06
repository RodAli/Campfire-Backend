package algorithms;

import java.util.ArrayList;

/*
 * A Course with students. Course code is a distinguishing 
 * feature.
 * 
 */
public class Course {
	

	// Full name of the course
	private String name;
	private String description;
	private String instructor;
	
	//All the students in this course.
	private ArrayList<Student> Students = new ArrayList<Student>();
	
	public Course(String name, String description, String instructor) {
		super();
		this.name = name;
		this.description = description;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getInstructor() {
		return instructor;
	}

	public ArrayList<Student> getStudents() {
		return Students;
	}
	
	/*
	 * Checks whether email is already used by a student in the course.
	 * Enforces email as a unique identifier for students in a course.
	 * 
	 */
	public Boolean emailExists(String email){
		for (Student stu : this.getStudents()){
			if (stu.getEmail() == email){
				return true;
			}
		}
		return false;
		
	}
	
	/*
	 * Adds Student s to the implicit graph of
	 * this course.
	 * Also adds the student to the available matches
	 * of every other student for this course.
	 * 
	 */
	public void addStudent(Student s) throws IllegalArgumentException{
		if (this.getStudents().contains(s) || emailExists(s.getEmail())){
			throw new IllegalArgumentException("Cannot add a student who is already in the course.");
		}
		s.MatchWithClass(this, true);
		ArrayList<Student> stuList = this.getStudents();
		for (int i = 0; i < stuList.size(); i++){
			stuList.get(i).addAvailablematches(this, s);
		}
		this.getStudents().add(s);
	}
	
}
