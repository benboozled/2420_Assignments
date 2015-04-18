package kdTree;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.introcs.StdOut;

/**
 * 
 * @author Joshua Hardesty
 * @author David Weber
 * Assignment: A05 Kd-Tree
 * Created: 03/30/2015
 * Modified: 04/18/2015
 * 
 * Dependencies: Point2D, RectHV
 * 
 * Sources and assistance: 
 * 		- Various code from algs4.cs.princeton.edu
 * 
 */
public class PointST<Value> {
	
	private RedBlackBST<Point2D, Value> points = new RedBlackBST<>();
	private SET<Point2D> pointsSet = new SET<>(); // Strictly used to iterate over to find the nearest point
	private int size;
	
	/**
	 * Ctor, size initialized with 0.
	 */
	public PointST() {
		 size = 0;
	}
	
	/**
	 * True, is size is equal to 0 
	 * @return boolean
	 */
	public boolean isEmpty(){
		return size == 0;  
	}
	
	/**
	 * Returns the number of points in the symbol table
	 * @return int
	 */
	public int size(){
		return size;  
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
		size++;
		
		while(!(pointsSet.contains(p))) {
			pointsSet.add(p);
		}
		
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
	 * @return boolean
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
	 * Returns a range of points that are contained within a given rectangle
	 * Easier said then done though, eh?
	 * @param a rectangle of type RectHV
	 * @return all points that are inside the rectangle 
	 */
	public Iterable<Point2D> range(RectHV rect){
		if (rect == null) 
			throw new NullPointerException("Null pointer exception");
		
		Queue<Point2D> queue = new Queue<Point2D>();
        for (Point2D p : points.keys()) {
            if (rect.contains(p)) {
                queue.enqueue(p);
            }
        }
        return queue;
	} 
	
	/**
	 * Returns the nearest neighbor of a given point.
	 * @param a point of type Point2D
	 * @return the nearest neighbor of a given point, null if the table is empty
	 */
	public Point2D nearest(Point2D p){
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		
		Point2D nearest = p;
		Double dist = Double.MAX_VALUE;
		for (Point2D p2 : pointsSet)
			if (p.distanceSquaredTo(p2) < dist && !p2.equals(p)) {
				nearest = p2;
				dist = p.distanceSquaredTo(p2);
			}
		return nearest; 
	}
	
	/**
	 * Main method for testing PointST.
	 * @param args
	 */
	public static void main(String[] args){
		PointST<Point2D> pSt = new PointST<>();
		Point2D p = new Point2D(1, 2);
		Point2D p2 = new Point2D(2, 3);
		Point2D p3 = new Point2D(7, 7);
		RectHV rect = new RectHV(1, 1, 6, 6);
		pSt.put(p, p);
		pSt.put(p2, p2);
		pSt.put(p3, p3);
		
		StdOut.println("Empty? " + pSt.isEmpty());
		StdOut.println("Size of pSt: " + pSt.size());
		StdOut.println("Nearest to " + p.toString() + " : " + pSt.nearest(p));
		for (Point2D point : pSt.range(rect)) { StdOut.println("In Range: " + point.toString()); }
	}
}