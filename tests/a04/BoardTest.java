package a04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class BoardTest {
	
	Board testBoard00;
	
	Board testBoardN201 = new Board(new int[][]{{1,2},{3,0}});//N2
	
	Board testBoardN301 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});//basic board
	Board testBoardN302 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});//same block positions
	Board testBoardN303 = new Board(new int[][]{{1,2,3},{4,5,6},{7,0,8}});//inverted blocks,unsolvable
	Board testBoardN304 = new Board(new int[][]{{1,2,3},{4,0,5},{6,7,8}});//center block open

	@Test
	public void testSize() {
		assertEquals(true, testBoardN301.size()==3);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(false, testBoardN301.equals(testBoard00));//test against null board
		assertEquals(true, testBoardN301.equals(testBoardN301));//test against self
		assertEquals(false, testBoardN301.equals(testBoardN302));//test against board with same block positions
	}
	
	@Test
	public void testToString() {
		String testBoardN201string = "2"+"\n"+" 1  2 "+"\n"+" 3  0 "+"\n";
		StdOut.println("testBoardN201.toString: \n"+testBoardN201.toString());
		StdOut.println("testBoardN201string: \n"+testBoardN201string);
		assertEquals(true, testBoardN201.toString().contentEquals(testBoardN201string));
	}
	
	
	/*
	@Test
	public void testHamming() {
		fail("Not yet implemented");
	}

	@Test
	public void testManhattan() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGoal() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSolvable() {
		fail("Not yet implemented");
	}

	@Test
	public void testNeighbors() {
		fail("Not yet implemented");
	}
*/


}
