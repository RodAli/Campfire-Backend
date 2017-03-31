package algorithms;

import java.util.Map;
import java.util.Random;

public class PinCourse {
	
	private String pin;
	private Map<String, Course> CoursePin;
	
	// Creates a map where a PIN is a special ID for each course
	public PinCourse(String courseCode, String name, String instructor) {
		String pin = generatePin();
		CoursePin.put(pin, new Course(courseCode, name, instructor));
		
	}
	
	// Generates a 15 Character PIN code for each course that is created
	public String generatePin(){
        String allCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String newPin = "";
        Random random = new Random();
        while (newPin.length() < 15) {
            newPin += allCharacters.charAt(random.nextInt(36));
        }
        return newPin; 
    }
	
	public Map<String, Course> getCoursePins(){
		return this.CoursePin;
	}
	
	public String getPin(){
		return this.pin;
	}
	
}
