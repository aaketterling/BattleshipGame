package battleship;

public class EmptySea extends Ship {

	// static variables

	static final int LENGTH = 1;
	static final String TYPE = "empty";

	// constructor
	public EmptySea() {
		super(EmptySea.LENGTH);
	}

	@Override
	boolean shootAt(int row, int column) {
		// always returns false
		return false;
	}

	@Override
	boolean isSunk() {
		// always returns false
		return false;
	}

	@Override
	public String toString() {
		return "-";
	}

	@Override
	public String getShipType() {
		return EmptySea.TYPE;
	}

}
