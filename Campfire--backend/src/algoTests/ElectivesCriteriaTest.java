package algoTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algorithms.CSCCoursesCriteria;
import algorithms.ElectivesCriteria;


public class ElectivesCriteriaTest {
	@Test
	public void TestCompare2Criteria() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("History", "Biology", "Physics"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("History", "Biology", "Philosophy", "Women and Gender Studies"));
		
		ElectivesCriteria E1 = new ElectivesCriteria(S1, 1);
		ElectivesCriteria E2 = new ElectivesCriteria(S2, 1);
		
		double compareResult = E1.Compare(E2);
		assertEquals(2.0, compareResult, 0.01);
	}
	
	
	@Test
	public void TestCompare2CriteriaWithNothingInCommon() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Business", "Astronomy", "Physics"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("History", "Biology", "Philosophy", "Women and Gender Studies"));
		
		ElectivesCriteria E1 = new ElectivesCriteria(S1, 1);
		ElectivesCriteria E2 = new ElectivesCriteria(S2, 1);
		
		double compareResult = E1.Compare(E2);
		assertEquals(0.0, compareResult, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCompare2DifferentCriteria() {
		
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC300"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("History", "Biology", "Philosophy", "Women and Gender Studies"));
		
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1, 1);
		ElectivesCriteria E2 = new ElectivesCriteria(S2, 1);
		
		E2.Compare(CSC1);
		
	}
	
	@Test
	public void TestEnsureIDIsValid() {
		ElectivesCriteria E1 = new ElectivesCriteria(null, 0);
		
		assertEquals("Electives", E1.getID());
	}

}
