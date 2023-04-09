/*
 * Adam Ketterling and Armand Aquino worked on homework together
 * We are submitting the same code
 */

package battleship;

/**
 * Battleship is a class that extends the abstract Ship class
 * 
 */

public class Battleship extends Ship {

	// static variables

	/**
	 * Length of battleship
	 */
	static final int LENGTH = 4;
	static final String TYPE = "battleship";

	/**
	 * Calls the constructor of the parent class passing the length of the
	 * battleship as an argument.
	 */
	public Battleship() {
		super(Battleship.LENGTH);
	}

	/**
	 * returns a string. This method in the parent class. Overriding the getShipType
	 */
	@Override
	public String getShipType() {
		// Returns a Type from string.
		return Battleship.TYPE;
	}

}
