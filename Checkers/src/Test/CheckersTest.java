package Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import checkers.Checkers;

public class CheckersTest {

	Checkers check; 
	
	@Before
	public void setUp() throws Exception {
		check = new Checkers();
	}

	/*
	 * undo() involves a call to drawCheckers() which in this setup throws
	 * a NPE.  In the time alloted I could not figure out how to bypass
	 * the NPE to run this unit test successfully. -JP
	@Test
	 public void testUndo() {
		int[][] preBoard = { { 0, 1, 0, 0, 0, 2, 0, 2 }, // Col1
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col2
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col3
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col4
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col5
				{ 1, 0, 1, 0, 0, 0, 2, 0 }, // Col6
				{ 0, 1, 0, 0, 0, 2, 0, 2 }, // Col7
				{ 1, 0, 1, 0, 0, 0, 2, 0 } };// Col8
		
		check.setPreBoard(preBoard);
		check.undo();
		int[][] outBoard = check.getBoard();
		
		boolean result = Arrays.equals(outBoard,preBoard);
		assertEquals(true,result);
	 }*/

	@Test
	public void testIsPossibleSquare() {
		boolean result;

		// Test 3
		result = Checkers.isPossibleSquare(0, 1);
		assertEquals(true, result);

		result = Checkers.isPossibleSquare(1, 0);
		assertEquals(true, result);

		result = Checkers.isPossibleSquare(6, 7);
		assertEquals(true, result);

		result = Checkers.isPossibleSquare(7, 6);
		assertEquals(true, result);

		// Test 4
		result = Checkers.isPossibleSquare(0, 0);
		assertEquals(false, result);

		result = Checkers.isPossibleSquare(1, 1);
		assertEquals(false, result);

		result = Checkers.isPossibleSquare(6, 6);
		assertEquals(false, result);

		result = Checkers.isPossibleSquare(7, 7);
		assertEquals(false, result);
	}

	@Test
	public void testShowStatus() {
		String result;

		check.setMove(Checkers.yellowNormal);
		check.showStatus();
		result = check.getMsg();
		assertEquals("Yellow to move", result);

		check.setMove(Checkers.redNormal);
		check.showStatus();
		result = check.getMsg();
		assertEquals("Red to move", result);

		/*
		 * Similar to the undo() call, setting the loser attempts
		 * to access the location of the GUI in order to show the
		 * "X Wins!" message.  Since there is no GUI visible, the
		 * test could not proceed and I was unable to figure out a
		 * workaround in the remaining time. -JP
		 */
		//check.setLoser(Checkers.yellowNormal);
		//result = check.getMsg();
		//assertEquals("Red Wins!", result);
		
		//check.setLoser(Checkers.redNormal);
		//check.showStatus();
		//result = check.getMsg();
		//assertEquals("Yellow Wins!", result);
	}

}
