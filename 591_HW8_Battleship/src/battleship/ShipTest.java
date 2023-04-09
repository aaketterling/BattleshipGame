package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

	Ocean ocean;
	Ship ship;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());

		// TODO
		// Test 2: test Cruiser getLength of different ship
		ship = new Cruiser();
		assertEquals(3, ship.getLength());

		// Test 3: test Submarine getLength of smallest ship
		ship = new Submarine();
		assertEquals(1, ship.getLength());
	}

	@Test
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());

		// TODO
		// Test 2: for Cruiser Placing different ship near boarder
		Ship cruiser = new Cruiser();
		row = 3;
		column = 2;
		horizontal = false;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, cruiser.getBowRow());

		// Test 3: for Destroyer placement in middle of board.
		Ship destroyer = new Destroyer();
		row = 5;
		column = 7;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, destroyer.getBowRow());
	}

	@Test
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());

		// TODO
		// Test 2: for Cruiser Placing different ship near boarder
		Ship cruiser = new Cruiser();
		row = 3;
		column = 2;
		horizontal = false;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		cruiser.setBowColumn(column);
		assertEquals(column, cruiser.getBowColumn());
		;

		// Test 3: for Destroyer placement in middle of board.
		Ship destroyer = new Destroyer();
		row = 5;
		column = 7;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		destroyer.setBowColumn(column);
		assertEquals(column, destroyer.getBowColumn());

	}

	@Test
	void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

		// TODO
		// Test 2: for Cruiser
		Ship cruiser = new Cruiser();
		boolean[] hitsCruiser = new boolean[3];
		assertArrayEquals(hitsCruiser, cruiser.getHit());
		assertFalse(cruiser.getHit()[0]);
		assertFalse(cruiser.getHit()[1]);

		// Test 3: for Destroyer
		Ship destroyer = new Destroyer();
		boolean[] hitsDestroyer = new boolean[2];
		assertArrayEquals(hitsDestroyer, destroyer.getHit());
		assertFalse(destroyer.getHit()[0]);
		assertFalse(destroyer.getHit()[1]);
	}

	@Test
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());

		// TODO
		// Test 2: Cruiser with lower case
		ship = new Cruiser();
		assertEquals("cruiser", ship.getShipType());

		// Test 3: Different ship Destroyer with lower case
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());
	}

	@Test
	void testIsHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());

		// TODO
		// Test 2: Cruiser if it is horizontal
		Ship cruiser = new Cruiser();
		int row1 = 0;
		int column1 = 4;
		boolean horizontal1 = true;
		cruiser.placeShipAt(row1, column1, horizontal1, ocean);
		assertTrue(cruiser.isHorizontal());

		// Test 3: Destroyer if it is horizontal
		Ship destroyer = new Destroyer();
		int row12 = 0;
		int column12 = 4;
		boolean horizontal12 = true;
		destroyer.placeShipAt(row12, column12, horizontal12, ocean);
		assertTrue(destroyer.isHorizontal());

	}

	@Test
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int rowrow = 0;
		battleship.setBowRow(rowrow);
		assertEquals(rowrow, battleship.getBowRow());

		// TODO
		// Test 2: Cruiser does this ship work with setBowRow
		Ship cruiser = new Cruiser();
		int rownew = 0;
		cruiser.setBowRow(rownew);
		assertEquals(rownew, cruiser.getBowRow());

		// Test 3: Destroyer does this ship work with setBowRow
		Ship destroyer = new Destroyer();
		int row0 = 0;
		destroyer.setBowRow(row0);
		assertEquals(row0, destroyer.getBowRow());

	}

	@Test
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int column = 4;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());

		// TODO
		// Test 2: Cruiser does this ship work with setBowColumn
		Ship cruiser = new Cruiser();
		int column1 = 4;
		cruiser.setBowColumn(column1);
		assertEquals(column1, cruiser.getBowColumn());

		// Test 3: Destroyer does this ship work with setBowColumn
		Ship destroyer1 = new Destroyer();
		int column2 = 4;
		destroyer1.setBowColumn(column2);
		assertEquals(column2, destroyer1.getBowColumn());
	}

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());

		// TODO
		// Test 2: Cruiser does this ship work with SetHorizontal
		Ship cruiser = new Cruiser();
		boolean horizontal1 = true;
		cruiser.setHorizontal(horizontal1);
		assertTrue(cruiser.isHorizontal());

		// Test 3: Destroyer does this ship work with SetHorizontal
		Ship destroyer1 = new Destroyer();
		boolean horizontal2 = true;
		destroyer1.setHorizontal(horizontal2);
		assertTrue(destroyer1.isHorizontal());

	}

	@Test
	void testOkToPlaceShipAt() {

		// test when other ships are not in the ocean
		Ship battleShip = new Battleship();
		Ocean battleShipOcean = new Ocean();
		battleShip.placeShipAt(0, 4, true, battleShipOcean); // horizontal
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleShip.okToPlaceShipAt(row, column, horizontal, battleShipOcean);
		assertFalse(ok, "OK to place ship here.");

		// Test 2: when placing a ship would cause an overlap with another ship
		Ship cruiser = new Cruiser();
		int row1 = 0;
		int column1 = 5;
		boolean horizontal1 = true;
		boolean ok1 = cruiser.okToPlaceShipAt(row1, column1, horizontal1, battleShipOcean);
		assertFalse(ok1, "Not OK to place ship here, would overlap another ship.");

		// Test 3: when placing a ship would cause it to touch another ship diagonally
		Ship destroyer = new Destroyer();
		row = 2;
		column = 2;
		horizontal = false;
		ok = destroyer.okToPlaceShipAt(row, column, horizontal, battleShipOcean);
		assertFalse(ok, "Not OK to place ship here, would touch another ship diagonally.");

		// test 4: place outside ocean dimensions row or column < 0 or > 9
		Ship submarine = new Submarine();
		assertFalse(submarine.okToPlaceShipAt(-1, 9, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(0, 10, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(-1, 10, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(10, 9, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(9, -1, true, ocean));
	}

	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {

		// test when other ships are in the ocean

		// place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		// test second ship
		Battleship battleship2 = new Battleship();
		row = 1;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");

		// TODO
		// Test 2:
		// place another ship which will go out of bounds.
		Battleship battleship3 = new Battleship();
		row = 1;
		column = 1;
		horizontal = true;
		boolean ok3 = battleship3.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok3, "Not OK to place ship it will go out of bounds.");

		// test 3: ship will be diagonally too close too other ship. This test affirms
		// diagonal checks are working
		Battleship battleship4 = new Battleship();
		row = 1;
		column = 8;
		horizontal = true;
		boolean ok5 = battleship4.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok5,
				"Not OK ship will be diagonally too close too other ship. This test affirms diagonal checks are working .");

		// test 4: place in an okay spot to make pass
		Battleship battleship5 = new Battleship();
		row = 5;
		column = 8;
		horizontal = true;
		boolean ok6 = battleship5.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok6, "Good place to put ship.");
	}

	@Test
	void testPlaceShipAt() {

		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);

		// TODO
		// Test 2: vertical placement
		Ship cruiser = new Cruiser();
		row = 3;
		column = 0;
		horizontal = false;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, cruiser.getBowRow());
		assertEquals(column, cruiser.getBowColumn());
		assertFalse(cruiser.isHorizontal());
		assertEquals(cruiser, ocean.getShipArray()[1][0]);

		// Test 3: edge case: placing a ship at the bottom-right corner of the ocean
		Ship submarine = new Submarine();
		row = 9;
		column = 9;
		horizontal = true; // or false, since it's a 1-length ship
		submarine.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, submarine.getBowRow());
		assertEquals(column, submarine.getBowColumn());
		assertTrue(submarine.isHorizontal());
		assertEquals(submarine, ocean.getShipArray()[9][9]);

	}

	@Test
	void testShootAt() {

		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);

		// Test when the ship is not hit
		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = { false, false, false, false };
		assertArrayEquals(hitArray0, battleship.getHit());

		// TODO
		// Test 2: when the ship is hit
		assertTrue(battleship.shootAt(0, 9));
		boolean[] hitArray1 = { true, false, false, false };
		assertArrayEquals(hitArray1, battleship.getHit());

		// Test 3: when the ship is sunk
		battleship.shootAt(0, 8);
		battleship.shootAt(0, 7);
		assertTrue(battleship.shootAt(0, 6));
		boolean[] hitArray2 = { true, true, true, true };
		assertArrayEquals(hitArray2, battleship.getHit());
	}

	@Test
	void testIsSunk() {

		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);

		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());

		// TODO
		// Test 2: when a ship is sunk after being hit multiple times
		Ship destroyer = new Destroyer();
		row = 6;
		column = 6;
		horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);

		assertFalse(destroyer.isSunk());
		assertTrue(destroyer.shootAt(6, 6));
		assertFalse(destroyer.isSunk());
		assertTrue(destroyer.shootAt(5, 6));
		assertTrue(destroyer.isSunk());

		// Test 3: when a ship is not sunk after being hit partially
		Ship cruiser = new Cruiser();
		row = 1;
		column = 3;
		horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);

		assertFalse(cruiser.isSunk());
		assertTrue(cruiser.shootAt(1, 3));
		assertFalse(cruiser.isSunk());

	}

	@Test
	void testToString() {

		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());

		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());

		// TODO
		// Test 2: when the ship has been hit only once (partially sunk)
		Ship cruiser = new Cruiser();
		row = 5;
		column = 5;
		horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		cruiser.shootAt(5, 5);
		assertEquals("x", cruiser.toString());

		// Test 3: when the ship has been completely sunk
		for (int i = 0; i < cruiser.getLength(); i++) {
			cruiser.shootAt(row, column - i);
		}
		assertEquals("s", cruiser.toString());
	}

}
