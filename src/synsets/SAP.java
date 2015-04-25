package sysnets;

import java.util.Stack;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.introcs.StdOut;

public class SAP {

	private final Digraph graph;
	private Stack<Integer> cycle; // vertices on a cycle (if one exists)
	private boolean[] onStack; // vertices on recursive call stack

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		this.graph = G;
	}

	// is the digraph a directed acyclic graph?
	public boolean isDAG() {
		DirectedCycle myDiCycle = new DirectedCycle(graph);
		return true == myDiCycle.hasCycle();
	}

	// is the digraph a rooted DAG?
	public boolean isRootedDAG() {
		boolean rooted = true;
		BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(
				this.graph, this.graph.V());
		for (int i = 0; i != graph.V(); i++) {
			if (!bfs.hasPathTo(i))
				rooted = false;
			break;
		}

		return rooted;
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		int length = length(v, w);
		if (length != -1) {
			return length;
		}

		else
			return -1;

	}

	// a common ancestor of v and w that participates in a shortest ancestral
	// path; -1 if no such path
	public int ancestor(int v, int w) {
		int ancestor = ancestor(v, w);
		if (ancestor != -1) {
			return ancestor;
		} else
			return -1;
	}

	// length of shortest ancestral path between any vertex in v and any vertex
	// in w; -1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {

		int ancestor = ancestor(v, w);
		BreadthFirstDirectedPaths v_bfs = new BreadthFirstDirectedPaths(
				this.graph, v);
		BreadthFirstDirectedPaths w_bfs = new BreadthFirstDirectedPaths(
				this.graph, w);

		int length = v_bfs.distTo(ancestor) + w_bfs.distTo(ancestor);
		return length;
	}

	// a common ancestor that participates in shortest ancestral path; -1 if no
	// such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		int ancestor = 0;
		BreadthFirstDirectedPaths v_bfs = new BreadthFirstDirectedPaths(
				this.graph, v);
		BreadthFirstDirectedPaths w_bfs = new BreadthFirstDirectedPaths(
				this.graph, w);

		Stack<Integer> v_stack = new Stack<Integer>();
		Stack<Integer> w_stack = new Stack<Integer>();

		return 0;
	}

	// do unit testing of this class
	public static void main(String[] args) {
		
	}
}
