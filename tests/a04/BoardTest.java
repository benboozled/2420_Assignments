package a04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import autocomplete.Autocomplete;
import autocomplete.Term;
import autocomplete.TermTest;
import edu.princeton.cs.introcs.BinaryIn;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdArrayIO;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

@SuppressWarnings("unused")
public class BoardTest {
	
	private static String file = "/A04Tests/puzzle10.txt";
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//weird boards
	Board testBoard00;														//null
	Board testBoardN222 = new Board(new int[][]{{1,2},{3,0}});				//2x2
	Board testBoardN323u = new Board(new int[][]{{1,2,3},{4,5,6},{7,0,8}});	//inverted blocks, unsolvable
	Board testBoardN333b = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//same block positions N301
	Board fileBoard = boardReader(file);									//board from file specified above
	//functional boards 
	Board testBoardN333 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//basic solved board
	Board testBoardN322 = new Board(new int[][]{{1,2,3},{4,0,5},{6,7,8}});	//2,2 block open;6 manhattan;4 ham
	Board testBoardN311 = new Board(new int[][]{{0,1,2},{5,3,4},{6,7,8}});	//1,1 block open;12 manhattan;8 ham
	
	@Test
	public void testBoardReader(){
		StdOut.println(file);
		StdOut.print(boardReader(file).toString());
		StdOut.println("hamming: "+fileBoard.hamming());
		StdOut.println("manhattan: "+fileBoard.manhattan());
	}
	
	@Test
	public void testManhattan() {
		assertEquals(true, testBoardN333.manhattan()==0);	//0 manhattan distance
		assertEquals(true, testBoardN333b.manhattan()==0);	//0 manhattan distance
		assertEquals(true, testBoardN323u.manhattan()==1);	//1 manhattan distance	
		assertEquals(true, testBoardN322.manhattan()==6);	//6 manhattan distance	
		assertEquals(true, testBoardN311.manhattan()==12);	//12 manhattan distance	
	}
	
	@Test
	public void testHamming() {
		assertEquals(true, testBoardN333.hamming()==0);		//0 blocks out of place
		assertEquals(true, testBoardN322.hamming()==4);		//4 blocks out of place
		assertEquals(true, testBoardN311.hamming()==8);		//8 blocks out of place
	}	
	
	@Test (expected = IllegalArgumentException.class)
	public void testBoardConstructor() {
		Board testBoardN2401 = new Board(new int[][]{{1,2,3,4},{5,6,7,0}});	//2x4 throws illegal argument
	}
	
	@Test
	public void testSize() {
		assertEquals(true, testBoardN333.size()==3);	//3x3 board has size 3
	}

	@Test
	public void testEqualsObject() {
		assertEquals(false, testBoardN333.equals(testBoard00));		//not null board
		assertEquals(true, testBoardN333.equals(testBoardN333));	//is itself
		assertEquals(false, testBoardN333.equals(testBoardN333b));	//not just same block positions
	}
	
	@Test
	public void testToString() {
		String testBoardN201string = "2"+"\n"+" 1  2 "+"\n"+" 3  0 "+"\n";
		assertEquals(true, testBoardN222.toString().contentEquals(testBoardN201string));
	}

	private Board boardReader(String inputFile){
		In in = new In(inputFile);
		int N = in.readInt();
		int[][] boardFile = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boardFile[i][j] = in.readInt();
			}
		}
		return new Board(boardFile);
	}
	
	/*
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
