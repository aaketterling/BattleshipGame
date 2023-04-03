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
		
		
		// test is game over.
		Ocean battleShipOcean2 = new Ocean();
		
		Ship sub1 = new Submarine();
		Ship sub2 = new Submarine();
		Ship sub3 = new Submarine();
		Ship sub4 = new Submarine();
		Ship sub5 = new Submarine();
		Ship sub6 = new Submarine();
		Ship sub7 = new Submarine();
		Ship sub8 = new Submarine();
		Ship sub9 = new Submarine();
		Ship sub10 = new Submarine();
		sub1.placeShipAt(0, 0, false, battleShipOcean2);
		sub2.placeShipAt(0, 9, false, battleShipOcean2);
		sub3.placeShipAt(9, 0, false, battleShipOcean2);
		sub4.placeShipAt(9, 9, false, battleShipOcean2);
		sub5.placeShipAt(2, 0, false, battleShipOcean2);
		sub6.placeShipAt(4, 0, false, battleShipOcean2);
		sub7.placeShipAt(6, 0, false, battleShipOcean2);
		sub8.placeShipAt(0, 3, false, battleShipOcean2);
		sub9.placeShipAt(0, 5, false, battleShipOcean2);
		sub10.placeShipAt(0, 7, false, battleShipOcean2);
		battleShipOcean2.printWithShips();
		battleShipOcean2.shootAt(0, 0);
		battleShipOcean2.shootAt(0, 9);
		battleShipOcean2.shootAt(9, 0);
		battleShipOcean2.shootAt(9, 9);
		battleShipOcean2.shootAt(2, 0);
		battleShipOcean2.shootAt(4, 0);
		battleShipOcean2.shootAt(6, 0);
		battleShipOcean2.shootAt(0, 3);
		battleShipOcean2.shootAt(0, 5);
		System.out.println(battleShipOcean2.isGameOver() ? "[issue]should not be true only 9 ships sank" : "only 9 ships sank");
		battleShipOcean2.shootAt(0, 7);
		System.out.println(battleShipOcean2.isGameOver() ? "Game is over, 10 ships sank" : "[issue] 10 ships should have sank");

		


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
