import java.util.Scanner;

public class MinesweeperApp {
	public static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		MineField field = new MineField();
		int row, col;

		System.out.println("board:");
		for (int i = 0; i < field.getRows(); i++) {
			for (int j = 0; j < field.getCols(); j++) {
				if (field.getCell(i, j).getMine())
					System.out.print("X");
				else
					System.out.print("O");
				if (j == field.getCols() - 1)
					System.out.print("\n");
			}
		}
		field.displayBoard();

		do {
			System.out.println("do you want to mark?");
			String check = scan.nextLine();
			System.out.print("Row: ");
			row = scan.nextInt();
			System.out.print("\nColumn: ");
			col = scan.nextInt();
			if (check.equals("y")) {
			field.probeCell(check,row, col);	
			}else field.probeCell(row, col);
		} while (true);
	}

}
