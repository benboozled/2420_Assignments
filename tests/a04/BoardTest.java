package a04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

@SuppressWarnings("unused")
public class BoardTest {
	
	//weird boards
	Board testBoard00;														//null
	Board testBoardN201 = new Board(new int[][]{{1,2},{3,0}});				//2x2
	//functional boards
	Board testBoardN301 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//basic board
	Board testBoardN302 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//same block positions as above
	Board testBoardN303 = new Board(new int[][]{{1,2,3},{4,5,6},{7,0,8}});	//inverted blocks, unsolvable
	Board testBoardN304 = new Board(new int[][]{{1,2,3},{4,0,5},{6,7,8}});	//center block open
	Board testBoardN305 = new Board(new int[][]{{0,1,2},{5,3,4},{6,7,8}});	//pure ham, baby. 
	
	@Test
	public void testHamming() {
		assertEquals(true, testBoardN301.hamming()==0);		//0 blocks out of place
		assertEquals(true, testBoardN304.hamming()==4);		//4 blocks out of place
		assertEquals(true, testBoardN305.hamming()==8);		//8 blocks out of place
	}	
	
	@Test (expected = IllegalArgumentException.class)
	public void testBoardConstructor() {
		Board testBoardN2401 = new Board(new int[][]{{1,2,3,4},{5,6,7,0}});	//2x4 throws illegal argument
	}
	
	@Test
	public void testSize() {
		assertEquals(true, testBoardN301.size()==3);	//3x3 board has size 3
	}

	@Test
	public void testEqualsObject() {
		assertEquals(false, testBoardN301.equals(testBoard00));		//not null board
		assertEquals(true, testBoardN301.equals(testBoardN301));	//is itself
		assertEquals(false, testBoardN301.equals(testBoardN302));	//not just same block positions
	}
	
	@Test
	public void testToString() {
		String testBoardN201string = "2"+"\n"+" 1  2 "+"\n"+" 3  0 "+"\n";
		assertEquals(true, testBoardN201.toString().contentEquals(testBoardN201string));
//		StdOut.println("testBoardN201.toString: \n"+testBoardN201.toString());
//		StdOut.println("testBoardN201string: \n"+testBoardN201string);
	}

	
	/*
	@Test
	public void testIsGoal() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testManhattan() {
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
