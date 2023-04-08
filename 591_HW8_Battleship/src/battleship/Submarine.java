package battleship;

/**
 * Submarine is a class that extends the abstract Ship class
 * 
 */
public class Submarine extends Ship {

	// static variable

	/**
	 * Length of ship made as a final static int.
	 */
	static final int LENGTH = 1;
	static final String TYPE = "submarine";

	/**
	 * Calls the constructor of the parent class passing the length of this ship as
	 * an argument.
	 */
	public Submarine() {
		super(Submarine.LENGTH);
	}

	/**
	 * returns a string. Overrides the method in the parent class. Overriding the
	 * getShipType
	 */
	@Override
	public String getShipType() {
		return Submarine.TYPE;
	}

}
