import javax.swing.event.CellEditorListener;

public class MineField {
	private int rows;
	private int cols;
	private Cell[][] mineSet;

	public MineField() {
		rows = 8;
		cols = 8;
		mineSet = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineSet[i][j] = new Cell();
			}
		}
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

	public void displayBoard() {
		System.out.println("   1   2   3   4   5   6   7   8 ");
		System.out.println(" ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if(mineSet[i][j].isRevealed()){
					System.out.print((i + 1) + "║" + mineSet[i][j].getCellState() + "║");
					}else{
						System.out.print((i + 1) + "║" + " ☻ " + "║");
					}
				} else if (j == getCols() - 1) {
					if(mineSet[i][j].isRevealed()){
					System.out.print(mineSet[i][j].getCellState() + "║\n");
					}else System.out.print(" ☻ " + "║\n");
				} else if(mineSet[i][j].isRevealed()){
					System.out.print(mineSet[i][j].getCellState() + "║");
					}else System.out.print(" ☻ " + "║");
					
			}
			if (i == getRows() - 1)
				System.out.println(" ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
			else
				System.out.println(" ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
		}
	}

	private void assignCells() {

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				int count = 0;
				if(mineSet[x][y].getMine()){
					continue;
				}
				try {
					if (mineSet[x + 1][y + 1].getMine()) {
						count++;
					}
				} catch (Exception e) {

				}

				try {
					if (mineSet[x + 1][y].getMine()) {
						count++;
					}
				} catch (Exception e) {

				}

				try {
					if (mineSet[x][y + 1].getMine()) {
						count++;
					}
				} catch (Exception e) {

				}

				try {
					if (mineSet[x - 1][y - 1].getMine()) {
						count++;
					}
				} catch (Exception e) {

				}

				try {
					if (mineSet[x - 1][y].getMine()) {
						count++;
					}
				} catch (Exception e) {
				}

				try {
					if (mineSet[x][y - 1].getMine()) {
						count++;
					}
				} catch (Exception e) {
				}

				try {
					if (mineSet[x + 1][y - 1].getMine()) {
						count++;
					}
				} catch (Exception e) {
				}

				try {
					if (mineSet[x][y - 1].getMine()) {
						count++;
					}
				} catch (Exception e) {
				}
			
				mineSet[x][y].setCellState(count);
				
			}
		}

	}

	private void whiteSpaceFlipper(int r, int c) {

	}

	public void probeCell(String m, int r, int c) {
		if (m == "y" && mineSet[r][c].getCellState().equals(" ? ")) {
			mineSet[r][c].setCellState(-1);
		} else if (mineSet[r][c].getCellState().equals(" ☻ ")) {
			mineSet[r][c].setCellState(9);
		}
		mineSet[r][c].setRevealed(true);
		if (mineSet[r][c].getMine()) {
			displayBoom();
		} else {
			displayBoard();
		}
		
		
	}
	public void displayBoom() {
		System.out.println("   1   2   3   4   5   6   7   8 ");
		System.out.println(" ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.print((i + 1) + "║ ☼ ║");
					else
						System.out.print((i + 1) + "║" + mineSet[i][j].getCellState() + "║");
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
				System.out.println(" ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
				System.out.println(" You hit a mine! You have lost!");
			} else
				System.out.println(" ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
		}
	}

}
