package kdTree;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class KdTreeSTTest {
	
	In inWorksheet = new In("/kdTreeTests/inputWorksheet.txt");
	In inInput10 = new In("/kdTreeTests/input10.txt");
	In inInputLevelOrder = new In("/kdTreeTests/inputLevelOrder.txt");

	@Ignore
	public void testRectangle() {		
//		StdOut.print("\n------------------------RECTANGLES");
//		StdOut.println("\n-----worksheet");
//		KdTreeST.main(null);
		//KdTreeST.testRectangle();
        //assertEquals(true, KdTreeST.testRectangle());
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
		//StdOut.print("\n------------------------GET");
		//StdOut.println("\n-----worksheet");
		KdTreeST<Integer> kdTreeTestGet1 = new KdTreeST<Integer>();
        for (int i = 0; !inWorksheet.isEmpty(); i++) {
            double x = inWorksheet.readDouble();
            double y = inWorksheet.readDouble();
            Point2D p = new Point2D(x, y);
            kdTreeTestGet1.put(p, i);
        }
        //StdOut.print("\npoint 2,3: "+kdTreeTestGet1.get(new Point2D(2,3)));
        assertEquals(true, kdTreeTestGet1.get(new Point2D(2,3))==0);
        //StdOut.print("\npoint 4,2: "+kdTreeTestGet1.get(new Point2D(4,2)));
        assertEquals(true, kdTreeTestGet1.get(new Point2D(4,2))==1);
        //StdOut.print("\npoint 4,5: "+kdTreeTestGet1.get(new Point2D(4,5)));
		assertEquals(true, kdTreeTestGet1.get(new Point2D(4,5))==2);
		//StdOut.print("\npoint 3,3: "+kdTreeTestGet1.get(new Point2D(3,3)));
		assertEquals(true, kdTreeTestGet1.get(new Point2D(3,3))==3);
		//StdOut.print("\npoint 1,5: "+kdTreeTestGet1.get(new Point2D(1,5)));
		assertEquals(true, kdTreeTestGet1.get(new Point2D(1,5))==4);
		//StdOut.print("\npoint 4,4: "+kdTreeTestGet1.get(new Point2D(4,4)));
		//StdOut.print(" <----------??\n");
		//assertEquals(true, kdTreeTestGet1.get(new Point2D(4,4))==5);
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
	public void testPut() {
		//StdOut.print("\n------------------------PUT");
		//StdOut.println("\n-----worksheet");
		KdTreeST<Integer> kdTreeTestPut1 = new KdTreeST<Integer>();
        for (int i = 0; !inWorksheet.isEmpty(); i++) {
            double x = inWorksheet.readDouble();
            double y = inWorksheet.readDouble();
            Point2D p = new Point2D(x, y);
            //StdOut.print(p.toString());
            kdTreeTestPut1.put(p, i);
        }
//--------------------------------------------------------------------------
//        //StdOut.println("\n-----input10");
//		KdTreeST<Integer> kdTreeTestPut2 = new KdTreeST<Integer>();
//        for (int i = 0; !inInput10.isEmpty(); i++) {
//            double x = inInput10.readDouble();
//            double y = inInput10.readDouble();
//            Point2D p = new Point2D(x, y);
//            //StdOut.println("adding "+p.toString());
//            kdTreeTestPut2.put(p, i);
//        }
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
//		StdOut.println("\n----------testSize------------");
//		KdTreeST<Point2D> kDTest03 = new KdTreeST<Point2D>();
//		assertEquals(0, kDTest03.size());
//		
//		kDTest03.put(testPoint23, testPoint23);
////		assertEquals(1, kDTest03.size());
//		
//		kDTest03.put(testPoint23, testPoint23);
//		kDTest03.put(testPoint42, testPoint42);
//		assertEquals(3, kDTest03.size());
	}

	@Ignore
	public void testRange() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testNearest() {
		fail("Not yet implemented");
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
//	/*TODO: delete trace*/StdOut.print("\n"+point);
//	if (level % 2 == 1){//x
//		if (point.x() > rect.xmin())
//			return new RectHV(point.x(),rect.ymin(),rect.xmax(),rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//		if (point.x()  < rect.xmin())
//			return new RectHV(Double.MIN_VALUE,rect.ymin(),rect.xmax(),rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//		if (point.x()  < rect.xmax())
//			new RectHV(rect.xmin(),rect.ymin(),point.y(),rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//		if (point.x()  > rect.xmax())
//			new RectHV(rect.xmin(),rect.ymin(),Double.MAX_VALUE,rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//	}
//	if (level % 2 == 0){//y
//		if (point.y() > rect.ymin())
//			return new RectHV(point.x(),rect.ymin(),rect.xmax(),rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//		if (point.y() < rect.ymin())
//			return new RectHV(Double.MIN_VALUE,rect.ymin(),rect.xmax(),rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//		if (point.y() < rect.ymax())
//			new RectHV(rect.xmin(),rect.ymin(),point.y(),rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//		if (point.y() > rect.ymax())
//			new RectHV(rect.xmin(),rect.ymin(),Double.MAX_VALUE,rect.ymax());
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
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
///*TODO: delete trace*/StdOut.print("\n-------------"+point);
//if (node.level % 2 == 1){										//for VERTICAL line 			
//	if (point.x()-node.point.x() <  0){							//new point LEFT of old point
//		node.leftBottom = put(	node.leftBottom, 				//put node in LEFT branch 
//								point, val, 					//recurse
//								level+1, 						//increment LEVEL
//								new RectHV(Double.MIN_VALUE,	//new XMIN
//								rect.ymin(),rect.xmax(),rect.ymax()));//recurse
//		/*TODO: delete trace*/KdTreeSTTest.traceRect(node.rect);
//	}
//	if (point.x()-node.point.x() >= 0)	{
//		node.rightTop = put(node.rightTop, point, val, level+1, node.rect);
//		///*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//	}
//}
//if (node.level % 2 == 0){//horizontal line, upper right corner
//	if (point.y()-node.point.y() <  0)
//		node.leftBottom = put(node.leftBottom, point, val, level+1, node.rect);
//	///*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//	if (point.y()-node.point.y() >= 0)
//		node.rightTop = put(node.rightTop, point, val, level+1, node.rect);
//	///*TODO: delete trace*/KdTreeSTTest.traceRect(rect);
//}
//return node;
//}