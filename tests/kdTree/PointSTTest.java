package kdTree;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

@SuppressWarnings("unused")
public class PointSTTest {
	
	In in = new In("/kdTreeTests/input10K.txt");
	PointST<Integer> brute = new PointST<Integer>();
	
	@Test
	public void setUpBeforeClass() throws Exception {
		
		for (Point2D pnt: brute.points())
			StdOut.print(pnt.toString());
		
	}

	
	
	/*
	@Test
	public void testPointST() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testPut() {
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
