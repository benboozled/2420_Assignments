package kdTree;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class KdTreeSTTest {

	Point2D testPoint23 = new Point2D(2,3);		//vert
	Point2D testPoint42 = new Point2D(4,2);		//horz
	Point2D testPoint45 = new Point2D(4,5);		//vert
	Point2D testPoint33 = new Point2D(3,3);		//horz
	Point2D testPoint15 = new Point2D(1,5);		//vert
	Point2D testPoint44 = new Point2D(4,4);		//horz
	
	
	
	@Test
	public void testPut() {
		KdTreeST<Point2D> kDTest01 = new KdTreeST<Point2D>();
		kDTest01.put(testPoint23, testPoint23);
		kDTest01.put(testPoint42, testPoint42);
		kDTest01.put(testPoint45, testPoint45);
		kDTest01.put(testPoint33, testPoint33);
		kDTest01.put(testPoint15, testPoint15);
		kDTest01.put(testPoint44, testPoint44);
		
		//fail("Not yet implemented");
		//assertEquals(expected, actual);
	}
	

	@Test
	public void testIsEmpty() {
		KdTreeST<Point2D> kDTest02 = new KdTreeST<Point2D>();
		assertEquals(true, kDTest02.isEmpty());
		
		kDTest02.put(testPoint23, testPoint23);
		kDTest02.put(testPoint42, testPoint42);
		assertEquals(false, kDTest02.isEmpty());
	}

	@Test
	public void testSize() {
		KdTreeST<Point2D> kDTest03 = new KdTreeST<Point2D>();
		assertEquals(0, kDTest03.size());
		
		kDTest03.put(testPoint23, testPoint23);
//		assertEquals(1, kDTest03.size());
		
		kDTest03.put(testPoint23, testPoint23);
		kDTest03.put(testPoint42, testPoint42);
		assertEquals(3, kDTest03.size());
	}

	/*

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
