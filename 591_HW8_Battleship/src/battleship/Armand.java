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
		
		System.out.println(battleShipOcean.isOccupied(5, 5) ? "5,5 should be and is occupied (true)" : "5,5 should be occupide but is NOT (issue)");
		System.out.println(battleShipOcean.isOccupied(9, 9) ? "9,9 should NOT be occupied and but IS occupied (issue)" : "9,9 should NOT be occupied (false) and is in fact empty");
		System.out.println(battleShipOcean.isOccupied(5, 4) ? "5,4 should be and is occupied (true)" : "5,4 should be occupide but is NOT (issue)");
		System.out.println(battleShipOcean.isOccupied(9, 9) ? "9,9 should NOT be occupied and but IS occupied (issue)" : "9,9 should NOT be occupied (false) and is in fact empty");

	}

}
