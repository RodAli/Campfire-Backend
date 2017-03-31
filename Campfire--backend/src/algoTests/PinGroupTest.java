package algoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import algorithms.CampfireGroup;
import algorithms.PinGroup;
import algorithms.Student;

public class PinGroupTest {


	/*
	 * Adding a group to the PIN map. Pay attention to the println statement
	 * so you know exactly what the PIN looks like. If you still are unsure.
	 */
	@Test
	public void TestAddingAPinGroup() {
		
		PinGroup allGroups = new PinGroup();
		CampfireGroup group1 = new CampfireGroup("A1", new ArrayList<Student>(), 10, 100);
		
		allGroups.addPinGroup(group1);
		
		String pin = allGroups.findPin(group1); 
		System.out.println(pin);
		
		assertEquals(group1, allGroups.getGroupPins().get(pin));
		
	}
	
	/* 
	 * Simple addition of multiple groups, with designated PINS.
	 */
	@Test
	public void AddingMultiplePinGroups() {
		PinGroup allGroups = new PinGroup();
		
		CampfireGroup group1 = new CampfireGroup("A1", new ArrayList<Student>(), 10, 100);
		CampfireGroup group2 = new CampfireGroup("A2", new ArrayList<Student>(), 10, 100);
		
		allGroups.addPinGroup(group1);
		allGroups.addPinGroup(group2);
		
		assertEquals(2, allGroups.getGroupPins().size());
		
		String pin = allGroups.findPin(group1); 
		
		assertEquals(group1, allGroups.getGroupPins().get(pin));	
	}
	
	/*
	 * A hard test to check. But, no PIN should be the same. We have a lot of combinations.
	 * A LOOOOOOOOT of combinations.
	 * 
	 */
	@Test
	public void NoPinShouldBeTheSame() {
		PinGroup allGroups = new PinGroup();
		
		CampfireGroup group1 = new CampfireGroup("A1", new ArrayList<Student>(), 10, 100);
		CampfireGroup group2 = new CampfireGroup("A2", new ArrayList<Student>(), 10, 100);
		
		allGroups.addPinGroup(group1);
		allGroups.addPinGroup(group2);
		
		String pin = allGroups.findPin(group1); 
		String pin2 = allGroups.findPin(group2); 
		
		Assert.assertFalse(allGroups.getGroupPins().get(pin2).equals(allGroups.getGroupPins().get(pin)));	
	}
	
	/*
	 * Remove a group by using the PIN.
	 */
	@Test
	public void removeAGroup() {
		
		PinGroup allGroups = new PinGroup();
		
		CampfireGroup group1 = new CampfireGroup("A1", new ArrayList<Student>(), 10, 100);
		CampfireGroup group2 = new CampfireGroup("A2", new ArrayList<Student>(), 10, 100);
		
		allGroups.addPinGroup(group1);
		allGroups.addPinGroup(group2);
		
		assertEquals(2, allGroups.getGroupPins().size());
		
		String pin = allGroups.findPin(group1); 
		String pin2 = allGroups.findPin(group2); 
		
		Assert.assertFalse(allGroups.getGroupPins().get(pin2).equals(allGroups.getGroupPins().get(pin)));
		
		allGroups.removePinGroup(pin);
		
		assertEquals(1, allGroups.getGroupPins().size());
	
	}
	
}
