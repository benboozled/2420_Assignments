package synsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class SAPTest {

	private In inDigraph1 = new In("/wordnetTests/digraph1.txt");
	Digraph digraph1 = new Digraph(inDigraph1);
	private SAP SAPdigraph1 = new SAP(digraph1);
	
	private In inDigraphCycle = new In("/wordnetTests/digraphCycle.txt");
	Digraph digraphCycle = new Digraph(inDigraphCycle);
	private SAP SAPdigraphCycle = new SAP(digraphCycle);
	
	@Test
	public void testSAP() {
		assertEquals(true, SAPdigraph1 != null);
	}	

	@Test
	public void testIsDAG() {
		assertEquals(false, SAPdigraph1.isDAG());
		assertEquals(true, SAPdigraphCycle.isDAG());
	}

	@Ignore
	public void testIsRootedDAG() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testLengthIntInt() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testAncestorIntInt() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testLengthIterableOfIntegerIterableOfInteger() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testAncestorIterableOfIntegerIterableOfInteger() {
		fail("Not yet implemented");
	}

}
