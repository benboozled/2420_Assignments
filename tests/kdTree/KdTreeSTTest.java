package kdTree;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class KdTreeSTTest {

	KdTreeST<Integer> kDTest01 = new KdTreeST<Integer>();
	Point2D testPoint23 = new Point2D(2,3);		//vert
	Point2D testPoint42 = new Point2D(4,2);		//horz
	Point2D testPoint45 = new Point2D(4,5);		//vert
	Point2D testPoint33 = new Point2D(3,3);		//horz
	Point2D testPoint15 = new Point2D(1,5);		//vert
	Point2D testPoint44 = new Point2D(4,4);		//horz
	
	@Test
	public void testPut() {
		kDTest01.put(testPoint23, 23);
		kDTest01.put(testPoint42, 42);
		kDTest01.put(testPoint45, 45);
		kDTest01.put(testPoint33, 33);
		kDTest01.put(testPoint15, 15);
		kDTest01.put(testPoint44, 44);
		fail("Not yet implemented");
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
