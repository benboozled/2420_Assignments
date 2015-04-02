package kdTree;

import edu.princeton.cs.algs4.RedBlackBST;

public class KdTreeST<Value> {
	
	RedBlackBST<Point2D, Value> points = new RedBlackBST<>();
	
	public KdTreeST() {
		 
	}
	
	/**
	 * Returns the bitter-sweet answer to life's eternal question: is this 
	 * all there is in this table? And as we peer into the table, so does it
	 * peer back at us. 
	 * @return emptiness. 
	 */
	public boolean isEmpty(){
		return points.isEmpty();  
	}
	
	/**
	 * Returns the number of points in the symbol table
	 * @return number of points
	 */
	public int size(){
		return points.size();  
	}
	
	/**
	 * Associates a given value with a given point
	 * @param a point of type Point2D
	 * @param a value to associate with given point
	 */
	public void put(Point2D p, Value val){
		if (p == null || val == null) 
			throw new NullPointerException("Null pointer exception");
		points.put(p, val);
	}
	
	/**
	 * returns the value associated with a given point
	 * @param a point of type Point2D
	 * @return the value associated with a given point
	 */
	public Value get(Point2D p){
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		return points.get(p);
	}
	
	/**
	 * return whether or not this table contains given point
	 * @param a point of type Point2D
	 * @return whether or not this table contains given point
	 */
	public boolean contains(Point2D p){
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		return points.contains(p);
	}
	
	/**
	 * Return all of the points
	 * @return all of the points
	 */
	public Iterable<Point2D> points(){
		return points.keys();  
	}
	
	/**
	 * returns a range of points that are contained within a given rectangle
	 * Easier said then done though, eh?
	 * @param a rectangle of type RectHV
	 * @return all points that are inside the rectangle 
	 */
	public Iterable<Point2D> range(RectHV rect){//TODO: all points that are inside the rectangle 
		if (rect == null) 
			throw new NullPointerException("Null pointer exception");
		
		return null; 
	}
	
	/**
	 * Returns the nearest neighbor of a given point.
	 * @param a point of type Point2D
	 * @return the nearest neighbor of a given point, null if the table is empty
	 */
	public Point2D nearest(Point2D p){//TODO: a nearest neighbor to point p; null if the symbol table is empty
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		
		return p; 
	}
	
	public static void main(String[] args){
		Point2D point01 = new Point2D(4,5);
		KdTreeST<Point2D> myTestST = new KdTreeST<>();

	}
	

}