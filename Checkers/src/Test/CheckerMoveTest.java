package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Vector;
import java.util.Arrays;
import java.util.Enumeration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import checkers.CheckerMove;
import checkers.Checkers;

public class CheckerMoveTest {

	CheckerMove checker = new CheckerMove();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIndex() {
		int[] result = new int[2];

		// Test Case 1
		result = CheckerMove.getIndex(1, 1);
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);

		// Test Case 2
		result = CheckerMove.getIndex(1, 399);
		assertEquals(0, result[0]);
		assertEquals(7, result[1]);

		// Test Case 3
		result = CheckerMove.getIndex(399, 399);
		assertEquals(7, result[0]);
		assertEquals(7, result[1]);

		// Test Case 4
		result = CheckerMove.getIndex(399, 1);
		assertEquals(7, result[0]);
		assertEquals(0, result[1]);

		// Test Case 5
		result = CheckerMove.getIndex(400, 1);
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);

		// Test Case 6
		result = CheckerMove.getIndex(1, 400);
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
	}

	@Test
	public void testNoMovesLeft() {

		boolean result;

		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		int[][] boardNoMoves = { { 0, 0, 1, 0, 2, 0, 2, 0 }, // Col1
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col2
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col3
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col4
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col5
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col6
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col7
				{ 0, 1, 0, 1, 0, 2, 0, 0 } }; // Col8

		int[][] boardCap = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 0, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 1, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 2, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 0, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		// Test 7
		result = CheckerMove.noMovesLeft(boardNoMoves, Checkers.redNormal);
		assertEquals(true, result);

		// Test 8
		result = CheckerMove.noMovesLeft(boardCap, Checkers.redNormal);
		assertEquals(false, result);

		// Test 9
		result = CheckerMove.noMovesLeft(board, Checkers.redNormal);
		assertEquals(false, result);

		// Test 10
		result = CheckerMove.noMovesLeft(boardNoMoves, Checkers.yellowNormal);
		assertEquals(true, result);

		// Test 11
		result = CheckerMove.noMovesLeft(boardCap, Checkers.yellowNormal);
		assertEquals(false, result);

		// Test 12
		result = CheckerMove.noMovesLeft(board, Checkers.yellowNormal);
		assertEquals(false, result);
	}

	@Test
	public void testApplyMove() {

		int result = 0;
		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		int[][] boardNoMoves = { { 0, 0, 1, 0, 2, 0, 2, 0 }, // Col1
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col2
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col3
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col4
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col5
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col6
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col7
				{ 0, 1, 0, 1, 0, 2, 0, 0 } }; // Col8

		// Test 13
		result = CheckerMove.ApplyMove(boardNoMoves, 1, 3, 2, 4);
		assertEquals(CheckerMove.illegalMove, result);

		// Test 14
		result = CheckerMove.ApplyMove(board, 1, 2, 2, 3);
		assertEquals(CheckerMove.legalMove, result);
	}

	@Test
	public void testIsMoveLegal() {
		int result = 0;
		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		int[][] boardNoMoves = { { 0, 0, 1, 0, 2, 0, 2, 0 }, // Col1
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col2
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col3
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col4
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col5
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col6
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col7
				{ 0, 1, 0, 1, 0, 2, 0, 0 } }; // Col8

		// Test 15
		result = CheckerMove.isMoveLegal(boardNoMoves, 2, 2, 3, 3, Checkers.yellowNormal);
		assertEquals(CheckerMove.illegalMove, result);

		// Test 16
		result = CheckerMove.isMoveLegal(board, 1, 2, 2, 3, Checkers.yellowNormal);
		assertEquals(CheckerMove.legalMove, result);
	}

	@Test
	public void testIsWalkLegal() {
		int result = 0;
		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		int[][] boardNoMoves = { { 0, 0, 1, 0, 2, 0, 2, 0 }, // Col1
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col2
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col3
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col4
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col5
				{ 0, 1, 0, 1, 0, 2, 0, 0 }, // Col6
				{ 0, 0, 1, 0, 2, 0, 2, 0 }, // Col7
				{ 0, 1, 0, 1, 0, 2, 0, 0 } }; // Col8

		// Test 15
		result = CheckerMove.isWalkLegal(boardNoMoves, 2, 2, 3, 3);
		assertEquals(CheckerMove.illegalMove, result);

		// Test 16
		result = CheckerMove.isWalkLegal(board, 1, 2, 2, 3);
		assertEquals(CheckerMove.legalMove, result);
	}

	@Test
	public void testCanWalk() {
		boolean result;

		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 0, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 1, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 2, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 0, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		// Test 30
		result = CheckerMove.canWalk(board, 1, 2);
		assertEquals(true, result);

		// Test 31
		result = CheckerMove.canWalk(board, 0, 1);
		assertEquals(false, result);
	}

	@Test
	public void testCanCaptureIntArrayArrayInt() {
		boolean result;

		int[][] boardInit = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 0, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 1, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 2, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 0, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		// Test 23
		result = CheckerMove.canCapture(boardInit, Checkers.redNormal);
		assertEquals(false, result);

		// Test 24
		result = CheckerMove.canCapture(board, Checkers.redNormal);
		assertEquals(true, result);

		// Test 25
		result = CheckerMove.canCapture(boardInit, Checkers.yellowNormal);
		assertEquals(false, result);

		// Test 26
		result = CheckerMove.canCapture(board, Checkers.yellowNormal);
		assertEquals(true, result);
	}

	@Test
	public void testCanCaptureIntArrayArrayIntInt() {
		boolean result;

		int[][] boardInit = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 0, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 1, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 2, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 0, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		// Test 27
		result = CheckerMove.canCapture(board, 1, 2);
		assertEquals(false, result);

		// Test 28
		result = CheckerMove.canCapture(board, 1, 2);
		assertEquals(false, result);

		// Test 29
		result = CheckerMove.canCapture(board, 4, 3);
		assertEquals(true, result);
	}

	@Test
	public void testIsEmpty() {
		boolean result;

		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		// Test 19
		result = CheckerMove.isEmpty(board, 0, 3);
		assertEquals(true, result);

		// Test 20
		result = CheckerMove.isEmpty(board, 0, 1);
		assertEquals(false, result);
	}

	@Test
	public void testColour() {
		int result = 0;

		// Test 21
		result = CheckerMove.colour(Checkers.yellowNormal);
		assertEquals(Checkers.yellowNormal, result);

		result = CheckerMove.colour(Checkers.yellowKing);
		assertEquals(Checkers.yellowNormal, result);

		// Test 22
		result = CheckerMove.colour(Checkers.redNormal);
		assertEquals(Checkers.redNormal, result);

		result = CheckerMove.colour(Checkers.redKing);
		assertEquals(Checkers.redNormal, result);
	}

	@Test
	public void testInRange() {
		boolean result;

		// Test 32
		result = CheckerMove.inRange(0, 0);
		assertEquals(true, result);

		// Test 33
		result = CheckerMove.inRange(7, 7);
		assertEquals(true, result);

		// Test 34
		result = CheckerMove.inRange(-1, 7);
		assertEquals(false, result);

		// Test 35
		result = CheckerMove.inRange(8, 7);
		assertEquals(false, result);

		// Test 36
		result = CheckerMove.inRange(7, -1);
		assertEquals(false, result);

		// Test 37
		result = CheckerMove.inRange(7, 8);
		assertEquals(false, result);
	}

	@Test
	public void testGenerateMoves() {
		boolean result = true;

		int[][] board = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8

		Vector moves = new Vector();

		int[] ar1 = { 6, 5, 5, 4 };
		int[] ar2 = { 6, 5, 7, 4 };
		int[] ar3 = { 4, 5, 3, 4 };
		int[] ar4 = { 4, 5, 5, 4 };
		int[] ar5 = { 2, 5, 1, 4 };
		int[] ar6 = { 2, 5, 3, 4 };
		int[] ar7 = { 0, 5, 1, 4 };
		moves.add(ar1);
		moves.add(ar2);
		moves.add(ar3);
		moves.add(ar4);
		moves.add(ar5);
		moves.add(ar6);
		moves.add(ar7);

		Vector moves2 = CheckerMove.generateMoves(board, Checkers.yellowNormal);

		for (int i = 0; i < moves2.size(); i++) {

			int[] a1 = (int[]) moves.get(i);
			int[] a2 = (int[]) moves2.get(i);

			result = Arrays.equals(a1, a2);
			assertEquals(true, result);

		}

	}

}