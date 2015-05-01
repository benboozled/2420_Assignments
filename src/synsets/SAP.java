package synsets;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdOut;

public class SAP {

	private final Digraph digraph;
	private BreadthFirstDirectedPaths bfsV; 
	private BreadthFirstDirectedPaths bfsW;

	/**
	 *  constructor takes a digraph (not necessarily a DAG)
	 * @param digraph
	 */
	public SAP(Digraph graph){
		this.digraph = graph;
	}
	
	/**
	 *  is the digraph a directed acyclic graph?
	 * @return
	 */
	public boolean isDAG(){
		DirectedCycle myDiCycle = new DirectedCycle(digraph);
		return true != myDiCycle.hasCycle();
	}
	
	/** is the digraph a rooted DAG?
	 * @return
	 */
	public boolean isRootedDAG(){
		boolean rooted = true;
		BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(
				this.digraph, this.digraph.V());
		for (int i = 0; i != digraph.V();) {
			if (!bfs.hasPathTo(i))
				rooted = false;
			break;
		}
		return rooted;
	}

	
	/** length of shortest ancestral path between v and w; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int length(int v, int w){
		int ancestor = ancestor(v,w);
		return length(bfsV.pathTo(ancestor), bfsW.pathTo(ancestor));
	}
	
	/** length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int length(Iterable<Integer> v, Iterable<Integer> w){
		if (v == null || w == null) return -1;
		int ancestor = ancestor(v,w);
		return bfsV.distTo(ancestor)+bfsW.distTo(ancestor);
	}

	/** a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int ancestor(int v, int w){
		bfsV = new BreadthFirstDirectedPaths(digraph, v);
		bfsW = new BreadthFirstDirectedPaths(digraph, w);
//		if (!this.isDAG()==true) return -1;
//		SAPTest.trace(bfsV, "bfsV");
//		SAPTest.trace(bfsW, "bfsW");
		return ancestor(bfsV.pathTo(0), bfsW.pathTo(0));
	}
	
	/** a common ancestor that participates in shortest ancestral path; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
		if (v == null || w == null) return -1;
		int ancestor = -1;
		
		//method 2
//		Stack<Integer> stackV = reverse(v);
//		for (int i : w) stackV.push(i);	
//		for (int j : reverse(v))
//			if (stackV.pop()==j) {ancestor = j;}

		//method 1
		for (int i : reverse(v))
			for (int j : reverse(w))
				if (i==j) {ancestor = i; break;}
		return ancestor;
	}

	private Stack<Integer> reverse(Iterable<Integer> s){

		Stack<Integer> stack = new Stack<Integer>();
		for (int item : s) {stack.push(item);}
		return stack;
	}

	
	/**
	 * for testing
	 */
	public static void main(String[] args){
		
	}

}
