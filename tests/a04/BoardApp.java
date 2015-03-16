package a04;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class BoardApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Board testBoardN333 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});	//basic solved board
		Board testBoardN322 = new Board(new int[][]{{1,2,3},{4,0,5},{6,7,8}});	//2,2 block open;6 manhattan;4 ham
		Board testBoardN311 = new Board(new int[][]{{0,1,2},{5,3,4},{6,7,8}});	//1,1 block open;12 manhattan;8 ham
    	String file = "/A04Tests/puzzle05.txt";
    	Board fileBoard = BoardApp.readBoard(file);
    	
    	traceBoard(fileBoard);
    	traceBoard(testBoardN322);
	}
	
	public static void traceBoard(Board brd){
		long startTime = System.currentTimeMillis();			//get the system time at start of method
		StdOut.print(brd.toString());							//print the board
		StdOut.println("hamming: "+brd.hamming());				//print the hamming result
		StdOut.println("manhattan: "+brd.manhattan());			//print the manhattan result
		long endTime   = System.currentTimeMillis();			//get the system time at end of method
		long totalTime = endTime - startTime;					//difference between start and end
		System.out.println("runtime: "+totalTime/1000.0);		//print time to perform hamming, manahattan															
		StdOut.println("---------------------------------");
	}

	public static Board readBoard(String inputFile){
		In in = new In(inputFile);					//Create new In Object for puzzle txt file
		int N = in.readInt();						//Make the first line the board dimensions
		int[][] boardFile = new int[N][N];			//Declare 2D array
		for (int i = 0; i < N; i++) {				//for each row...
			for (int j = 0; j < N; j++) {			//for each column...
				boardFile[i][j] = in.readInt();		//add the next int from the file
			}
		}
		return new Board(boardFile);				//return a new board made with the 2D array 
	}

}
