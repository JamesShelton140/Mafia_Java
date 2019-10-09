//import java.util.ArrayList;

public class Vanilla extends Role {
	
	/*
	 * Constructors
	 */
	
	public Vanilla() {
		super();
	}
	
	public Vanilla(String alignment) {
		super(alignment);
	}
	
	/*
	 * Methods
	 */
	
	
	public String toString() {
		return "vanilla " + getAlignment();
	}
	
	@Override
	public void ability(Player[] players, int[] playerIndex) {}

	public static void main(String[] args) {
		
		
	}

}
