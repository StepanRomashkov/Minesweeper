public class MineField {
	private int rows;
	private int cols;
	private Cell[][] mineSet;
	boolean inProgress = true;
	private int totalNumOfMines;

	public MineField(int row, int col, int mines) {
			rows = row;
			cols = col;
			totalNumOfMines = mines;
		mineSet = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineSet[i][j] = new Cell();
			}
		}
		Cell.count = totalNumOfMines;
		while (Cell.getCount() > 0) {
			int randRow = (int) (Math.random() * rows);
			int randCol = (int) (Math.random() * cols);
			if (!mineSet[randRow][randCol].getMine())
				mineSet[randRow][randCol].setMine();
		}
		assignCells();
	}
	public MineField(String difficulty) {
		if (difficulty.equalsIgnoreCase("b")) {
			rows = 9;
			cols = 9;
			totalNumOfMines = 10;
		} else if (difficulty.equalsIgnoreCase("i")) {
			rows = 16;
			cols = 16;
			totalNumOfMines = 40;
		} else if (difficulty.equalsIgnoreCase("e")) {
			rows = 16;
			cols = 30;
			totalNumOfMines = 99;
		} else if (difficulty.equalsIgnoreCase("c")){
			
		}
		mineSet = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineSet[i][j] = new Cell();
			}
		}
		Cell.count = totalNumOfMines;
		while (Cell.getCount() > 0) {
			int randRow = (int) (Math.random() * rows);
			int randCol = (int) (Math.random() * cols);
			if (!mineSet[randRow][randCol].getMine())
				mineSet[randRow][randCol].setMine();
		}
		assignCells();
	}
	public void setRows(int r) {
		rows = r;
	}

	public int getRows() {
		return rows;
	}

	public void setCols(int c) {
		cols = c;
	}

	public int getCols() {
		return cols;
	}

	public Cell getCell(int r, int c) {
		return mineSet[r][c];
	}

	public void isWin() {
		int numOfRevealed = 0;
		for (int x = 0; x < mineSet.length; x++) {
			for (int y = 0; y < mineSet.length; y++) {
				if (mineSet[x][y].isRevealed()) {
					numOfRevealed++;
				}
			}
		}
		if (numOfRevealed >= ((rows * cols) - totalNumOfMines)) {
			inProgress = false;
			displayWin();

		}
	}

	public void displayBoard() {
		System.out.print("        ");
		for (int i = 1; i <= cols; i++){
			System.out.printf("%4d", i);
		}
		System.out.printf("\n \t ╔");

		for (int o = 0; o < cols - 1; o++) {
			System.out.printf("═══╦");
		}
		System.out.println("═══╗");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == 0) {
					if (mineSet[i][j].isRevealed()) {
						System.out.printf("%9d" + "║" + mineSet[i][j].getCellState() + "║", (i + 1));
					} else if (mineSet[i][j].isMarked()) {
						System.out.printf("%9d" + "║" + " ? " + "║", (i + 1));
					} else {
						System.out.printf("%9d" + "║" + " ☻ " + "║", (i + 1));
						// "%9d" + "║ ☼ ║" , (i + 1)
					}
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].isRevealed()) {
						System.out.print(mineSet[i][j].getCellState() + "║\n");
					} else if (mineSet[i][j].isMarked()) {
						System.out.print(" ? " + "║\n");
					} else
						System.out.print(" ☻ " + "║\n");
				} else if (mineSet[i][j].isRevealed()) {
					System.out.print(mineSet[i][j].getCellState() + "║");
				} else if (mineSet[i][j].isMarked()) {
					System.out.print(" ? " + "║");
				} else {
					System.out.print(" ☻ " + "║");

				}

			}
			if (i == getRows() - 1) {
				System.out.printf(" \t ╚");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╩");
				}
				System.out.println("═══╝");
			} else {
				System.out.printf(" \t ╠");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╬");
				}
				System.out.println("═══╣");
			}

		}
	}

	private void assignCells() {

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				int count = 0;

				for (int i = x - 1; i <= x + 1; i++) {

					for (int j = y - 1; j <= y + 1; j++) {
						if (i < 0 || j < 0) {
							continue;
						} else if (i >= rows || j >= rows) {
							continue;
						}
						if (mineSet[i][j].getMine()) {
							count++;

						}
					}
				}

				mineSet[x][y].setCellState(count);

			}
		}

	}

	private void whiteSpaceFlipper(int r, int c) {
		if (!mineSet[r][c].equals("   ")){
			return;
		}
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if (i < 0 || j < 0) {
					continue;
				} else if (i >= rows || j >= rows) {
					continue;
				}
				if (!mineSet[i][j].isRevealed() && !mineSet[i][j].isMarked() && !mineSet[i][j].getMine()) {
					
					mineSet[i][j].setRevealed(true);
					if (mineSet[i][j].getCellState().equals("   ")){
						whiteSpaceFlipper(i, j);
					}
				}
			}
		}
	}

	public void probeCell(String m, int r, int c) {
		if (m.equals("y") && mineSet[r][c].isMarked()) {
			mineSet[r][c].setRevealed(false);
			mineSet[r][c].setMarked(false);
			displayBoard();
		} else if (m.equals("y") && !mineSet[r][c].isRevealed()) {
			mineSet[r][c].setMarked(true);
			displayBoard();
		} else if (m.equals("y") && mineSet[r][c].isRevealed()) {
			System.out.println("that cell is already revealed, please make another selection");
		} else if (!m.equals("y") && mineSet[r][c].isMarked()) {
			System.out.println("that place is already marked, so you cannot select it. please unmark it to select");
		} else if (mineSet[r][c].getMine()) {
			displayBoom();
		} else {
			mineSet[r][c].setRevealed(true);
			whiteSpaceFlipper(r, c);
			isWin();
			if (inProgress)
				displayBoard();
		}

	}

	public void displayBoom() {
		System.out.print("        ");
		for (int i = 1; i <= cols; i++)
			System.out.printf("%4d", i);
		System.out.printf("\n \t ╔");
		for (int o = 0; o < mineSet.length - 1; o++) {
			System.out.printf("═══╦");
		}
		System.out.println("═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.printf("%9d" + "║ ☼ ║", (i + 1));
					else
						System.out.printf("%9d" + "║" + mineSet[i][j].getCellState() + "║", (i + 1));
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].getMine())
						System.out.print(" ☼ ║\n");
					else
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				} else if (mineSet[i][j].getMine())
					System.out.print(" ☼ ║");
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1) {
				System.out.printf(" \t ╚");

				for (int o = 0; o < mineSet.length - 1; o++) {
					System.out.printf("═══╩");
				}
				System.out.println("═══╝");

				System.out.println("You hit a mine! You have lost!");

			} else {
				System.out.printf(" \t ╠");

				for (int o = 0; o < mineSet.length - 1; o++) {
					System.out.printf("═══╬");
				}
				System.out.println("═══╣");
			}
			inProgress = false;
		}
	}

	public void displayWin() {
		System.out.print("        ");
		for (int i = 1; i <= cols; i++)
			System.out.printf("%4d", i);
		System.out.printf("\n \t ╔");
		for (int o = 0; o < mineSet.length - 1; o++) {
			System.out.printf("═══╦");
		}
		System.out.println("═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.format("%9d" + "║ ☼ ║", (i + 1));
					else
						System.out.format("%9d" + "║" + mineSet[i][j].getCellState() + "║", (i + 1));
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].getMine())
						System.out.print(" ☼ ║\n");
					else
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				} else if (mineSet[i][j].getMine())
					System.out.print(" ☼ ║");
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1) {
				System.out.printf(" \t ╚");

				for (int o = 0; o < mineSet.length - 1; o++) {
					System.out.printf("═══╩");
				}
				System.out.println("═══╝");

				System.out.println(" You won! way to go!");

			} else {
				System.out.printf(" \t ╠");

				for (int o = 0; o < mineSet.length - 1; o++) {
					System.out.printf("═══╬");
				}
				System.out.println("═══╣");
			}
			inProgress = false;
		}

	}
}