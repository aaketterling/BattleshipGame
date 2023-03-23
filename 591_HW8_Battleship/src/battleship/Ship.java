package battleship;

public abstract class Ship {
	// instance variables

	// The row that contains the bow (front part of the ship)
	private int bowRow;

	// The column that contains the bow (front part of the ship)
	private int bowColumn;

	// The length of the ship
	private int length;

	// A boolean that represents whether the ship is going to be placed horizontally
	// or vertically
	private boolean horizontal;

	// An array of booleans that indicate whether that part of the ship has been hit
	// or not
	private boolean[] hit;

	// constructor
	public Ship(int length) {
		this.length = length;
		// initialize hit array based on length
		this.hit = new boolean[length];
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
		// TODO
		return false;
	}

	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// TODO
	}

	boolean shootAt(int row, int column) {
		// TODO
		return false;
	}

	boolean isSunk() {
		// Return true if every part of the ship has been hit, false otherwise
		// using getter method because it is available.
		// TA in OhO said can use direct, e.g. this.hit but if getter available, then
		// should to use it. either is correct, preference, but be consistent.
		for (int i = 0; i < this.getHit().length; i++) {
			// if any of part of the ship is NOT hit, i.e. true, then return false early
			if (!this.getHit()[i]) {
				return false;
			}
		}

		// if the for loop above did not return early, false, then it must be sunk all
		// parts are true, hit.
		return true;
	}

	@Override
	public String toString() {
		// return ”s” if the ship has been sunk and ”x” if it has not been sunk
		return this.isSunk() ? "s" : "x";
	}

}
