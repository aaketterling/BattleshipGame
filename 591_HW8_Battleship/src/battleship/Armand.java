package battleship;

/*
 * For testing methods with printWithShips
 * Do not add to codio when submitting the assignment
 */
public class Armand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ocean battleShipOcean = new Ocean();
		// for testing print
		
		Ship destroyer1 = new Destroyer();
		Ship destroyer2 = new Destroyer();
		destroyer1.placeShipAt(9, 9, true, battleShipOcean);
		destroyer2.placeShipAt(9, 1, true, battleShipOcean);
		// sink destroyer at 9,9
		battleShipOcean.shootAt(9, 9);
		battleShipOcean.shootAt(9, 8);
		battleShipOcean.shootAt(9, 7);
		
		// partial sink destroyer at 9,1
		battleShipOcean.shootAt(9, 0);
		battleShipOcean.shootAt(9, 2);




		battleShipOcean.placeAllShipsRandomly();
		battleShipOcean.printWithShips();
		System.out.println();
		battleShipOcean.print();
//		Ship battleShip = new Battleship();
//		Ship cruiserShip = new Cruiser();
//		
//		if (battleShip.okToPlaceShipAt(5, 5, true, battleShipOcean)) {
//			battleShip.placeShipAt(5, 5, true, battleShipOcean);
//		}
//		
//		if (cruiserShip.okToPlaceShipAt(2, 0, false, battleShipOcean)) {
//			cruiserShip.placeShipAt(2, 0, false, battleShipOcean);
//		}
//		
//		Ship battleShip2 = new Battleship();
//		
//		if (battleShip2.okToPlaceShipAt(4, 5, true, battleShipOcean)) {
//			System.out.println("[issue] battleShip2 4,5 should be false");
//		} else {
//			System.out.println("battleShip2 4,5 is false as expected");
//		}
//		
//		if (battleShip2.okToPlaceShipAt(9, 2, true, battleShipOcean)) {
//			System.out.println("[issue] battleShip2 9,2 should be false too long for board");
//		} else {
//			System.out.println("battleShip2 9,2 is false as expected");
//		}
//		
//		if (battleShip2.okToPlaceShipAt(-1, 9, true, battleShipOcean)) {
//			System.out.println("[issue] battleShip2 -1, 9 should be false illegal coordinates");
//		} else {
//			System.out.println("battleShip2 -1, 9 is false as expected");
//		}
//		
//		if (battleShip2.okToPlaceShipAt(9, 10, true, battleShipOcean)) {
//			System.out.println("[issue] battleShip2 9, 10 should be false illegal coordinates");
//		} else {
//			System.out.println("battleShip2 9, 10 is false as expected");
//		}
//		
//		if (battleShip2.okToPlaceShipAt(-1, 10, true, battleShipOcean)) {
//			System.out.println("[issue] battleShip2 -1, 10 should be false illegal coordinates");
//		} else {
//			System.out.println("battleShip2 -1, 10 is false as expected");
//		}
//		
//		if (battleShip2.okToPlaceShipAt(9, 3, true, battleShipOcean)) {
//			System.out.println("battleShip2 9, 3 should be true");
//			battleShip2.placeShipAt(9, 3, true, battleShipOcean);
//		} else {
//			System.out.println("[issue] battleShip2 9,3 is false and NOT expected fits in board");
//		}
//		
//
//		System.out.println(); // spacing
//		
//		battleShipOcean.printWithShips();
//		
//		System.out.println(battleShipOcean.isOccupied(5, 5) ? "5,5 should be and is occupied (true)" : "5,5 should be occupide but is NOT (issue)");
//		System.out.println(battleShipOcean.isOccupied(9, 9) ? "9,9 should NOT be occupied and but IS occupied (issue)" : "9,9 should NOT be occupied (false) and is in fact empty");
//		System.out.println(battleShipOcean.isOccupied(5, 4) ? "5,4 should be and is occupied (true)" : "5,4 should be occupide but is NOT (issue)");
//		System.out.println(battleShipOcean.isOccupied(9, 9) ? "9,9 should NOT be occupied and but IS occupied (issue)" : "9,9 should NOT be occupied (false) and is in fact empty");
		
	}

}
