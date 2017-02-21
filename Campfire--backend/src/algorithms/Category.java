package algorithms;

/*
 * 
 * 
 */
public class Category {

	//Might need more in the future; For more accurate results!
	private String category;
	private int index; 
	
	//Categories that exist
	public Category(String category, int index) {
		this.category = category;
		this.index = index;
	}

	public String getCategory() {
		return category;
	}

	public int getIndex() {
		return index;
	}
	
}
