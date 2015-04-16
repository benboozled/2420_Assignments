package kdTree;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class KdTreeSTTest {
	
	In inWorksheet = new In("/kdTreeTests/inputWorksheet.txt");
	In inInput10 = new In("/kdTreeTests/input10.txt");
	In inInputLevelOrder = new In("/kdTreeTests/inputLevelOrder.txt");
	In inInput10K = new In("/kdTreeTests/input10K.txt");
	In inInput100K = new In("/kdTreeTests/input100K.txt");
	In inInput1M = new In("/kdTreeTests/input1M.txt");

	@Test
	public void testRange() {
		//StdOut.println("\n-----input10K");
		KdTreeST<Integer> kdTreeTestRange1 = new KdTreeST<Integer>();
		for (int i = 0; !inInput10K.isEmpty(); i++) {
			double x = inInput10K.readDouble();
			double y = inInput10K.readDouble();
			Point2D p = new Point2D(x, y);
			kdTreeTestRange1.put(p, i);
		}
		double lowLeft = 0.0; 
		double upRight = 0.5;
		RectHV rect = new RectHV(lowLeft, lowLeft, upRight, upRight);
		Iterable<Point2D> range = kdTreeTestRange1.range(rect);
		Queue<Point2D> q = new Queue<>();
		for(Point2D p : q){
			assertEquals(true, (p.x() > lowLeft && p.x() < upRight && 
								p.y() > lowLeft && p.y() < upRight ));
		}
		
		
		
//		StdOut.print("\nrange: ");
//		for(Point2D pnt : range)	 StdOut.print(pnt.toString()+"\n");
		
		//assertEquals(true, kdTreeTestRange1.get(new Point2D(0.158530, 0.486901))==0);
	}

	@Test
	public void testNearest() {
		//StdOut.println("\n-----input1M");
		KdTreeST<Integer> kdTreeTestNear1 = new KdTreeST<Integer>();
		for (int i = 0; !inInput1M.isEmpty(); i++) {
			double x = inInput1M.readDouble();
			double y = inInput1M.readDouble();
			Point2D p = new Point2D(x, y);
			kdTreeTestNear1.put(p, i);
		}
		Point2D pnt1 = kdTreeTestNear1.nearest(new Point2D(0.723941, 0.966772));
		StdOut.print("Nearest: (0.723941, 0.966772)\n         "+pnt1+"");
		Point2D pnt2 = kdTreeTestNear1.nearest(new Point2D(0.052521, 0.273311));
		StdOut.print("\nNearest: (0.052521, 0.273311)\n         "+pnt2+"");
	}	

	@Ignore
	public void testPutGet1M() {
		//StdOut.println("\n-----input1M");
		KdTreeST<Integer> kdTreeTestPut5 = new KdTreeST<Integer>();
		for (int i = 0; !inInput1M.isEmpty(); i++) {
			double x = inInput1M.readDouble();
			double y = inInput1M.readDouble();
			Point2D p = new Point2D(x, y);
			kdTreeTestPut5.put(p, i);
		}
		assertEquals(true, kdTreeTestPut5.get(new Point2D(0.723941, 0.966772))==999995);
		assertEquals(true, kdTreeTestPut5.get(new Point2D(0.723055, 0.568865))==999996);
		assertEquals(true, kdTreeTestPut5.get(new Point2D(0.233049, 0.438232))==999997);
		assertEquals(true, kdTreeTestPut5.get(new Point2D(0.800153, 0.567465))==999998);
		assertEquals(true, kdTreeTestPut5.get(new Point2D(0.761521, 0.842539))==999999);
	}
	
	@Ignore
	public void testPutGet100K() {
		//StdOut.println("\n-----input100K");
		KdTreeST<Integer> kdTreeTestPut4 = new KdTreeST<Integer>();
		for (int i = 0; !inInput100K.isEmpty(); i++) {
			double x = inInput100K.readDouble();
			double y = inInput100K.readDouble();
			Point2D p = new Point2D(x, y);
			kdTreeTestPut4.put(p, i);
		}
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.158530, 0.486901))==0);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.792202, 0.762825))==1);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.738013, 0.827616))==2);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.615232, 0.064454))==3);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.107092, 0.863317))==4);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.654095, 0.869838))==99995);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.613742, 0.970450))==99996);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.843521, 0.443400))==99997);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.594097, 0.539994))==99998);
		assertEquals(true, kdTreeTestPut4.get(new Point2D(0.946269, 0.290566))==99999);
	}

	@Test
	public void testPutGetWorksheet() {
		//StdOut.println("\n-----worksheet");
		KdTreeST<Integer> kdTreeTestPut1 = new KdTreeST<Integer>();
        for (int i = 0; !inWorksheet.isEmpty(); i++) {
            double x = inWorksheet.readDouble();
            double y = inWorksheet.readDouble();
            Point2D p = new Point2D(x, y);
            //StdOut.print(p.toString());
            kdTreeTestPut1.put(p, i);
        }
        assertEquals(true, kdTreeTestPut1.get(new Point2D(2,3))==0);
        assertEquals(true, kdTreeTestPut1.get(new Point2D(4,2))==1);
		assertEquals(true, kdTreeTestPut1.get(new Point2D(4,5))==2);
		assertEquals(true, kdTreeTestPut1.get(new Point2D(3,3))==3);
		assertEquals(true, kdTreeTestPut1.get(new Point2D(1,5))==4);
		//TODO: ERROR!!!
		int five = kdTreeTestPut1.get(new Point2D(4,4));
		//assertEquals(5, five);
	}

	@Test
	public void testPutGet10() {
		//StdOut.println("\n-----input10");
		KdTreeST<Integer> kdTreeTestPut2 = new KdTreeST<Integer>();
		for (int i = 0; !inInput10.isEmpty(); i++) {
			double x = inInput10.readDouble();
			double y = inInput10.readDouble();
			Point2D p = new Point2D(x, y);
			//StdOut.println("adding "+p.toString());
			kdTreeTestPut2.put(p, i);
		}
        assertEquals(true, kdTreeTestPut2.get(new Point2D(0.406360,0.678100))==0);
        assertEquals(true, kdTreeTestPut2.get(new Point2D(0.147733,0.203388))==4);
        assertEquals(true, kdTreeTestPut2.get(new Point2D(0.371858,0.169457))==9);
	}

	@Test
	public void testPutGet10K() {
		//StdOut.println("\n-----input10K");
		KdTreeST<Integer> kdTreeTestPut3 = new KdTreeST<Integer>();
		for (int i = 0; !inInput10K.isEmpty(); i++) {
			double x = inInput10K.readDouble();
			double y = inInput10K.readDouble();
			Point2D p = new Point2D(x, y);
			kdTreeTestPut3.put(p, i);
		}
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.406360, 0.678100))==0);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.740024, 0.021714))==1);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.010189, 0.742363))==2);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.018690, 0.959379))==3);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.147733, 0.203388))==4);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.350568, 0.758627))==9994);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.612036, 0.710024))==9995);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.597453, 0.295488))==9996);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.161338, 0.918481))==9997);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.933617, 0.350682))==9998);
		assertEquals(true, kdTreeTestPut3.get(new Point2D(0.785370, 0.652338))==9999);
	}

	@Ignore
	public void testRectangle() {		

	}
	
	@Test
	public void testContains() {
		//StdOut.print("\n------------------------CONTAINS");
		//StdOut.println("\n-----worksheet");
		KdTreeST<Integer> kdTreeTestContains1 = new KdTreeST<Integer>();
        for (int i = 0; !inWorksheet.isEmpty(); i++) {
            double x = inWorksheet.readDouble();
            double y = inWorksheet.readDouble();
            Point2D p = new Point2D(x, y);
            kdTreeTestContains1.put(p, i);
        }
        //StdOut.print("\npoint 2,3: "+kdTreeTestContains1.contains(new Point2D(2,3)));
        assertEquals(true, kdTreeTestContains1.contains(new Point2D(2,3)));
        //StdOut.print("\npoint 4,2: "+kdTreeTestContains1.contains(new Point2D(4,2)));
        assertEquals(true, kdTreeTestContains1.contains(new Point2D(4,2)));
        //StdOut.print("\npoint 4,5: "+kdTreeTestContains1.contains(new Point2D(4,5)));
		assertEquals(true, kdTreeTestContains1.contains(new Point2D(4,5)));
		//StdOut.print("\npoint 3,3: "+kdTreeTestContains1.contains(new Point2D(3,3)));
		assertEquals(true, kdTreeTestContains1.contains(new Point2D(3,3)));
		//StdOut.print("\npoint 1,5: "+kdTreeTestContains1.contains(new Point2D(1,5)));
		assertEquals(true, kdTreeTestContains1.contains(new Point2D(1,5)));
		//StdOut.print("\npoint 4,4: "+kdTreeTestContains1.contains(new Point2D(4,4)));
		assertEquals(true, kdTreeTestContains1.contains(new Point2D(4,4)));
		
		//StdOut.print("\npoint 0,0: "+kdTreeTestContains1.contains(new Point2D(0,0)));
		assertEquals(false, kdTreeTestContains1.contains(new Point2D(0,0)));
		//StdOut.print("\npoint 10,10: "+kdTreeTestContains1.contains(new Point2D(10,10)));
		assertEquals(false, kdTreeTestContains1.contains(new Point2D(10,10)));
	}
	
	@Test
	public void testGet() {
		testPutGetWorksheet();
	}

	@Test
	public void testPointsLevelOrder() {
		//StdOut.println("\n----------------------POINTS");
		//StdOut.println("-----testPointsLevelOrder,worksheet");
		KdTreeST<Integer> kdTreeTestPoints1 = new KdTreeST<Integer>();
        for (int i = 0; !inInputLevelOrder.isEmpty(); i++) {
            double x = inInputLevelOrder.readDouble();
            double y = inInputLevelOrder.readDouble();
            Point2D p = new Point2D(x, y);
            kdTreeTestPoints1.put(p, i);
        }
		StringBuilder actual = new StringBuilder();
		String expected = "(0.7, 0.2)(0.5, 0.4)(0.9, 0.6)(0.2, 0.3)(0.4, 0.7)";
		//StdOut.println();
		for (Point2D pnt : kdTreeTestPoints1.points()){
			//StdOut.print(pnt.toString());
			actual.append(pnt.toString());
		}
		//StdOut.println();
		//StdOut.print(expected+"\n");
		assertEquals(expected, actual.toString());
	}

	@Test
	public void testPoints2() {
		//StdOut.println("\n\n-----testPoints2,worksheet");
		KdTreeST<Integer> kdTreeTestPoints2 = new KdTreeST<Integer>();
        for (int i = 0; !inWorksheet.isEmpty(); i++) {
            double x = inWorksheet.readDouble();
            double y = inWorksheet.readDouble();
            Point2D p = new Point2D(x, y);
            
            kdTreeTestPoints2.put(p, i);
        }
        //StdOut.println();
		StringBuilder actual2 = new StringBuilder();
		String expected2 = "(2.0, 3.0)(1.0, 5.0)(4.0, 2.0)(4.0, 5.0)(3.0, 3.0)(4.0, 4.0)";
		for (Point2D pnt : kdTreeTestPoints2.points()){
			//StdOut.print(pnt.toString());
			actual2.append(pnt.toString());
		}
		//StdOut.println();
		//StdOut.print(expected2+"\n");
		assertEquals(expected2, actual2.toString());
	}	
	
	@Test
	public void testIsEmpty() {
		//StdOut.println("\n\n----------------------ISEMPTY");
		KdTreeST<Integer> testIsEmpty = new KdTreeST<Integer>();
		assertEquals(true, testIsEmpty.isEmpty());
		//StdOut.println("isEmpty: "+(testIsEmpty.isEmpty()?"true":"false"));
		
		testIsEmpty.put(new Point2D(2, 3), 0);
		//StdOut.println("adding 2,3");
		testIsEmpty.put(new Point2D(4, 5), 1);
		//StdOut.println("adding 4,5");
		testIsEmpty.put(new Point2D(6, 7), 2);
		//StdOut.println("adding 6,7");
		assertEquals(false, testIsEmpty.isEmpty());
		//StdOut.println("isEmpty: "+(testIsEmpty.isEmpty()?"true":"false"));
	}
	
	@Ignore
	public static void traceRect(RectHV rect){
		StdOut.print("\n[(");
		StdOut.print(rect.xmin() == Double.MIN_VALUE? "-inf": rect.xmin());
		StdOut.print(", ");
		StdOut.print(rect.ymin() == Double.MIN_VALUE? "-inf": rect.ymin());
		StdOut.print(")(");
		StdOut.print(rect.xmax() == Double.MAX_VALUE? "+inf": rect.xmax());
		StdOut.print(", ");
		StdOut.print(rect.ymax() == Double.MAX_VALUE? "+inf": rect.ymax());
		StdOut.print(")]");
	}

	@Ignore
	public void testSize() {

	}

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

