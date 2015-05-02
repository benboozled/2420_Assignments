/**
 * @author David Weber
 * @author Ben Anderl
 * @Date Created Apr 19, 2015 
 * Last modified: May 2, 2015 
 */
package synsets;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.algs4.TransitiveClosure;
import edu.princeton.cs.introcs.StdOut;

public class SAP {

	private final Digraph digraph;
	private BreadthFirstDirectedPaths bfsV;
	private BreadthFirstDirectedPaths bfsW;

	/**
	 * constructor takes a digraph (not necessarily a DAG)
	 * 
	 * @param digraph
	 */
	public SAP(Digraph graph) {
		this.digraph = graph;
	}

	/**
	 * is the digraph a directed acyclic graph?
	 * 
	 * @return
	 */
	public boolean isDAG() {
		DirectedCycle myDiCycle = new DirectedCycle(digraph);
		return true != myDiCycle.hasCycle();
	}

	/**
	 * is the digraph a rooted DAG?
	 * 
	 * @return
	 */
	public boolean isRootedDAG() {
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

	/**
	 * length of shortest ancestral path between v and w; -1 if no such path
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public int length(int v, int w) {
		int ancestor = ancestor(v, w);
		return bfsV.distTo(ancestor) + bfsW.distTo(ancestor);
	}

	/**
	 * length of shortest ancestral path between any vertex in v and any vertex
	 * in w; -1 if no such path
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		bfsV = new BreadthFirstDirectedPaths(digraph, v);
		bfsW = new BreadthFirstDirectedPaths(digraph, w);
		int ancestor = ancestor(v, w);
		if (ancestor == -1)
			return -1;
		return bfsV.distTo(ancestor) + bfsW.distTo(ancestor);
	}

	/**
	 * a common ancestor of v and w that participates in a shortest ancestral
	 * path; -1 if no such path
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public int ancestor(int v, int w) {
		Bag<Integer> bagv = new Bag<>(); bagv.add(v);
		Bag<Integer> bagw = new Bag<>(); bagw.add(w);
		return ancestor (bagv, bagw);
	}

	/**
	 * a common ancestor that participates in shortest ancestral path; -1 if no
	 * such path
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		int shortest = digraph.E();
		int ancestor = -1;
		bfsV = new BreadthFirstDirectedPaths(digraph, v);
		bfsW = new BreadthFirstDirectedPaths(digraph, w);

		for (int i = 0; i < digraph.V(); i++) {
			if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
				int distance = bfsV.distTo(i) + bfsW.distTo(i);
				if (distance < shortest) {
					shortest = distance;
					ancestor = i;
				}
			}
		}
		return ancestor;
	}
	
	/**
	 * for testing
	 */
	public static void main(String[] args) {

	}

}