/**
 * @author David Weber
 * @author Ben Anderl
 * @Date Created Apr 19, 2015 
 * Last modified: May 2, 2015 
 */
package synsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
@SuppressWarnings("unused")
public class SAPTest {

	private SAP SAPnothing;
	
	private In inDigraphCycle = new In("/wordnetTests/digraphCycle.txt");
	Digraph digraphCycle = new Digraph(inDigraphCycle);
	private SAP SAPdigraphCycle = new SAP(digraphCycle);
	
	private In inTinyCG = new In("/wordnetTests/tinyCG.txt");
	Digraph tinyCG = new Digraph(inTinyCG);
	private SAP SAPtinyCG = new SAP(tinyCG);
	
	private In inDigraphClient = new In("/wordnetTests/digraphClient.txt");
	Digraph digraphClient = new Digraph(inDigraphClient);
	private SAP SAPdigraphClient = new SAP(digraphClient);
	
	
	private In inSapEx1 = new In("/wordnetTests/sapEx1.txt");
	Digraph sapEx1 = new Digraph(inSapEx1);
	private SAP SAPsapEx1 = new SAP(sapEx1);
	
	private In inSapEx2 = new In("/wordnetTests/sapEx2.txt");
	Digraph sapEx2 = new Digraph(inSapEx2);
	private SAP SAPsapEx2 = new SAP(sapEx2);
	
	
	private In inDigraph1 = new In("/wordnetTests/digraph1.txt");
	Digraph digraph1 = new Digraph(inDigraph1);
	private SAP SAPdigraph1 = new SAP(digraph1);
	
	private In inDigraph4 = new In("/wordnetTests/digraph4.txt");
	Digraph digraph4 = new Digraph(inDigraph4);
	private SAP SAPdigraph4 = new SAP(digraph4);
	
	private In inDigraph6 = new In("/wordnetTests/digraph6.txt");
	Digraph digraph6 = new Digraph(inDigraph6);
	private SAP SAPdigraph6 = new SAP(digraph6);
	
	/************************************************
	 * Basic construction
	 ***********************************************/
	@Test
	public void testSAP() {
		assertEquals("it's nothing", true, SAPdigraph1 != null);
		assertEquals("it's nothing", true, SAPdigraph4 != null);
		assertEquals("it's nothing", true, SAPdigraph6 != null);
		assertEquals("it's nothing", false, SAPnothing != null);
		assertEquals("it's nothing", true, SAPtinyCG != null);
	}	
	@Test
	public void testIsDAG() {
		assertEquals("Has a cycle", true, SAPdigraph1.isDAG());
		assertEquals("Has a cycle", true, SAPdigraph4.isDAG());	
		assertEquals("Has a cycle", true, SAPdigraph6.isDAG());	
		assertEquals(false, SAPdigraphCycle.isDAG());
		assertEquals(true, SAPtinyCG.isDAG());
//		trace(digraphCycle, "digraphCycle");
	}
	@Test
	public void testIsRootedDAG() {
		assertEquals(true, SAPsapEx1.isDAG());
		assertEquals(true, SAPsapEx2.isDAG());
		assertEquals(false, SAPdigraphCycle.isDAG());
		assertEquals(true, SAPtinyCG.isDAG());
	}
	/************************************************
	 * Methods
	 ***********************************************/
	@Test
	public void testWordnet100Sub() {
		WordNet net = new WordNet("/wordnetTests/synsets100-subgraph.txt", "/wordnetTests/hypernyms100-subgraph.txt");
		StdOut.println("Distance test hypernyms-100 : " + net.distance("gluten", "molecule"));
	}
	@Test
	public void testWordnetBigSynset() {
		WordNet net2 = new WordNet("/wordnetTests/big_synset.txt", "/wordnetTests/big_hypernyms.txt");
		StdOut.println("Distance test big_hypernyms : " + net2.distance("b", "f"));
	}
	@Test
	public void testWordnetSynset() {
		WordNet net3 = new WordNet("/wordnetTests/synset.txt", "/wordnetTests/hypernyms.txt");
		StdOut.println("should be 23: " + net3.distance("white_marlin", "mileage"));
		StdOut.println("should be 33: " + net3.distance("Black_Plague", "black_marlin"));
		StdOut.println("should be 27: " + net3.distance("American_water_spaniel", "histology"));
		StdOut.println("should be 29: " + net3.distance("Brown_Swiss", "barrel_roll"));
	}
	@Test
	public void testLengthInt() {
		//StdOut.print("\n--------lengthInt----------\n");
		//StdOut.print("\nSAPsapEx2 1,5:\n");
		assertEquals(2, SAPsapEx2.length(1, 5));
		assertEquals(4, SAPsapEx1.length(3, 11));
		//StdOut.print("\nSAPsapEx1 4,6:\n");
		assertEquals(4, SAPsapEx1.length(4, 6));
		//StdOut.print("\nSAPdigraph1 10,8:\n");
		assertEquals(3, SAPdigraph1.length(10, 8));
	}	
	@Test
	public void testWithTestClient() {
		testClient(digraphClient, 3, 11);
		testClient(digraphClient, 9, 12);
		testClient(digraphClient, 7, 2);
		testClient(digraphClient, 1, 6);
	}
	@Test
	public void testAncestorIntInt() {
		//StdOut.print("\n--------ancestorInt----------\n");
		//StdOut.print("\nSAPsapEx1 3,11\n");
		assertEquals(1, SAPsapEx1.ancestor(3, 11));
		//StdOut.print("\nSAPsapEx1 4,6\n");
		assertEquals(0, SAPsapEx1.ancestor(4, 6));
		//StdOut.print("\nSAPsapEx1 7,8\n");
		assertEquals(3, SAPsapEx1.ancestor(7, 8));
		//StdOut.print("\nSAPsapEx1 9,12\n");
		assertEquals(5, SAPsapEx1.ancestor(9, 12));
		//StdOut.print("\nSAPsapEx2 1,5\n");
		assertEquals(0, SAPsapEx2.ancestor(1, 5));
	}
	/************************************************
	 * Traces and analysis
	 ***********************************************/
	public static void trace(Digraph graph, String name){
		StdOut.print("\n\n"+name+"-------------\n"+graph.toString());
	}
	public static void trace(Topological topo, String name){
		StdOut.print("TOPO "+name+"-------------\n"+topo.order()+"\n");
	}
	public static void trace(BreadthFirstDirectedPaths bfs, String name){
		StdOut.print("BFS "+name+"\n"+bfs.pathTo(0).toString()+"\n");
	}
	public static void trace(Bag<Integer> b, String name){
		StdOut.print("\n"+name+": ");
		for (int i : b){ StdOut.print(i); }
	}
	public static void testClient(Digraph G, int v, int w) {
	    SAP sap = new SAP(G);
        int length   = sap.length(v, w);
        int ancestor = sap.ancestor(v, w);
        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
	}

}

