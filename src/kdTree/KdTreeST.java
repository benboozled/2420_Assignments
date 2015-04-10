package kdTree;

import edu.princeton.cs.introcs.StdOut;

@SuppressWarnings("unused")
public class KdTreeST<Value> {
	
	private enum Oriented { VERTICALLY, HORIZONTALLY };
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
		   private Oriented orientation;// vertical or horizontal
		   
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
	public void put(Point2D point, Value val){
		if (val == null)	throw new IllegalArgumentException ("Unable to insert null value into KDTree");
		root = put(root, point, val, Oriented.VERTICALLY);
		root.rect = new RectHV(Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		N++;
	}
	
	
	private Node put(Node node, Point2D point, Value val, Oriented orientation) {
		if (node == null) 	return new Node(point, val, orientation);
		
		if (node.orientation == Oriented.VERTICALLY){
			if (point.x()-node.point.x() <  0)	
				node.leftBottom = put(node.leftBottom, point, val, Oriented.HORIZONTALLY);
			if (point.x()-node.point.x() >= 0)	
				node.rightTop   = put(node.rightTop,   point, val, Oriented.HORIZONTALLY);
			
			if (point.x() > minX)			minX = node.point.x();
			if (point.x() < minX)			minX = Double.MIN_VALUE;
			if (point.x() < maxX)			maxX = node.point.x();
			if (point.x() > maxX)			maxX = Double.MAX_VALUE;
			
		}
		if (node.orientation == Oriented.HORIZONTALLY){
			if (point.y()-node.point.y() <  0)
				node.leftBottom = put(node.leftBottom, point, val, Oriented.VERTICALLY);		
			if (point.y()-node.point.y() >= 0)
				node.rightTop   = put(node.rightTop,   point, val, Oriented.VERTICALLY);
			
			if (point.y() > minY)			minY = node.point.y();
			if (point.y() < minY)			minY = Double.MIN_VALUE;
			if (point.y() < maxY)			maxY = node.point.y();
			if (point.y() > maxY)			maxY = Double.MAX_VALUE;
			
		}
		
		node.rect = new RectHV(minX, minY, maxX, maxY);

	
		StdOut.print(node.point.toString());
		StdOut.print("\t[(");
		StdOut.print(minX == Double.MIN_VALUE? "-inf": minX);
		StdOut.print(", ");
		StdOut.print(minY == Double.MIN_VALUE? "-inf": minY);
		StdOut.print(")(");
		StdOut.print(maxX == Double.MAX_VALUE? "+inf": maxX);
		StdOut.print(", ");
		StdOut.print(maxY == Double.MAX_VALUE? "+inf": maxY);
		StdOut.print(")]\n");
		
		
///*TODO: delete trace*/ if (node.rightTop != null)
//	StdOut.print("\n"+point.toString()+" has rt.x: "+node.rightTop.point.x());
//	if (node.leftBottom != null)
//		StdOut.print(" has lb.x: "+node.leftBottom.point.x()+"\n");
		
//		node.rect = new RectHV(
//				node.leftBottom != null? node.leftBottom.point.x() : Double.MIN_VALUE, 
//				node.leftBottom != null? node.leftBottom.point.y() : Double.MIN_VALUE,
//				node.rightTop != null? node.rightTop.point.x() : Double.MAX_VALUE, 
//				node.rightTop != null? node.rightTop.point.y() : Double.MAX_VALUE);
		
		

//		if (node.leftBottom != null){
//			if (node.rightTop != null){
//				
//			}
//		}
		
//		
//		StdOut.println("[("+node.leftBottom.point.x()+
//				", "+node.leftBottom.point.y()+
//				"), ("+node.rightTop.point.x()+
//				", "+node.rightTop.point.y()+")]");
		
//		node.rect = new RectHV( node.leftBottom.point.x(),
//				node.leftBottom.point.y(),
//				node.rightTop.point.x(),
//				node.rightTop.point.y());
	
		
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