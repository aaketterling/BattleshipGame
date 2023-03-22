package battleship;

public class Destroyer extends Ship {

	// static variables

	static final int LENGTH = 2;
	static final String TYPE = "destroyer";


	public Destroyer() {
		super(Destroyer.LENGTH);
	}

	@Override
	public String getShipType() {
		return Destroyer.TYPE;
	}

}
