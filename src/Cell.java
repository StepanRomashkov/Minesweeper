
public class Cell {
	public static int count = 10;
	private int cellState;
	private boolean mine;
	private boolean revealed;
	
	public boolean isRevealed() {
		return revealed;
	}

	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}

	public Cell() {
		cellState = -1;
		mine = false;
		revealed =false;
	}
	
	public static void increaseCount() {
		count++;
	}
	
	public static void decreaseCount() {
		count--;
	}
	
	public static int getCount() {
		return count;
	}
	
	public void setCellState(int s) {
		cellState = s;
	}
	
	public String getCellState() {
		switch (cellState) {
		case -1:
			return " ☻ ";
		case 0:
			return "   ";
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			return (" "+cellState+" ");
		case 9:
			return " ? ";
		}
		return " X ";
	}
	
	public void setMine() {
		mine = true;
		decreaseCount();
	}
	
	public boolean getMine() {
		return mine;
	}
	
}
