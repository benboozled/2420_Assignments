package kdTree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;


public class KdTreeSTTest {

	Point2D testPoint23 = new Point2D(2,3);		//vert
	Point2D testPoint42 = new Point2D(4,2);		//horz
	Point2D testPoint45 = new Point2D(4,5);		//vert
	Point2D testPoint33 = new Point2D(3,3);		//horz
	Point2D testPoint15 = new Point2D(1,5);		//vert
	Point2D testPoint44 = new Point2D(4,4);		//horz

	@Test
	public void testPut() {
StdOut.println("\n----------testWorksheet------------");
StdOut.printf("%-20s %22s %6s %5s\n", "Node", "Orent", "subs", "N");
		In in1 = new In("/kdTreeTests/inputWorksheet.txt");
		KdTreeST<Integer> kdTreeTestPut1 = new KdTreeST<Integer>();
        for (int i = 0; !in1.isEmpty(); i++) {
            double x = in1.readDouble();
            double y = in1.readDouble();
            Point2D p = new Point2D(x, y);
            kdTreeTestPut1.put(p, i);
            StdOut.println("adding "+p.toString());
        }
//		In in2 = new In("/kdTreeTests/input10.txt");
//		KdTreeST<Integer> kdTreeTestPut2 = new KdTreeST<Integer>();
//        for (int i = 0; !in2.isEmpty(); i++) {
//            double x = in2.readDouble();
//            double y = in2.readDouble();
//            Point2D p = new Point2D(x, y);
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
