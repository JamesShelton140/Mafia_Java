//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.*;
import java.io.*;
//import java.nio.*;
import java.nio.file.*;

public class Input {

	public static void inputMenuOption() {
		
	}
	
	public static String[][] importSetup(String setupName) throws IOException {
		
		ArrayList<String[]> setupData = new ArrayList<String[]>();
		
		Path path = Paths.get(".\\resources\\setups\\"+setupName+".txt");
        Scanner scanner = new Scanner(path);
        System.out.println("Reading setup save file.");
        //read line by line
        while(scanner.hasNextLine()){
            //read next role as "role number" and add to setupData as string array [role, number]
            setupData.add(scanner.nextLine().split(" "));
            //System.out.println(Arrays.toString(line));
        }
        scanner.close();
		
        String[][] tempArray = new String[1][];
        
		return setupData.toArray(tempArray);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
