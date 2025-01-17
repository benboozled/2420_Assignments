package a04;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;

@SuppressWarnings("unused")
public class BoardTest {
	
//weird boards
	Board testBoard00;														//null
	Board testBoardN222 = new Board(new int[][]{{1,2},{3,0}});				//2x2
	Board testBoardN333b = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//same block positions N311
	Board testBoardPZ05 = new Board(new int[][]{{4,1,3},{0,2,6},{7,5,8}});	//same as puzzle05.txt
	private String file = "/A04Tests/puzzle00.txt";
	Board fileBoard = BoardApp.readBoard(file);								//board from file specified above

//no inversions
	Board testBoardN333 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//basic solved board
	Board testBoardN322 = new Board(new int[][]{{1,2,3},{4,0,5},{6,7,8}});	//2,2 block open;6 manhattan;4 ham
	Board testBoardN311 = new Board(new int[][]{{0,1,2},{5,3,4},{6,7,8}});	//1,1 block open;12 manhattan;8 ham		
	
//neighbor tests
	//testBoardN322 neighbors
	Board testBoardN322up = new Board(new int[][]{{1,0,3},{4,2,5},{6,7,8}});//open up
	Board testBoardN322rt = new Board(new int[][]{{1,2,3},{4,5,0},{6,7,8}});//open right
	Board testBoardN322dn = new Board(new int[][]{{1,2,3},{4,7,5},{6,0,8}});//open down
	Board testBoardN322lf = new Board(new int[][]{{1,2,3},{0,4,5},{6,7,8}});//open left
	//testBoardN333 neighbors
	Board testBoardN333up = new Board(new int[][]{{1,2,3},{4,5,0},{7,8,6}});//open up
	Board testBoardN333lf = new Board(new int[][]{{1,2,3},{4,5,6},{7,0,8}});//open left

//inversion tests
	//odd inversions, odd board
	Board inversionN333i1 = new Board(new int[][]{{1,2,3},{4,5,6},{8,7,0}});//1 inversion
	Board inversionN322i3 = new Board(new int[][]{{1,2,3},{4,0,6},{8,5,7}});//3 inversions
	//even inversions, even board
	Board inversionN422i6 = new Board(new int[][]
			{{1,2,3,4},{5,0,6,8},{9,10,7,11},{13,14,15,12}});				//6 inversions
	Board inversionN433i3 = new Board(new int[][]
			{{1,2,3,4},{5,6,7,8},{9,10,0,11},{13,14,15,12}});				//3 inversions
	//odd inversions, even board
	Board inversionN442i3 = new Board(new int[][]
			{{1,2,3,4},{5,6,7,0},{8,9,10,11},{13,14,15,12}});				//3 inversions

//ad hoc boards
	Board jTest = new Board(new int[][] {{8, 1, 3},{4, 0, 2},{7, 6, 5}});	//Jasmin's test board
	Board solutionTest = BoardApp.readBoard("/A04Tests/puzzle04.txt");		//4 move board from test files
			//	3
			//	0 1 3	<----------------------------------------------     //board from the file
			//	4 2 5
			//	7 8 6														 //moves to solve....
	Board solution1 = new Board(new int[][] {{1, 0, 3},{4, 2, 5},{7, 8, 6}});//Move 1
	Board solution2 = new Board(new int[][] {{1, 2, 3},{4, 0, 5},{7, 8, 6}});//Move 2
	Board solution3 = new Board(new int[][] {{1, 2, 3},{4, 5, 0},{7, 8, 6}});//Move 3
	Board solution4 = new Board(new int[][] {{1, 2, 3},{4, 5, 6},{7, 8, 0}});//Move 4
	

//	@Test
//	public void testSolution() {
//		
//		Stack<Board> solutionStack = new Stack<Board>();
//		solutionStack.push(solution4);
//		solutionStack.push(solution3);
//		solutionStack.push(solution2);
//		solutionStack.push(solution1);
//		
//		//assertEquals(true,
//		
//		
////		Solver solver = new Solver(solutionTest);
////		for (Board board : solver.solution()) {
////			System.out.println(board);
////		}
//		
//	}
	
/*
	@Test
	public void testIsSolvable() {
	StdOut.println("ASSERT SOLVABLE======================================================================");
	//StdOut.println("\nshould be solvable");
	StdOut.println("Board: "+inversionN442i3.toString());
	//inversionN442i3.isSolvable();
	assertEquals(true, inversionN442i3.isSolvable());
	//from instructions
	StdOut.println("\n\nJTEST==============================");
	StdOut.println("Board: "+jTest.toString());
	jTest.isSolvable();
	assertEquals(true, jTest.isSolvable());
	StdOut.println("JTEST==============================\n\n");
	
	//StdOut.println("should be solvable because even rows, no inversions");
	StdOut.println("Board: "+testBoardN322.toString());
	assertEquals(true, testBoardN322.isSolvable());		//blank row: 2, inversions: 0
	StdOut.println("Board: "+testBoardN333.toString());
	assertEquals(true, testBoardN333.isSolvable());		//blank row: 3, inversions: 0
	
	StdOut.println("\n\n\nASSERT NOT SOLVABLE=====================================================================");	
	//StdOut.println("should be unsolvable because odd board size w/ inversions");
	StdOut.println("Board: "+inversionN333i1.toString());
	assertEquals(false, inversionN333i1.isSolvable());	//blank row: 3, inversions: 1
	StdOut.println("Board: "+inversionN322i3.toString());
	assertEquals(false, inversionN322i3.isSolvable());	//blank row: 2, inversions: 3

	//StdOut.println("\nshould be unsolvable because blank row + inversions is odd");
	StdOut.println("Board: "+inversionN422i6.toString());
	assertEquals(false, inversionN422i6.isSolvable());	//blank row: 1, inversions: 6
	StdOut.println("Board: "+inversionN433i3.toString());
	assertEquals(false, inversionN433i3.isSolvable());	//blank row: 2, inversions: 3
	StdOut.println("================================================================================");
	}

*/	
	
