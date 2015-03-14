package a04;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdOut;

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
/*TODO:delete*///StdOut.println("i:"+i+" j:"+j+" val: "+blocks[i][j]+" cal: "+(i*N+j+1));
        	}
    	}
		return hams;
    }
    
    /**
     * sum of Manhattan distances between blocks and goal
     * @return
     */
    public int manhattan()   {
    	int mans = 0;
    	int emptyX = 0;
    	int emptyY = 0;
    	List<int[]> oopList = new ArrayList<>();				//-Create array list for out-of-place blocks,
    	for (int i = 0; i < N; i++){							// for rows (i corresponds to y),
        	for (int j = 0; j < N; j++){						// for columns (j corresponds to x),
        		if (blocks[i][j] == 0)	{emptyX=j; emptyY=i;}	// set x,y for the empty block.
        		else if (blocks[i][j] != i*N+j+1){				//-For only blocks that are out of place,
        			oopList.add(new int[]{j,i});				// add new out-of-place x,y to oopList.
/*TODO:delete*/StdOut.println("ij:"+(i)+","+(j)+"\txy:"+(j+1)+","+(i+1)+"\tval: "+blocks[i][j]);
        		}
        	}
    	}
/*TODO:delete*/StdOut.println("\nemptyX:"+(emptyX+1)+" emptyY:"+(emptyY+1)+"\n");

		for (int y=0;y<oopList.size();y++){
			for (int x=0;y<oopList.size();x++){
				
			}
		}
    	return mans;
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
    	if (this == y) return true;
    	if (y == null) return false;
    	if (this.getClass() != y.getClass()) return false;
    	Board that = (Board) y;
    	if (this.size() != that.size()) return false;//return false if board sizes are not the same
    	if (this.blocks != that.blocks) return false;//return false if block arrays are not the same
    	return true;
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


    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	Board testBoardN301 = new Board(new int[][]{{1,2,3},{4,5,6},{7,8,0}});							//basic board
    	Board testBoardN304 = new Board(new int[][]{{1,2,3},{4,0,5},{6,7,8}});							//center block open
    	Board testBoardN401 = new Board(new int[][]{{1,2,3,4},{5,6,7,8},{9,0,10,11},{15,13,14,12}});	//4x4 with 2,3 block open
    	Board board01 = testBoardN304;
    	StdOut.println(board01.toString());
    	board01.manhattan();
    	Board board02 = testBoardN401;
    	StdOut.println(board02.toString());
    	board02.manhattan();
    }
}










