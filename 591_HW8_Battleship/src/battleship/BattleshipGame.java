package battleship;

import java.util.Scanner;

public class BattleshipGame {
	
	/*
	 * print ocean
	 * print ocean with ships
	 * show shots fired
	 * ask for row, column
	 * parse string
	 * convert to number array
	 * shoot at until game is over
	 * print congrats
	 * print number of shots taken
	 * print number of hits made
	 */
	
	/*
	 * helper method to keep asking for string with 2 numbers separated by comma
	 * 
	 */
	
	// play until game is over
	// print congrats message
	// print results
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BattleshipGame().run();
	}
	
	void run() {
		Scanner scanner = new Scanner(System.in);
		
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		boolean isGameOver = ocean.isGameOver();
		int row;
		int column;
		
		while(!isGameOver) {
			ocean.printWithShips();
			ocean.print();
			
			// give summary
			System.out.println("The number of shots fired " + ocean.getShotsFired());
			// ask for row and column
			// TODO make this into a method
			System.out.print("enter a row and column separated by , ");
			String rowAndColumnString = scanner.nextLine().trim();
			System.out.println(rowAndColumnString);
			
			// check in input has a comma ","
			if (!rowAndColumnString.contains(",")) {
				System.out.println("Invalid input");
			} 
			
			try {
				String[] rowAndColumn = rowAndColumnString.split(",");
				// check if array is length 2
				
				if (rowAndColumn.length != 2) {
					System.out.println("Invalid input");
				}
				
				row = Integer.parseInt(rowAndColumn[0].trim());
				column = Integer.parseInt(rowAndColumn[1].trim());
				
				// check if row and column in bounds
				if (row < 0 || row > 9) {
					System.out.println("Invalid input");
				}
				
				if (column < 0 || column > 9) {
					System.out.println("Invalid input");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("invalid input");
				continue;
			}
			System.out.println(row);
			System.out.println(column);
			ocean.shootAt(row, column);
			isGameOver = ocean.isGameOver();
		}
		
		scanner.close();
		
		// make a printGameSummary method
		System.out.println("You won! you sank all the ships!");
		System.out.println("The number of shots fired " + ocean.getShotsFired());
		System.out.println("The number of hits made " + ocean.getHitCount());
	}
}
