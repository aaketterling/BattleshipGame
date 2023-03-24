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
		/*
		 *	logic depends if horizontal
		 *	check if ship is within the 10x10 array
		 *	TODO with Adam
		 *
		 *	check surroundings, surrounding cell should not be occupied.  occupied return false
		 *		can be out of bounds, means on the edge.  logic above says ship fits on board
		 *	for horizontal, need to check row above and below, and column bow +1, end -1
		 *	e.g bow 5,5 battleship (length 4) would check row from for 4 to 6,  columns, 6 to 1 
		 *	for not horizontal, need to check column left and right of column, and row bow +1 end  -1
		 *	e.g bow 5,5 cruiser (length 3), would check column 4 to 6, and row 6 to 2
		 *
		 *	return true if never return false early
		 */
		return false;
	}

	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// TODO
		/*
		 * assume okToPlaceShipAt is true, will not do checks
		 * setBowRow, setBowColumn, setHorizontal
		 * 	get ocean ship array and start at [row][column] and equal it to this ship
		 * 	this is the bow
		 * if horizontal,
		 * 	move right to left length - 1 more times, 
		 * 	e.g. set i = 1, [row][column - i--] until i < length
		 * if not horizontal, move up length - 1 times, j = 1 until j < length - 1, [row - j--][column]
		 */
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
