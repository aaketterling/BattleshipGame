package battleship;

import java.util.Random;

/**
 * Ocean is a class that represents an ocean and provides methods where you can
 * place ships on, shoot at them, and other variables and methods to play a
 * version of Battleship.
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

		// initializes game variables,
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	// methods

	/**
	 * Helper method to emulate Python randInt with min and max private method
	 * because it is used only inside the class and not to be used by instances of
	 * this class
	 * 
	 * @param min minimum integer to select randomly (inclusive)
	 * @param max maximum integer to select randomly (exclusive)
	 * @return integer randomly selected with range min to (max - 1)
	 */
	private int randInt(int min, int max) {
		Random random = new Random();

		return random.nextInt(max - min) + min;
	}

	/**
	 * Adds a certain type of ship a number of times in legal positions in the
	 * ocean. private method because it is used only inside the class and not to be
	 * used by instances of this class
	 * 
	 * @param num      number of ships you want to add to the ocean if ok
	 * @param shipType type of ship you want to add
	 * @return nothing. no-op
	 */
	private void placeShipsInOceanIfOk(int num, String shipType) {
		int row;
		int column;
		boolean isHorizontal;
		Ship ship;

		for (int i = 0; i < num; i++) {
			// create new ship per iteration
			if (shipType.toLowerCase().equals("battleship")) {
				ship = new Battleship();
			} else if (shipType.toLowerCase().equals("cruiser")) {
				ship = new Cruiser();
			} else if (shipType.toLowerCase().equals("destroyer")) {
				ship = new Destroyer();
			} else {
				ship = new Submarine();
			}
			// randomly determine if horizontal. 0 = false, 1 = true
			isHorizontal = this.randInt(0, 2) == 1 ? true : false;
			if (isHorizontal) {
				// can be any row 0-9,
				row = this.randInt(0, 10);
				// column min is ship length - 1
				// e.g. battleship length 4, column can only be 3
				column = this.randInt(ship.getLength() - 1, 10);
			} else {
				// row min must be ship length - 1
				// e.g. battleship length r, row can only be 3
				row = randInt(ship.getLength() - 1, 10);
				// column can be 0-9
				column = this.randInt(0, 10);
			}

			boolean okToPlaceShip = ship.okToPlaceShipAt(row, column, isHorizontal, this);

			while (!okToPlaceShip) {
				// if didn't work above, was false, the keep trying.
				// same logic. try to make helper
				isHorizontal = this.randInt(0, 2) == 1 ? true : false;
				if (isHorizontal) {
					row = this.randInt(0, 10);
					column = this.randInt(ship.getLength() - 1, 10);
				} else {
					row = this.randInt(ship.getLength() - 1, 10);
					column = this.randInt(0, 10);
				}

				okToPlaceShip = ship.okToPlaceShipAt(row, column, isHorizontal, this);
			}
			// either the for loop was true, or the while loop keep going until true
			ship.placeShipAt(row, column, isHorizontal, this);
		}
	}

	/**
	 * Helper method to create an ”empty” ocean (and fills the ships array with
	 * EmptySea objects)
	 * 
	 * @return void
	 */
	private void createEmptyOcean() {
		// go through each row of the array
		for (int i = 0; i < 10; i++) {
			// go through each column of the array
			for (int j = 0; j < 10; j++) {
				// Create instance of EmptySea (a type of ship)
				Ship emptySea = new EmptySea();

				// set emptySea variables
				emptySea.setBowRow(i);
				emptySea.setBowColumn(j);
				emptySea.setHorizontal(true);

				// place emptySea ship in ship array
				this.getShipArray()[i][j] = emptySea;
			}
		}
	}

	/**
	 * Place ten ships randomly on the (initially empty) ocean.
	 * 
	 * @return void
	 */
	void placeAllShipsRandomly() {
		// TODO
		// call helper to place a type of ship a number of times
		// should equal 10
		// Place larger ships before smaller ones
		this.placeShipsInOceanIfOk(1, "battleship");
		this.placeShipsInOceanIfOk(2, "cruiser");
		this.placeShipsInOceanIfOk(3, "destroyer");
		this.placeShipsInOceanIfOk(4, "submarine");
	}

	/**
	 * Returns true if the given location contains a ship, false if it does not
	 * 
	 * @param row    int of the row index in the ships array to check if occupied
	 * @param column int of column index in ships array to check if occupied
	 * @return boolean. true if the given location contains a ship, false if it does
	 *         not
	 */
	boolean isOccupied(int row, int column) {
		// Returns true if the given location contains a ship, false if it does not
		return this.getShipArray()[row][column].getShipType().equals("empty") ? false : true;
	}

	/**
	 * Returns true if the given location contains a ”real” ship, still afloat, (not
	 * an EmptySea), false if it does not. In addition, this method updates the
	 * number of shots that have been fired, and the number of hits.
	 * 
	 * @param row    int of the row index in the ships array to shoot at
	 * @param column int of column index in ships array to shoot at
	 * @return boolean. true if the given location contains a ”real” ship, still
	 *         afloat, false if it does not
	 */
	boolean shootAt(int row, int column) {
		// TODO
		// Note: If a location contains a “real” ship, shootAt should return true every
		// time the user shoots at that same location..

		// update number of shots that have been fired
		this.shotsFired += 1;
		// get ship type at row, column
		Ship ship = this.getShipArray()[row][column];

		// is it a real ship
		if (this.isOccupied(row, column)) {

			// is it a float
			if (!ship.isSunk()) {
				// update number of hits
				// If the user shoots the same part of a ship more than once, every hit is
				// counted, even though additional “hits” don’t do the user any good.
				this.hitCount += 1;
				// The shootAt method in the Ocean class will call the shootAt method in the
				// ship (or EmptySea), in this particular location
				ship.shootAt(row, column);

				// check if after you hit the ship, if it sunk
				if (ship.isSunk()) {
					// update ships sunk
					this.shipsSunk += 1;
				}
				return true;
			} else {
				// Once a ship has been ”sunk”, additional shots at its location should return
				// false
				return false;
			}
		} else {
			// it is EmptySea
			// The shootAt method in the Ocean class will call the shootAt method in the
			// ship (or EmptySea), in this particular location
			ship.shootAt(row, column);
			return false;
		}
	}

	/**
	 * getter method to return the number of shots fired (in the game) stored in a
	 * private variable
	 * 
	 * @return int number of shots fired
	 */
	int getShotsFired() {
		return shotsFired;
	}

	/**
	 * getter method to return the number of hits recorded (in the game) stored in a
	 * private variable
	 * 
	 * @return int hit count when shootAt hits a ship not empty sea
	 */
	int getHitCount() {
		return hitCount;
	}

	/**
	 * getter method to return the number of ships sunk (in the game) stored in a
	 * private variable
	 * 
	 * @return int number of ships sunk
	 */
	int getShipsSunk() {
		return shipsSunk;
	}

	/**
	 * getter method to return if the game is over by checking if all the ships sunk
	 * 
	 * @return boolean true if all sips sunk, false otherwise
	 */
	boolean isGameOver() {
		return this.getShipsSunk() == 10 ? true : false;
	}

	/**
	 * getter method to return the ships array stored in a private variable
	 * 
	 * @return Ship[][] array of ships in this ocean
	 */
	Ship[][] getShipArray() {
		// TODO
		return ships;
	}

	/**
	 * Prints the Ocean. To aid the user, row numbers should be displayed along the
	 * left edge of the array, and column numbers should be displayed along the top.
	 * Numbers should be 0 to 9, not 1 to 10.
	 * 
	 * @return void
	 */
	void print() {
		// TODO

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
			// for each row, print each ship at each row x column "cell" like in a
			// spreadsheet
			for (int k = 0; k < 10; k++) {
				// get ship at cell
				Ship shipAtCell = this.getShipArray()[j][k];

				// contains a ship?
				if (this.isOccupied(j, k)) {
					// if it is sunk, the toString will print what is appropriate
					if (shipAtCell.isHorizontal()) {
						// if k = bowColumn, then in bow, hit[0], else subtract to go left to get index
						// in hit array
						// 0 bowcolumn, 1 bowcolumn - 1, ...
						if (shipAtCell.getHit()[shipAtCell.getBowColumn() - k]) {
							// if hit print if is is s or x, will call toString method of class
							System.out.print(" " + shipAtCell);
						} else {
							// not yet hit
							System.out.print(" " + ".");
						}
					} else {
						// if k = bowRow, then in bow, hit[0], else subtract to go up to get index in
						// hit array
						// 0 bowRow, 1 bowRow - 1, ...
						if (shipAtCell.getHit()[shipAtCell.getBowRow() - j]) {
							// if hit print if is is s or x, will call toString method of class
							System.out.print(" " + shipAtCell);
						} else {
							// not yet hit
							System.out.print(" " + ".");
						}
					}

				} else {
					// is empty

					// the cell is hit. note empty sea is 1 length so bow is at hit[0]
					if (shipAtCell.getHit()[0]) {
						// System.out.print will convert Ship type toString automatically
						System.out.print(" " + shipAtCell);
					} else {
						// not hit
						System.out.print(" " + ".");
					}
				}

			}
			// go to next line
			System.out.println();
		}

	}

	/**
	 * Similar to the print method but shows the location of the ships. USED FOR
	 * DEBUGGING PURPOSES ONLY.
	 * 
	 * @return void
	 */
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
			// for each row, print each ship at each row x column "cell" like in a
			// spreadsheet
			for (int k = 0; k < 10; k++) {
				// get ship at cell
				Ship shipAtCell = this.getShipArray()[j][k];
				// print based on ship type
				if (shipAtCell.getShipType().equals("battleship")) {
					System.out.print(" " + "b");
				} else if (shipAtCell.getShipType().equals("cruiser")) {
					System.out.print(" " + "c");
				} else if (shipAtCell.getShipType().equals("destroyer")) {
					System.out.print(" " + "d");
				} else if (shipAtCell.getShipType().equals("submarine")) {
					System.out.print(" " + "s");
				} else if (shipAtCell.getShipType().equals("empty")) {
					System.out.print(" " + " ");
				}
			}
			// go to next line
			System.out.println();
		}
	}
}
