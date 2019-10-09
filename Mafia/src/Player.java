import java.util.ArrayList;

public class Player {
	
	/*
	 * Field parameters
	 */
	
	private Role role;
	private ArrayList<String> propertyTypes = new ArrayList<String>();
	private ArrayList<String> propertyValues = new ArrayList<String>();
	private ArrayList<String> affects = new ArrayList<String>();
	private ArrayList<String> affectors = new ArrayList<String>();
	
	/*
	 * Constructors
	 */
	
	public Player() {
		this("newPlayer");
	}
	
	public Player(Role role) {
		this("newPlayer", role);
	}
	
	public Player(String name) {
		setProperty("name", name);
		setProperty("alive", "true");
		Role role = new Vanilla();
		setRole(role);
	}
	
	public Player(String name, Role role) {
		setProperty("name", name);
		setProperty("alive", "true");
		setRole(role);
	}
	
	/*
	 * Accessors and Mutators
	 */
	
	//Accessors
	
	public String getProperty(String propertyType) {
		if(propertyTypes.contains(propertyType)) {
			return propertyValues.get(propertyTypes.indexOf(propertyType));
		} else {
			return null;
		}
	}
	
	public ArrayList<String> getAffects() {
		return affects;
	}
	
	public ArrayList<String> getAffectors() {
		return affectors;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	//Mutators
	
	public void setProperty(String propertyType, String propertyValue) {
		if(propertyTypes.contains(propertyType)) {
			propertyValues.set(propertyTypes.indexOf(propertyType), propertyValue) ;
		} else {
			propertyTypes.add(propertyType);
			propertyValues.add(propertyValue);
		}
	}
	
	public void addAffect(String affect, String affector) {
			affects.add(affect);
			affectors.add(affector);
	}
	
	public void setRole(Role role) {
		this.role = role;
		setProperty("alignment", role.getAlignment());
	}
	
	/*
	 * Methods
	 */
	
	public String toString() {
		return getProperty("name");
	}
	
	/*
	 * Main method for testing.
	 */
	
	public static void main(String[] args) {
		Player player1 = new Player("James");
		Role role1 = new Vanilla("town");
		player1.setRole(role1);
		
		Player player2 = new Player("Arnie");
		Role role2 = new Vanilla("mafia");
		player2.setRole(role2);
		
		System.out.println(player1.getRole()+" "+player1.getProperty("alignment"));
		System.out.println(player2.getRole()+" "+player2.getProperty("alignment"));
		System.out.println(player1);
	}

}