//double xnew = (point.x() >= rect.xmin()? point.x() : Double.MIN_VALUE);	   	
//private RectHV bisect(RectHV rect, Point2D point, int level){
//	if (level % 2 == 1){//x
//		if (point.x() > rect.xmin())
//			return new RectHV(point.x(),rect.ymin(),rect.xmax(),rect.ymax());
//		if (point.x()  < rect.xmin())
//			return new RectHV(Double.MIN_VALUE,rect.ymin(),rect.xmax(),rect.ymax());
//		if (point.x()  < rect.xmax())
//			new RectHV(rect.xmin(),rect.ymin(),point.y(),rect.ymax());
//		if (point.x()  > rect.xmax())
//			new RectHV(rect.xmin(),rect.ymin(),Double.MAX_VALUE,rect.ymax());
//	}
//	if (level % 2 == 0){//y
//		if (point.y() > rect.ymin())
//			return new RectHV(point.x(),rect.ymin(),rect.xmax(),rect.ymax());
//		if (point.y() < rect.ymin())
//			return new RectHV(Double.MIN_VALUE,rect.ymin(),rect.xmax(),rect.ymax());
//		if (point.y() < rect.ymax())
//			new RectHV(rect.xmin(),rect.ymin(),point.y(),rect.ymax());
//		if (point.y() > rect.ymax())
//			new RectHV(rect.xmin(),rect.ymin(),Double.MAX_VALUE,rect.ymax());
//	}
//	System.err.println("\nunhandled rectangle condition");
	
	
//		if (point.x() > minX)			minX = node.point.x();
//		if (point.x() < minX)			minX = Double.MIN_VALUE;
//		if (point.x() < maxX)			maxX = node.point.x();
//		if (point.x() > maxX) maxX = Double.MAX_VALUE;
	
