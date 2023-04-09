/*
 * Adam Ketterling and Armand Aquino worked on homework together
 * We are submitting the same code
 */

package battleship;

/**
 * Ship describes the Characteristics common to all ships
 * 
 * @author adamkett
 *
 */
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
	/**
	 *  Ship(int length): Initializes a new ship with the given length and an empty hit array.
	 * @param length
	 */
	public Ship(int length) {
		this.length = length;
		// initialize hit array based on length
		this.hit = new boolean[length];
	}


	// getters
	/**
	 *  *  - bowRow: The row containing the bow (front) of the ship
	 * @param bowRow
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * - bowColumn: The column containing the bow (front) of the ship
	 * @return
	 */
	public int getBowColumn() {
		return bowColumn;
	}
	
	/**
	 * - horizontal: A boolean indicating whether the ship is placed horizontally or vertically
	 * @return
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	
	public int getLength() {
		return length;
	}

	/**
	 * - hit: An array of booleans indicating whether each part of the ship has been hit or not
	 * @return
	 */
	public boolean[] getHit() {
		return hit;
	}

	// setters
	/**
	 *  *  - bowRow: The row containing the bow (front) of the ship
	 * @param bowRow
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	/**
	 *  *  - bowColumn: The column containing the bow (front) of the ship
	 * @param bowColumn
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	
	/**
	 *  *  - horizontal: whether the ship is horizontal or not
	 * @param horiztonal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	// abstract method

	// Returns the type of ship as a String.
	/**
	 *  * Abstract methods:
	 *  - String getShipType(): Returns the type of the ship as a String.
	 * @return
	 */
	public abstract String getShipType();

	// other methods

		/**
		 *  - boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean): 
		 * Returns true if it is possible to place the ship at the given position on the ocean grid, 
		 * without overlapping or touching another ship.
		 * @param row
		 * @param column
		 * @param horizontal
		 * @param ocean
		 * @return
		 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		/*
		 * Check if the ship's position is within the grid bounds. If not, return false.
		 * Check if the ship overlaps or touches another ship (vertically, horizontally,
		 * or diagonally). If it does, return false. If the ship's position is within
		 * bounds and doesn't overlap or touch another ship, return true.
		 * 
		 */

		// Is ship within the 0-9 ocean array?
		if (horizontal) {
			if (column - this.getLength() < -1 || column > 9 || row < 0 || row > 9) { // subs might be placed to close
																						// to edge and go out. Same with
																						// boats smaller than battle
																						// ship.
				// return false if out of bounds
				return false;
			}
		} else {
			if (row - this.getLength() < -1 || row > 9 || column < 0 || column > 9) {
				return false;
			}
		}
		// i & j represent horizontal and vertical offsets, ranging from -1 to 1
		if (horizontal) {
			// column prior to row to cover edges of negative space
			for (int j = column - this.getLength(); j <= column + 1; j++) {
				for (int i = row - 1; i <= row + 1; i++) {
					// Check if the current position is within the ocean bounds
					if (i >= 0 && i < 10 && j >= 0 && j < 10) {
						// If there is already a ship at this position, return false
						if (ocean.isOccupied(i, j)) {
							return false;
						}
					}
				}
			}
		} else {
			// Rows prior to columns to cover edges of negative space
			for (int i = row - this.getLength(); i <= row + 1; i++) {
				for (int j = column - 1; j <= column + 1; j++) {
					// Check if the current position is within the ocean bounds
					if (i >= 0 && i < 10 && j >= 0 && j < 10) {
						// If there is already a ship at this position, return false
						if (ocean.isOccupied(i, j)) {
							return false;
						}
					}
				}
			}
		}

		// If the code reaches this point, it means the ship can be placed at the given
		// position
		return true;
	}

		/**
		 * void placeShipAt(int row, int column, boolean horizontal, Ocean ocean): 
		 * Places the ship at the given position on the ocean grid.
		 * assume okToPlaceShipAt is true, will not do checks setBowRow, setBowColumn,
		 * setHorizontal get ocean ship array and start at [row][column] and equal it to
		 * this ship this is the bow if horizontal, move right to left length - 1 more
		 * times, e.g. set i = 1, [row][column - i--] until i < length if not
		 * horizontal, move up length - 1 times, j = 1 until j < length - 1, [row -
		 * j--][column]
		 * 
		 * *** did this way *** maybe just place entire ship in loop, start i or j to 0,
		 * minus 0 is itself so it will set the bow
		 * @param row
		 * @param column
		 * @param horizontal
		 * @param ocean
		 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// TODO

		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		// the incremental variable starts at 0, so first time it is ran, it subtracts 0
		// from row or column
		// so that sets the bow
		if (horizontal) {
			// row is constant, the column gets decremented
			for (int i = 0; i < this.getLength(); i++) {
				ocean.getShipArray()[row][column - i] = this;
			}
		} else {
			// the column is constant, the row gets decremented
			for (int j = 0; j < this.getLength(); j++) {
				ocean.getShipArray()[row - j][column] = this;
			}
		}
	}

	/**
	 * boolean shootAt(int row, int column): Returns true if the ship occupies the given location on the grid, 
	 * updates the hit array to indicate a hit at the given location, and returns false otherwise.
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column) {
		// If the ship has been sunk, return false
		if (isSunk()) {
			return false;
		}

		// Does the ship occupy the given location (row, column)
		if (this.isHorizontal()) {
			if (row == this.getBowRow() && column <= this.getBowColumn()
					&& column > this.getBowColumn() - this.getLength()) {
				// Calculate the index of the hit section and update the hit array
				int hitIndex = bowColumn - column;
				hit[hitIndex] = true;
				return true;
			}
		} else {
			if (column == this.getBowColumn() && row <= this.getBowRow() && row > this.getBowRow() - this.getLength()) {
				// Calculate the index of the hit section and update the hit array
				int hitIndex = bowRow - row;
				hit[hitIndex] = true;
				return true;
			}
		}
		return false;
	}

	/**
	* boolean isSunk(): Returns true if every part of the ship has been hit (i.e. the ship is sunk), 
	* and false otherwise.
	* @return
	*/
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
	/**
	 *String toString(): Returns a string representation of the ship. Returns "s" if the ship has been sunk 
	 * and "x" if it has not been sunk.
	 */
	@Override
	public String toString() {
		// return ”s” if the ship has been sunk and ”x” if it has not been sunk
		return this.isSunk() ? "s" : "x";
	}

}
