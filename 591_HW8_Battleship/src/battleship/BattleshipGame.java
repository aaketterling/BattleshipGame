/*
 * Adam Ketterling and Armand Aquino worked on homework together
 * We are submitting the same code
 */

package battleship;

import java.util.Scanner;

/**
 * BattleshipGame is a class to play a simple version of the game Battleship We
 * will be doing just a one-player vs. computer version, where the computer
 * places the ships, and the human attempts to sink them.
 */

public class BattleshipGame {
	// helper to get user input
	/**
	 * Helper method to get player input for row and column for shootAt method
	 * 
	 * @param scanner to get user input
	 * @return array of integers of length 2. first element is row, second element
	 *         is column
	 */
	int[] getUserRowColumnInput(Scanner scanner) {
		// variables for response
		int[] response = new int[2];
		int row;
		int column;
		// will use in while loop until we get valid input
		boolean validInput = false;
		while (!validInput) {
			// ask user for row and column
			System.out.print("Enter row,column: ");

			// get input as string, trim leading and trailing whitespaces
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

	/**
	 * Prints message of the game when it is over and some stats of your game
	 * 
	 * @param ocean the ocean with the ships that has information on the game
	 * @return nothing. no-op
	 */
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
		// for getUserRowColumnInput method
		Scanner scanner = new Scanner(System.in);

		// create instance of ocean and place ships randomly for the game
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		// for while loop. it will be false when first initialized
		boolean isGameOver = ocean.isGameOver();

		// keep playing until game is over. when all ships sank. there are 10 ships
		while (!isGameOver) {
			// for debugging only
			ocean.printWithShips();
			// show sea
			ocean.print();

			// give summary of how many shots fired so far
			System.out.println("Shots fired: " + ocean.getShotsFired());
			// ask for row and column
			int[] userInput = this.getUserRowColumnInput(scanner);
			// take shot
			if (ocean.shootAt(userInput[0], userInput[1])) {
				// display message if the shot hit a ship or sunk it

				// get ship
				Ship ship = ocean.getShipArray()[userInput[0]][userInput[1]];

				if (ship.isSunk()) {
					System.out.println("You sunk a ship (" + ship.getShipType() + ")!");

				} else {
					System.out.println("You hit a ship!, keep going!");
				}
			} else {
				// display message if the missed and did not hit a ship
				System.out.println("You missed, try again.");
			}

			// create blank line
			System.out.println();

			// check if you the last ship after you made a shot
			isGameOver = ocean.isGameOver();
		}

		scanner.close();

		// make a printGameSummary method
		this.printSummary(ocean);
	}
}
