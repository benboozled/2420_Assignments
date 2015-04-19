package synsets;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Stack;

public class SAP {
	
		private final Digraph graph;
		private Stack<Integer> cycle; // vertices on a cycle (if one exists)
		private boolean[] onStack; // vertices on recursive call stack
			
		// constructor takes a digraph (not necessarily a DAG)
		public SAP(Digraph G){
			this.graph = G;
		}
		
		// is the digraph a directed acyclic graph?
		public boolean isDAG(){
			DirectedCycle myDiCycle = new DirectedCycle(graph);
			return true == myDiCycle.hasCycle();
		}
		
		// is the digraph a rooted DAG?
		public boolean isRootedDAG(){
			
			return false;
		}
		
		// length of shortest ancestral path between v and w; -1 if no such path
		public int length(int v, int w){
			
			return w;
		}
		
		// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
		public int ancestor(int v, int w){
			
			return w;
		}
		
		// length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
		public int length(Iterable<Integer> v, Iterable<Integer> w){
			
			return 0;
		}
		
		// a common ancestor that participates in shortest ancestral path; -1 if no such path
		public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
			
			return 0;
		}
		
		// do unit testing of this class
		public static void main(String[] args){
			
		}
	
	}
