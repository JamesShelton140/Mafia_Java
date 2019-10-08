import java.util.*;
import java.io.*;
//import java.nio.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MafiaGame {
	
	private static final String[] availableRoles = {"vanilla", "vanillatown", "vanillamafia", "cop", "doctor"};
	
	/*
	 * Field parameters
	 */
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Integer> playerIndexList = new ArrayList<Integer>();
	private ArrayList<Role> roleList = new ArrayList<Role>();
	/*
	 * Constructors
	 */
	
	public MafiaGame() {
		playerList.add(new Player("James"));
		playerIndexList.add(0);
	}
	
	/*
	 * Accessors and Mutators
	 */
	public static String[] availableRoles() {
		return availableRoles;
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
	public ArrayList<Integer> getPlayerIndexList() {
		return playerIndexList;
	}
	
	public ArrayList<Role> getRoleList() {
		return roleList;
	}
	
	public void setPlayerList(Player[] playerList) {
		this.playerList = new ArrayList<Player>(Arrays.asList(playerList));
		for(int i = 0; i < playerList.length; i++ ) {
			this.playerIndexList.add(Integer.valueOf(i));
		}
	}
	
	public void addPLayer(Player player) {
		this.playerList.add(player);
		this.playerIndexList.add(Integer.valueOf(playerIndexList.size()));
	}
	
	public void setRoleList(Role[] roleList ) {
		this.roleList = new ArrayList<Role>(Arrays.asList(roleList));
	}
	
	public void setRoleListFromString(String[] roleList) {
		
	}
	
	public void addRole(Role role) {
		this.roleList.add(role);
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
		 
		 //Menu options array
		 String[] mainMenu = {"Setup", "Play", "Exit"};
		 
		 while(programRunning == true) {
			 
			 Output.printMenu(mainMenu);
			 
			 //Set default behaviour to avoid infinite loops
			 String selectedOption = "Exit";
			 
			 //Get and parse user input
			 selectedOption = input.next().toLowerCase();
			 
			 //List all options and viable input
			 String[] Setup = {"setup",Integer.toString(Arrays.asList(mainMenu).indexOf("Setup")+1)};
			 String[] Play = {"play",Integer.toString(Arrays.asList(mainMenu).indexOf("Play")+1)};
			 String[] Exit = {"exit","0","q","quit"};
			 
			 String[][] optionsToParse = {Setup, Play, Exit};
			 
			 for(int i = 0; i < optionsToParse.length; i++) {
				 if(Arrays.asList(optionsToParse[i]).contains(selectedOption)) {
					 selectedOption = optionsToParse[i][0];
				 }
			 }
			 
			 //Act on user input
			 switch (selectedOption) {
			 	case "setup":
					try {
						setup();
					} catch (IOException e) {
						System.out.println("Input exception in setup!");
						e.printStackTrace();
					}
			 		break;
			 		
			 	case "play":
			 		play();
			 		break;
			 		
			 	case "3":
			 		break;
			 		
			 	case "exit":
			 		System.out.println("Exiting game!");
			 		programRunning = false;
			 		break;
			 		
			 	default:
			 		System.out.println("Invalid input! Please try again.");
			 }
			 
		 }
		 input.close();
	}
	
	/*
	 * Game Setup Logic
	 */
	
	private void setup() throws IOException{
		
		String[][] setup = Input.importSetup("default");
		
		System.out.println(Arrays.deepToString(setup));
		
	}
	
	/*
	 * Game Logic
	 */
	
	private void play() {
		
		// TODO create setup loading method
		
		setRoleList()  ;
		
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
