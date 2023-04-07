package battleship;

public class Cruiser extends Ship {

	// static variables

	static final int LENGTH = 3;
	static final String TYPE = "cruiser";

	public Cruiser() {
		super(Cruiser.LENGTH);
	}

	@Override
	public String getShipType() {
		return Cruiser.TYPE;
	}

}