	@Test
	public void performanceTests() {
		
		long period0 = System.currentTimeMillis();
		
//		SolverVisualizer.animateBoard("/A04Tests/puzzle30.txt");
		
		Solver solve1 = new Solver(BoardApp.readBoard("/A04Tests/puzzle28.txt"));
		long period1 = System.currentTimeMillis();
		StdOut.println("/A04Tests/puzzle28.txt");
		System.out.printf("Runtime: %.3f \n", (period1 - period0) / 1000.0);
		System.out.printf("Moves: %d\n\n\n", solve1.moves());		
		
		Solver solve2 = new Solver(BoardApp.readBoard("/A04Tests/puzzle30.txt"));
		long period2 = System.currentTimeMillis();
		StdOut.println("/A04Tests/puzzle30.txt");
		System.out.printf("Runtime: %.3f \n", (period2 - period1) / 1000.0);
		System.out.printf("Moves: %d\n\n\n", solve2.moves());		
		
//-----------------STACK OVERFLOW--------------------------------------------------------
		
		
//		Solver solve3 = new Solver(BoardApp.readBoard("/A04Tests/puzzle32.txt"));
//		StdOut.println("/A04Tests/puzzle32.txt");
//		long period3 = System.currentTimeMillis();
//		System.out.printf("Runtime: %.3f \n", (period3 - period0) / 1000.0);
//		System.out.printf("Moves: %d\n\n\n", solve3.moves());
		
		

//		Solver solve4 = new Solver(BoardApp.readBoard("/A04Tests/puzzle34.txt"));
//		StdOut.println("/A04Tests/puzzle34.txt");
//		long period4 = System.currentTimeMillis();
//		System.out.printf("Runtime: %.3f \n", (period4 - period3) / 1000.0);
//		System.out.printf("Moves: %d\n\n\n", solve4.moves());	
//		
//		Solver solve5 = new Solver(BoardApp.readBoard("/A04Tests/puzzle36.txt"));
//		StdOut.println("/A04Tests/puzzle36.txt");
//		long period5 = System.currentTimeMillis();
//		System.out.printf("Runtime: %.3f \n", (period5 - period4) / 1000.0);
//		System.out.printf("Moves: %d\n\n\n", solve5.moves());	
//		
//		Solver solve6 = new Solver(BoardApp.readBoard("/A04Tests/puzzle38.txt"));
//		StdOut.println("/A04Tests/puzzle38.txt");
//		long period6 = System.currentTimeMillis();
//		System.out.printf("Runtime: %.3f \n", (period6 - period5) / 1000.0);
//		System.out.printf("Moves: %d\n\n\n", solve6.moves());	
//		
//		Solver solve7 = new Solver(BoardApp.readBoard("/A04Tests/puzzle40.txt"));
//		StdOut.println("/A04Tests/puzzle40.txt");
//		long period7 = System.currentTimeMillis();
//		System.out.printf("Runtime: %.3f \n", (period7 - period2) / 1000.0);
//		System.out.printf("Moves: %d\n\n\n", solve7.moves());	
//		
//		Solver solve8 = new Solver(BoardApp.readBoard("/A04Tests/puzzle42.txt"));
//		StdOut.println("/A04Tests/puzzle42.txt");
//		long period8 = System.currentTimeMillis();
//		System.out.printf("Runtime: %.3f \n", (period8 - period7) / 1000.0);
//		System.out.printf("Moves: %d\n\n\n", solve8.moves());	
	}
	

