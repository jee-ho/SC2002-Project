package Controller;

import java.util.Scanner;

/**
 * Declares a static Scanner and its child methods to avoid many instances of scanner.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-10-30
 */
public class ScannerController {
	// The scanner is declared "final" to prevent inheritance (and thus overriding) from this class.
	// Any extra method needed for Scanner MUST be declared in this class.
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * Gets user to input a string, repeat asking until the string is correct.
	 * @return A valid string entered by the user.
	 */
	public static String getInputString(){
		String input = "";
		while(input.equals("")){
			input = sc.nextLine();
			if(input.equals("")){
				System.out.println("Please enter a string");
			}
		}
		return input;
	}
	/**
	 * Gets user to input an int, repeat asking until the int is correct.
	 * @return A valid int entered by the user.
	 */
	public static int getInputInt(){
		int input = -1;
		boolean validInput = false;
		while(!validInput) {
			if(sc.hasNextInt()){
				input = sc.nextInt();
				validInput = true;
			}
			else{
				System.out.println("Please enter a number");
			}
			sc.nextLine();
		}
		return input;
	}

	/**
	 * Closes the scanner.
	 */
	public static void closeScanner(){
		sc.close();
	}
}
