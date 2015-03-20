package a04;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdOut;

/**
 * @author Jasmin Stefanussen
 * @author David Weber
 * @Source Sedgewick
 * @Date Created March 28, 2015   
 * Last modified: March 16, 2015 - D
 */

public class Board {

	private int N;
	private int[][] blocks;
	
	/**
	 * construct a board from an N-by-N array of blocks 
	 * where blocks[i][j] = block in row i, column j)
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		//make sure that the number of blocks in each sub array are equal array length
		if (blocks[0].length != blocks.length) throw new java.lang.IllegalArgumentException();
		this.N = blocks.length;
		this.blocks = blocks;
    }
  
	/**
	 * board size N
	 * @return
	 */
	public int size() {
		return N;
    }
	
	/**
	 * Evaluates the number of blocks out of place by performing a nested
	 * loop and using the i and j values to calculate where each array...
	 * too tired to finish my thought.
	 * TODO: Sleep, then finish describing this. 
	 * @return
	 */
    public int hamming()  {
    	int hams = 0;
    	for (int i = 0; i < N; i++){
        	for (int j = 0; j < N; j++){
        		//if the block is out of place and not 0, increment hams
        		if (blocks[i][j] != i*N+j+1 && blocks[i][j]  != 0)	hams++;  
        	}
    	}
		return hams;
    }
    
    /**
     * sum of Manhattan distances between blocks and goal
     * @return
     */
    public int manhattan(){
    	   int distance = 0;
           for (int i = 0; i < N; i++) {
               for (int j = 0; j < N; j++) {
                   if (blocks[i][j] == 0) continue;
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
           return distance;    	
    }
	
	/**
	 * is this board the goal board?
	 * @return
	 */
    public boolean isGoal() {
		return false;
    }
    
    /**
     * is this board solvable?
     * @return
     */
    @SuppressWarnings("unused")
	public boolean isSolvable()   {
    	
    	Stack<Integer> blockStack = new Stack<Integer>();
    	int inversions = 0;
    	
    	for (int i = 0; i < N; i++){
        	for (int j = 0; j < N; j++){	
        		if (blocks[i][j] != 0) 					//*except* for the empty block..
        			blockStack.push(blocks[i][j]);		//push blocks onto a stack, row-by-row
        	}
        }
    	
    	if (N % 2 == 1){								//if the board size is odd...
    		for (int i=blockStack.size(); i>1; i--){	//starting at the top of the stack 
	    		for (Integer el : blockStack)			//for each block in the stack
	    			if (el > i)							//if any block below it should be above it,
	    				inversions++;	 				//count that as an inversion.							   		 
	    		blockStack.pop();						//Then remove the top block
    		}											//and start over with remaining stack.
    		return inversions % 2 == 0;					//If # inversions odd, board is not solvable 
    	}else{
    		StdOut.println("board is even");			//if the board is even do something else.
    		//TODO: If the board number is even
    	}
    	
    	return inversions == 0;							//assuming no inversions, it is solvable.
    }
    
    /**
     * does this board equal y?
     * @param y
     * @return 
     */
    public boolean equals(Object y)   {
    	if (this == y) return true;
    	if (y == null) return false;
    	if (this.getClass() != y.getClass()) return false;
    	Board that = (Board) y;
    	if (this.size() != that.size()) return false;		//are board sizes the same
//    	if (this.blocks != that.blocks) return false;		//return false if block arrays are not the same
    	 for (int i = 0; i < N; i++) {

             for (int j = 0; j < N; j++) {

                 if (this.blocks[i][j] != that.blocks[i][j])

                     return false;
             }
    	 }
    	return true;
    }
    
    /**
     * all neighboring boards
     * @return
     */
    public Iterable<Board> neighbors()  {

    	Queue<Board> neighbors = new Queue<Board>();
    	int blankRow = 0;
    	int blankColumn = 0;
    	
    	//for loop to find the blank block
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (blocks[i][j] != 0) continue;
    			else {
    				blankRow = i;
    				blankColumn = j;
    			}
    		}
    	}

    	//to find blocks bordering the blank block
    	//top(-1, 0), right(0, 1), bottom(1, 0), left(0, -1) 
    	int[] offsets = {-1, 0, 0, 1, 1, 0, 0, -1};
    	for (int i = 0; i < offsets.length; i += 2) {
    		int row = blankRow + offsets[i];
    		int column = blankColumn + offsets[i + 1];
    		if (row >= 0 && row < N && column >= 0 && column < N) {
    			neighbors.enqueue(this.swap(blankRow, blankColumn, row, column));
    		}
    	}
        return neighbors;  
	}
    
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
     * string representation of this board (in the output format specified below)
     * @return
     */
    public String toString()    {
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

}








