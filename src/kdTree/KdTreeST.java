package kdTree;

public class KdTreeST<Value> {
	
	private Node root;
	private int N;
	
	@SuppressWarnings("unused")
	private class Node {
		   private Point2D p;      // the point
		   private Value value;    // the symbol table maps the point to this value
		   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
		   private Node lb;        // the left/bottom subtree
		   private Node rt;        // the right/top subtree
		   private boolean orientation;// true = vertical, false = horizontal
	
		   public Node(Point2D p, Value value, boolean orientation){
			   this.p = p;
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
		//if (val == null) { delete(p); return; }			//from BST.java		
		if (val == null) {
			throw new IllegalArgumentException ("unable to insert null value into KDTree");
		}
		// root = put(root, key, val);						//from BST.java
 
		root = put(root, p, val, N%2==1); 					//0==false==vert, 1==true==horz
	}
	
//  private Node put(Node x, Key key, Value val) {
	private Node put(Node x, Point2D p, Value val, boolean orientation) {
//      if (x == null) return new Node(key, val, 1);		//from BST.java
		
		
//		int cmp = key.compareTo(x.key);//from BST.java

		
//		if      (cmp < 0) x.left  = put(x.left,  key, val);	//from BST.java

		
//		else if (cmp > 0) x.right = put(x.right, key, val);	//from BST.java
//		else              x.val   = val;					//from BST.java
		
		
//      x.N = 1 + size(x.left) + size(x.right);				//from BST.java
		N++;
		
//      return x;											//from BST.java
		return x;
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
	* @param x
	* @param key
	* @return Value, our favorite
	*/
	private Value get(Node x, Point2D p) {
	        if (x == null) return null;
	        int cmp = p.compareTo(x.p);
	        
	        if      (cmp < 0) return get(x.lb, p);
	        else if (cmp > 0) return get(x.rt, p);
	        else              return x.value;
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