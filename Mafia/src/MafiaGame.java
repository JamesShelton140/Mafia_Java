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
	
	public void pollActions(String[] Players) {
		
	}
	
	public void reset(String[] Players) {
		
	}
	
	
	public static void main(String[] args) {
		
		MafiaGame game = new MafiaGame();
		System.out.println(game.getPlayerList());
		System.out.println(game.getPlayerIndexList());
	}

}
