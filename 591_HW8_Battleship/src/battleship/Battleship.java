package battleship;

public class Battleship extends Ship {

	// static variables

	static final int LENGTH = 4;
	static final String TYPE = "battleship";

	public Battleship() {
		super(Battleship.LENGTH);
	}

	@Override
	public String getShipType() {
		return Battleship.TYPE;
	}

}
