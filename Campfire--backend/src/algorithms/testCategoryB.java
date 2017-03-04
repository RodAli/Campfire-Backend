package algorithms;

public class testCategoryB implements Comparable{

	/**
	 * ID was matched
	 */
	private static final long serialVersionUID = 1952358793540268673L;
	private int value;
	private static String ID = "B";
	
	public testCategoryB(int val){
		this.value = val;
	}
	
	public int getValue(){
		return value;
	}
		
	@Override
	//Comparing Method B - This will need to be more accurate
	public double Compare(Comparable other) {
		int checkagainst = ((testCategoryB) other).getValue();
		return Math.abs(this.getValue()*3 - checkagainst*2);
	}
	
	@Override
	public String getID(){
		return ID;
	}

}
