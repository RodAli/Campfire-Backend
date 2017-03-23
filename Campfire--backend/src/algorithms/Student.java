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
	private String pass;
	private String description;
	private ArrayList<Comparable> criteria;
	//// CAMPFIRE
	private MyCampfire campfire;
	private String sID;
	////
	private HashMap<String, HashMap<Student, Holder>> matchvalues = new HashMap<String, HashMap<Student, Holder>>();
	private HashMap<String, ArrayList<Student>> availablematches = new HashMap<String, ArrayList<Student>>();
	
	//Data structures for a Course to Assignment to Student mapping
	private HashMap<String, HashMap<Assignment, AssignmentGroup>> groupsForAssignment = new HashMap<>();
	private HashMap<String, HashMap<Assignment, ArrayList<Student>>> savedAvailableMatches = new HashMap<>();
	private HashMap<String, Assignment> curAssignmentForCourse = new HashMap<>();
	
	public Student(String fname, String lname, String email, String pass, ArrayList<Comparable> criteria) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.criteria = criteria;
		this.sID = pass;
		campfire = new MyCampfire(this, sID);
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
	
	public ArrayList<Comparable> getCriteria(){
		return criteria;
	}

	public HashMap<String, HashMap<Student, Holder>> getMatchvalues() {
		return matchvalues;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public ArrayList<String> getCSCCourses(){
		return findArrayComparable("Previous CSC Courses");
	}
	
	public ArrayList<String> getElectives(){
		return findArrayComparable("Electives");
	}
	
	public ArrayList<String> getHobbies(){
		return findArrayComparable("Hobbies");
	}
	
	public ArrayList<String> getProgramming(){
		return findArrayComparable("Programming Languages");
	}
	
	public HashMap<String, ArrayList<String>> getCalendar(){
		return (HashMap<String, ArrayList<String>>) findMapComparable("Time Schedule");
	}
	
	/*
	 * Extracts the criteria from comparable and returns it as an ArrayList 
	 * For further information see test case - extractComparables
	 */
	public ArrayList<String> findArrayComparable(String search){
		for(Comparable criteria: this.getCriteria()){
			if(criteria.getID() == search){
				return (ArrayList<String>) criteria.getItems();
			}
		}
		return null;
	}
	
	public HashMap<String, ArrayList<String>> findMapComparable(String search){
		for(Comparable criteria: this.getCriteria()){
			if(criteria.getID() == search){
				return (HashMap<String, ArrayList<String>>) criteria.getItems();
			}
		}
		return null;
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
	
	
	//This method is used for the ArrayList<Comparable>
	public Holder GenerateScore(Student s){
		double totalScore = 0;
		for (Comparable thisStudent : this.getCriteria()){
			for(Comparable otherStudent : s.getCriteria()){
				if(thisStudent.getID() == otherStudent.getID()){
					totalScore += thisStudent.Compare(otherStudent);
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
			for (Student s : this.getAvailablematches().get(course.getName())){
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
	
	// My Campfire //
	
	public ArrayList<Student> getCampfire(){
		return this.campfire.getMembers();
	}
	
	///////////////////////////////////////////////////////////////
	//Methods for tracking assignments and groups
	
	public void enroll(Course course){
		this.groupsForAssignment.put(course.getName(), new HashMap<Assignment, AssignmentGroup>());
		this.savedAvailableMatches.put(course.getName(), new HashMap<Assignment, ArrayList<Student>>());
		this.curAssignmentForCourse.put(course.getName(), null);
	}
	
	public void addAssignment(Course course, Assignment a, boolean first){
		
		this.groupsForAssignment.get(course.getName()).put(a, null);
		this.savedAvailableMatches.get(course.getName()).put(a, this.getallOtherCourseStudents(course));
		if (first){
			this.curAssignmentForCourse.put(course.getName(), a);
		}
		else{
			save(course);
			load(course, a);
		}
	}
	
	private ArrayList<Student> copy(ArrayList<Student> src){
		ArrayList<Student> dest = new ArrayList<>();
		for (Student s : src){
			dest.add(s);
		}
		return dest;
	}
	
	public void save(Course course){
		this.savedAvailableMatches.get(course.getName()).put(this.curAssignmentForCourse.get(course.getName()), copy(this.getAvailablematches().get(course.getName())));
	}
	
	public void load(Course course, Assignment a){
		this.availablematches.put(course.getName(), copy(this.savedAvailableMatches.get(course.getName()).get(a)));
		this.curAssignmentForCourse.put(course.getName(), a);
	}
	
	public void restoreMatches (Course course, Assignment a){
		this.savedAvailableMatches.get(course.getName()).put(a, copy(this.getallOtherCourseStudents(course)));
		this.availablematches.put(course.getName(), this.savedAvailableMatches.get(course.getName()).put(a, this.getallOtherCourseStudents(course)));
	}

	public HashMap<String, HashMap<Assignment, AssignmentGroup>> getGroupsForAssignment() {
		return groupsForAssignment;
	}

	public HashMap<String, HashMap<Assignment, ArrayList<Student>>> getSavedAvailableMatches() {
		return savedAvailableMatches;
	}

	public HashMap<String, Assignment> getCurAssignmentForCourse() {
		return curAssignmentForCourse;
	}
	
	
}
