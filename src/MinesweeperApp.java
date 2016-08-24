import java.util.Scanner;

public class MinesweeperApp {
	public static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		do {
			System.out.println("Please select a difficulty: ");
			System.out.println("A: Beginner");
			System.out.println("B: Intermediate");
			System.out.println("C: Expert");
			MineField begin = new MineField();
			Intermediate inter = new Intermediate();
			Expert expert = new Expert();
			int row, col;
			String choice = scan.nextLine();
			if (choice.equalsIgnoreCase("a")) {
				begin.displayBoard();
				do {
					System.out.println("do you want to mark?");
					String check = scan.nextLine();
					System.out.print("Row: ");
					row = scan.nextInt();
					System.out.print("\nColumn: ");
					col = scan.nextInt();
					begin.probeCell(check, row - 1, col - 1);
					scan.nextLine();
				} while (begin.inProgress);
			} else if (choice.equalsIgnoreCase("b")) {
				inter.displayBoard();
				do {
					System.out.println("do you want to mark?");
					String check = scan.nextLine();
					System.out.print("Row: ");
					row = scan.nextInt();
					System.out.print("\nColumn: ");
					col = scan.nextInt();
					inter.probeCell(check, row - 1, col - 1);
					scan.nextLine();
				} while (inter.inProgress);
			} else if (choice.equalsIgnoreCase("c")) {
				expert.displayBoard();
				do {
					System.out.println("do you want to mark?");
					String check = scan.nextLine();
					System.out.print("Row: ");
					row = scan.nextInt();
					System.out.print("\nColumn: ");
					col = scan.nextInt();
					expert.probeCell(check, row - 1, col - 1);
					scan.nextLine();
				} while (expert.inProgress);
			}
			System.out.println("Would you want to play again? (y/n)");
		} while (scan.nextLine().equalsIgnoreCase("y"));
		
		}
	
	
	
	

}
