package battleship;

public class Adam {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Ocean battleShipOcean = new Ocean();
        
		Ship battleShip = new Battleship();
		Ship cruiserShip = new Cruiser();
		Ship submarineShip = new Submarine();

        Cruiser cruiser = new Cruiser();
        Battleship battleship = new Battleship();
        
        
        submarineShip.placeShipAt(7, 2, false, battleShipOcean);
		battleShip.placeShipAt(9, 3, true, battleShipOcean);
		cruiserShip.placeShipAt(8, 4, false, battleShipOcean); 
		
        battleShipOcean.printWithShips();
		
		// Test cases for Cruiser
        System.out.println("Cruiser at (6,7) vertically: -> true = " + cruiser.okToPlaceShipAt(6, 7, false, battleShipOcean)); //false = vertical
        System.out.println("Cruiser at (0,0) vertically: -> false = " + cruiser.okToPlaceShipAt(0, 0, false, battleShipOcean));
        System.out.println("Cruiser at (6,4) vertically: -> false = " + cruiser.okToPlaceShipAt(6, 4, false, battleShipOcean));
        System.out.println("Cruiser at (1,1) vertically: -> false = " + cruiser.okToPlaceShipAt(1, 1, false, battleShipOcean));
        System.out.println("Cruiser at (5,5) diganal issue: -> false = " + cruiser.okToPlaceShipAt(5, 5, false, battleShipOcean));
        System.out.println("Cruiser at (9,9) vertically: -> true = " + cruiser.okToPlaceShipAt(9, 9, false, battleShipOcean));
        System.out.println("Cruiser at (3,0) vertically: -> true = " + cruiser.okToPlaceShipAt(3, 0, false, battleShipOcean));
        System.out.println("----------------------------------------------------------------------------------------");
        
        // Test cases for Battleship horizontal
        System.out.println("Battleship at (5,5) negitive space next to cruiser: -> false = " + battleship.okToPlaceShipAt(5, 5, true, battleShipOcean)); //true = horizontal 
        System.out.println("Battleship at (0,3) : -> true = " + battleship.okToPlaceShipAt(0, 3, true, battleShipOcean));
        System.out.println("Battleship at (6,8) too close to cruiser : -> false = " + battleship.okToPlaceShipAt(6, 8, true, battleShipOcean));
        System.out.println("Battleship at (-1,9) horizontally: Shouldn't work - " + battleship.okToPlaceShipAt(-1, 9, true, battleShipOcean));
        System.out.println("Battleship at (0,10) horizontally: Shouldn't work - " + battleship.okToPlaceShipAt(0, 10, true, battleShipOcean));
        System.out.println("--------------------------------- 1 ");
        
  
        
        System.out.println("--------------------------------- 11 ");
        

        
    }

}	