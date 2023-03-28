package battleship;

/*
 * For testing methods with printWithShips
 * Do not add to codio when submitting the assignment
 */
public class Armand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ocean battleShipOcean = new Ocean();
		Ship battleShip = new Battleship();
		Ship cruiserShip = new Cruiser();
		battleShip.placeShipAt(5, 5, true, battleShipOcean);
		cruiserShip.placeShipAt(2, 0, false, battleShipOcean);
		
		battleShipOcean.printWithShips();

	}

}
