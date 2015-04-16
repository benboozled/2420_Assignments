package a04;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Jasmin Stefanussen
 * @author David Weber
 * @Source Sedgewick
 * @Date Created March 16, 2015 
 * Last modified: March 26, 2015 
 */

public class Board {

	private int N;
	private int[][] blocks;
	private int manhattanValue = -1;
	private int hammingValue = -1;

	/**
	 * construct a board from an N-by-N array of blocks where blocks[i][j] =
	 * block in row i, column j)
	 * 
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		if (blocks == null)
			throw new NullPointerException("Null pointer exception");
		if (blocks[0].length != blocks.length)
			throw new java.lang.IllegalArgumentException("Illegal arguments");
		this.N = blocks.length;
		this.blocks = blocks;
	}

	/**
	 * board size N
	 * 
	 * @return int N
	 */
	public int size() {
		return N;
	}

	/**
	 * number of blocks out of place
	 * 
	 * @return int hammingValue
	 */
	public int hamming() {

		if (hammingValue != -1) {
			return hammingValue;
		}

		int distance = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (blocks[i][j] != i * N + j + 1 && blocks[i][j] != 0)
					distance++;
			}
		}
		hammingValue = distance;
		return hammingValue;
	}

	/**
	 * sum of Manhattan distances between blocks and goal
	 * 
	 * @return int manhattanValue
	 */
	public int manhattan() {
		if (manhattanValue != -1) {
			return manhattanValue;
		}

		int distance = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (blocks[i][j] == 0)
					continue;
				
				int x;
				int y;
				
				if (blocks[i][j] % N == 0) {
					x = blocks[i][j] / N - 1;
					y = N - 1;
				} else {
					x = blocks[i][j] / N;
					y = blocks[i][j] % N - 1;
				}
				distance += Math.abs(i - x) + Math.abs(j - y);
			}
		}
		manhattanValue = distance;
		return manhattanValue;
	}

	/**
	 * is this board the goal board?
	 * 
	 * @return boolean 
	 */
	public boolean isGoal() {

		return manhattan() == 0;
	}

	/**
	 * is this board solvable?
	 * 
	 * @return boolean
	 */
	public boolean isSolvable() {

		Stack<Integer> blockStack = new Stack<Integer>();
		int inversions = 0;
		int blankRow = N;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (blocks[i][j] == 0) 			
					blankRow = i; 						
				if (blocks[i][j] != 0) 					
					blockStack.push(blocks[i][j]); 														
			}
		}

		for (int i = blockStack.size(); i > 1; i--) { 
			for (Integer el : blockStack)
				if (blockStack.peek() < el)
					inversions++;
			blockStack.pop(); 
		} 

		if (N % 2 == 1) 							// ODD board size
			return (inversions % 2) == 0; 	
		return (inversions + blankRow) % 2 == 1;	// EVEN board size
	}

	/**
	 * does this board equal y?
	 * 
	 * @param y
	 * @return boolean
	 */
	public boolean equals(Object y) {
		if (this == y)
			return true;
		if (y == null)
			return false;
		if (this.getClass() != y.getClass())
			return false;
		Board that = (Board) y;
		if (this.size() != that.size())
			return false;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (this.blocks[i][j] != that.blocks[i][j])
					return false;
			}
		}
		return true;
	}

  
  private int[][] exch(int newRow, int newCol, int blankRow, int blankCol){
  	int[][] t = new int[N][N];
  	for (int i = 0; i<N; i++)
  		for (int j = 0; j<N; j++)
  			t[i][j] = blocks[i][j];
  	t[blankRow][blankCol] = t[newRow][newCol]; 
  	t[newRow][newCol] = 0; 
  	return t;
  }
	
	public Iterable<Board> neighborsTEST()  {
		
		Queue<Board> neighbors = new Queue<Board>();
		
	  	int blankRow = 0;
	  	int blankCol = 0;
	  	
	  	for (int i = 0; i<N; i++)
	  		for (int j = 0; j<N; j++) {
	  			if (blocks[i][j] == 0){
		  			blankRow = i; 
		  			blankCol = j;
	  			}
	  		}
		if (blankRow >= 0)
		neighbors.enqueue(new Board(exch(blankRow-1,blankCol,blankRow,blankCol)));//up
		
		if (blankCol <= N)
		neighbors.enqueue(new Board(exch(blankRow,blankCol+1,blankRow,blankCol)));//right
		
		if (blankRow <= N)
		neighbors.enqueue(new Board(exch(blankRow+1,blankCol,blankRow,blankCol)));//down
		
		if (blankCol >= 0)
		neighbors.enqueue(new Board(exch(blankRow,blankCol-1,blankRow,blankCol)));//left
		
		return neighbors;  	
	}
	
	/**
	 * all neighboring boards
	 * 
	 * @return Iterable<Board>
	 */
	public Iterable<Board> neighbors() {

		Queue<Board> neighbors = new Queue<Board>();
		int blankRow = 0;
		int blankColumn = 0;

		// for loop to find the blank block
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (blocks[i][j] != 0)
					continue;
				else {
					blankRow = i;
					blankColumn = j;
				}
			}
		}

		// to find blocks bordering the blank block
		// top(-1, 0), right(0, 1), bottom(1, 0), left(0, -1)
		int[] offsets = { -1, 0, 0, 1, 1, 0, 0, -1 };
		for (int i = 0; i < offsets.length; i += 2) {
			int row = blankRow + offsets[i];
			int column = blankColumn + offsets[i + 1];
			
			if (row >= 0 && row < N && column >= 0 && column < N) {
				neighbors.enqueue(this.swap(blankRow, blankColumn, row, column));
			}
		}
		return neighbors;
	}

	/**
	 * method to swap block 0 with another block in board  
	 * @param row1
	 * @param column1
	 * @param row2
	 * @param column2
	 * @return Board
	 */
	private Board swap(int row1, int column1, int row2, int column2) {
		int[][] boardCopy = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boardCopy[i][j] = this.blocks[i][j];
			}
		}

		int v1 = boardCopy[row1][column1];
		int v2 = boardCopy[row2][column2];
		boardCopy[row1][column1] = v2;
		boardCopy[row2][column2] = v1;

		return new Board(boardCopy);
	}

	/**
	 * string representation of this board (in the output format specified
	 * below)
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(N + "\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				s.append(String.format("%2d ", blocks[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {

	}

	public int tileAt(int row, int col) {
		return blocks[row][col];
	}
}