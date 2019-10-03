//import java.util.*;

public class Output {
	
	public static void printMenu(String[] menu) {
		//System.out.println(Arrays.toString(menu));
		
		for(int i = 0; i < menu.length; i++) {
			if(menu[i] != "Exit") {
				System.out.println(i+1+". "+menu[i]);
			} else {
				System.out.println(0+". "+menu[i]);
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
