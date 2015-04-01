package kdTree;

import edu.princeton.cs.algs4.RedBlackBST;

public class PointST<Value> {
	
	RedBlackBST<Point2D, Value> points = new RedBlackBST<>();
	
	public PointST() { 							// construct an empty symbol table of points
		 
	}
	
	public boolean isEmpty(){					// is the symbol table empty?
		return points.isEmpty();  
	}
	
	public int size(){							// number of points
		return points.size();  
	}
	
	public void put(Point2D p, Value val){		// associate the value val with point p
		if (p == null || val == null) 
			throw new NullPointerException("Null pointer exception");
		points.put(p, val);
	}
	
	public Value get(Point2D p){				//value associated with point p
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		return points.get(p);
	}
	
	public boolean contains(Point2D p){			//does the symbol table contain point p?
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		return points.contains(p);
	}
	
	public Iterable<Point2D> points(){			// all points in the symbol table 
		return points.keys();  
	}
	
	public Iterable<Point2D> range(RectHV rect){//TODO: all points that are inside the rectangle 
		if (rect == null) 
			throw new NullPointerException("Null pointer exception");
		
		return null; 
	}
	
	public Point2D nearest(Point2D p){			//TODO: a nearest neighbor to point p; null if the symbol table is empty
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		
		return p; 
	}
	
	public static void main(String[] args){		// unit testing of the methods (not graded)
		
	}
	

}