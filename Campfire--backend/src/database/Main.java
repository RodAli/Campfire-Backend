package database;

import java.util.ArrayList;
import algorithms.Comparable;
import algorithms.ProgrammingLanguagesCriteria;

public class Main {
	
	public static void main (String[] args){
		
		String [] a = {"Java", "C#", "C", "Python", "C++", "Javascript", "HTML", "CSS", "Verilog"};	// 9 elements
		String [] b = {""};
		
		ArrayList<Comparable> criteria = new ArrayList<>();
		
		ArrayList<String> languages = new ArrayList<>();
		languages.add(a[0]);
		languages.add(a[2]);
		languages.add(a[8]);
		ProgrammingLanguagesCriteria pc = new ProgrammingLanguagesCriteria(languages);
		criteria.add(pc);
		
		
	}
}
