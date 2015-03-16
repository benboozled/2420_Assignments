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
		long startTime = System.currentTimeMillis();
		StdOut.print(brd.toString());
		StdOut.println("hamming: "+brd.hamming());
		StdOut.println("manhattan: "+brd.manhattan());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("runtime: "+totalTime/1000.0);
		StdOut.println("---------------------------------");
	}

	public static Board readBoard(String inputFile){
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

}
