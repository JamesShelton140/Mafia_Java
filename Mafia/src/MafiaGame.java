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
	
	public void addPlayer(Player player) {
		this.playerList.add(player);
		this.playerIndexList.add(Integer.valueOf(playerIndexList.size()));
	}
	
	public void setRoleList(Role[] roleList ) {
		this.roleList = new ArrayList<Role>(Arrays.asList(roleList));
	}
	
	public void setRoleListString(String[] roles) {
		for(int i = 0; i < roles.length; i++ ) {
			this.roleList.add(Input.convertToRole(roles[i]));
		} 
	}
	
	public void fillRemainingRolesAsTown() {
		while(this.getRoleList().size() <  this.getPlayerList().size()) {
			this.addRole(Input.convertToRole("vanillatown"));
		}
	}
	
	public void addRole(Role role) {
		this.roleList.add(role);
	}
	
	/*
	 * Game Methods
	 */
	public void assignRoles() {
		//Initialise temp indexing array
		ArrayList<Integer> playersNotYetAssigned = new ArrayList<Integer>();
		for(int i = 0; i < this.getPlayerList().size(); i++) {
			playersNotYetAssigned.add(Integer.valueOf(i));
		}
		
		//initialise random number generator
		Random randGenerator = new Random();
		
		for(int i = 0; i < this.getRoleList().size(); i++) {
			//generate random number
			int chosen = randGenerator.nextInt(playersNotYetAssigned.size());
			//assign role to corresponing player
			this.getPlayerList().get(playersNotYetAssigned.get(chosen)).setRole(this.getRoleList().get(i));
			//remove chosen index from index list
			System.out.println(playersNotYetAssigned.size() + ". " + this.getPlayerList().get(playersNotYetAssigned.get(chosen)) + ", " + this.getRoleList().get(i));
			playersNotYetAssigned.remove(chosen);
			
		}
	}
	
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
			 String[] Setup = {"setup", Integer.toString(Arrays.asList(mainMenu).indexOf("Setup")+1)};
			 String[] Play = {"play", Integer.toString(Arrays.asList(mainMenu).indexOf("Play")+1)};
			 String[] Exit = {"exit", "0", "q", "quit"};
			 
			 String[][] optionsToParse = {Setup, Play, Exit};
			 
			 for(int i = 0; i < optionsToParse.length; i++) {
				 if(Arrays.asList(optionsToParse[i]).contains(selectedOption)) {
					 selectedOption = optionsToParse[i][0];
					 break;
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
		
		//TODO create player list creation menu
		int numberOfPlayers = 10;
		for(int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player("Player "+Integer.toString(i + 1));
			this.addPlayer(player);
		}
		
		// TODO create setup loading menu
		
		try {
			this.setRoleList(Input.loadSetup(Input.importSetup("default")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.fillRemainingRolesAsTown();
		
		System.out.println(this.getPlayerList().size() + " players");
		System.out.println(this.getPlayerList());
		System.out.println(this.getRoleList().size() + " roles");
		System.out.println(this.getRoleList());
		
		this.assignRoles();
		
		for(int i = 0; i < this.getPlayerList().size(); i++) {
			System.out.println(this.getPlayerList().get(i) + " has role " + this.getPlayerList().get(i).getRole());
		}
		
		Boolean gameNotFinished = true;
		
		while(gameNotFinished == true) {
			
			
			System.out.println("We played a game!");
			/*
			 *  End game to stop infinite loop.
			 */
			gameNotFinished = false;
		}
		
		this.getPlayerList().clear();
		this.getRoleList().clear();
		this.getPlayerIndexList().clear();
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
