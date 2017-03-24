package algorithms;

import java.util.ArrayList;

public class CampfireGroup {

	private Course course;
	private ArrayList<Student> group;
	private int size;
	private String name;
	
	public CampfireGroup(String name, ArrayList<Student> group, int size) {
		this.course = course;
		this.group = group;
		this.size = size;
		this.name = name;
	}
	
	public ArrayList<Student> getMembers() {
		ArrayList<Student> tmp = new ArrayList<>();
			for(Student s : this.group){
				tmp.add(s);
			}
		return tmp;
	}
		
	public void addMember(Student stu){
		this.group.add(stu);
	}
		
	public void removeMember(Student stu){
		this.group.remove(stu);
	}
	
	public int getSize(){
		return this.size;
	}
	
	public String getName(){
		return this.name;
	}
	
}








