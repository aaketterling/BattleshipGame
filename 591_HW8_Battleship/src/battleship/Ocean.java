package battleship;

public class Ocean {
	// instance variables
	
	// Used to quickly determine which ship is in any given location
	private Ship[][] ships = new Ship[10][10];
	
	// The total number of shots fired by the user
	private int shotsFired;
	
	// The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, every hit is counted, even though additional “hits” don’t do the user any good.
	private int hitCount;
	
	// The number of ships sunk (10 ships in all)
	private int shipsSunk;
	
	
	// constructor
	
	public Ocean() {
		
	}
	
	
	void placeAllShipsRandomly() {
		
	}
	
	boolean isOccupied(int row, int column) {
		return false;
	}
	
	boolean shootAt(int row, int column) {
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
		return false;
	}
	
	Ship[][] getShipArray() {
		return ships;
	}
	
	void print() {
		
	}
	
	// for debugging only
	void printWithShips() {
		
	}
}
