package kdTree;

import edu.princeton.cs.algs4.Queue;

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
		root = put(root, point, val, 0);
		N++;
	}
	
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
	 * Private helper method for get
	 * @param root2
	 * @param p
	 * @param o
	 * @return
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
	 * returns a range of points that are contained within a given rectangle
	 * Easier said then done though, eh?
	 * @param a rectangle of type RectHV
	 * @return all points that are inside the rectangle 
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
	
	public Point2D nearest(Point2D p) {               // a nearest neighbor in the set to p; null if set is empty
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

	}
	
}