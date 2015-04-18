package kdTree;

/**
 * @author Joshua Hardesty
 * @author David Weber
 * Assignment: A05 Kd-Tree
 * Created: 03/30/2015
 * Modified: 04/18/2015
 * 
 * Dependencies: Point2D.java, RectHV.java
 * 
 * Implementation of 2D axis-aligned rectangle
 * Subset lifted from http://algs4.cs.princeton.edu/code/RectHV.java.html
 *
 * Sources and assistance: 
 * 		- Various code from algs4.cs.princeton.edu
 * 		- Some explanation of recursive methodology from Melissa Weber
 */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdOut;

public class KdTreeST<Value> {

	private Node root;
	private int N;
	
	private class Node {
		private Point2D point;		// the point
		private Value value;		// the symbol table maps the point to this value
		private Node leftBottom;	// the left/bottom subtree
		private Node rightTop;		// the right/top subtree
		private int level;			// the tree level the node is on
		public Node(Point2D point, Value value, int level){
			this.point = point;
			this.value = value;
			this.level = level;
		}  
	}

	/**
	 * The constructor.
	 */
	public KdTreeST() {
		 
	}
	
	/**
	 * Returns the bitter-sweet answer to life's eternal question: is this 
	 * all there is in this table? And as we peer into the table, so does it
	 * peer back at us. 
	 * @return emptiness. 
	 */
	public boolean isEmpty(){
		return N == 0;
	}
	
	/**
	 * Returns the number of points in the symbol table
	 * @return number of points
	 */
	public int size(){
        return N; 
	}
	
	/**
	 * Associates a given value with a given point. This method is
	 * non-recursive but initiates a recursive, private, overloaded
	 * method which creates the binary tree.  
	 * @param a point of type Point2D
	 * @param a value to associate with given point
	 */
	public void put(Point2D point, Value val){
		if (val == null)	throw new IllegalArgumentException ("Unable to insert null value into KDTree");
		root = put(root, point, val, 0);
		N++;
	}
	
	/** This method is recursive. When reaching a null node
	 *  a new node is created and the method resets the antecedent 
	 *  nodes accordingly.
	 * @param node: node which holds the values for Point and Value
	 * @param point: 2-dimensional point represented by the tree
	 * @param value: value associated with a given node in the tree
	 * @param level: hierarchical level in the binary tree 
	 * 		  	(root = 0, root leftBottom & rightTop = 1, etc.)
	 * @return returns the node. 
	 */
	private Node put(Node node, Point2D point, Value val, int level) {
		if (node == null) 	return new Node(point, val, level+1);
		if (node.level % 2 == 1){
			if (point.x()-node.point.x() <  0)	
				node.leftBottom = put(node.leftBottom, point, val, level+1);
			if (point.x()-node.point.x() >= 0)	
				node.rightTop   = put(node.rightTop,   point, val, level+1);	
		}
		if (node.level % 2 == 0){
			if (point.y()-node.point.y() <  0)
				node.leftBottom = put(node.leftBottom, point, val, level+1);		
			if (point.y()-node.point.y() >= 0)
				node.rightTop   = put(node.rightTop,   point, val, level+1);			
		}
		return node;
	}

	/**
	* returns the value associated with a given point
	* @param a point of type Point2D
	* @return the value associated with a given point
	*/
	public Value get(Point2D p){
		return get(root, p);
	}
	
	/**
	 * A recursive method which traverses the tree and returns the 
	 * node and point associated with that node. 
	 * @param node
	 * @param point
	 * @return returns node and point
	 */
	private Value get(Node node, Point2D point) { 
		if (node == null)	return null;
		int cmp = 0;
		if (node.level % 2 == 0) 	cmp = Double.compare(point.y(), node.point.y());
		if (node.level % 2 == 1)	cmp = Double.compare(point.x(), node.point.x());
        if 		(cmp < 0) 	return get(node.leftBottom, point);
        else if (cmp > 0)	return get(node.rightTop, point);
        else             	return node.value;
	}

	/**
	 * return whether or not this table contains given point
	 * @param a point of type Point2D
	 * @return whether or not this table contains given point
	 */
	public boolean contains(Point2D point){
		return get(root, point)!=null;
	}

	/**
	 * Returns a Point2D Iterable containing all the points in the tree
	 * @return all the points in the tree
	 */
    public Iterable<Point2D> points() {
        Queue<Point2D> points = new Queue<Point2D>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            points.enqueue(x.point);
            queue.enqueue(x.leftBottom);
            queue.enqueue(x.rightTop);
        }
        return points;
    }
    	
	/**
	 * Returns a Point2D Iterable containing all the points in a given rectangle
	 * @param RectHV used to query which points are contained in a given area
	 * @return All the points in a given rectangle
	 */
	public Iterable<Point2D> range(RectHV rect){
		Queue<Point2D> queue = new 	Queue<Point2D>();
		// for each point that is returned points(), enqueue the point to a queue if it is contained in the rectangle
        for (Point2D p: points()) {
        	if (rect.contains(p))
        		queue.enqueue(p);
        }
        return queue; 
	}
	
	/**
	 * returns the nearest neighbor to a given point. 
	 * @param The point being queried
	 * @return the nearest neighbor in the set to p; null if set is empty
	 */
	public Point2D nearest(Point2D p) {
		if (p == null) 
			throw new NullPointerException("Null pointer exception");
		Point2D nearest = p;
		Double dist = Double.MAX_VALUE;
		for (Point2D p2 : points())
			if (p.distanceSquaredTo(p2) < dist && !p2.equals(p)) {
				nearest = p2;
				dist = p.distanceSquaredTo(p2);
			}
		return nearest;
	}
		
	public static void main(String[] args){
		Point2D testPoint23 = new Point2D(2,3);	
		Point2D testPoint22 = new Point2D(2,2);
		Point2D testPoint33 = new Point2D(3,3);
		Point2D testPoint42 = new Point2D(4,2);		
		Point2D testPoint45 = new Point2D(4,5);	
		Point2D testPoint77 = new Point2D(7,7);
		
		KdTreeST<Point2D> kdst = new KdTreeST<>();
		
		kdst.put(testPoint23, testPoint23);
		kdst.put(testPoint22, testPoint22);
		kdst.put(testPoint33, testPoint33);
		kdst.put(testPoint42, testPoint42);
		kdst.put(testPoint45, testPoint45);
		kdst.put(testPoint77, testPoint77);
		
		StdOut.println("kdst empty? " + kdst.isEmpty());
		StdOut.println("kdst size: " + kdst.size());
		StdOut.println("Nearest to " + testPoint23.toString() + " : " + kdst.nearest(testPoint23));
		StdOut.println();
		
		Iterable<Point2D> points = kdst.range(new RectHV(0, 0, 6, 6));
		
		StdOut.println("Points in the RectHV(0, 0, 6, 6):");
		for(Point2D p: points) {
			StdOut.println(p);
		}	
	}
	
}