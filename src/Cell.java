
public class Cell {
	public static int count = 10;
	private int cellState;
	private boolean mine;
	
	public Cell() {
		cellState = -1;
		mine = false;
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
			return " ☺ ";
		case 0:
			return "   ";
		case 1:
			return " 1 ";
		case 2:
			return " 2 ";
		case 3:
			return " 3 ";
		case 4:
			return " 4 ";
		case 5:
			return " 5 ";
		case 6:
			return " 6 ";
		case 7:
			return " 7 ";
		case 8:
			return " 8 ";
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
