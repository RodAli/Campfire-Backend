package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * A student using the app.
 * Each student has a list of comparable criteria,
 * A Hashmap of courses they belong to mapped to 
 * a Hashmap of the other students in that course and their
 * compatibility score,
 * A HashMap of course names to students who they have not
 * yet matched with or have not declined to match with.
 * 
 */
public class Student {

	private String name;
	private String email;
	private ArrayList<Comparable> criteria;
	private HashMap<String, HashMap<Student, Holder>> matchvalues;
	private HashMap<String, ArrayList<Student>> availablematches;
	
	public Student(String name, String email, ArrayList<Comparable> criteria) {
		super();
		this.name = name;
		this.email = email;
		this.criteria = criteria;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Comparable> getCriteria() {
		return criteria;
	}

	public HashMap<String, HashMap<Student, Holder>> getMatchvalues() {
		return matchvalues;
	}
	
	/*
	 * Gets the Hashmap of students to compatibility values for Course course.
	 * 
	 */
	public HashMap<Student, Holder> getClassMatchvalues(Course course) {
		return matchvalues.get(course.getName());
	}
	
	public HashMap<String, ArrayList<Student>> getAvailablematches() {
		return availablematches;
	}
	
	/*
	 * Gets all the students in Course course that are
	 * not this student.
	 * 
	 */
	public ArrayList<Student> getallOtherCourseStudents(Course course){
		ArrayList<Student>tmpStudents = course.getStudents();
		tmpStudents.remove(this);
		return tmpStudents;
	}
	
	/*
	 * Generates the compatibility score between this Student
	 * and Student s.
	 * 
	 */
	public Holder GenerateScore(Student s){
		double aggregate = 0;
		for (Comparable c : this.getCriteria()){
			aggregate += c.Compare(s.getCriteria().get(s.getCriteria().indexOf(c)));
		}
		return new Holder(aggregate);
	}
	
	/*
	 * Fills up the matchvalues HashMap for Course course
	 * by matching this student with every other student in the course.
	 * Also sets the available matches for this student to every other
	 * student in the course.
	 * 
	 * Analagous to adding edges in a connected graph between this student
	 * and every other student.
	 * 
	 */
	public void MatchWithClass(Course course){
		HashMap <Student, Holder> tmp = new HashMap <Student, Holder>();
		for (Student s : course.getStudents()){
			tmp.put(s, this.GenerateScore(s));
		}
		this.getMatchvalues().put(course.getName(), tmp);
		this.getAvailablematches().put(course.getName(), this.getallOtherCourseStudents(course));
	}

	
	/*
	 * Get the student in Course course who has the highest
	 * compatibility score with this Student.
	 * 
	 */
	public Student getBestClassMatch(Course course){
		Student bestStudent = null;
		double bestScore = 0;
		for (Student s : this.getAvailablematches().get(course.getName())){
			if (this.getClassMatchvalues(course).get(s).getValue() > bestScore){
				bestStudent = s;
				bestScore = this.getClassMatchvalues(course).get(s).getValue();
			}
		}
		
		return bestStudent;
	}
	
	
	/*
	 * If this student declined to match with Student s in Course course,
	 * s is removed from the available matches list for course.
	 * 
	 */
	public void notMatched(Student s, Course course){
		ArrayList<Student> tmp = this.getallOtherCourseStudents(course);
		tmp.remove(s);
		this.getAvailablematches().put(course.getName(), tmp);
	}
}
