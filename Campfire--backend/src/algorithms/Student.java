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

	private String fname;
	private String lname;
	private String email;
	//private ArrayList<Comparable> criteria;
	private ArrayList<Category> criteria;
	private HashMap<String, HashMap<Student, Holder>> matchvalues = new HashMap<String, HashMap<Student, Holder>>();
	private HashMap<String, ArrayList<Student>> availablematches = new HashMap<String, ArrayList<Student>>();
	
	public Student(String fname, String lname, String email, ArrayList<Category> criteria) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.criteria = criteria;
	}

	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}


	public String getEmail() {
		return email;
	}
	
	public ArrayList<Category> getCriteria(){
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
	
	public void addAvailablematches(Course course, Student s) {
		if (this.getAvailablematches().get(course.getName()) == null){
			this.getAvailablematches().put(course.getName(), new ArrayList<Student>());
		}
		if (s.getEmail() != this.getEmail()){
			this.getAvailablematches().get(course.getName()).add(s);
		}
	}
	
	/*
	 * Gets all the students in Course course that are
	 * not this student.
	 * 
	 */
	public ArrayList<Student> getallOtherCourseStudents(Course course){
		ArrayList<Student>tmpStudents = new ArrayList<Student>();
		for (Student stu : course.getStudents()){
			tmpStudents.add(stu);
		}
		tmpStudents.remove(this);
		return tmpStudents;
	}
	
	/*
	 * Generates the compatibility score between this Student
	 * and Student s.
	 * 
	 */
	public Holder GenerateScore(Student s){
		double totalScore = 0;
		for (Category thisStudent : this.getCriteria()){
			for(Category otherStudent : s.getCriteria()){
				if(thisStudent.getCategory() == otherStudent.getCategory()){
					totalScore += Math.abs(thisStudent.getIndex() - otherStudent.getIndex());
				}
			}
		}
		return new Holder(totalScore);
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
	public void MatchWithClass(Course course, Boolean flag){
		
		if (course.getStudents().isEmpty()){
			return;
		}
		
		HashMap <Student, Holder> tmp = new HashMap <Student, Holder>();
		
		/*
		 * If flag is true then the student is being added to the course
		 * for the first time -- match with everyone
		 * 
		 */
		if (flag){
			for (Student s : course.getStudents()){
				tmp.put(s, this.GenerateScore(s));
			}
			this.getMatchvalues().put(course.getName(), tmp);
			this.getAvailablematches().put(course.getName(), this.getallOtherCourseStudents(course));
		}
		
		/*
		 * If flag is false then student has already calculated everyone
		 * at least once -- only need to calculate score of sudents
		 * that are available matches.
		 * 
		 */
		else {
			for (Student s : this.getAvailablematches().get(course)){
				tmp.put(s, this.GenerateScore(s));	
			}
			this.getMatchvalues().put(course.getName(), tmp);
		}
		
	}

	
	/*
	 * Get the student in Course course who has the highest
	 * compatibility score with this Student.
	 * 
	 */
	public Student getBestClassMatch(Course course){
		if(this.getAvailablematches().get(course.getName()).isEmpty()){
			return null;
		}
		Student bestStudent = null;
		double bestScore = Double.MAX_VALUE;
		for (Student s : this.getAvailablematches().get(course.getName())){
			if ((s.getEmail() != this.getEmail()) && this.getClassMatchvalues(course).get(s).getValue() < bestScore){
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
		
		this.getAvailablematches().get(course.getName()).remove(s);
		
	}
}
