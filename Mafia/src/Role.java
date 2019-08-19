
public abstract class Role {
	
	/*
	 * Field parameters
	 */
	
	private String alignment;
	
	/*
	 * Constructors
	 */
	
	protected Role() {
		setAlignment(null);
	}
	
	protected Role(String alignment) {
		setAlignment(alignment);
	}
	
	/*
	 * Accessors and Mutators
	 */
	
	//Accessors
	
	public String getAlignment() {
		return alignment;
	}
	
	//Mutators
	
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	
	public abstract String toString();
	
	/*
	 * Role ability function
	 */
	
	public abstract void ability(Player[] players, int[] playerIndex);
		
	/*
	 * Main method for testing
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
