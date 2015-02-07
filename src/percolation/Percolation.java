/**
 * @author in order of appearance: David Weber, Vance Green
 * @Date created: 1/24/2015 - David Weber
<<<<<<< HEAD
 * @Date last modified: 2/6/2015 - David Weber
>>>>>>> branch 'master' of https://github.com/davidlweber/2420_Assignments.git
 */
package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int size;
	private boolean[][] openCloseBoard; // open=true; close=false;
	private WeightedQuickUnionUF wquUF;
	private WeightedQuickUnionUF backwashEraser;
	private int topConnector;
	private int bottomConnector;
	private int openSites = 0;
	
	private int here;
	private int up;
	private int down;
	private int left;
	private int right;

	/**
	 * create N­by­N grid, with all sites blocked
	 *
	 * @param n = size
	 */
	public Percolation(int n) {
		
		if (n < 1)     throw new java.lang.IllegalArgumentException();
		
		size = n;
		wquUF = new WeightedQuickUnionUF(n * n + 2);
		backwashEraser = new WeightedQuickUnionUF(n * n + 1);
		openCloseBoard = new boolean[n][n];
		topConnector = n * n; 
		bottomConnector = n * n + 1;
		
	}

	/**
	 * is site (row, column) full?
	 *
	 * @param row = row
	 * @param col = column
	 * @return = whether (row i, column j) is full, true if full
	 */
	public boolean isFull(int row, int col) {
		
		return  (validate(row, col)?  	
				 backwashEraser.connected((row * size) + col, topConnector):
				 false);
		
	}

	/**
	 * is site (row i, column j) open?
	 *
	 * @param row = row
	 * @param col = column
	 * @return whether (row i, column j) is open, true if open
	 */
	public boolean isOpen(int row, int col) {
		
		return (validate(row, col)?  	
				openCloseBoard[row][col]: 
				false);
		
	}

	/**
	 * does the system percolate?
	 *
	 * @return whether the current system percolates, true if percolates
	 */
	public boolean percolates() {
		
		return wquUF.connected(topConnector, bottomConnector);
		
	}

	/**
	 * open site (row i, column j) if it is not open already
	 *
	 * @param row = row
	 * @param col = column
	 */
	public void open(int row, int col) {
		
		if (validate(row, col)) {
			
			openCloseBoard[row][col] = true;
			openSites++;
			
			here = (row * size) + col;
			up = ((row - 1) * size) + col;
			down = ((row + 1) * size) + col;
			left = (row * size) + (col - 1);
			right = (row * size) + (col + 1);
			
			if (row == 0) {
				wquUF.union(here, topConnector);
				backwashEraser.union(here, topConnector);
			}
			
			if (row == size - 1) {
				wquUF.union(here, bottomConnector);
			}
			
			if (row > 0 && isOpen(row - 1, col)) {
				wquUF.union(here, up);
				backwashEraser.union(here, up);
			}
			
			if (row < size - 1 && isOpen(row + 1, col)) {
				wquUF.union(here, down);
				backwashEraser.union(here, down);
			}
			
			if (col > 0 && isOpen(row, col - 1)) {
				wquUF.union(here, left);
				backwashEraser.union(here, left);
			}
			
			if (col < size - 1 && isOpen(row, col + 1)) {
				wquUF.union(here, right);
				backwashEraser.union(here, right);
			}
		}
		
	}

	/**
	 * Determines whether or not a row/column value pair are within bounds or
	 * not. If outside of bounds an IndexOutOfBounds exception is thrown,
	 * otherwise returns "true".
	 *
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean validate(int row, int col) {
		
		if (row < 0 || row > size || col < 0 || col > size)
			throw new IndexOutOfBoundsException("row = " + row + " col = " + col);
		else 
			return true;
		
	}
	

	public String numberOfOpenSites() {
		
		return String.valueOf(openSites);
		
	}
}
