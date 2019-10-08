
public class Doctor extends Role {

	public Doctor() {
		super("town");
	}

	public Doctor(String alignment) {
		super(alignment);
	}

	@Override
	public String toString() {
		return "doctor";
	}

	@Override
	public void ability(Player[] players, int[] playerIndex) {

	}

	public static void main(String[] args) {

	}

}
