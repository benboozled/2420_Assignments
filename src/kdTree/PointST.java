package kdTree;

public class PointST<Value> {
	
	public PointST() { // construct an empty symbol table of points
		 
	}
	
	public boolean isEmpty(){// is the symbol table empty?
		
		return false;  
	}
	
	public int size(){// number of points
		
		return 0;  
	}
	
	public void put(Point2D p, Value val){// associate the value val with point p
		
	}
	
	public Value get(Point2D p){// value associated with point p
		
		return null;
	}
	
	public boolean contains(Point2D p){// does the symbol table contain point p?
		
		return false;
	}
	
	public Iterable<Point2D> points(){// all points in the symbol table 
		
		return null;  
	}
	
	public Iterable<Point2D> range(RectHV rect){// all points that are inside the rectangle 
		
		return null; 
	}
	
	public Point2D nearest(Point2D p){// a nearest neighbor to point p; null if the symbol table is empty
		
		return p; 
	}
	
	public static void main(String[] args){// unit testing of the methods (not graded)
		
	}
	

}