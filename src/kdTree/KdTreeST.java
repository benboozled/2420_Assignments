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
	
		   public Node(Point2D p, Value value){
			   this.p = p;
			   this.value = value;
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
	//TODO: The code below was taken from BST.class as per
	//the recommendation in assignment checklist. Needs to 
	//be adopted for our particular needs.
	public void put(Point2D p, Value val){
		
		//if (val == null) { delete(p); return; }
		root = put(root, p, val, size() % 2); 
				
		//from checklist:
		//1. use helper method below
		//2. pass orientation (vertical, horizontal) as argument to helper method
		//from BST.java:

	}
	
//  private Node put(Node x, Key key, Value val) {
	private Node put(Node x, Point2D p, Value val, int orientation) {
		
//      if (x == null) return new Node(key, val, 1);
		if (x == null) return new Node(p, val);
		
		
//		int cmp = key.compareTo(x.key);
		
//		if      (cmp < 0) x.left  = put(x.left,  key, val);
		
//		else if (cmp > 0) x.right = put(x.right, key, val);
		
//		else              x.val   = val;
		
		
//      x.N = 1 + size(x.left) + size(x.right);
		N++;
		
//      return x;
		return x;
	}
	
//    private Node put(Node x, Key key, Value val) {
//        if (x == null) return new Node(key, val, 1);
//        int cmp = key.compareTo(x.key);
//        if      (cmp < 0) x.left  = put(x.left,  key, val);
//        else if (cmp > 0) x.right = put(x.right, key, val);
//        else              x.val   = val;
//        x.N = 1 + size(x.left) + size(x.right);
//        return x;
//    }
	
	/**
	 * returns the value associated with a given point
	 * @param a point of type Point2D
	 * @return the value associated with a given point
	 */
	public Value get(Point2D p){
		return null;

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
		Point2D point01 = new Point2D(4,5);
		KdTreeST<Point2D> myTestST = new KdTreeST<>();

	}
	

}