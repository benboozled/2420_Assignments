package kdTree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

@SuppressWarnings("unused")
public class KdTreeSTTest {

	Point2D testPoint23 = new Point2D(2,3);		//vert
	Point2D testPoint42 = new Point2D(4,2);		//horz
	Point2D testPoint45 = new Point2D(4,5);		//vert
	Point2D testPoint33 = new Point2D(3,3);		//horz
	Point2D testPoint15 = new Point2D(1,5);		//vert
	Point2D testPoint44 = new Point2D(4,4);		//horz
	
	In in = new In("/kdTreeTests/inputWorksheet.txt");
	
	@Test
	public void testPut() {
StdOut.println("\n----------testPut------------");
StdOut.println("Node\t\t\tOrent \tDir \tN");
		KdTreeST<Integer> kdTreeTestPut = new KdTreeST<Integer>();
        for (int i = 0; !in.isEmpty(); i++) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdTreeTestPut.put(p, i);
        }
		//fail("Not yet implemented");
		//assertEquals(expected, actual);
	}
	
	@Test
	public void testIsEmpty() {
StdOut.println("\n----------testIsEmpty------------");
		KdTreeST<Point2D> kDTest02 = new KdTreeST<Point2D>();
		assertEquals(true, kDTest02.isEmpty());
		
		kDTest02.put(testPoint23, testPoint23);
		kDTest02.put(testPoint42, testPoint42);
		assertEquals(false, kDTest02.isEmpty());
	}
	
	/*
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
