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
	
	// helper to get user input
	
	int[] getUserRowColumnInput(Scanner scanner) {
		// variables for response
		int[] response = new int[2];
		int row;
		int column;
		// will use in while loop until we get valid input
		boolean validInput = false;
		while(!validInput) {
			// ask user for row and column
			System.out.print("Enter row,column: ");
			
			// get input as string
			String input = scanner.nextLine().trim();
			
			// check if there is a comma
			if (!input.contains(",")) {
				validInput = false;
				continue;
			}
			
			// split string by comma "," into String array
			String[] inputArray = input.split(",");
			
			// check if length is not 2 and continue
			if (inputArray.length != 2) {
				validInput = false;
				continue;
			}
			
			try {
				// try to parse string to in and clean whitespaces
				row = Integer.parseInt(inputArray[0].trim());
				column = Integer.parseInt(inputArray[1].trim());
				
				// check if row and column within range
				if (row < 0 || row > 9 || column < 0 || column > 9) {
					validInput = false;
					continue;
				}
				
				// update response array
				response[0] = row;
				response[1] = column;
				
				// update valid input to true to stop while loop
				validInput = true;
			} catch (NumberFormatException e) {
				// continue loop again
				validInput = false;
				continue;
			}
			
		}
	
		return response;
	}
	
	void printSummary(Ocean ocean) {
		System.out.println("You won! you sank all the ships!");
		System.out.println("The number of shots fired " + ocean.getShotsFired());
		System.out.println("The number of hits made " + ocean.getHitCount());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BattleshipGame().run();
	}
	
	void run() {
		Scanner scanner = new Scanner(System.in);
		
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		boolean isGameOver = ocean.isGameOver();
		
		while(!isGameOver) {
			ocean.printWithShips();
			ocean.print();
			
			// give summary
			System.out.println("The number of shots fired " + ocean.getShotsFired());
			// ask for row and column
			int[] userInput = this.getUserRowColumnInput(scanner);
			// take shot
			if (ocean.shootAt(userInput[0], userInput[1])) {
				System.out.println("You hit a ship!, keep going!");
			} else {
				System.out.println("You missed, try again.");
			}
			
			isGameOver = ocean.isGameOver();
		}
		
		scanner.close();
		
		// make a printGameSummary method
		this.printSummary(ocean);
	}
}
