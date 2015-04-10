package kdTree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class KdTreeSTTest {

	@Test
	public void testPut() {
		
		In in1 = new In("/kdTreeTests/inputWorksheet.txt");
		KdTreeST<Integer> kdTreeTestPut1 = new KdTreeST<Integer>();

		StdOut.println("\n----------testWorksheet------------");
        for (int i = 0; !in1.isEmpty(); i++) {
            double x = in1.readDouble();
            double y = in1.readDouble();
            Point2D p = new Point2D(x, y);
            StdOut.print(p.toString());
            kdTreeTestPut1.put(p, i);
        }
        StdOut.println();
//        StdOut.println("2,3 is: "+kdTreeTestPut1.get(new Point2D(2,3)));
//        StdOut.println("4,5 is: "+kdTreeTestPut1.get(new Point2D(4,5)));
        StringBuilder actual = new StringBuilder();
        String expected = "(2.0, 3.0)(4.0, 2.0)(4.0, 5.0)(3.0, 3.0)(1.0, 5.0)(4.0, 4.0)";
		for (Point2D pnt : kdTreeTestPut1.points()){
			actual.append(pnt.toString());
			StdOut.print(pnt.toString());
		}
			
		
		assertEquals(expected, actual.toString());

        
//		In in2 = new In("/kdTreeTests/input10.txt");
//		KdTreeST<Integer> kdTreeTestPut2 = new KdTreeST<Integer>();
//        for (int i = 0; !in2.isEmpty(); i++) {
//            double x = in2.readDouble();
//            double y = in2.readDouble();
//            Point2D p = new Point2D(x, y);
//            StdOut.println("adding "+p.toString());
//            kdTreeTestPut2.put(p, i);
//        }
		//fail("Not yet implemented");
		//assertEquals(expected, actual);
	}
	
	/*	
	@Test
	public void testIsEmpty() {
StdOut.println("\n----------testIsEmpty------------");
		KdTreeST<Point2D> kDTest02 = new KdTreeST<Point2D>();
		assertEquals(true, kDTest02.isEmpty());
		
		kDTest02.put(testPoint23, testPoint23);
		kDTest02.put(testPoint42, testPoint42);
		assertEquals(false, kDTest02.isEmpty());
	}
	

	@Test
	public void testSize() {
StdOut.println("\n----------testSize------------");
		KdTreeST<Point2D> kDTest03 = new KdTreeST<Point2D>();
		assertEquals(0, kDTest03.size());
		
		kDTest03.put(testPoint23, testPoint23);
//		assertEquals(1, kDTest03.size());
		
		kDTest03.put(testPoint23, testPoint23);
		kDTest03.put(testPoint42, testPoint42);
		assertEquals(3, kDTest03.size());
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testPoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testRange() {
		fail("Not yet implemented");
	}

	@Test
	public void testNearest() {
		fail("Not yet implemented");
	}
	*/
}

/*-------------------CODE SCRAPHEAP----------------------------------*/


//StdOut.print(node.point.toString());
//
//StdOut.print("\t[(");
//StdOut.print(minX == Double.MIN_VALUE? "-inf": node.rect.xmin());
//StdOut.print(", ");
//StdOut.print(minY == Double.MIN_VALUE? "-inf": node.rect.ymin());
//StdOut.print(")(");
//StdOut.print(maxX == Double.MAX_VALUE? "+inf": node.rect.xmax());
//StdOut.print(", ");
//StdOut.print(maxY == Double.MAX_VALUE? "+inf": node.rect.ymax());
//StdOut.print(")]\n");

//private void points(Node node, Queue<Point2D> queue, Point2D lo, Point2D hi) { 
//StdOut.print("lo: "+lo.toString()+"hi: "+hi.toString()+"\n");
//if (node == null){
//	StdOut.print("hit null\n");
//	return; 
//}
////int cmplo = lo.compareTo(node.point); 
////int cmphi = hi.compareTo(node.point);
//int cmp = compare(lo,hi,node.orientation);
//if (cmp < 0){
//	StdOut.print("cmp: "+cmp+" left\n");
//	points(node, queue, lo, hi); 
//}
//if (cmp == 0){
//	queue.enqueue(node.point); 
//	StdOut.print("Enqueued: "+node.point.toString()+"\n");
//}
//if (cmp > 0){
//	StdOut.print("cmp: "+cmp+" right\n");
//	points(node.rightTop, queue, lo, hi); 
//}
//} 

//private Node put(Node node, Point2D point, Value val, Oriented o) {
//
//if (node == null) return new Node(point, val, o);
//
//if (point.x() - node.point.x() < 0 && node.orientation == Oriented.VERTICALLY){
//	node.lb = put(node.lb, point, val, Oriented.HORIZONTALLY);
//StdOut.print(tracer(node));				
//}
//if (point.x() - node.point.x() >= 0 && node.orientation == Oriented.VERTICALLY){
//	node.rt = put(node.rt, point, val, Oriented.HORIZONTALLY);
//StdOut.print(tracer(node));				
//}
//if (point.y() - node.point.y() < 0 && node.orientation == Oriented.HORIZONTALLY){
//	node.lb = put(node.lb, point, val, Oriented.VERTICALLY);
//StdOut.print(tracer(node));				
//}
//if (point.y() - node.point.y() >= 0 && node.orientation == Oriented.HORIZONTALLY){
//	node.rt = put(node.rt, point, val, Oriented.VERTICALLY);
//StdOut.print(tracer(node));				
//}
//return node;
//}

///**
// * Private method for tracing node results. Returns a formatted string 
// * illustrating the node, orientation of the node and whether it has 
// * subtrees on the down/left side and/or up/right side
// * @param node
// * @return formatted string
// */
//private String tracer(Node node){
//	String orent = "no";
//	if (node.orientation == Oriented.VERTICALLY) orent = " | ";
//	if (node.orientation == Oriented.HORIZONTALLY) orent = "---";
//	return String.format("%-20s %20s\n", node.point.toString(), orent);
//}
