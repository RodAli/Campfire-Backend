package algoTests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import algorithms.Holder;

public class HolderTest {

	private Holder hold;
	

	@Test
	public void TestCreateHolderandGetValue() {
		double val = 1.2;
		hold = new Holder(val);
		assertEquals(val, hold.getValue(), 0.01);
	}
	
	@Test
	public void TestCreateHolderandGetValueRandom() {
		Random r = new Random();
		double val = 100*r.nextDouble();
		hold = new Holder(val);
		assertEquals(val, hold.getValue(), 0.01);
	}
	
	@Test
	public void TestCreateHolderandSetValue() {
		double val = 1.2;
		hold = new Holder(val);
		double val2 = 2.4;
		hold.setValue(val2);
		assertEquals(val2, hold.getValue(), 0.01);
	}
	
	@Test
	public void TestCreateHolderandSetValueRandom() {
		Random r = new Random();
		double val = 100*r.nextDouble();
		hold = new Holder(val);
		double val2 = 100*r.nextDouble();
		hold.setValue(val2);
		assertEquals(val2, hold.getValue(), 0.01);
	}

}
