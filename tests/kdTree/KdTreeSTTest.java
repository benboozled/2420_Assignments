package kdTree;

import static org.junit.Assert.*;

import org.junit.Test;

public class KdTreeSTTest {

	KdTreeST<Point2D> kDTest01 = new KdTreeST<>();
	Point2D testPoint23 = new Point2D(2,3);		//vert
	Point2D testPoint42 = new Point2D(4,2);		//horz
	Point2D testPoint45 = new Point2D(4,5);		//vert
	Point2D testPoint33 = new Point2D(3,3);		//horz
	Point2D testPoint15 = new Point2D(1,5);		//vert
	Point2D testPoint44 = new Point2D(4,4);		//horz
	
	@Test
	public void testPut() {
		//kDTest01.put(testPoint23, 1);
		//assertEquals(expected, actual);
	}
	
	/*
	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
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
