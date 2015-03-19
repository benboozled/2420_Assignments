package a04;

import edu.princeton.cs.algs4.MinPQ;

/**
 * @author Jasmin Stefanussen
 * @author David Weber
 * Date: March 28, 2015
 * Date last modified: March 10, 2015
 * sources:
 */
@SuppressWarnings("unused")
public class Solver {

	private MinPQ<SearchNode> boardQ;
	private Board initialBoard;

	/**
	 * find a solution to the initial board
	 * (using the A* algorithm)
	 * @param initial
	 */
	public Solver(Board initialBoard) {
		this.initialBoard = initialBoard;						//set initialBoard
		SearchNode initialNode = new SearchNode(initialBoard);	//Create new Node from board
		boardQ.insert(initialNode);								//Enqueue the board node					
	}

	/**
	 * min number of moves to solve initial board
	 * @return
	 */
    public int moves() {
    	
		return 0;
    }
    
    /**
     * sequence of boards in a shortest solution
     * @return Board solution
     */
    public Iterable<Board> solution() {
    	//TODO: this might just be return boardQ.
    	//maybe it will need to be sorted, maybe not. 
		return null;
    }
    
    
    /**
     * Recursive solving prototype. 
     * @param node
     * @return
     */
	private SearchNode recursiveSolve(SearchNode node){
    	if (node.getBoard().isGoal() != true){	//stop when node is goal Board

    		node.setMoves(node.getMoves()+1);	//increment node.moves...
    		return node;						//return node
    	}
		return null;
    }
    
//	public static void main(String[] args) {
//		
//	}

}
