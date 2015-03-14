package a04;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

	Board testBoardN301;
	int[][] solvedRrayN3 = new int[][]{{1,2,3},{4,5,6},{7,8,0}};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void testBoard() {
		testBoardN301 = new Board(solvedRrayN3);
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
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
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testNeighbors() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}*/

}
