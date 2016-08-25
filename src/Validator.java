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
			System.out.println("b: Beginner");
			System.out.println("i: Intermediate");
			System.out.println("e: Expert");
			System.out.println("c: Custom");
		} while (!check.equalsIgnoreCase("b") && !check.equalsIgnoreCase("i")&& !check.equalsIgnoreCase("e")&& !check.equalsIgnoreCase("i"));
	return check;
	}

	
	public static int isRowNumber(Scanner scan, int rows) {
		int number=0;
		boolean valid = true;
		while (valid) {
		try {
		number = scan.nextInt();
		if (number < 1 || number > rows) {
			System.out.println("Not a valid Row number. Please re-enter a number: ");
		} else valid=false;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Please try again: ");
			scan.nextLine();
		}
		
	}
		return number;
	}
	
public static int isColumnNumber(Scanner scan, int columns){
	int number=0;
	boolean valid = true;
	while (valid) {
	try {
	number = scan.nextInt();
	if (number < 1 || number > columns) {
		System.out.println("Not a valid Column number. Please re-enter a number: ");
	} else valid=false;
	} catch (InputMismatchException e) {
		System.out.println("Not a number. Please try again: ");
		scan.nextLine();
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
		if (number <=1 || number > 100) {
			System.out.println("Not a valid number. Please re-enter a number: ");
			continue;
		} else break;
		} catch (InputMismatchException e) {
			System.out.println("Not a number. Please try again: ");
			scan.nextLine();
		}
		
	}
		return number;
	}

public static int isAMineNumber(Scanner scan,int maxRows, int maxColumns) {
	
	int number = 0;
	boolean valid = true;
	while (valid) {
	try {
	number = scan.nextInt();
	if (number < 0 || number >=(maxColumns* maxRows) ) {
		System.out.println("Not a valid number. Please re-enter a number: ");
		continue;
	} else break;
	} catch (InputMismatchException e) {
		System.out.println("Not a number. Please try again: ");
		scan.nextLine();
	}
	
}
	return number;
}
	
}