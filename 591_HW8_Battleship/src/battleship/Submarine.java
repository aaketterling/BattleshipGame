package battleship;

public class Submarine extends Ship {

	// static variable

	static final int LENGTH = 1;
	static final String TYPE = "submarine";


	public Submarine() {
		super(Submarine.LENGTH);
	}

	@Override
	public String getShipType() {
		return Submarine.TYPE;
	}

}
