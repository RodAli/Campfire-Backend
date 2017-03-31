package algorithms;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class PinGroup {
	
	private Map<String, CampfireGroup> GroupPins;
			
	// Creates a map where a PIN is a special ID for each course
	public PinGroup(CampfireGroup group) {
		this.GroupPins.put(generatePin(), group);
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
		
	// Get the entire map of all the groups and pins
	public Map<String, CampfireGroup> getGroupPins(){
		return this.GroupPins;
	}
	
	// Extract the PIN for the given group
	public String findPin(CampfireGroup group){
		for(Entry<String, CampfireGroup> value : this.GroupPins.entrySet()){
			if(group.equals(value.getValue())){
				return value.getKey();
			}
		}
		return null;
	}

}
