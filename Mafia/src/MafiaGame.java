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
	
	/*
	 * Menu Logic
	 */
	
	public void run() {
		 Boolean programRunning = true;
		 Scanner input = new Scanner(System.in);
		 
		 String[] mainMenu = {"Setup", "Play", "Exit"};
		 
		 while(programRunning == true) {
			 
			 Output.printMenu(mainMenu);
			 
			 int selectedOption = 0;
			 selectedOption = input.nextInt();
			 
			 switch (selectedOption) {
			 	case 1:
			 		//setup();
			 		break;
			 		
			 	case 2:
			 		play();
			 		break;
			 		
			 	case 3:
			 		break;
			 		
			 	case 0:
			 		programRunning = false;
			 		break;
			 		
			 	default:
			 		System.out.println("Invalid input! Please try again.");
			 }
			 
		 }
		 input.close();
	}
	
	/*
	 * Game Logic
	 */
	
	private void play() {
		
		Boolean gameNotFinished = true;
		
		while(gameNotFinished == true) {
			
			
			System.out.println("We played a game!");
			/*
			 *  End game to stop infinite loop.
			 */
			gameNotFinished = false;
		}
	}
	
	
	/*
	 * Main Method
	 */
	
	public static void main(String[] args) {
		
		MafiaGame game = new MafiaGame();
		System.out.print(game.getPlayerList()+"\n");
		System.out.println(game.getPlayerIndexList());
		game.run();
	}

}
