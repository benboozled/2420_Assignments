package kdTree;

import edu.princeton.cs.algs4.Queue;

@SuppressWarnings("unused")
public class KdTreeST<Value> {
	
	//TODO: deprecate orientation
	private enum Oriented {
		VERTICALLY, HORIZONTALLY;
		                 /**
		* 
		* @return next orientation
		*/
		public static Oriented next() {
			if (Oriented.VERTICALLY.equals(Oriented.VERTICALLY))
				return Oriented.HORIZONTALLY;
			else 
				return Oriented.VERTICALLY;
		}
	};
		
	private Node root;
	private int N;
	
	private double minX = Double.MIN_VALUE;
	private double minY = Double.MIN_VALUE;
	private double maxX = Double.MAX_VALUE;
	private double maxY = Double.MAX_VALUE;

	private class Node {
		   private Point2D point;		// the point
		   private Value value;			// the symbol table maps the point to this value
		   private RectHV rect;			// the axis-aligned rectangle corresponding to this node
		   private Node leftBottom;		// the left/bottom subtree
		   private Node rightTop;		// the right/top subtree
		   private Node parent;			// the node above
		   private int level;			// the tree level the node is on

		   public Node(Point2D point, Value value, Node parent, int level){
			   this.point = point;
			   this.value = value;
			   this.parent = parent;
			   this.level = level;
		   }
	}

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
	 * Associates a given value with a given point
	 * @param a point of type Point2D
	 * @param a value to associate with given point
	 */
	public void put(Point2D point, Value val){
		if (val == null)	throw new IllegalArgumentException ("Unable to insert null value into KDTree");
		RectHV infinity = new RectHV(Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE );
		root = put(	root, null, point, infinity, val, 0);
		N++;
	}
	
	private Node put(Node node, Node parent, Point2D point, RectHV rect, Value val, int level) {
		if (node == null)	return new Node(point, val, node, level+1);
		if (node.level % 2 == 1){
			if (point.x()-node.point.x() <  0)	
				node.leftBottom = put(node.leftBottom, node, point, rect, val, level+1);
			if (point.x()-node.point.x() >= 0)	
				node.rightTop   = put(node.rightTop,   node, point, rect, val, level+1);
			if (point.x() > minX)			minX = node.point.x();
			if (point.x() < minX)			minX = Double.MIN_VALUE;
			if (point.x() < maxX)			maxX = node.point.x();
			if (point.x() > maxX)			maxX = Double.MAX_VALUE;
		}
		if (node.level % 2 == 0){
			if (point.y()-node.point.y() <  0)
				node.leftBottom = put(node.leftBottom, node, point, rect, val, level+1);		
			if (point.y()-node.point.y() >= 0)
				node.rightTop   = put(node.rightTop,   node, point, rect, val, level+1);
			
			if (point.y() > minY)			minY = node.point.y();
			if (point.y() < minY)			minY = Double.MIN_VALUE;
			if (point.y() < maxY)			maxY = node.point.y();
			if (point.y() > maxY)			maxY = Double.MAX_VALUE;
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
	 * Private helper method for get
	 * @param root2
	 * @param p
	 * @param o
	 * @return
	 */
	private Value get(Node node, Point2D point) { 
		if (node == null)	return null;
		int cmp = 0;
		if (node.level % 2 == 1)	cmp = Double.compare(point.x(), node.point.x());
		if (node.level % 2 == 0) 	cmp = Double.compare(point.y(), node.point.y());
        if (cmp < 0) 		return get(node.leftBottom, point);
        else if (cmp > 0)	return get(node.rightTop, point);
        else             	return node.value;
	}
	
	
	
	/**
	 * return whether or not this table contains given point
	 * @param a point of type Point2D
	 * @return whether or not this table contains given point
	 */
	public boolean contains(Point2D p){
		return false;

	}
	
    public Iterable<Point2D> points() {
        return points(min(), max());
    }
    
	/**
	 * Return all of the points
	 * @return all of the points
	 */
	private Iterable<Point2D> points(Point2D lo, Point2D hi){
		Queue<Point2D> queue = new Queue<Point2D>();
        points(root, queue, lo, hi);
        return queue;
	}
	 
    private void points(Node node, Queue<Point2D> queue, Point2D lo, Point2D hi) { 
        if (node == null) return; 
      	queue.enqueue(node.point);
       	points(node.leftBottom, queue, lo, hi); 
       	points(node.rightTop, queue, lo, hi);  
    } 


	private Point2D min() {
    	if (isEmpty()) return null;
    	return min(root).point;
    } 
    private Node min(Node x) { 
    	if (x.leftBottom == null) return x; 
    	else                return min(x.leftBottom); 
    } 
    private Point2D max() {
    	if (isEmpty()) return null;
    	return max(root).point;
    } 
    private Node max(Node x) { 
    	if (x.rightTop == null) return x; 
    	else                 return max(x.rightTop); 
    } 
    	
	/**
	 * returns a range of points that are contained within a given rectangle
	 * Easier said then done though, eh?
	 * @param a rectangle of type RectHV
	 * @return all points that are inside the rectangle 
	 */
	public Iterable<Point2D> range(RectHV rect){//TODO: all points that are inside the rectangle 
		
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
        
	}

	
}