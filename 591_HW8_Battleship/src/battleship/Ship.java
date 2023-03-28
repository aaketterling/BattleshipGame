package battleship;

/**
 *  Ship describes the Characteristics common to all ships
 * @author adamkett
 *
 */
public abstract class Ship {
	
	/*make subclasses: 
	 	▪ class Battleship extends Ship
			● Describes a ship of length 4
	 	▪ class Cruiser extends Ship
			● Describes a ship of length 3
		▪ class Destroyer extends Ship
			● Describes a ship of length 2
		▪ class Submarine extends Ship
			● Describes a ship of length 1
		▪ class EmptySea extends Ship
			● Describes a part of the ocean that doesn’t have a ship in it. (It
			seems silly to have the lack of a ship be a type of ship, but this is a
			trick that simplifies a lot of things. This way, every location in the
			ocean contains a “ship” of some kind.)
	 */
	
	
	
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
	
		/*
		 *	logic depends if horizontal
		 *	check if ship is within the 10x10 array
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
		
		/*
		 * note from armand
		 * we should check if ship will even fit on board and return early if not
		 * don't do any for loops.  
		 * e.g. battle ship will not fit horizontally row, column 0, 2 but ok for 0, 3
		 * can we avoid a for loop, in a for loop, in a for loop.  
		 * if branches in newColumn is the same, line 169 and 171
		 * 
		 * shipType is "empty" not "EmptyShip" but can use ocean.isOccupied() same thing, line 177
		 * 
		 * surrounding cells can be out of grid, e.g. horizontal battleship row, column = 0, 3
		 * 
		 * some smoe tests on a empty board
		 * all horizontal battleship
		 * 5,5 return true
		 * 0, 3 return true
		 * 9, 2 return false
		 * -1, 9 return false
		 * 0, 10 return false
		 * 
		 * Adam, walk through logic 
		 */
		
		// Is ship within the 10x10 ocean array? 
		if (horizontal) {
			//since the column index already includes the bow we need to subtract 1 to get the remaining length that extends from the bow. 
			if (column - (length -1) < 0) {
				// return false if out of bounds
				return false;
			}
		} else {
			if (row - (length -1) < 0 ) {
				return false;
			}
		}
		
		// Check surrounding of the ship to ensure no other ship is present (V, H, D) 
		// v & h loops through the cells surrounding the ship ( v = row offset h = column offset ranging from 1 to -1
		for (int v = -1; v <= 1; v++) {
			for (int h = -1; h <= 1; h++ ) {
				// d loops through the length of the ship (ranging from 0 to -1 length)
				// based on orientation of the ship ( h or v) and check each part of the ship along with its surroundings. 
				for (int d = 0; d < length; d++) {
					
					// if horizontal then this else that. 
					
					int newRow;
					if (horizontal) {
					    newRow = row + v;
					} else {
					    newRow = row + h - d;
					}
					
					int newColumn;
					if (horizontal) {
						newColumn = column + h - d;
					} else {
						newColumn = column + h - d;
					}
					
					// are the indices within the bounds of the ocean???
					if (newRow >= 0 && newRow < ocean.getDimension() && newColumn >= 0 && newColumn < ocean.getDimension()) {
						// Check if there is a ship in the surrounding cells
	                    if (!ocean.getShipArray()[newRow][newColumn].getShipType().equals("EmptySea")) {
	                        return false;
	                    }
	                }
	            }
	        }
	    }
		return true;
	
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
		 * 
		 * *** did this way *** maybe just place entire ship in loop, start i or j to 0, minus 0 is itself so it will set the bow
		 */
		
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		// the incremental variable starts at 0, so first time it is ran, it subtracts 0 from row or column
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
