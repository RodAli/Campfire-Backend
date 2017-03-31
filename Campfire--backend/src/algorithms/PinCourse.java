package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class PinCourse {
	
	private String pin;
	private HashMap<String, Course> CoursePin = new HashMap<String, Course>();
	
	// Creates a hashmap where a PIN is a special ID for each course
	public PinCourse(String courseCode, String name, String instructor) {
		String pin = generatePin();
		CoursePin.put(pin, new Course(courseCode, name, instructor));
		
	}
	
	public String generatePin(){
        ArrayList<String> allCharacters = (ArrayList<String>) Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        		"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        		"1", "2", "3", "4", "5", "6", "7", "8", "9");
        ArrayList<String> newPin = new ArrayList<String>();
        Random random = new Random();
        while (newPin.size() < 10) {
        	String temp = allCharacters.get(random.nextInt(36)+1);
            newPin.add(temp);
        }
        String newPinStr = newPin.toString();
        return newPinStr; 
    }
	
	public HashMap<String, Course> getCoursePins(){
		return this.CoursePin;
	}
	
	public String getPin(){
		return this.pin;
	}
	
	public Course getCourseWithPin(String pin){
		if(this.CoursePin.get(pin) == null){
			throw new IllegalArgumentException("Pin Does Not Exist");
		}
		return this.CoursePin.get(pin);
	}
	
}
