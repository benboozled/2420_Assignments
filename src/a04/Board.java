package a04;

/**
 * 
 * 
 * @author Jasmin Stefanussen
 * @author David Weber
 * Date: March 28, 2015
 * Date last modified: March 10, 2015
 * 
 * sources:
 *
 */

public class Board {

	/**
	 * construct a board from an N-by-N array of blocks 
	 * where blocks[i][j] = block in row i, column j)
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		
    }
  
	/**
	 * board size N
	 * @return
	 */
	public int size() {
		return 0;
    }
	
	/**
	 * number of blocks out of place
	 * @return
	 */
    public int hamming()  {
		return 0;
    }
    
    /**
     * sum of Manhattan distances between blocks and goal
     * @return
     */
    public int manhattan()   {
		return 0;
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
    public boolean isSolvable()   {
		return false;
    }
    
    /**
     * does this board equal y?
     * @param y
     * @return 
     */
    public boolean equals(Object y)   {
		return false;
    }
    
    /**
     * all neighboring boards
     * @return
     */
    public Iterable<Board> neighbors()   {
		return null;
	}
    
    /**
     * string representation of this board (in the output format specified below)
     * @return
     */
    public String toString()    {
		return null;
    }

    public static void main(String[] args) {
    	// unit tests (not graded)
    }
}
