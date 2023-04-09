/*
 * Adam Ketterling and Armand Aquino worked on homework together
 * We are submitting the same code
 */

package battleship;

/**
 * Cruiser is a class that extends the abstract Ship class
 * 
 */

public class Cruiser extends Ship {

	// static variables
	/**
	 * Length of Cruiser
	 */
	static final int LENGTH = 3;
	static final String TYPE = "cruiser";

	/**
	 * Calls the constructor of the parent class passing the length of the cruiser
	 * as an argument.
	 */
	public Cruiser() {
		super(Cruiser.LENGTH);
	}

	/**
	 * returns a string. This method in the parent class. Overriding the getShipType
	 */
	@Override
	public String getShipType() {
		return Cruiser.TYPE;
	}

}