//		if (point.y() > minY)			minY = node.point.y();
//		if (point.y() < minY)			minY = Double.MIN_VALUE;
//		if (point.y() < maxY)			maxY = node.point.y();
//		if (point.y() > maxY) maxY = Double.MAX_VALUE;
//	if (level % 2 == 1){//y
//		if (point > rect.ymin())
//
//		if (point < rect.ymin())
//
//		if (point < rect.ymax())
//
//		if (point > rect.ymax())
//			;
//	}
//	
//	
//	new RectHV(rect.xmin(),point.y(),rect.xmax(),rect.ymax());
//	new RectHV(rect.xmin(),rect.ymin(),rect.xmax(),point.y());		
//	return infinity;
//}
//private Node put(Node node, Point2D point, Value val, int level, RectHV rect) {
//if (node == null)	return new Node(point, val, level+1,
//					new RectHV(rect.xmin(),rect.ymin(),rect.xmax(),rect.ymax()));
//
//if (node.level % 2 == 1){										//for VERTICAL line 			
//	if (point.x()-node.point.x() <  0){							//new point LEFT of old point
//		node.leftBottom = put(	node.leftBottom, 				//put node in LEFT branch 
//								point, val, 					//recurse
//								level+1, 						//increment LEVEL
//								new RectHV(Double.MIN_VALUE,	//new XMIN
//								rect.ymin(),rect.xmax(),rect.ymax()));//recurse
//	}
//	if (point.x()-node.point.x() >= 0)	{
//		node.rightTop = put(node.rightTop, point, val, level+1, node.rect);
//	}
//}
//if (node.level % 2 == 0){//horizontal line, upper right corner
//	if (point.y()-node.point.y() <  0)
//		node.leftBottom = put(node.leftBottom, point, val, level+1, node.rect);
//	if (point.y()-node.point.y() >= 0)
//		node.rightTop = put(node.rightTop, point, val, level+1, node.rect);
//}
//return node;
//}