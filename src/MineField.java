
public class MineField {
	private int rows;
	private int cols;
	private Cell[][] mineSet;
	
	public MineField() {
		rows = 9;
		cols = 9;
		mineSet = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineSet[i][j] = new Cell();
			}
		}
		while (Cell.getCount() > 0) {
			int randRow = (int)(Math.random() * rows);
			int randCol = (int)(Math.random() * cols);
			if (!mineSet[randRow][randCol].getMine())
				mineSet[randRow][randCol].setMine();
		}
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
		System.out.println("  0 1 2 3 4 5 6 7 8 ");
		System.out.println(" ╔═╦═╦═╦═╦═╦═╦═╦═╦═╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
//					if (mineSet[i][j].getCellState() < 0)
//						System.out.print(i + "║░║");
//					else
						System.out.print(i + "║" + mineSet[i][j].getCellState() + "║");
				}
				else if (j == getCols() - 1) {
//					if (mineSet[i][j].getCellState() < 0)
//						System.out.print("░║\n");
//					else
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				}
//				else if (mineSet[i][j].getCellState() < 0)
//					System.out.print("░║");
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1)
				System.out.println(" ╚═╩═╩═╩═╩═╩═╩═╩═╩═╝");
			else
				System.out.println(" ╠═╬═╬═╬═╬═╬═╬═╬═╬═╣");
		}
	}
	
	private int checkCell(int r, int c) {
		int count = 0;
		if (r == 0) {
			if (c == 0 && r == 0) {
				if (mineSet[r][c+1].getMine())
					count++;
				if (mineSet[r+1][c].getMine())
					count++;
				if (mineSet[r+1][c+1].getMine())
					count++;
			} else if (c == getCols() && r == 0) {
				if (mineSet[r][c-1].getMine())
					count++;
				if (mineSet[r+1][c-1].getMine())
					count++;
				if (mineSet[r+1][c].getMine())
					count++;
			} else if (r == 0 && c != getCols() && c != 0)
				if (mineSet[r][c-1].getMine())
					count++;
				if (mineSet[r][c+1].getMine())
					count++;
				if (mineSet[r+1][c-1].getMine())
					count++;
				if (mineSet[r+1][c].getMine())
					count++;
				if (mineSet[r+1][c+1].getMine())
					count++;
		} else if (r == getRows()) {
			if (c == 0 && r == getRows()) {
				if (mineSet[r-1][c].getMine())
					count++;
				if (mineSet[r-1][c+1].getMine())
					count++;
				if (mineSet[r][c+1].getMine())
					count++;				
			} else if (c == getCols()) {
				if (mineSet[r-1][c-1].getMine())
					count++;
				if (mineSet[r+1][c].getMine())
					count++;
				if (mineSet[r][c-1].getMine())
					count++;
			} else
				if (mineSet[r-1][c-1].getMine())
					count++;
				if (mineSet[r-1][c].getMine())
					count++;
				if (mineSet[r-1][c+1].getMine())
					count++;
				if (mineSet[r][c-1].getMine())
					count++;
				if (mineSet[r][c+1].getMine())
					count++;
		} else if (c == 0) {
			if (mineSet[r-1][c].getMine())
				count++;
			if (mineSet[r-1][c+1].getMine())
				count++;
			if (mineSet[r][c+1].getMine())
				count++;
			if (mineSet[r+1][c].getMine())
				count++;
			if (mineSet[r+1][c+1].getMine())
				count++;			
		} else if (c == getCols()) {
			if (mineSet[r-1][c-1].getMine())
				count++;
			if (mineSet[r-1][c].getMine())
				count++;
			if (mineSet[r][c-1].getMine())
				count++;
			if (mineSet[r+1][c-1].getMine())
				count++;
			if (mineSet[r+1][c].getMine())
				count++;					
		} else {
			if (mineSet[r-1][c-1].getMine())
				count++;
			if (mineSet[r-1][c].getMine())
				count++;
			if (mineSet[r-1][c+1].getMine())
				count++;
			if (mineSet[r][c-1].getMine())
				count++;
			if (mineSet[r][c+1].getMine())
				count++;					
			if (mineSet[r+1][c-1].getMine())
				count++;
			if (mineSet[r+1][c].getMine())
				count++;
			if (mineSet[r+1][c+1].getMine())
				count++;
		}
		return count;
	}
	
	public void probeCell(int r, int c) {
		if (mineSet[r][c].getMine()) {
			displayBoom();
		} else { 
			mineSet[r][c].setCellState(checkCell(r, c));
			displayBoard();
		}
	}

	public void displayBoom() {
		System.out.println("  0 1 2 3 4 5 6 7 8 ");
		System.out.println(" ╔═╦═╦═╦═╦═╦═╦═╦═╦═╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.print(i + "║☻║");
					else
						System.out.print(i + "║" + mineSet[i][j].getCellState() + "║");
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].getMine())
						System.out.print("☻║\n");
					else
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				} else if (mineSet[i][j].getMine())
					System.out.print("☻║");
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1) {
				System.out.println(" ╚═╩═╩═╩═╩═╩═╩═╩═╩═╝");
				System.out.println(" B O O M ! ! ! ! ! !");
			} else
				System.out.println(" ╠═╬═╬═╬═╬═╬═╬═╬═╬═╣");
		}
	}

}
