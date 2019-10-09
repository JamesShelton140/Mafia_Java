import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;

public class Input {
	
	//Method convert a role name passed as a string to an instance of that role and returns
	/*
	 * 
	 * All new roles must be added the following switch so that the game can recognise that they exist.
	 * 
	 */
		public static Role convertToRole(String roleString) {
			Role role = null;
			
			ArrayList<String> availableRoles = new ArrayList<String>(Arrays.asList(MafiaGame.availableRoles()));
			if( !availableRoles.contains(roleString)) {
				System.out.println(roleString + " role not available!");
			}
			
			switch (roleString.toLowerCase()) {
				case "vanilla":
					role = new Vanilla();
					break;
				case "vanillatown":
					role = new Vanilla("town");
					break;
				case "vanillamafia":
					role = new Vanilla("mafia");
					break;
				case "cop":
					role = new Cop();
					break;
				case "doctor":
					role = new Doctor();
					break;
				default:
					role = null;
			}
			
			return role;
		}
		
	public static void inputMenuOption() {
		
	}
	
	//Import setup from file
	public static String[][] importSetup(String setupName) throws IOException {
		
		ArrayList<String[]> setupData = new ArrayList<String[]>();
		
		if (!setupName.endsWith(".stp")) {
			setupName += ".stp";
		}
		
		Path path = Paths.get(".\\resources\\setups\\"+setupName);
        Scanner scanner = new Scanner(path);
        System.out.println("Reading setup save file.");
        //read line by line
        while(scanner.hasNextLine()){
            //read next role as "role number" and add to setupData as string array [role, number]
            setupData.add(scanner.nextLine().split(" "));
        }
        scanner.close();
		
        //re-type setup data to String[][] array and return
        //String[][] tempStringArray = new String[1][];
		return setupData.toArray(new String[1][]);
	}
	
	//Load setup into active game
	public static Role[] loadSetup(String[][] setup) {
		ArrayList<Role> roleList = new ArrayList<Role>();
		
		//Add the required number of each role to the temporary list
		for(int i = 0; i < setup.length; i++) {
			Role role = convertToRole(setup[i][0]);
			for(int j = 0; j < Integer.parseInt(setup[i][1]); j++) {
				roleList.add(role);
			}
		}
		
		Role[] tempRoleArray = new Role[1];
		return roleList.toArray(tempRoleArray);
	}
	
	
	//File walker class ("https://docs.oracle.com/javase/tutorial/essential/io/find.html")
	public static class FileFinder extends SimpleFileVisitor<Path> {
		private final PathMatcher matcher;
		private ArrayList<String> filesFound = new ArrayList<String>();
		
		//Constructor
		FileFinder(String pattern) {
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }
		
		//Mathed matches pattern in "matcher" to file, if successful file name is added to filesFound list. 
		void find(Path file) {
			Path name = file.getFileName();
			if (name != null && matcher.matches(name)) {
				filesFound.add(name.toString());
			}
		}
		
		// Invoke the pattern matching method on each file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }
        
        //Returns string array of names of all matching files found
        public String[] done() {
        	String[] tempStringArray = new String[1];
        	return filesFound.toArray(tempStringArray);
        }
		
	}
	
	
	// Method that utilises Finder subclass to find files matching given filename in given directory
	public static String[] findFiles(String startDirectoryString, String filename) throws IOException {
		
		//Create path for start directory string
		Path startDirectoryPath = Paths.get(startDirectoryString);
		//Create finder for specified filename (can be file extension e.g. "*.txt") 
		FileFinder finder = new FileFinder(filename);
		//Walk directory saving files that match the finder
		Files.walkFileTree(startDirectoryPath, finder);
		
		//return array of filenames
		return finder.done();
	}
	
	
	public static void main(String[] args) {
		/*
		String[] setups = null;
		try {
			setups = findFiles(".\\resources\\setups", "*.stp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (setups != null) {
			System.out.println(Arrays.toString(setups));
		} else {
			System.out.println("Setups not initialised!");
		}
		*/
		
		try {
			System.out.println(Arrays.toString(loadSetup(importSetup("default"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
