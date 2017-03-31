package algorithms;

import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class PinCourse {

	private Map<String, Course> CoursePins;
	
	// Creates a map where a PIN is a special ID for each course
	public PinCourse(Course course) {
		CoursePins.put(generatePin(), course);
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
	
	// Get the entire map of all the courses and pins
	public Map<String, Course> getCoursePins(){
		return this.CoursePins;
	}
	
	// Extract the PIN for the given course
	public String findPin(Course course){
		for(Entry<String, Course> value : this.CoursePins.entrySet()){
			if(course.equals(value.getValue())){
				return value.getKey();
			}
		}
		return null;
	}
	
}
