import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;

public class Input {

	public static void inputMenuOption() {
		
	}
	
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
        String[][] tempStringArray = new String[1][];
		return setupData.toArray(tempStringArray);
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
			
		
	}

}
