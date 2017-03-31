package algoTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algorithms.CSCCoursesCriteria;
import algorithms.ProgrammingLanguagesCriteria;


public class CSCCoursesCriteriaTest {

	@Test
	public void TestCompare2Criteria() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC300"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC324", "CSC318"));
		
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1, 1);
		CSCCoursesCriteria CSC2 = new CSCCoursesCriteria(S2, 1);
		
		double compareResult = CSC1.Compare(CSC2);
		assertEquals(2.0, compareResult, 0.01);
	}
	
	
	@Test
	public void TestCompare2CriteriaWithNothingInCommon() {
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC300"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("CSC373", "CSC358", "CSC324", "CSC318"));
		
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1, 1);
		CSCCoursesCriteria CSC2 = new CSCCoursesCriteria(S2, 1);
		
		double compareResult = CSC1.Compare(CSC2);
		assertEquals(0.0, compareResult, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCompare2DifferentCriteria() {
		
		ArrayList<String> S1 = new ArrayList<String>(Arrays.asList("CSC301", "CSC369", "CSC300"));
		ArrayList<String> S2 = new ArrayList<String>(Arrays.asList("Java", "C", "C++", "HTML"));
		
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(S1, 1);
		ProgrammingLanguagesCriteria PL2 = new ProgrammingLanguagesCriteria(S2, 1);
		
		CSC1.Compare(PL2);
		
	}
	
	@Test
	public void TestEnsureIDIsValid() {
		CSCCoursesCriteria CSC1 = new CSCCoursesCriteria(null, 0);
		
		assertEquals("Previous CSC Courses", CSC1.getID());
	}

}
