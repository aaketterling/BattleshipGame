package battleship;

/**
 * Contains a 10x10 array of Ships, representing an "ocean", and some methods to manipulate it. 
 * @author adamkett
 *
 */
public class Ocean {
	// instance variables

	// Used to quickly determine which ship is in any given location
	private Ship[][] ships = new Ship[10][10];

	// The total number of shots fired by the user
	private int shotsFired;

	// The number of times a shot hit a ship. If the user shoots the same part of a
	// ship more than once, every hit is counted, even though additional “hits”
	// don’t do the user any good.
	private int hitCount;

	// The number of ships sunk (10 ships in all)
	private int shipsSunk;

	// constructor

	public Ocean() {
		// TODO
		// helper method for empty ocean, update this.ships with all EmptySea ships
		this.createEmptyOcean();
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	/*
	 * Proposed helper function for constructor Creates an empty ocean and fills the
	 * ships array with EmptySea objects. make private because internal helper tool
	 * No instance of Ocean could call it this:
	 * 
	 * private void createEmptyOcean()
	 * 
	 * for loop each row i for loop each column in i, j create a emptyShip instance
	 * set bow column and row and if horizontal assign to ships array [i][j]
	 * 
	 * DISCUSSION. When with in class, access private instance variables with getter
	 * or directly with this?
	 * 
	 * Asked TA, said both is ok but be consistent. TA preferred to use getter if
	 * available.  I kind of think use directly.  Discuss and agree what to do.
	 * 
	 */
	
	// methods 
	
	// this will be used within 
	public int getDimension() {
	    return 10;
	}
	
	private void createEmptyOcean() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// EmptySea is a type of ship
				Ship emptySea = new EmptySea();
				emptySea.setBowRow(i);
				emptySea.setBowColumn(j);
				emptySea.setHorizontal(true);
				this.ships[i][j] = emptySea;
				//or
//				this.getShipArray()[i][j] = emptySea;
			}
		}
	}

	void placeAllShipsRandomly() {
		// TODO

	}

	boolean isOccupied(int row, int column) {
		// TODO

		// Returns true if the given location contains a ship, false if it does not

		/*
		 * Proposed pseudo code check ships array at [row][column] if equals "empty
		 * return false, else true e.g. 
		 * 
		 * if empty, then not occupied.  it must be another ship.
		 * return this.getShipArray()[row][column].getShipType().equals("empty") ? false : true; 
		 * 
		 * Adam, are you ok with ternary and one-liners? Easy to read?
		 */
//		return false;
		return this.getShipArray()[row][column].getShipType().equals("empty") ? false : true; 

	}

	boolean shootAt(int row, int column) {
		// TODO
		return false;
	}

	int getShotsFired() {
		return shotsFired;
	}

	int getHitCount() {
		return hitCount;
	}

	int getShipsSunk() {
		return shipsSunk;
	}

	boolean isGameOver() {
		return this.getShipsSunk() == 10 ? true : false;
	}

	Ship[][] getShipArray() {
		// TODO
		return ships;
	}

	void print() {
		// TODO

	}

	// for debugging only
	void printWithShips() {
		// TODO
		
		// for debugging only
		// 10 x 10 grid
		// print top row headers
		System.out.print(" "); // space for top left corner
		// column numbers with space between
		for (int i = 0; i < 10; i++) {
			System.out.print(" " + i);
		}
		
		// go to next line
		System.out.println();
		
		// print each row label
		for (int j = 0; j < 10; j++) {
			System.out.print(j);
			// for each row, print each ship at each row x column "cell" like in a spreadsheet
			for (int k = 0; k < 10; k++) {
				// get ship at cell
				Ship shipAtCell = this.getShipArray()[j][k];
				// print based on ship type
				if (shipAtCell.getShipType().equals("battleship")) {
					System.out.print(" " + "b");
				} else if (shipAtCell.getShipType().equals("cruiser")){
					System.out.print(" " + "c");
				} else if (shipAtCell.getShipType().equals("destroyer")){
					System.out.print(" " + "d");
				} else if (shipAtCell.getShipType().equals("submarine")){
					System.out.print(" " + "s");
				} else if (shipAtCell.getShipType().equals("empty")){
					System.out.print(" " + " ");
				} 
			}
			// go to next line
			System.out.println();
		}
	}
}