	@Test
	public void testNeighbors() {
		List<Board> tbN322rray = new ArrayList<Board>();
		for (Board el : testBoardN322.neighbors()){
			tbN322rray.add(el);
		}
		assertEquals(true, tbN322rray.get(0).equals(testBoardN322up));
		assertEquals(true, tbN322rray.get(1).equals(testBoardN322rt));
		assertEquals(true, tbN322rray.get(2).equals(testBoardN322dn));
		assertEquals(true, tbN322rray.get(3).equals(testBoardN322lf));
		
		List<Board> tbN333rray = new ArrayList<Board>();
		for (Board el : testBoardN333.neighbors()){
			tbN333rray.add(el);
		}
		assertEquals(true, tbN333rray.get(0).equals(testBoardN333up));
		assertEquals(true, tbN333rray.get(1).equals(testBoardN333lf));
		
//-----------------------TEST PROTOTYPE-----------------------------------------
//		for (Board el : testBoardN322.neighborsTEST()){
//			tbN322rray.add(el);
//		}
//		assertEquals(true, tbN322rray.get(0).equals(testBoardN322up));
//		assertEquals(true, tbN322rray.get(1).equals(testBoardN322rt));
//		assertEquals(true, tbN322rray.get(2).equals(testBoardN322dn));
//		assertEquals(true, tbN322rray.get(3).equals(testBoardN322lf));
		
	}

/*
	@Test
	public void testMoves() {
		Solver solve30 = new Solver(BoardApp.readBoard("/A04Tests/puzzle30.txt"));
		assertEquals(true, solve30.moves() == 30);
		Solver solve32 = new Solver(BoardApp.readBoard("/A04Tests/puzzle32.txt"));
		assertEquals(true, solve32.moves() == 32);
		Solver solve34 = new Solver(BoardApp.readBoard("/A04Tests/puzzle34.txt"));
		assertEquals(true, solve34.moves() == 34);
		Solver solve36 = new Solver(BoardApp.readBoard("/A04Tests/puzzle36.txt"));
		assertEquals(true, solve36.moves() == 36);
	}
	
*/	
	
	@Test
	public void testManhattan() {
		assertEquals(true, testBoardN333.manhattan()==0);	//0 manhattan distance
		assertEquals(true, testBoardN333b.manhattan()==0);	//0 manhattan distance
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
		assertEquals(true, testBoardN333.equals(testBoardN333b));	//has the same block positions
	}
	
	@Test
	public void testToString() {
		String testBoardN201string = "2"+"\n"+" 1  2 "+"\n"+" 3  0 "+"\n";
		assertEquals(true, testBoardN222.toString().contentEquals(testBoardN201string));
	}

}
