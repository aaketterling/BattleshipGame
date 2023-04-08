package battleship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {

	Ocean ocean;

	static int NUM_BATTLESHIPS = 1;
	static int NUM_CRUISERS = 2;
	static int NUM_DESTROYERS = 3;
	static int NUM_SUBMARINES = 4;
	static int OCEAN_SIZE = 10;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testEmptyOcean() {

		// tests that all locations in the ocean are "empty"

		Ship[][] ships = ocean.getShipArray();

		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];

				assertEquals("empty", ship.getShipType());
			}
		}

		assertEquals(0, ships[0][0].getBowRow());
		assertEquals(0, ships[0][0].getBowColumn());

		assertEquals(5, ships[5][5].getBowRow());
		assertEquals(5, ships[5][5].getBowColumn());

		assertEquals(9, ships[9][0].getBowRow());
		assertEquals(0, ships[9][0].getBowColumn());
	}

	@Test
	void testPlaceAllShipsRandomly() {

		// tests that the correct number of each ship type is placed in the ocean

		ocean.placeAllShipsRandomly();

		Ship[][] ships = ocean.getShipArray();
		ArrayList<Ship> shipsFound = new ArrayList<Ship>();

		int numBattlehips = 0;
		int numCruisers = 0;
		int numDestroyers = 0;
		int numSubmarines = 0;
		int numEmptySeas = 0;

		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				if (!shipsFound.contains(ship)) {
					shipsFound.add(ship);
				}
			}
		}

		for (Ship ship : shipsFound) {
			if ("battleship".equals(ship.getShipType())) {
				numBattlehips++;
			} else if ("cruiser".equals(ship.getShipType())) {
				numCruisers++;
			} else if ("destroyer".equals(ship.getShipType())) {
				numDestroyers++;
			} else if ("submarine".equals(ship.getShipType())) {
				numSubmarines++;
			} else if ("empty".equals(ship.getShipType())) {
				numEmptySeas++;
			}
		}

		assertEquals(NUM_BATTLESHIPS, numBattlehips);
		assertEquals(NUM_CRUISERS, numCruisers);
		assertEquals(NUM_DESTROYERS, numDestroyers);
		assertEquals(NUM_SUBMARINES, numSubmarines);

		// calculate total number of available spaces and occupied spaces
		int totalSpaces = OCEAN_SIZE * OCEAN_SIZE;
		int occupiedSpaces = (NUM_BATTLESHIPS * 4) + (NUM_CRUISERS * 3) + (NUM_DESTROYERS * 2) + (NUM_SUBMARINES * 1);

		// test number of empty seas, each with length of 1
		assertEquals(totalSpaces - occupiedSpaces, numEmptySeas);
	}

	@Test
	void testIsOccupied() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);

		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);

		Destroyer destroyer1 = new Destroyer();
		row = 8;
		column = 6;
		horizontal = false;
		destroyer1.placeShipAt(row, column, horizontal, ocean);

		assertTrue(ocean.isOccupied(1, 5));

		// TODO
		// two more tests
		// Test 2: That a spot in the ocean is empty.
		assertFalse(ocean.isOccupied(8, 8));

		// Test 3: Check new destroy's body is in the way
		assertTrue(ocean.isOccupied(7, 6));

	}

	@Test
	void testShootAt() {

		assertFalse(ocean.shootAt(0, 1));

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);

		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));

		// TODO
		// Test 2: Shooting at sunk ship should return false.
		Destroyer destroyernew = new Destroyer();
		int row1 = 3;
		int column1 = 3;
		boolean horizontal1 = true;
		destroyernew.placeShipAt(row1, column1, horizontal1, ocean);

		assertTrue(ocean.shootAt(3, 3));
		assertTrue(ocean.shootAt(3, 2));
		assertTrue(destroyernew.isSunk());

		// Shooting at a sunk ship should return false
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(3, 4));

		// Test 3: Tests if the shootAt method can handle shooting at multiple ships in
		// the ocean. If one ship is not sunk completely.
		Destroyer destroyer1 = new Destroyer();
		int row2 = 5;
		int column2 = 1;
		boolean horizontal2 = true;
		destroyer1.placeShipAt(row2, column2, horizontal2, ocean);

		Destroyer destroyer2 = new Destroyer();
		int row3 = 7;
		int column3 = 6;
		boolean horizontal3 = false;
		destroyer2.placeShipAt(row3, column3, horizontal3, ocean);

		assertTrue(ocean.shootAt(5, 1));
		assertFalse(ocean.shootAt(5, 2));
		assertFalse(destroyer1.isSunk());

		assertTrue(ocean.shootAt(7, 6));
		assertFalse(ocean.shootAt(8, 6));
		assertFalse(destroyer2.isSunk());

		// Test 4: shooting at an "EmptySea" ship should return false
		assertFalse(ocean.shootAt(9, 9));
	}

	@Test
	void testGetShotsFired() {

		// should be all false - no ships added yet
		assertFalse(ocean.shootAt(0, 1));
		assertFalse(ocean.shootAt(1, 0));
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(9, 9));
		assertEquals(4, ocean.getShotsFired());

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);

		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);

		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(6, ocean.getShotsFired());

		// TODO
		// Test 3: Test if shots fired counts shoots that happen in the same place as
		// prior to ships being added and after ships have been sunk.
		assertFalse(ocean.shootAt(0, 1));
		assertFalse(ocean.shootAt(1, 5));
		assertEquals(8, ocean.getShotsFired());
	}

	@Test
	void testGetHitCount() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);

		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());

		// TODO
		// Test 2: Fire another shot at the same spot
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(2, ocean.getHitCount()); // hitCount should increase

		Destroyer destroyer2 = new Destroyer();
		int row2 = 3;
		int column2 = 6;
		boolean horizontal2 = true;
		destroyer2.placeShipAt(row2, column2, horizontal2, ocean);

		// Test3: Fire a shot at the second ship
		assertTrue(ocean.shootAt(3, 6));
		assertFalse(destroyer2.isSunk());
		assertEquals(3, ocean.getHitCount()); // hitCount should increase

		// Test 4: Shooting an "EmptySea" ship should not increase hit count
		// shooting at empty sea should return false
		assertFalse(ocean.shootAt(9, 9));
		// should not increase hit count, should be same as test above that was the last
		// call to getHItCount
		assertEquals(3, ocean.getHitCount());
	}

	@Test
	void testGetShipsSunk() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);

		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());

		// TODO
		// Test 2: if works when ship is hit again is destroy sunk with 2 hits.
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());

		// Test 3: if more shoots are fired does the shootAT method add to getHitCount
		// or getShips Sunk?
		assertFalse(ocean.shootAt(0, 5));
		assertFalse(ocean.shootAt(3, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
	}

	@Test
	void testGetShipArray() {

		Ship[][] shipArray = ocean.getShipArray();
		assertEquals(OCEAN_SIZE, shipArray.length);
		assertEquals(OCEAN_SIZE, shipArray[0].length);

		assertEquals("empty", shipArray[0][0].getShipType());

		// TODO
		// More tests
		// Test 2: if getShipArray() returns the correct Ship array after placing a ship
		Ship battleship = new Battleship();
		battleship.placeShipAt(5, 5, true, ocean);
		Ship[][] updatedShipArray = ocean.getShipArray();
		assertEquals(battleship, updatedShipArray[5][5]);

		// Test 3: if getShipArray() allows modifications to the array by updating a
		// Ship object
		Ship cruiser = new Cruiser();
		updatedShipArray[3][3] = cruiser;
		Ship[][] modifiedShipArray = ocean.getShipArray();
		assertEquals(cruiser, modifiedShipArray[3][3]);
	}

}
