package a04;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
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
public class Solver {

	private SearchNode solution;
	Board board;
	
	/**
	 * find a solution to the initial board (using the A* algorithm)
	 * @param initial
	 */
	public Solver(Board board) {
		if (board == null) throw new NullPointerException("null pointer exception");
		if (!board.isSolvable()) throw new IllegalArgumentException("not solvable");

		this.board = board;	
		
    	SearchNode node = new SearchNode(board, 0, null);
    	MinPQ<SearchNode> minQueue = new MinPQ<SearchNode>();
    	    	
    	minQueue.insert(node);
    	int i = 1;
    	while(!node.board.isGoal()) {
    		StdOut.println(i++);
    		if (minQueue.isEmpty())
    			break;
    		
    		node = minQueue.delMin();
       		Iterable<Board> neighbors = node.board.neighbors();
    		for (Board b : neighbors) {
    			SearchNode newNode = new SearchNode(b, node.moves + 1, node);
    			
    			//critical optimization 
    			if (!b.equals(node.board)) {
        			minQueue.insert(newNode);    				
    			}
    		}	
    	}
    	solution = node;
	}

	/**
	 * min number of moves to solve initial board
	 * @return
	 */
    public int moves() {    		
		return solution.moves;
    }
    
    /**
     * sequence of boards in a shortest solution
     * @return Board solution
     */
    public Iterable<Board> solution() {
    	// a stack, so it will return them in order of how it was solved, 
    	// with correct solution at the end
    	Stack<Board> solutionSet = new Stack<Board>();
    	SearchNode current = solution;
    	while (current != null) {
    		solutionSet.push(current.board);
    		current = current.prev;
    	}
    	
		return solutionSet;
    }
    
    private class SearchNode implements Comparable<SearchNode> {
    	private Board board;
    	private SearchNode prev;
    	private int moves;
    	
    	public SearchNode(Board board, int moves, SearchNode prev) {
    		this.board = board;
    		this.prev = prev;
    		this.moves = moves;
    	}

    	public int priority() {
    		return this.moves + this.board.manhattan();
    	}
		@Override
		public int compareTo(SearchNode o) {
			return this.priority() - o.priority();
		}
    }
    
	public static void main(String[] args) {
		
//		int[][] test = null;
//		Board testBoard = new Board(test);	
//		Solver solver = new Solver(testBoard);
//		
//		System.out.println(solver.moves());
//		System.out.print(solver.solution.board);
//		
//		for (Board board : solver.solution()) {
//			System.out.println(board);
//		}
		
		
	}

}