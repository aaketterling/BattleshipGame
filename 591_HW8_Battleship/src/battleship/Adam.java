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
        Submarine submarine = new Submarine();
        
        
        submarineShip.placeShipAt(7, 2, false, battleShipOcean); //vertical
		battleShip.placeShipAt(9, 6, true, battleShipOcean); //horizontal
		cruiserShip.placeShipAt(8, 4, false, battleShipOcean); //vertical
		
        battleShipOcean.printWithShips();
		
		// Test cases for Cruiser Vertical
        System.out.println("Cruiser at (6,7) open area:                     -> true = " + cruiser.okToPlaceShipAt(6, 7, false, battleShipOcean)); //false = vertical
        System.out.println("Cruiser at (0,0) out of bouds:                  -> false = " + cruiser.okToPlaceShipAt(0, 0, false, battleShipOcean));
        System.out.println("Cruiser at (6,5) for i vertical negative space: -> false = " + cruiser.okToPlaceShipAt(6, 5, false, battleShipOcean));
        System.out.println("Cruiser at (1,1) length goes out of bounds:     -> false = " + cruiser.okToPlaceShipAt(1, 1, false, battleShipOcean));
        System.out.println("Cruiser at (5,5) diganal issue:                 -> false = " + cruiser.okToPlaceShipAt(5, 5, false, battleShipOcean));
        System.out.println("Cruiser at (8,5) right boat side:               -> false = " + cruiser.okToPlaceShipAt(8, 5, false, battleShipOcean));
        System.out.println("Cruiser at (3,0) left edge of board:            -> true = " + cruiser.okToPlaceShipAt(3, 0, false, battleShipOcean));
        System.out.println("Cruiser at (-1,9) out of bounds:                -> false = " + cruiser.okToPlaceShipAt(-1, 9, false, battleShipOcean));
        System.out.println("Cruiser at (6,-1) out of bounds:                -> false = " + cruiser.okToPlaceShipAt(6, -1, false, battleShipOcean));
        System.out.println("----------------------------------------------------------------------------------------");
        
        // Test cases for Battleship horizontal
        System.out.println("Battleship at (5,5) negitive space next to cruiser diganally :    -> false = " + battleship.okToPlaceShipAt(5, 5, true, battleShipOcean)); //true = horizontal
        System.out.println("Cruiser at (8,9) negitive space next to battelship diganally :    -> false = " + cruiser.okToPlaceShipAt(8, 9, true, battleShipOcean)); //true = horizontal 
        System.out.println("Battleship at (0,-1) out of bounds:                               -> false = " + battleship.okToPlaceShipAt(0, -1, true, battleShipOcean));
        System.out.println("Battleship at (6,8) too close to cruiser side :                   -> false = " + battleship.okToPlaceShipAt(6, 8, true, battleShipOcean));
        System.out.println("Battleship at (0,11) out of bounds negative: 					  -> false = " + battleship.okToPlaceShipAt(0, 11, true, battleShipOcean));
        System.out.println("Battleship at (2,11) out of bounds negative: 					  -> false = " + battleship.okToPlaceShipAt(9, 11, true, battleShipOcean));
        System.out.println("Battleship at (0,10) out of bounds: 					          -> false = " + battleship.okToPlaceShipAt(0, 10, true, battleShipOcean));
        System.out.println("Battleship at (2,9) in bounds :    					          -> true = " + battleship.okToPlaceShipAt(2, 9, true, battleShipOcean));
        System.out.println("-----------------------------------------------------------------------------------------");
		
		// Test cases for subs horizontal
        System.out.println("Sub at (3,-1) out of bounds:                      -> false = " + submarine.okToPlaceShipAt(3, -1, true, battleShipOcean)); //false = vertical
        System.out.println("Sub at (-1,3) out of bouds:                       -> false = " + submarine.okToPlaceShipAt(-1, 3, true, battleShipOcean));
        System.out.println("Sub at (10,0) out of bouds:                       -> false = " + submarine.okToPlaceShipAt(10, 0, true, battleShipOcean));
        System.out.println("Sub at (0,10) out of bouds:                       -> false = " + submarine.okToPlaceShipAt(0, 10, true, battleShipOcean));
        System.out.println("Sub at (0,0) in bouds:                            -> true = " + submarine.okToPlaceShipAt(1, 1, true, battleShipOcean));
        System.out.println(" ");
        
		// Test cases for subs vertical
        System.out.println("Sub at (3,-1) out of bounds:                      -> false = " + submarine.okToPlaceShipAt(3, -1, false, battleShipOcean)); //false = vertical
        System.out.println("Sub at (-1,3) out of bouds:                       -> false = " + submarine.okToPlaceShipAt(-1, 3, false, battleShipOcean));
        System.out.println("Sub at (10,0) out of bouds:                       -> false = " + submarine.okToPlaceShipAt(10, 0, false, battleShipOcean));
        System.out.println("Sub at (0,10) out of bouds:                       -> false = " + submarine.okToPlaceShipAt(0, 10, false, battleShipOcean));
        System.out.println("Sub at (0,0) in bouds:                            -> true = " + submarine.okToPlaceShipAt(1, 1, false, battleShipOcean));

        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println("---------------------------------");
        

        
    }

}	