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
	public static String isValidDifficulty(Scanner scan) {
		String check = "";
		do {
			check = scan.nextLine();
			if(check.equalsIgnoreCase("b")) {
				return check;
			} else if (check.equalsIgnoreCase("i")) {
				return check;
			}else if(check.equalsIgnoreCase("e")) {
				return check;
			}else if(check.equalsIgnoreCase("c")) {
				return check;
			}
			System.out.println("Invalid entry.");
			System.out.println("Please select a difficulty: ");
			System.out.println("A: Beginner");
			System.out.println("B: Intermediate");
			System.out.println("C: Expert");
		} while (!check.equalsIgnoreCase("b") && !check.equalsIgnoreCase("i")&& !check.equalsIgnoreCase("e")&& !check.equalsIgnoreCase("i"));
	return check;
	}

	public static int isRowNumber(Scanner scan, int rows) {
		int number = 0;
		boolean valid = true;
		while (valid) {
		try {
		number = scan.nextInt();
		if (number < 1 || number > rows) {
			System.out.println("Not a valid number. Please re-enter a number: ");
			continue;
		} else break;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Please try again: ");
		}
		
	}
		return number;
	}
	
	
	
	public static int isPositiveNumber(Scanner scan) {
		int number = 0;
		boolean valid = true;
		while (valid) {
		try {
		number = scan.nextInt();
		if (number < 1 || number > 100) {
			System.out.println("Not a valid number. Please re-enter a number: ");
			continue;
		} else break;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Please try again: ");
		}
		
	}
		return number;
	}
	
}