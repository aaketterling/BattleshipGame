/*
 * Adam Ketterling and Armand Aquino worked on homework together
 * We are submitting the same code
 */

package battleship;

/**
 * Destroyer is a class that extends the abstract Ship class
 * 
 */
public class Destroyer extends Ship {

	// static variables

	/**
	 * Length of ship made as a final static int.
	 */
	static final int LENGTH = 2;
	static final String TYPE = "destroyer";

	/**
	 * Calls the constructor of the parent class passing the length of this ship as
	 * an argument.
	 */
	public Destroyer() {
		super(Destroyer.LENGTH);
	}

	/**
	 * returns a string. Overrides the method in the parent class. Overriding the
	 * getShipType
	 */
	@Override
	public String getShipType() {
		return Destroyer.TYPE;
	}

}
