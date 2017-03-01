package algoTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


import algorithms.ElectivesCriteria;
import algorithms.HobbiesCriteria;

public class HobbiesCriteriaTest {

	@Test
	public void TestCompare2Criteria() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Grooming Cats"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Studying", "Math"));
		
		HobbiesCriteria H1 = new HobbiesCriteria(S1);
		HobbiesCriteria H2 = new HobbiesCriteria(S2);
		
		double compareResult = H1.Compare(H2);
		assertEquals(2.0, compareResult, 0.01);
	}
	
	
	@Test
	public void TestCompare2CriteriaWithNothingInCommon() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Grooming Cats"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Breathing", "TV", "Studying", "Math"));
		
		HobbiesCriteria H1 = new HobbiesCriteria(S1);
		HobbiesCriteria H2 = new HobbiesCriteria(S2);
		
		double compareResult = H1.Compare(H2);
		assertEquals(0.0, compareResult, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCompare2DifferentCriteria() {
		
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Grooming Cats"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("History", "Biology", "Philosophy", "Women and Gender Studies"));
		
		HobbiesCriteria H1 = new HobbiesCriteria(S1);
		ElectivesCriteria E2 = new ElectivesCriteria(S2);
		
		H1.Compare(E2);
		
	}
	
	@Test
	public void TestEnsureIDIsValid() {
		HobbiesCriteria H1 = new HobbiesCriteria(null);
		
		assertEquals("Hobbies", H1.getID());
	}

}
