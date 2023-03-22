package battleship;

public class EmptySea extends Ship {
	
	// static variables

	static final int LENGTH = 1;

	public EmptySea() {
		super(EmptySea.LENGTH);
	}

	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override
	boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public String getShipType() {
		return "";
	}

}
