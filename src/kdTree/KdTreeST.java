package kdTree;


public class KdTreeST<Value> {
	
	private enum Oriented {
		VERTICALLY, HORIZONTALLY
	};
	
	private Node root;
	private int N;
	
	@SuppressWarnings("unused")
	private class Node {
		   private Point2D point;		// the point
		   private Value value;			// the symbol table maps the point to this value
		   private RectHV rect;			// the axis-aligned rectangle corresponding to this node
		   private Node leftBottom;		// the left/bottom subtree
		   private Node rightTop;		// the right/top subtree
		   private Oriented orientation;//vertical or horizontal
		   
		   public Node(Point2D point, Value value, Oriented orientation){
			   this.point = point;
			   this.value = value;
			   this.orientation = orientation;
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
	public void put(Point2D p, Value val){	
		if (val == null)		throw new IllegalArgumentException ("unable to insert null value into KDTree");
		root = put(root, p, val, Oriented.VERTICALLY);
		N++;
	}
	
	private Node put(Node node, Point2D point, Value val, Oriented o) {
		if (node == null) return new Node(point, val, o);
		if (node.orientation == Oriented.VERTICALLY){
			if (point.x()-node.point.x() <  0)		node.leftBottom = put(node.leftBottom, point, val, Oriented.HORIZONTALLY);						
			if (point.x()-node.point.x() >= 0)		node.rightTop = put(node.rightTop, point, val, Oriented.HORIZONTALLY);				
		}
		if (node.orientation == Oriented.HORIZONTALLY){
			if (point.y()-node.point.y() <  0)		node.leftBottom = put(node.leftBottom, point, val, Oriented.VERTICALLY);			
			if (point.y()-node.point.y() >= 0)		node.rightTop = put(node.rightTop, point, val, Oriented.VERTICALLY);	
		}																		
		return node;
	}
	

//	private Node put(Node node, Point2D point, Value val, Oriented o) {
//		
//		if (node == null) return new Node(point, val, o);
//		
//		if (point.x() - node.point.x() < 0 && node.orientation == Oriented.VERTICALLY){
//			node.lb = put(node.lb, point, val, Oriented.HORIZONTALLY);
/////*TODO:delete trace*/																			StdOut.print(tracer(node));				
//		}
//		if (point.x() - node.point.x() >= 0 && node.orientation == Oriented.VERTICALLY){
//			node.rt = put(node.rt, point, val, Oriented.HORIZONTALLY);
/////*TODO:delete trace*/																			StdOut.print(tracer(node));				
//		}
//		if (point.y() - node.point.y() < 0 && node.orientation == Oriented.HORIZONTALLY){
//			node.lb = put(node.lb, point, val, Oriented.VERTICALLY);
/////*TODO:delete trace*/																			StdOut.print(tracer(node));				
//		}
//		if (point.y() - node.point.y() >= 0 && node.orientation == Oriented.HORIZONTALLY){
//			node.rt = put(node.rt, point, val, Oriented.VERTICALLY);
/////*TODO:delete trace*/																			StdOut.print(tracer(node));				
//		}
//		return node;
//	}
	
	/**
	 * Private method for tracing node results. Returns a formatted string 
	 * illustrating the node, orientation of the node and whether it has 
	 * subtrees on the down/left side and/or up/right side
	 * TODO: DELETE before handing in assignment
	 * @param node
	 * @return formatted string
	 */
	private String tracer(Node node){
		String orent = "no";
		if (node.orientation == Oriented.VERTICALLY) orent = " | ";
		if (node.orientation == Oriented.HORIZONTALLY) orent = "---";
		return String.format("%-20s %20s\n", node.point.toString(), orent);
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
	* Private helper method similar to what is found in BST.class
	* @param node
	* @param key
	* @return Value, our favorite
	*/
	private Value get(Node node, Point2D point) {
	        if (node == null) return null;
	        int cmp = point.compareTo(node.point);//TODO: Point2D.compareTo won't work for this
	        
	        if      (cmp < 0) return get(node.leftBottom, point);
	        else if (cmp > 0) return get(node.rightTop, point);
	        else              return node.value;
	}
	
	/**
	 * return whether or not this table contains given point
	 * @param a point of type Point2D
	 * @return whether or not this table contains given point
	 */
	public boolean contains(Point2D p){
		return false;

	}
	
	/**
	 * Return all of the points
	 * @return all of the points
	 */
	public Iterable<Point2D> points(){
		return null;
 
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