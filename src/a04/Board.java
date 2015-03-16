package a04;

import java.util.Iterator;

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
    	if (this.size() != that.size()) return false;		//are board sizes the same
    	if (this.blocks != that.blocks) return false;		//return false if block arrays are not the same
    	return true;
    }
    
    /**
     * all neighboring boards
     * @return
     */
    public Iterable<Board> neighbors()  {
    	/**
    	 * TODO: figure this part out. 
    	 * @Source http://www.cs.princeton.edu/courses/archive/fall14/
    	 *  cos226/checklist/8puzzle.html :
    	 * "How do I return an Iterable<Board>? Add the items you want to
    	 *  a Stack<Board> or Queue<Board> and return that."
    	 * @Source Below is from "Algorithms 4th ed." by Sedgewick
    	 */
    	@SuppressWarnings({ "unused", "hiding" })
		class Stack<Board> implements Iterable<Board>{
    		private Node first;
    		class Node{
    			Board board;
    			Node next;
    		}
    		public void add(Board board){
    			Node oldfirst = first;
    			first = new Node();
    			first.board = board;
    			first.next = oldfirst;
    		}
    		public Iterator<Board> iterator(){
    			return new BoardIterator(); 
    		}
    		class BoardIterator implements Iterator<Board>{
    			private Node current = first;
    			public boolean hasNext() {
    				return current != null; 
    			}
    			public Board next() {
    				Board board = current.board;
    				current = current.next;
    				return board;
    			}
    			public void remove() { }
    		}
    	}
		return new Stack<Board>();
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








