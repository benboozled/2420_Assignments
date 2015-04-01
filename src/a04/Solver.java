package a04;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdOut;

/**
 * @author Jasmin Stefanussen
 * @author David Weber Date: 
 * March 28, 2015 
 * Date last modified: March 26, 2015
 * 
 * sources:
 *
 */
public class Solver {

	private SearchNode solution;
	Board board;

	/**
	 * find a solution to the initial board (using the A* algorithm)
	 * 
	 * @param initial
	 */
	public Solver(Board board) {
		
		if (board == null)
			throw new NullPointerException("null pointer exception");
		if (!board.isSolvable())
			throw new IllegalArgumentException("not solvable");

		this.board = board;

		SearchNode node = new SearchNode(board, 0, null);
		MinPQ<SearchNode> minQueue = new MinPQ<SearchNode>();

		minQueue.insert(node);

		while (!node.board.isGoal()) {
			if (minQueue.isEmpty())
				break;
			node = minQueue.delMin();
			Iterable<Board> neighbors = node.board.neighbors();

			for (Board b : neighbors) {
				SearchNode newNode = new SearchNode(b, node.moves + 1, node);

				// critical optimization
				if (!b.equals(node.board)) {
					minQueue.insert(newNode);
				}
			}
		}
		solution = node;
	}

	/**
	 * min number of moves to solve initial board
	 * 
	 * @return int moves
	 */
	public int moves() {
		return solution.moves;
	}

	/**
	 * sequence of boards in a shortest solution
	 * 
	 * @return Board solution
	 */
	public Iterable<Board> solution() {
		Stack<Board> solutionSet = new Stack<Board>();
		SearchNode current = solution;
		while (current != null) {
			solutionSet.push(current.board);
			current = current.prev;
		}
		return solutionSet;
	}
	
	/**
	 * Private class SearchNode, to create priority queue
	 */
	private class SearchNode implements Comparable<SearchNode> {
		private Board board;
		private SearchNode prev;
		private int moves;

		/**
		 * SearchNode Constructor
		 * @param board
		 * @param moves
		 * @param prev
		 */
		public SearchNode(Board board, int moves, SearchNode prev) {
			this.board = board;
			this.prev = prev;
			this.moves = moves;
		}

		/**
		 * calculates priority
		 * @return int priority
		 */
		public int priority() {
			return this.moves + this.board.hamming();
		}

		@Override
		public int compareTo(SearchNode o) {
			return this.priority() - o.priority();
		}
	}

	public static void main(String[] args) {
		
			int[][] blocks = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
		    Board initial = new Board(blocks);

		    // check if puzzle is solvable; if so, solve it and output solution
		    if (initial.isSolvable()) {
		        Solver solver = new Solver(initial);
		        StdOut.println("Minimum number of moves = " + solver.moves());
		        for (Board board : solver.solution())
		            StdOut.println(board);
		    }

		    // if not, report unsolvable
		    else {
		        StdOut.println("Unsolvable puzzle");
		    }		
	}
}