import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
	
	public static String isValidContinue(Scanner scan) {
		String check = "";
		do {
			check = scan.nextLine();
			if(check.equalsIgnoreCase("y")) {
				return check;
			} else if (check.equalsIgnoreCase("n")) {
				return check;
			}
			
			System.out.println("Invalid entry. If you want to continue, please enter 'y'. Otherwise, please enter 'n'.");
		} while (!check.equalsIgnoreCase("y") && !check.equalsIgnoreCase("n"));
	return check;
	}

	public int isNumber(Scanner scan) {
		int number = 0;
		while (true) {
		try {
		number = scan.nextInt();
		if (number < 1 || number > MineField.rows) {
			System.out.println("Not a valid number. Please re-enter a number: ");
			return number;
		} 
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Please try again: ");
		}
		return number;
	}
	}
	
}