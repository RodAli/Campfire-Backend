package algorithms;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class PinGroup {
	
	private String pin;
	private Map<String, CampfireGroup> GroupPin;
			
	// Creates a map where a PIN is a special ID for each course
	public PinGroup(String name, ArrayList<Student> group, int size) {
		String pin = generatePin();
		this.GroupPin.put(pin, new CampfireGroup(name, group, size));
	}
			
	// Generates a 15 Character PIN code for each course that is created
	public String generatePin(){
		String allCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String newPin = "";
		Random random = new Random();
		while (newPin.length() < 15){
		    newPin += allCharacters.charAt(random.nextInt(36));
		}
	    return newPin; 
	}
		
	// Get the entire "table" of all the groups and pins
	public Map<String, CampfireGroup> getGroupPins(){
		return this.GroupPin;
	}
	
	// This is mostly needed for testing purposes
	public String getPin(){
		return this.pin;
	}

}
