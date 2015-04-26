package synsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
@SuppressWarnings("unused")
public class SAPTest {

	private In inDigraph1 = new In("/wordnetTests/digraph1.txt");
	Digraph digraph1 = new Digraph(inDigraph1);
	private SAP SAPdigraph1 = new SAP(digraph1);
	
	private In inDigraph4 = new In("/wordnetTests/digraph4.txt");
	Digraph digraph4 = new Digraph(inDigraph4);
	private SAP SAPdigraph4 = new SAP(digraph4);
	
	private In inDigraph6 = new In("/wordnetTests/digraph6.txt");
	Digraph digraph6 = new Digraph(inDigraph6);
	private SAP SAPdigraph6 = new SAP(digraph6);
	
	private In inSapEx1 = new In("/wordnetTests/sapEx1.txt");
	Digraph sapEx1 = new Digraph(inSapEx1);
	private SAP SAPsapEx1 = new SAP(sapEx1);
	
	private In inSapEx2 = new In("/wordnetTests/sapEx2.txt");
	Digraph sapEx2 = new Digraph(inSapEx2);
	private SAP SAPsapEx2 = new SAP(sapEx2);
	
	private In inDigraphCycle = new In("/wordnetTests/digraphCycle.txt");
	Digraph digraphCycle = new Digraph(inDigraphCycle);
	private SAP SAPdigraphCycle = new SAP(digraphCycle);
	
	
	/************************************************
	 * Basic construction
	 ***********************************************/
	@Test
	public void testSAP() {
		assertEquals("it's nothing", true, SAPdigraph1 != null);
//		trace(sapEx1, "SAPsapEx1");
//		trace(SAPsapEx1.getBfs(3), "SAPsapEx1 bfs 3");
//		trace(SAPsapEx1.getBfs(11), "SAPsapEx1 bfs 11");
//		trace(sapEx2, "SAPsapEx2");
//		trace(SAPsapEx2.getBfs(1), "SAPsapEx2 bfs 1");
//		trace(SAPsapEx2.getBfs(5), "SAPsapEx2 bfs 5");
		
//		trace(digraph1, "digraph1");
//		trace(digraph4, "digraph4");
//		trace(digraph6, "digraph6");
//		trace(SAPsapEx1.getTopo(), "SAPsapEx1 topo");
//		trace(SAPsapEx2.getTopo(), "SAPsapEx2 topo");
//		trace(SAPdigraph1.getTopo(), "digraph1 topo");
//		trace(SAPdigraph4.getTopo(), "digraph4 topo");
//		trace(SAPdigraph6.getTopo(), "digraph6 topo");
	}	
	@Test
	public void testIsDAG() {
		assertEquals("Has a cycle", true, SAPdigraph1.isDAG());
		assertEquals(false, SAPdigraphCycle.isDAG());
//		trace(digraphCycle, "digraphCycle");
	}
	@Test
	public void testAncestorIntInt() {
		StdOut.print("\nSAPsapEx1 3,11");
		assertEquals(1, SAPsapEx1.ancestor(3, 11));
		StdOut.print("\nSAPsapEx1 4,6");
		assertEquals(0, SAPsapEx1.ancestor(4, 6));
		StdOut.print("\nSAPsapEx1 7,8");
		assertEquals(3, SAPsapEx1.ancestor(7, 8));
		StdOut.print("\nSAPsapEx1 9,12");
		assertEquals(5, SAPsapEx1.ancestor(9, 12));
		
		StdOut.print("\nSAPsapEx2 1,5");
		assertEquals(0, SAPsapEx2.ancestor(1, 5));
		
//		SAPsapEx1.ancestor(4, 6);
//		SAPsapEx1.ancestor(3, 11);
//		SAPsapEx2.ancestor(1, 5);
	}
	
	
	/************************************************
	 * Traces and analysis
	 ***********************************************/
	private static void trace(Digraph graph, String name){
		StdOut.print("\n\n"+name+"-------------\n"+graph.toString());
	}
	private static void trace(Topological topo, String name){
		StdOut.print(""+name+"-------------\n"+topo.order()+"\n");
	}
	private static void trace(BreadthFirstDirectedPaths bfs, String name){
		StdOut.print(""+name+"-------------\n"+bfs.pathTo(0).toString()+"\n");
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
	public void testLengthIterableOfIntegerIterableOfInteger() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testAncestorIterableOfIntegerIterableOfInteger() {
		fail("Not yet implemented");
	}

}
