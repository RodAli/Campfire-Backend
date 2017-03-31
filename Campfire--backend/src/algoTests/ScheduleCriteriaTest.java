package algoTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import algorithms.CSCCoursesCriteria;
import algorithms.ScheduleCriteria;


public class ScheduleCriteriaTest {

	@Test
	public void TestCompare2Criteria() {
		HashMap<String, ArrayList<String>> S1 = new HashMap<String, ArrayList<String>>(); 
		HashMap<String, ArrayList<String>> S2 = new HashMap<String, ArrayList<String>>(); 
		ArrayList<String> MTimesS1 = new ArrayList<String>(Arrays.asList("5", "6", "7"));
		ArrayList<String> MTimesS2 = new ArrayList<String>(Arrays.asList("3", "6", "7"));
		ArrayList<String> TTimesS1 = new ArrayList<String>(Arrays.asList("1", "2", "3"));
		ArrayList<String> TTimesS2 = new ArrayList<String>(Arrays.asList("3", "1", "10"));
		ArrayList<String> STimesS1 = new ArrayList<String>(Arrays.asList("0", "1", "2"));
		ArrayList<String> STimesS2 = new ArrayList<String>(Arrays.asList("3", "4"));
		S1.put("Monday", MTimesS1);
		S2.put("Monday", MTimesS2);
		S1.put("Tuesday", TTimesS1);
		S2.put("Tuesday", TTimesS2);
		S1.put("Saturday", STimesS1);
		S2.put("Sunday", STimesS2);
		
		ScheduleCriteria SC1 = new ScheduleCriteria(S1, 2);
		ScheduleCriteria SC2 = new ScheduleCriteria(S2, 2);
		
		double compareResult = SC1.Compare(SC2);
		assertEquals(4.0, compareResult, 0.01);
	}
	
	
	@Test
	public void TestCompare2CriteriaWithNothingInCommon() {
		HashMap<String, ArrayList<String>> S1 = new HashMap<String, ArrayList<String>>(); 
		HashMap<String, ArrayList<String>> S2 = new HashMap<String, ArrayList<String>>(); 
		ArrayList<String> MTimesS1 = new ArrayList<String>(Arrays.asList("5", "6", "7"));
		ArrayList<String> MTimesS2 = new ArrayList<String>(Arrays.asList("8", "9", "10"));
		ArrayList<String> TTimesS1 = new ArrayList<String>(Arrays.asList("1", "2", "3"));
		ArrayList<String> TTimesS2 = new ArrayList<String>(Arrays.asList("11", "4", "10"));
		ArrayList<String> STimesS1 = new ArrayList<String>(Arrays.asList("0", "1", "2"));
		ArrayList<String> STimesS2 = new ArrayList<String>(Arrays.asList("3", "4"));
		S1.put("Monday", MTimesS1);
		S2.put("Monday", MTimesS2);
		S1.put("Tuesday", TTimesS1);
		S2.put("Tuesday", TTimesS2);
		S1.put("Saturday", STimesS1);
		S2.put("Sunday", STimesS2);
		
		ScheduleCriteria SC1 = new ScheduleCriteria(S1, 2);
		ScheduleCriteria SC2 = new ScheduleCriteria(S2, 2);
		
		double compareResult = SC1.Compare(SC2);
		assertEquals(0.0, compareResult, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCompare2DifferentCriteria() {
		HashMap<String, ArrayList<String>> S1 = new HashMap<String, ArrayList<String>>(); 
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("TEST", "CASE", "LOL"));
		
		ScheduleCriteria SC1 = new ScheduleCriteria(S1, 2);
		CSCCoursesCriteria CSC2 = new CSCCoursesCriteria(S2, 2);
		
		SC1.Compare(CSC2);
	}
	
	@Test
	public void TestEnsureIDIsValid() {
		ScheduleCriteria SC1 = new ScheduleCriteria(null, 0);
		
		assertEquals("Time Schedule", SC1.getID());
	}

}
