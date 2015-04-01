package kdTree;

import edu.princeton.cs.algs4.RedBlackBST;

public class PointST<Value> {
	
	RedBlackBST<Point2D, Value> points = new RedBlackBST<>();
	
	public PointST() { 							// construct an empty symbol table of points
		 
	}
	
	/**
	 * Returns the bitter-sweet answer to life's eternal question: is this 
	 * all there is in this table? And as we peer into the abyss, so does it
	 * peer back at us. 
	 * @return emptiness. 
	 */
	public boolean isEmpty(){					// is the symbol table empty?
		return points.isEmpty();  
	}
	
	/**
	 * Returns the number of points in the symbol table
	 * @return number of points
	 */
	public int size(){							// number of points
		return points.size();  
	}
	
	/**
	 * Associates a given value with a given point
	 * @param a point of type Point2D
	 * @param a value to associate with given point
	 */
	public void put(Point2D p, Value val){		// associate the value val with point p
		if (p == null || val == null) 
			throw new NullPointerException("Null pointer exception");
		points.put(p, val);
	}
	
	/**
	 * returns the value associated with a given point
	 * @param a point of type Point2D
	 * @return the value associated with a given point
	 */
	public Value get(Point2D p){				//value associated with point p
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		return points.get(p);
	}
	
	/**
	 * return whether or not this table contains given point
	 * @param a point of type Point2D
	 * @return whether or not this table contains given point
	 */
	public boolean contains(Point2D p){			//does the symbol table contain point p?
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		return points.contains(p);
	}
	
	/**
	 * Return all of the points
	 * @return all of the points
	 */
	public Iterable<Point2D> points(){			// all points in the symbol table 
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
	 * Returns the nearest neighbor of a given point
	 * @param a point of type Point2D
	 * @return the nearest neighbor of a given point
	 */
	public Point2D nearest(Point2D p){			//TODO: a nearest neighbor to point p; null if the symbol table is empty
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		
		return p; 
	}
	
	public static void main(String[] args){		// unit testing of the methods (not graded)
		
	}
	

}