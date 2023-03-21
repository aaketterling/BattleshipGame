package battleship;

public abstract class Ship {
	// instance variables
	
	// The row that contains the bow (front part of the ship)
	private int bowRow;
	
	// The column that contains the bow (front part of the ship)
	private int bowColumn;
	
	// The length of the ship
	private int length;
	
	// A boolean that represents whether the ship is going to be placed horizontally or vertically
	private boolean horizontal;
	
	// An array of booleans that indicate whether that part of the ship has been hit or not
	private boolean[] hit;
	
	// constructor
	public Ship(int length) {
		this.length = length;
	}

	// getters
	public int getBowRow() {
		return bowRow;
	}

	public int getBowColumn() {
		return bowColumn;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public int getLength() {
		return length;
	}
	
	public boolean[] getHit() {
		return hit;
	}
	
	// setters
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	// abstract method
	
	// Returns the type of ship as a String. 
	public abstract String getShipType();
	
	// other methods
	
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		return false;
	}
	
	void placeShipAt(int row, int column, boolean horizontal,Ocean ocean) {
		
	}
	
	boolean shootAt(int row, int column) {
		return false;
	}
	
	boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	
}
