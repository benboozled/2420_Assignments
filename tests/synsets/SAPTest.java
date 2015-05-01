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
	@Ignore
	public void testSAP() {
		assertEquals("it's nothing", true, SAPdigraph1 != null);
		assertEquals("it's nothing", true, SAPdigraph4 != null);
		assertEquals("it's nothing", true, SAPdigraph6 != null);
		assertEquals("it's nothing", false, SAPnothing != null);
		assertEquals("it's nothing", true, SAPtinyCG != null);
	}	
	@Ignore
	public void testIsDAG() {
		assertEquals("Has a cycle", true, SAPdigraph1.isDAG());
		assertEquals("Has a cycle", true, SAPdigraph4.isDAG());	
		assertEquals("Has a cycle", true, SAPdigraph6.isDAG());	
		assertEquals(false, SAPdigraphCycle.isDAG());
		assertEquals(true, SAPtinyCG.isDAG());
//		trace(digraphCycle, "digraphCycle");
	}
	@Ignore
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
	public void testWordnet() {
		WordNet net = new WordNet("/wordnetTests/synsets100-subgraph.txt", "/wordnetTests/hypernyms100-subgraph.txt");
		//WordNet net = new WordNet("/wordnetTests/big_synset.txt", "/wordnetTests/big_hypernyms.txt");
		StdOut.println("Here is all the nouns: " + net.nouns());
		StdOut.println("is it a noun? " + net.isNoun("gluten"));
		StdOut.println("SAP test: " + net.sap("gluten", "molecule"));
		StdOut.println("Distance test : " + net.distance("gluten", "molecule"));
	}
	
	@Ignore
	public void testLengthInt() {
		StdOut.print("\n--------lengthInt----------\n");
		
		StdOut.print("\nSAPsapEx2 1,5:\n");
		assertEquals(2, SAPsapEx2.length(1, 5));
		StdOut.print("\nSAPsapEx1 3,11:\n");
		assertEquals(4, SAPsapEx1.length(3, 11));
		StdOut.print("\nSAPsapEx1 4,6:\n");
		assertEquals(4, SAPsapEx1.length(4, 6));
		StdOut.print("\nSAPdigraph1 10,8:\n");
		assertEquals(3, SAPdigraph1.length(10, 8));
		
//		StdOut.print("\nSAPdigraph6 0,7:\n");
//		assertEquals(4, SAPdigraph6.length(0, 7));
//		assertEquals(2, SAPdigraph6.length(7, 4));
//		assertEquals(5, SAPdigraph6.length(0, 5));
	}	
	
	@Ignore
	public void testWithTestClient() {
		testClient(digraphClient, 3, 11);
		testClient(digraphClient, 9, 12);
		testClient(digraphClient, 7, 2);
		//TODO: does not catch bad data point: there is no 6 in the digraph
		//testClient(digraphClient, 1, 6);
	}
	
	
	@Ignore
	public void testAncestorIntInt() {
		StdOut.print("\n--------ancestorInt----------\n");
		StdOut.print("\nSAPsapEx1 3,11\n");
		assertEquals(1, SAPsapEx1.ancestor(3, 11));
		StdOut.print("\nSAPsapEx1 4,6\n");
		assertEquals(0, SAPsapEx1.ancestor(4, 6));
		StdOut.print("\nSAPsapEx1 7,8\n");
		assertEquals(3, SAPsapEx1.ancestor(7, 8));
		StdOut.print("\nSAPsapEx1 9,12\n");
		assertEquals(5, SAPsapEx1.ancestor(9, 12));
		StdOut.print("\nSAPsapEx2 1,5\n");
		assertEquals(0, SAPsapEx2.ancestor(1, 5));
	}
	
	@Ignore
	public void testLengthIterable() {
		fail("Not yet implemented");
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

//TODO: delete unused----------------------------------------

//if (!valid(v)||!valid(w)) return -1;
//	private boolean valid (int s){
//		//TODO: data validation
//		if (digraph.adj(s) == null) return false;
//		boolean result = true;
//		for (int i : digraph.adj(s)){   
//			if (s==i) result = true;
//		}
//		return result;
//	}
//	
//	private boolean valid(Iterable<Integer> s){
//		if (s==null) return false;
//		return true;
//	}



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
//		Stack<Integer> stackV = path(v);
//		Stack<Integer> stackW = path(w);
//		for (int i : stackV){
//			if (stackV.peek() == stackW.peek()){
//				ancestor = stackV.peek();
//				stackV.pop(); 
//				stackW.pop();
//			}
//		}

//		BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
//		BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);
//		Stack<Integer> stackV = new Stack<>();
//		Stack<Integer> stackW = new Stack<>();
//		for (int i : bfsV.pathTo(0))	{stackV.push(i);}	
//		for (int i : bfsW.pathTo(0))	{stackW.push(i);}
//		StdOut.print("\nstackV:\n");
//		StdOut.print(stackV.toString());
//		StdOut.print("\n");
//		StdOut.print("stackW:\n");
//		StdOut.print(stackW.toString());
//		StdOut.print("\n");	
//				if (stackV.peek() != null){
//					graph.addEdge(stackV.pop(), stackV.peek());
//				}
//		int vPeek = 0;
//		int wPeek = 0;
		//while (!stackV.isEmpty())
		//for (int i : stackW.pop())
//			vPeek = stackV.peek();
//			wPeek = stackW.peek();
//		Queue<Integer> queueW = new Queue<>();
//		for (int i : bfsW.pathTo(0))
//			if (stackV.peek() != i)
//				queueW.enqueue(stackV.pop());
		
//		for (int i : bfsW.pathTo(0))
//			stackW.push(i); wlength++;
		
//		Queue<Integer> queueV = new Queue<>();
//		for (int i : bfsV.pathTo(0)) 
//			queueV.enqueue(i);
//		StdOut.print("\nbfsV:\n");
//		for (int i : bfsV.pathTo(0)){
//			StdOut.print(i);
//			if (i != 0) StdOut.print(" > ");
//		}
//		StdOut.print("\nbfsW:\n");
//		for (int i : bfsW.pathTo(0)){
//			StdOut.print(i);
//			if (i != 0) StdOut.print(" > ");
//		}
//		StdOut.print("\nqueueV:\n");
//		StdOut.print(queueV.toString());																								
//		StdOut.print("\nqueueW:\n");
//		StdOut.print(queueW.toString());
//end trace--------------------------------------------------
