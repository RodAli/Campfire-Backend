package algoTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algorithms.HobbiesCriteria;
import algorithms.ProgrammingLanguagesCriteria;


/*
 * Implicitly tests ArrayCriteria
 */
public class ProgrammingLanguagesCriteriaTest {
	
	
	@Test
	public void TestCompare2Criteria() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Java", "C", "Racket"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Java", "C", "C++", "HTML"));
		
		ProgrammingLanguagesCriteria PL1 = new ProgrammingLanguagesCriteria(S1);
		ProgrammingLanguagesCriteria PL2 = new ProgrammingLanguagesCriteria(S2);
		
		double compareResult = PL1.Compare(PL2);
		assertEquals(2.0, compareResult, 0.01);
	}
	
	
	@Test
	public void TestCompare2CriteriaWithNothingInCommon() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("XML", "C#", "Racket"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Java", "C", "C++", "HTML"));
		
		ProgrammingLanguagesCriteria PL1 = new ProgrammingLanguagesCriteria(S1);
		ProgrammingLanguagesCriteria PL2 = new ProgrammingLanguagesCriteria(S2);
		
		double compareResult = PL1.Compare(PL2);
		assertEquals(0.0, compareResult, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCompare2DifferentCriteria() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("Eating", "Walking", "Grooming Cats"));
		HobbiesCriteria H1 = new HobbiesCriteria(S1);
		
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Java", "C", "C++", "HTML"));
		
		ProgrammingLanguagesCriteria PL2 = new ProgrammingLanguagesCriteria(S2);
		
		PL2.Compare(H1);
		
	}
	
	@Test
	public void TestEnsureIDIsValid() {
		ProgrammingLanguagesCriteria PL1 = new ProgrammingLanguagesCriteria(null);
		
		assertEquals("Programming Languages", PL1.getID());
	}

}
