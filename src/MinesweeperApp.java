import java.util.Scanner;

public class MinesweeperApp {
	public static Scanner scan;

	public static void main(String[] args) {
		int row, col;
		scan = new Scanner(System.in);
		MineField minefield;
		do {
			System.out.println("Please select a difficulty: ");
			System.out.println("B: Beginner");
			System.out.println("I: Intermediate");
			System.out.println("E: Expert");
			System.out.println("C: Custom");
			String difficulty = Validator.isValidDifficulty(scan);
			if (difficulty.equals("c")){
				System.out.println("please the number of rows you would like");
				int numOfRows = Validator.isPositiveNumber(scan);
				System.out.println("please the number of columns you would like");				
				int numOfColumn = Validator.isPositiveNumber(scan);
				System.out.println("please the number of mines you would like");				
				int numOfMines = Validator.isPositiveNumber(scan);
				scan.nextLine();
				minefield = new MineField(numOfRows,numOfColumn,numOfMines);				
				
			}else {
				minefield = new MineField(Validator.isValidDifficulty(scan));
			}
			
				minefield.displayBoard();
				do {
					System.out.println("do you want to flag/unflag a cell? y/n");
					String check = Validator.isValidContinue(scan);
					System.out.print("Row: ");
					row = Validator.isRowNumber(scan, minefield.getRows());
					System.out.print("\nColumn: \n");
					col = Validator.isRowNumber(scan, minefield.getRows());
					minefield.probeCell(check, row - 1, col - 1);
					scan.nextLine();
				} while (minefield.inProgress);
			
			
			System.out.println("Would you want to play again? (y/n)");
		} while (Validator.isValidContinue(scan).equals("y"));
		
		}
	
	
	
	

}
