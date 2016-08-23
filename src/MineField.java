
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
		System.out.println("   1   2   3   4   5   6   7   8 ");
		System.out.println(" ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
						System.out.print((i +1)+ "║" + mineSet[i][j].getCellState() + "║");
				}
				else if (j == getCols() - 1) {
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				}
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1)
				System.out.println(" ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
			else
				System.out.println(" ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
		}
	}
	
	private int checkCell(int r, int c) {
		int count = 0;
		
		
		for(int x = 0 ; x<rows; x++){
			for(int y = 0; y<cols;y++){
				
			try {
			if(	mineSet[x+1][y+1].getMine()){
				count++;
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			
			try {
				if(mineSet[x+1][y].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			try {
				if(mineSet[x][y+1].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			try {
				if(mineSet[x-1][y-1].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			try {
				if(mineSet[x-1][y].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			try {
				if (mineSet[x][y-1].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			try {
				if(mineSet[x+1][y-1].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
			
			try {
				if(mineSet[x][y-1].getMine()){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ummmm.....");
			}
		}
		}
		return count;
	}
	
	private void whiteSpaceFlipper(int r, int c){
	
		
		
	}
	
	
	public void probeCell(String m, int r, int c) {
		if (m == "y" && mineSet[r][c].getCellState() == " ? "){
			mineSet[r][c].setCellState(-1);
		}else if (mineSet[r][c].getCellState() == " ☻ "){
			mineSet[r][c].setCellState(9);
		}
		displayBoard();
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
		System.out.println("   1   2   3   4   5   6   7   8 ");
		System.out.println(" ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.print((i +1)+ "║ ☼ ║");
					else
						System.out.print((i +1) + "║" + mineSet[i][j].getCellState() + "║");
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
