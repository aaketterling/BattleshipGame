package battleship;

import java.util.Random;

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
	
	// helper methods
	
	/**
	 * Helper method to emulate Python randInt with min and max
	 * @param min	minimum integer to select randomly (inclusive)
	 * @param max	maximum integer to select randomly (exclusive)
	 * @return integer randomly selected with range min to (max - 1)
	 */
	private int randInt(int min, int max) {
        Random random = new Random();
        
        return random.nextInt(max - min) + min;

	}
	
	
	/**
	 * Adds a certain type of ship a number of times in legal positions.
	 * 
	 * @param num number of ships you want to add to the ocean if ok
	 * @param shipType type of ship you want to add
	 * @return nothing.  no-op
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
	            // randomly determine if horizontal.  0 = false, 1 = true
	            isHorizontal = this.randInt(0, 2) == 1 ? true : false;
	            if (isHorizontal) {
	            	// can be any row 0-9, 
	                row = this.randInt(0, 10);
	                // column min is ship length - 1
	                // e.g. battleship length 4, column can only be 3
	                // 10 - 4 - 1 is nextInt(7) i.e. 0-6, now add 4 - 1.  range is 3 - 9
	                column = this.randInt(ship.getLength() - 1, 10);
	            } else {
	            	// row min must be ship length - 1
	            	// e.g. battleship length r, row can only be 3
	                row = randInt(ship.getLength() - 1, 10);
	                // column can be 0-9
	                column = this.randInt(0,10);
	            }

	            boolean okToPlaceShip = ship.okToPlaceShipAt(row, column, isHorizontal, this);

	            while (!okToPlaceShip) {
	            	// if didn't work above, was false, the keep trying.
	            	// same logic.  try to make helper
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
	
	private void createEmptyOcean() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// EmptySea is a type of ship
				Ship emptySea = new EmptySea();
				emptySea.setBowRow(i);
				emptySea.setBowColumn(j);
				emptySea.setHorizontal(true);
				this.getShipArray()[i][j] = emptySea;
			}
		}
	}

	void placeAllShipsRandomly() {
		// TODO
		
		// Adam, maybe make helper function for random int with range like in python.
		// i thought it was like python and kept getting error
		
//        Random random = new Random();
//        int row;
//        int column;
//        boolean isHorizontal;
        // Place two battleships.
        // Adam, maybe we make a helper function.  I did a copy and paste for the other
        // three ships after I did the battleship and just replaced some variables
        // good case to make helper function.
//        // this will be used with the other Ship types
        this.placeShipsInOceanIfOk(1, "battleship");
        this.placeShipsInOceanIfOk(2, "cruiser");
        this.placeShipsInOceanIfOk(3, "destroyer");
        this.placeShipsInOceanIfOk(4, "submarine");

//        for (int i = 0; i < 1; i++) {
//        	// create ship
//            Ship battleship = new Battleship();
//            // randomly determine if horizontal.  0 = false, 1 = true
//            isHorizontal = random.nextBoolean();
//            if (isHorizontal) {
//            	// can be any row 0-9, 
//                row = this.randInt(0, 10);
//                // column min is ship length - 1
//                // e.g. battleship length 4, column can only be 3
//                // 10 - 4 - 1 is nextInt(7) i.e. 0-6, now add 4 - 1.  range is 3 - 9
//                column = this.randInt(battleship.getLength() - 1, 10);
//            } else {
//            	// row min must be ship length - 1
//            	// e.g. battleship length r, row can only be 3
//                row = randInt(battleship.getLength() - 1, 10);
//                // column can be 0-9
//                column = this.randInt(0,10);
//            }
//
//            boolean okToPlaceBattleship = battleship.okToPlaceShipAt(row, column, isHorizontal, this);
//
//            while (!okToPlaceBattleship) {
//            	// if didn't work above, was false, the keep trying.
//            	// same logic.  try to make helper
//                isHorizontal = random.nextBoolean();
//                if (isHorizontal) {
//                    row = this.randInt(0, 10);
//                    column = this.randInt(battleship.getLength() - 1, 10);
//                } else {
//                    row = this.randInt(battleship.getLength() - 1, 10);
//                    column = this.randInt(0, 10);
//                }
//                
//                okToPlaceBattleship = battleship.okToPlaceShipAt(row, column, isHorizontal, this);
//            }
//            // either the for loop was true, or the while loop keep going until true
//            battleship.placeShipAt(row, column, isHorizontal, this);
//        }
        
        // above logic is reused for the other ships but for loop changes
////        for (int j = 0; j < 2; j++) {
////        	// create ship
////            Ship cruiser = new Cruiser();
////            // randomly determine if horizontal.  0 = false, 1 = true
////            isHorizontal = random.nextBoolean();
////            if (isHorizontal) {
////            	// can be any row 0-9, 
////                row = random.nextInt(10);
////                // column min is ship length - 1
////                // e.g. battleship length 4, column can only be 3
////                // 10 - 4 - 1 is nextInt(7) i.e. 0-6, now add 4 - 1.  range is 3 - 9
////                column = random.nextInt(10 - cruiser.getLength() - 1) + cruiser.getLength() - 1;
////            } else {
////            	// row min must be ship length - 1
////            	// e.g. battleship length r, row can only be 3
////                row = random.nextInt(10 - cruiser.getLength() - 1) + cruiser.getLength() - 1;
////                // column can be 0-9
////                column = random.nextInt(10);
////            }
//
//            boolean okToPlaceCruiser = cruiser.okToPlaceShipAt(row, column, isHorizontal, this);
//
//            while (!okToPlaceCruiser) {
//            	// if didn't work above, was false, the keep trying.
//            	// same logic.  try to make helper
//                isHorizontal = random.nextBoolean();
//                if (isHorizontal) {
//                    row = random.nextInt(10);
//                    column = random.nextInt(10 - cruiser.getLength() - 1) + cruiser.getLength() - 1;
//                } else {
//                    row = random.nextInt(10 - cruiser.getLength() - 1) + cruiser.getLength() - 1;
//                    column = random.nextInt(10);
//                }
//                
//                okToPlaceCruiser = cruiser.okToPlaceShipAt(row, column, isHorizontal, this);
//            }
//            // either the for loop was true, or the while loop keep going until true
//            cruiser.placeShipAt(row, column, isHorizontal, this);
//        }
//        
//        for (int k = 0; k < 3; k++) {
//        	// create ship
//            Ship destroyer = new Destroyer();
//            // randomly determine if horizontal.  0 = false, 1 = true
//            isHorizontal = random.nextBoolean();
//            if (isHorizontal) {
//            	// can be any row 0-9, 
//                row = random.nextInt(10);
//                // column min is ship length - 1
//                // e.g. battleship length 4, column can only be 3
//                // 10 - 4 - 1 is nextInt(7) i.e. 0-6, now add 4 - 1.  range is 3 - 9
//                column = random.nextInt(10 - destroyer.getLength() - 1) + destroyer.getLength() - 1;
//            } else {
//            	// row min must be ship length - 1
//            	// e.g. battleship length r, row can only be 3
//                row = random.nextInt(10 - destroyer.getLength() - 1) + destroyer.getLength() - 1;
//                // column can be 0-9
//                column = random.nextInt(10);
//            }
//
//            boolean okToPlaceDestroyer = destroyer.okToPlaceShipAt(row, column, isHorizontal, this);
//
//            while (!okToPlaceDestroyer) {
//            	// if didn't work above, was false, the keep trying.
//            	// same logic.  try to make helper
//                isHorizontal = random.nextBoolean();
//                if (isHorizontal) {
//                    row = random.nextInt(10);
//                    column = random.nextInt(10 - destroyer.getLength() - 1) + destroyer.getLength() - 1;
//                } else {
//                    row = random.nextInt(10 - destroyer.getLength() - 1) + destroyer.getLength() - 1;
//                    column = random.nextInt(10);
//                }
//                
//                okToPlaceDestroyer = destroyer.okToPlaceShipAt(row, column, isHorizontal, this);
//            }
//            // either the for loop was true, or the while loop keep going until true
//            destroyer.placeShipAt(row, column, isHorizontal, this);
//        }
//        
//        for (int k = 0; k < 4; k++) {
//        	// create ship
//            Ship submarine = new Submarine();
//            // randomly determine if horizontal.  0 = false, 1 = true
//            isHorizontal = random.nextBoolean();
//            if (isHorizontal) {
//            	// can be any row 0-9, 
//                row = random.nextInt(10);
//                // column min is ship length - 1
//                // e.g. battleship length 4, column can only be 3
//                // 10 - 4 - 1 is nextInt(7) i.e. 0-6, now add 4 - 1.  range is 3 - 9
//                column = random.nextInt(10 - submarine.getLength() - 1) + submarine.getLength() - 1;
//            } else {
//            	// row min must be ship length - 1
//            	// e.g. battleship length r, row can only be 3
//                row = random.nextInt(10 - submarine.getLength() - 1) + submarine.getLength() - 1;
//                // column can be 0-9
//                column = random.nextInt(10);
//            }
//
//            boolean okToPlaceSubmarine = submarine.okToPlaceShipAt(row, column, isHorizontal, this);
//
//            while (!okToPlaceSubmarine) {
//            	// if didn't work above, was false, the keep trying.
//            	// same logic.  try to make helper
//                isHorizontal = random.nextBoolean();
//                if (isHorizontal) {
//                    row = random.nextInt(10);
//                    column = random.nextInt(10 - submarine.getLength() - 1) + submarine.getLength() - 1;
//                } else {
//                    row = random.nextInt(10 - submarine.getLength() - 1) + submarine.getLength() - 1;
//                    column = random.nextInt(10);
//                }
//                
//                okToPlaceSubmarine = submarine.okToPlaceShipAt(row, column, isHorizontal, this);
//            }
//            // either the for loop was true, or the while loop keep going until true
//            submarine.placeShipAt(row, column, isHorizontal, this);
//        }
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
		 */
