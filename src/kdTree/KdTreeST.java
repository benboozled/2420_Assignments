package kdTree;



public class KdTreeST<Value> {
	
	private enum Oriented {
		VERTICALLY, HORIZONTALLY
	};
	
	private Node root;
	private int N;
	
	@SuppressWarnings("unused")
	private class Node {
		   private Point2D point;  // the point
		   private Value value;    // the symbol table maps the point to this value
		   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
		   private Node lb;        // the left/bottom subtree
		   private Node rt;        // the right/top subtree
		   private Oriented orientation;
		   
		   public Node(Point2D p, Value value, Oriented o){
			   this.point = p;
			   this.value = value;
			   this.orientation = o;
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

	//============FROM BST.CLASS============
	/*This first put method only applies to associating the root, the recursing method
	 * is the helper method below, which is an overloaded method that requires a Node
	 * as an argument*/
//    public void put(Key key, Value val) {                 //Put a new node in the binary search tree
	/*For this exercise, Value is simply represents the Value data being contained 
	 * within the BST, so it needs to be passed along and stored in the correct node. 
	 * But for now, it's just along for the ride.*/ 	
//        if (val == null) { delete(key); return; }        	//if no value, delete the key and stop
//        root = put(root, key, val);						//value with root using method below
//        assert check();									//(ignore this)
//    }
	
//       \/   \/    \/   \/   RECURSIVE BELOW   \/   \/   \/   \/
	/*	Everything in this helper class is recursive. The base case is when the method 
	 * reaches the end of the branch (null node), it creates a new node. The new node 
	 * is given the key and the value which have been passed along through the recursion.  
	 * The key is used for sorting, and is set to 1 by default so that the method checks on
	 * the right before checking the left*/
//    private Node put(Node x, Key key, Value val) { 		//with the result of this method(& key, value)...
//        if (x == null) return new Node(key, val, 1); 		//STOP and make a new node.
//        int cmp = key.compareTo(x.key);					//compare keys
//        if      (cmp < 0) x.left  = put(x.left,  key, val);//if it's -1, start over in LEFT subtree node
//        else if (cmp > 0) x.right = put(x.right, key, val);//if it's 1, start over in RIGHT subtree node
//        else              x.val   = val;					//otherwise, keep passing the value 
//        x.N = 1 + size(x.left) + size(x.right);			//set the N value in the node (ignore this)
//        return x;											//start over (till reaching null node)
//    }
//============FROM BST.CLASS============	
	
	/**
	 * Associates a given value with a given point
	 * @param a point of type Point2D
	 * @param a value to associate with given point
	 */
	public void put(Point2D p, Value val){	
		if (val == null) {
			throw new IllegalArgumentException ("unable to insert null value into KDTree");
		}
		root = put(root, p, val, Oriented.VERTICALLY); 					
	}
	
	private Node put(Node node, Point2D point, Value val, Oriented o) {
		if (node == null) return new Node(point, val, o);
		double compare = point.x() - node.point.x();		
		if (node.orientation == Oriented.VERTICALLY){
			if 		(compare < 0) 	node.lb = put(node.lb, point, val, Oriented.HORIZONTALLY);
			else if (compare > 0) 	node.rt = put(node.rt, point, val, Oriented.HORIZONTALLY);
			else 					node.value = val;
		}
		if (node.orientation == Oriented.HORIZONTALLY){
			if 		(compare < 0) 	node.lb = put(node.lb, point, val, Oriented.VERTICALLY);
			else if (compare > 0) 	node.rt = put(node.rt, point, val, Oriented.VERTICALLY);
			else					node.value = val;
		}
		if (node.orientation != Oriented.HORIZONTALLY && node.orientation != Oriented.VERTICALLY) 
			System.err.println("Node without orientation");

		N++;
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
	        int cmp = point.compareTo(node.point);
	        
	        if      (cmp < 0) return get(node.lb, point);
	        else if (cmp > 0) return get(node.rt, point);
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