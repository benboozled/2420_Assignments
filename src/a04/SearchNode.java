package a04;

class SearchNode implements Comparable<SearchNode> {
//these are taken pretty much directly from the diagram of the SearchNode in the 
//odd, furry little man video.
private Board board;
private Board previous;
private int priority;
private int moves;

	public SearchNode(Board board) {
	
	}
	
	private int priority() {
		return this.moves + this.board.manhattan();
	}
	
	@Override
	public int compareTo(SearchNode o) {
		if (this.board.equals(o.board)) {
			return 1;
		}
		return 0;
	}
	
	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public Board getBoard() {
		return board;
	}
	
}