//		return false;
		return this.getShipArray()[row][column].getShipType().equals("empty") ? false : true; 

	}

	boolean shootAt(int row, int column) {
		// TODO
		// Returns true if the given location contains a ”real” ship, still afloat, (not
		// an EmptySea), false if it does not. In addition, this method updates the
		// number of shots that have been fired, and the number of hits.
		// Note: If a location contains a “real” ship, shootAt should return true every
		// time the user shoots at that same location. Once a ship has been ”sunk”,
		// additional shots at its location should return false.
		
		// update number of shots that have been fired
		// TODO for this entire method. create helper methods so we don't directly
		// update private instance variables.  e.g. this.incrementShotsFired(1)
		this.shotsFired += 1; 
		// get ship type at row, column
        Ship ship = this.getShipArray()[row][column];
        
        // is it a real ship
        if (this.isOccupied(row, column)) {
        	// is it a float
        	if (!ship.isSunk()) {
        		// update number of hits
        		this.hitCount += 1;
				// The shootAt method in the Ocean class will call the shootAt method in the
				// ship (or EmptySea), in that particular location
        		ship.shootAt(row, column);
        		
        		// check if after you hit the ship, if it sunk
        		if (ship.isSunk()) {
        			// update ships sunk
        			this.shipsSunk += 1;
        		}
        		return true;
        	} else {
        		// don't shootAt sunk ship? don't update hit count?
        		return false;
        	}
        	
        } else {
        	// it is empty
			// The shootAt method in the Ocean class will call the shootAt method in the
			// ship (or EmptySea), in that particular location
        	ship.shootAt(row, column);
    		return false;
        }
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
		// for each location in the 10 by 10 array (the “ocean”)
		// if the location contains a ship that is sunk or if the location has been shot at, and was hit or nothing was found
		// print the ship itself -- this will call toString in the Ship class or any Ship subclass which has toString defined (i.e. EmptySea)
		// otherwise print “.”
		
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
				
				// contains a ship?
				if (this.isOccupied(j, k)) {
					// if it is sunk, the toString will print what is appropriate
                    if (shipAtCell.isHorizontal()) {
                    	// if k = bowColumn, then in bow, hit[0], else subtract to go left to get index in hit array
                    	// 0 bowcolumn, 1 bowcolumn - 1, ...
                        if (shipAtCell.getHit()[shipAtCell.getBowColumn() - k]) {
                        	// if hit print if is is s or x
                            System.out.print(" " + shipAtCell);
                        } else {
                        	// not yet hit
                            System.out.print(" " + ".");
                        }
                    } else {
                    	// if k = bowRow, then in bow, hit[0], else subtract to go up to get index in hit array
                    	// 0 bowRow, 1 bowRow - 1, ...
                        if (shipAtCell.getHit()[shipAtCell.getBowRow() - j]) {
                        	// if hit print if is is s or x
                            System.out.print(" " + shipAtCell);
                        } else {
                        	// not yet hit
                            System.out.print(" " + ".");
                        }
                    }
				
				} else {
					// is empty
					
					// the cell is hit.  note empty sea is 1 length so bow is at hit[0]
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
