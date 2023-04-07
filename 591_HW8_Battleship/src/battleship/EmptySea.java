package battleship;

public class EmptySea extends Ship {

	// static variables
	
	/**
	 * Length of "empty" made as a final static int. 
	 */
	static final int LENGTH = 1;
	static final String TYPE = "empty";
	
	/**
	 * Calls the constructor of the parent class passing the length of this EmptySea as an argument. 
	 */
	// constructor
	public EmptySea() {
		super(EmptySea.LENGTH);
	}
	
	/**
	 * Overrides the Ship.shootAt() method to always return false and sets hit to true for the "empty" sea.
	 * 
	 * @param row the row of the location being shot at
	 * @param column the column of the location being shot at
	 * @return always returns false because an "empty" sea cannot be hit
	 */
	@Override
	boolean shootAt(int row, int column) {
		// always returns false
		// set hit to true, overrides the Ship.shootAt
//        this.getHit()[0] = true;
		super.shootAt(row, column);
		return false;
	}
	
	/**
	 * Overrides the Ship.isSunk() method to always return false because an "empty" sea cannot be sunk.
	 * 
	 * @return always returns false because an "empty" sea cannot be sunk
	 */
	@Override
	boolean isSunk() {
		// always returns false
		return false;
	}
	
	/**
	 * Returns a string representation of the "empty" sea.
	 * 
	 * @return a string representation of the "empty" sea
	 */
	@Override
	public String toString() {
		return "-";
	}
	
	/**
	 * returns a string. Overrides the method in the parent class. Overriding the getShipType
	 */
	@Override
	public String getShipType() {
		return EmptySea.TYPE;
	}

}
