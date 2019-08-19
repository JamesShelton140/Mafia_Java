import java.util.*;

public class MafiaGame {
	
	/*
	 * Field parameters
	 */
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Integer> playerIndexList = new ArrayList<Integer>();
	/*
	 * Constructors
	 */
	
	public MafiaGame() {
		playerList.add(new Player("James"));
		playerIndexList.add(1);
	}
	
	/*
	 * Accessors and Mutators
	 */
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	public ArrayList<Integer> getPlayerIndexList() {
		return playerIndexList;
	}
	
	/*
	 * Game Methods
	 */
	
	public void testFunc(ArrayList<Player> playerList1, ArrayList<Integer> playerIndexList1) {
		playerList1.add(new Player("Arnie"));
		playerIndexList1.add(2);
	}
	
	public void activate(String[] Players) {
		
	}
	
	public void resolve(String[] Players) {
		
	}
	
	public void reset(String[] Players) {
		
	}
	
	
	public static void main(String[] args) {
		
		MafiaGame game = new MafiaGame();
		System.out.println(game.getPlayerList());
		System.out.println(game.getPlayerIndexList()); 
		game.testFunc(game.getPlayerList(), game.getPlayerIndexList());
		System.out.println(game.getPlayerList());
		System.out.println(game.getPlayerIndexList());
		System.out.println("a change");
		System.out.println("a branch test");
	}

}
